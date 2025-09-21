package iceberg.run;

import com.intellij.execution.ProgramRunnerUtil;
import com.intellij.execution.RunManager;
import com.intellij.execution.RunnerAndConfigurationSettings;
import com.intellij.execution.executors.DefaultRunExecutor;
import com.intellij.execution.lineMarker.RunLineMarkerContributor;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import iceberg.psi.IcebergFile;
import org.jetbrains.annotations.NotNull;

public class IcebergRunLineMarkerContributor extends RunLineMarkerContributor {

    @Override
    public Info getInfo(@NotNull PsiElement element) {
        PsiFile file = element.getContainingFile();
        if (!(file instanceof IcebergFile)) return null;

        AnAction runAction = new AnAction() {
            @Override
            public void actionPerformed(@NotNull AnActionEvent e) {
                Project project = element.getProject();
                RunnerAndConfigurationSettings settings = RunManager.getInstance(project)
                    .createConfiguration(
                        file.getName(),
                        new IcebergRunConfigurationType().getConfigurationFactories()[0]
                    );

                var configuration = (IcebergRunConfiguration) settings.getConfiguration();
                configuration.setProgramFilePath(file.getVirtualFile().getPath());

                settings.setName(file.getName());
                RunManager.getInstance(project).addConfiguration(settings);
                RunManager.getInstance(project).setSelectedConfiguration(settings);

                ProgramRunnerUtil.executeConfiguration(
                    settings,
                    DefaultRunExecutor.getRunExecutorInstance()
                );
            }
        };

        // Чтобы кнопка не дублировалась на каждой ноде,
        // вешаем её только на первый элемент PSI файла
        if (element.equals(file.getFirstChild())) {
            return new RunLineMarkerContributor.Info(
                AllIcons.Actions.Execute,            // иконка запуска
                new AnAction[] {runAction}
            );
        }

        return null;
    }
}
