package iceberg.run;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class IcebergSettingsEditor extends SettingsEditor<IcebergRunConfiguration> {

    private TextFieldWithBrowseButton fileField;

    @Override
    protected void resetEditorFrom(@NotNull IcebergRunConfiguration config) {
        fileField.setText(config.getProgramFilePath());
    }

    @Override
    protected void applyEditorTo(@NotNull IcebergRunConfiguration config) {
        config.setProgramFilePath(fileField.getText());
    }

    @Override
    protected @NotNull JComponent createEditor() {
        fileField = new TextFieldWithBrowseButton();

        //TODO нужен поиск по каталогам
//        FileChooserDescriptor descriptor = new FileChooserDescriptor(
//            true,   // chooseFiles
//            false,  // chooseFolders
//            false,
//            false,
//            false,
//            false
//        );
//        fileField.addBrowseFolderListener(
//            "Choose Program File",
//            "Select a source file to run",
//            null,
//            descriptor
//        );

        return fileField;
    }
}
