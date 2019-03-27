package lint;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class AMVCheckIT {
    @Test
    public void testCheck() {
        JavaCheckVerifier.verify("src/test/files/AMVReader.java", new AMVCheck());
    }
}
