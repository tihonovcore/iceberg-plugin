package iceberg.run;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;
import com.intellij.openapi.util.text.StringUtil;

import java.util.*;
import java.util.stream.Collectors;

public class IcebergRunConfigurationOptions extends RunConfigurationOptions {

    private final StoredProperty<String> sourceFile = string(null).provideDelegate(this, "sourceFile");
    private final StoredProperty<String> classPath = string("").provideDelegate(this, "classPath");

    public String getSourceFile() {
        return sourceFile.getValue(this);
    }

    public void setSourceFile(String scriptName) {
        sourceFile.setValue(this, scriptName);
    }

    public Set<String> getClassPath() {
        return Optional.ofNullable(classPath.getValue(this)).stream()
            .flatMap(cp -> StringUtil.split(cp, ":").stream())
            .map(String::trim)
            .collect(Collectors.toSet());
    }

    public void setClassPath(Set<String> updated) {
        classPath.setValue(this, String.join(":", updated));
    }
}
