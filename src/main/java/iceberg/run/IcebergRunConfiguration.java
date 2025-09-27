package iceberg.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class IcebergRunConfiguration extends RunConfigurationBase<IcebergRunConfigurationOptions> {

    protected IcebergRunConfiguration(Project project, ConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    @Override
    protected @NotNull IcebergRunConfigurationOptions getOptions() {
        return (IcebergRunConfigurationOptions) super.getOptions();
    }

    public String getProgramFilePath() {
        return getOptions().getSourceFile();
    }

    public void setProgramFilePath(String path) {
        getOptions().setSourceFile(path);
    }

    public Set<String> getClasspath() {
        return getOptions().getClassPath();
    }

    public void setClasspath(Set<String> classpath) {
        getOptions().setClassPath(classpath);
    }

    @Override
    public @NotNull SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new IcebergSettingsEditor(getProject());
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        var file = getOptions().getSourceFile();
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
                if (getClasspath().isEmpty()) {
                    GeneralCommandLine cmd = new GeneralCommandLine("ice", "-run", getProgramFilePath());
                    return new ColoredProcessHandler(cmd);
                } else {
                    var cp = String.join(":", getClasspath());
                    GeneralCommandLine cmd = new GeneralCommandLine("ice", "-cp", cp, "-run", getProgramFilePath());
                    return new ColoredProcessHandler(cmd);
                }
            }
        };
    }
}
