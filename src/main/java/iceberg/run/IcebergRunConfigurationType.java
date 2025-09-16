package iceberg.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import iceberg.IcebergIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class IcebergRunConfigurationType implements ConfigurationType {

    private final ConfigurationFactory factory;

    public IcebergRunConfigurationType() {
        factory = new ConfigurationFactory(this) {
            @Override
            public @NotNull @NonNls String getId() {
                return "IcebergRunConfiguration";
            }

            @Override
            public @NotNull RunConfiguration createTemplateConfiguration(@NotNull Project project) {
                return new IcebergRunConfiguration(project, this, "Iceberg Run");
            }
        };
    }

    @Override
    public @NotNull String getDisplayName() {
        return "Iceberg";
    }

    @Override
    public String getConfigurationTypeDescription() {
        return "Run Iceberg programs";
    }

    @Override
    public Icon getIcon() {
        return IcebergIcons.FILE;
    }

    @Override
    public @NotNull String getId() {
        return "ICEBERG_RUN_CONFIGURATION";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{factory};
    }
}
