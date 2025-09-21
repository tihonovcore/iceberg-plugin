package iceberg.run;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.DocumentAdapter;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.components.JBList;
import iceberg.IcebergFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class IcebergSettingsEditor extends SettingsEditor<IcebergRunConfiguration> {

    private final TextFieldWithBrowseButton fileField;
    private final JBList<String> classpathList;
    private final DefaultListModel<String> classpathModel;

    private final JPanel panel;

    public IcebergSettingsEditor(@NotNull Project project) {
        panel = new JPanel(new BorderLayout());

        // --- file chooser ---
        fileField = new TextFieldWithBrowseButton();
        fileField.addBrowseFolderListener(
            new TextBrowseFolderListener(
                FileChooserDescriptorFactory.createSingleFileDescriptor(
                    IcebergFileType.INSTANCE
                ),
                project
            )
        );
        fileField.getTextField().getDocument().addDocumentListener(new DocumentAdapter() {
            @Override
            protected void textChanged(@NotNull DocumentEvent e) {
                fireEditorStateChanged();
            }
        });

        // --- classpath list ---
        classpathModel = new DefaultListModel<>();
        classpathList = new JBList<>(classpathModel);
        classpathList.setVisibleRowCount(5);

        ToolbarDecorator decorator = ToolbarDecorator.createDecorator(classpathList)
            .setAddAction(button -> {
                String path = com.intellij.openapi.ui.Messages.showInputDialog(
                    project,
                    "Enter classpath directory:",
                    "Add to Classpath",
                    null
                );
                if (path != null && !path.isBlank()) {
                    classpathModel.addElement(path.trim());
                    fireEditorStateChanged();
                }
            })
            .setRemoveAction(button -> {
                int index = classpathList.getSelectedIndex();
                if (index >= 0) {
                    classpathModel.remove(index);
                    fireEditorStateChanged();
                }
            });

        JPanel classpathPanel = decorator.createPanel();

        // --- layout ---
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("File:"), BorderLayout.WEST);
        topPanel.add(fileField, BorderLayout.CENTER);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JLabel("Classpath:"), BorderLayout.CENTER);
        panel.add(classpathPanel, BorderLayout.SOUTH);
    }

    @Override
    protected void resetEditorFrom(@NotNull IcebergRunConfiguration config) {
        fileField.setText(config.getProgramFilePath());

        classpathModel.clear();
        if (config.getClasspath() != null) {
            for (String path : config.getClasspath()) {
                classpathModel.addElement(path);
            }
        }
    }

    @Override
    protected void applyEditorTo(@NotNull IcebergRunConfiguration config) {
        config.setProgramFilePath(fileField.getText());

        List<String> newClasspath = new ArrayList<>();
        for (int i = 0; i < classpathModel.getSize(); i++) {
            newClasspath.add(classpathModel.get(i));
        }
        config.setClasspath(newClasspath);
    }

    @Override
    protected @NotNull JComponent createEditor() {
        return panel;
    }
}
