package lint.sonar;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonarsource.api.sonarlint.SonarLintSide;

@SonarLintSide
public class AMVCheckRegistrar  implements CheckRegistrar {
    @Override
    public void register(RegistrarContext registrarContext) {

    }
}
