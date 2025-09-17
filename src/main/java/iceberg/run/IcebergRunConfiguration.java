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

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IcebergRunConfiguration extends RunConfigurationBase {

    protected IcebergRunConfiguration(Project project, ConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    @Override
    public @NotNull SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new IcebergSettingsEditor(getProject());
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        if (file == null) {
            throw new RuntimeConfigurationError("File path is not set");
        }

        var path = Path.of(file);
        if (!Files.exists(path)) {
            throw new RuntimeConfigurationError("File not exists");
        }

        if (Files.isDirectory(path)) {
            throw new RuntimeConfigurationError("Not a .ib file");
        }
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
    private List<String> classpath = new ArrayList<>();

    String getProgramFilePath() {
        return file;
    }

    void setProgramFilePath(String path) {
        file = path;
    }

    public List<String> getClasspath() {
        return classpath;
    }

    public void setClasspath(List<String> classpath) {
        this.classpath = classpath;
    }
}
