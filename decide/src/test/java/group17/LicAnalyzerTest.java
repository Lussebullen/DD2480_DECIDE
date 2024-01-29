package group17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LicAnalyzerTest {
    
    private static InputHandler input;
    private static LicAnalyzer licAnalyzer;

    @BeforeEach
    public void setUp() {
        input = new InputHandler("sampleData.json");
        licAnalyzer = new LicAnalyzer();
    }

    @Test
    public void lic0Test() {
        assertTrue(true);
    }

    @Test
    public void lic1Test() {
        assertTrue(true);
    }

    @Test
    public void lic2AngleOutsideEPSILONRadius() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{-1.0, 3.0, 3.0};
        input.Y_COORD = new double[]{1.0, 1.0, 5.0};
        input.EPSILON = Math.PI / 4;

        assertTrue(licAnalyzer.lic2(input));
    }

    @Test
    public void lic2AngleInsideEPSILONRadius() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{-1.0, 3.0, 7.0};
        input.Y_COORD = new double[]{1.0, 1.0, 1.0};
        input.EPSILON = Math.PI / 4;

        assertFalse(licAnalyzer.lic2(input));
    }

    @Test
    public void lic2TestInvalidEPSILON() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{0.0, 0.0, 0.0};
        input.Y_COORD = new double[]{0.0, 0.0, 0.0};
        input.EPSILON = 2 * Math.PI;

        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic2(input));
    }

    @Test
    public void lic2TestInvalidNUMPOINTS() {
        input.NUMPOINTS = 2;
        input.X_COORD = new double[]{0.0, 0.0};
        input.Y_COORD = new double[]{0.0, 0.0};
        input.EPSILON = Math.PI / 4;

        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic2(input));
    }

    @Test
    public void lic3Test() {
        assertTrue(true);
    }

    @Test
    public void lic4Test() {
        assertTrue(true);
    }

    @Test
    public void lic5Test() {
        assertTrue(true);
    }

    @Test
    public void lic6Test() {
        assertTrue(true);
    }

    @Test
    public void lic7DistanceLongerThanLength() {
        input.NUMPOINTS = 5;
        input.X_COORD = new double[]{0.0, 3.0, 1.0, 2.0, 7.0};
        input.Y_COORD = new double[]{0.0, 1.0, 1.0, 0.0, 5.0};
        input.K_PTS= 2;
        input.LENGTH1 = 1;

        assertTrue(licAnalyzer.lic7(input));
    }
    @Test

    public void lic7DistanceLongerThanLength2() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{0.0, 3.0, 1.0};
        input.Y_COORD = new double[]{0.0, 1.0, 1.0};
        input.K_PTS= 1;
        input.LENGTH1 = 1;

        assertTrue(licAnalyzer.lic7(input));
    }

    @Test
    public void lic7DistanceShorterThanLength() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{0.0, 3.0, 1.0};
        input.Y_COORD = new double[]{0.0, 1.0, 1.0};
        input.K_PTS= 1;
        input.LENGTH1 = 2;

        assertFalse(licAnalyzer.lic7(input));
    }

    @Test
    public void lic7InvalidLENGTH1() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{0.0, 3.0, 1.0};
        input.Y_COORD = new double[]{0.0, 1.0, 1.0};
        input.K_PTS= 1;
        input.LENGTH1 = -1;

        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic7(input));
    }

    @Test
    public void lic7InvalidK_PTS() {
        input.NUMPOINTS = 5;
        input.X_COORD = new double[]{0.0, 0.0, 0.0, 3.0, 1.0};
        input.Y_COORD = new double[]{0.0, 0.0, 0.0, 1.0, 1.0};
        input.K_PTS= 4;
        input.LENGTH1 = 2;

        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic7(input));
    }

    @Test
    public void lic8Test() {
        assertTrue(true);
    }

    @Test
    public void lic9Test() {
        assertTrue(true);
    }

    @Test
    public void lic10Test() {
        assertTrue(true);
    }

    @Test
    public void lic11Test() {
        assertTrue(true);
    }

    @Test
    public void lic12Test() {
        assertTrue(true);
    }

    @Test
    public void lic13Test() {
        assertTrue(true);
    }

    @Test
    public void lic14Test() {
        assertTrue(true);
    }

    @Test
    public void lic15Test() {
        assertTrue(true);
    }
}
