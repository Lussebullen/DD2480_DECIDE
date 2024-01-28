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

///////////////////////////// Lic 0 /////////////////////////////

    @Test
    public void lic0Test() {
        assertTrue(true);
    }
///////////////////////////// Lic 1 /////////////////////////////

    @Test
    public void lic1TestUncontained() {
        input.NUMPOINTS = 4;
        input.X_COORD = new double[]{-1.0, 1.0, 3.0, 7.0};
        input.Y_COORD = new double[]{-1.0, 0.0, 3.0, 3.0};
        input.RADIUS1 = 3;
        assertTrue(licAnalyzer.lic1(input));
    }

    @Test
    public void lic1TestContained() {
        input.NUMPOINTS = 4;
        input.X_COORD = new double[]{-1.0, 1.0, 3.0, 5.0};
        input.Y_COORD = new double[]{-1.0, 0.0, 3.0, 3.0};
        input.RADIUS1 = 3;
        assertFalse(licAnalyzer.lic1(input));
    }

    @Test
    public void lic1TestContainedBoundary() {
        input.NUMPOINTS = 4;
        input.X_COORD = new double[]{-3.0, 0.0, 3.0, 5.0};
        input.Y_COORD = new double[]{0.0, 3.0, 0.0, 3.0};
        input.RADIUS1 = 3;
        assertFalse(licAnalyzer.lic1(input));
    }

    @Test
    public void lic1TestContained3Points() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{1.0, 0.0, 0.0};
        input.Y_COORD = new double[]{0.0, 1.0, 0.0};
        input.RADIUS1 = 3;
        assertFalse(licAnalyzer.lic1(input));
    }

    @Test
    public void lic1TestUncontained3Points() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{-4.0, 0.0, 4.0};
        input.Y_COORD = new double[]{0.0, 0.0, 0.0};
        input.RADIUS1 = 3;
        assertTrue(licAnalyzer.lic1(input));
    }

    @Test
    public void lic1TestContainedZeroRadius() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{1.0, 1.0, 1.0};
        input.Y_COORD = new double[]{1.0, 1.0, 1.0};
        input.RADIUS1 = 0;
        assertFalse(licAnalyzer.lic1(input));
    }

    @Test
    public void lic1TestUncontainedZeroRadius() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{1.0, 0.0, 1.0};
        input.Y_COORD = new double[]{1.0, 1.0, 1.0};
        input.RADIUS1 = 0;
        assertTrue(licAnalyzer.lic1(input));
    }

    @Test
    public void lic1TestTooFewPoints() {
        input.NUMPOINTS = 2;
        input.X_COORD = new double[]{-4.0, 0.0};
        input.Y_COORD = new double[]{0.0, 0.0};
        input.RADIUS1 = 3;
        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic1(input));
    }

    @Test
    public void lic1TestNegativeRadius() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{-4.0, 0.0, 4.0};
        input.Y_COORD = new double[]{0.0, 0.0, 0.0};
        input.RADIUS1 = -1;
        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic1(input));
    }

///////////////////////////// Lic 2 /////////////////////////////

    @Test
    public void lic2Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 3 /////////////////////////////

    @Test
    public void lic3Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 4 /////////////////////////////

    @Test
    public void lic4Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 5 /////////////////////////////

    @Test
    public void lic5Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 6 /////////////////////////////

    @Test
    public void lic6Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 7 /////////////////////////////

    @Test
    public void lic7Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 8 /////////////////////////////

    @Test
    public void lic8Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 9 /////////////////////////////

    @Test
    public void lic9Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 10 /////////////////////////////

    @Test
    public void lic10Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 11 /////////////////////////////

    @Test
    public void lic11Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 12 /////////////////////////////

    @Test
    public void lic12Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 13 /////////////////////////////

    @Test
    public void lic13Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 14 /////////////////////////////

    @Test
    public void lic14Test() {
        assertTrue(true);
    }

}