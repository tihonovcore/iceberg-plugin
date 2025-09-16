package iceberg.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.ColoredProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

//TODO: нужна кнопка run в файле
public class IcebergRunConfiguration extends RunConfigurationBase {

    protected IcebergRunConfiguration(Project project, ConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    @Override
    public @NotNull SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new IcebergSettingsEditor(); // UI для редактирования (путь к файлу, аргументы и т.п.)
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        // Проверки перед запуском
    }

    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) {
        return new CommandLineState(environment) {
            @NotNull
            @Override
            protected ProcessHandler startProcess() throws ExecutionException {
                GeneralCommandLine cmd = new GeneralCommandLine("ice", "-run", getProgramFilePath());
                return new ColoredProcessHandler(cmd);
            }
        };
    }

    private String file = "~/IdeaProjects/ice/src/x.ib";

    String getProgramFilePath() {
        // Вернуть путь к файлу, который нужно запускать
        return file;
    }

    void setProgramFilePath(String path) {
        file = path;
    }
}
