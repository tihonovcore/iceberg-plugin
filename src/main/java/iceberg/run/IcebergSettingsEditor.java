package iceberg.run;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.components.JBList;
import com.intellij.util.ui.FormBuilder;
import iceberg.IcebergFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class IcebergSettingsEditor extends SettingsEditor<IcebergRunConfiguration> {

    private final TextFieldWithBrowseButton fileField;
    private final JBList<String> classpathList;
    private final DefaultListModel<String> classpathModel;

    private final JPanel panel;

    public IcebergSettingsEditor(@NotNull Project project) {
        // --- file chooser ---
        fileField = new TextFieldWithBrowseButton();
        fileField.addBrowseFolderListener(
            project,
            FileChooserDescriptorFactory.createSingleFileDescriptor(
                IcebergFileType.INSTANCE
            )
        );

        // --- classpath chooser ---
        classpathModel = new DefaultListModel<>();
        classpathList = new JBList<>(classpathModel);

        JPanel classpathPanel = ToolbarDecorator.createDecorator(classpathList)
            .setAddAction(button -> {
                var descriptor = FileChooserDescriptorFactory.createSingleFolderDescriptor();
                descriptor.setTitle("Select Classpath Folder");
                VirtualFile file = com.intellij.openapi.fileChooser.FileChooser.chooseFile(descriptor, project, null);
                if (file != null) {
                    classpathModel.addElement(file.getPath());
                }
            })
            .setRemoveAction(button -> {
                int idx = classpathList.getSelectedIndex();
                if (idx >= 0) {
                    classpathModel.remove(idx);
                }
            })
            .disableUpDownActions()
            .createPanel();

        panel = FormBuilder.createFormBuilder()
            .addLabeledComponent("Script file", fileField)
            .addLabeledComponent("Classpath", classpathPanel)
            .getPanel();
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

        Set<String> newClasspath = new HashSet<>();
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
