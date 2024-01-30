package group17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void lic2Test() {
        assertTrue(true);
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
    public void lic7Test() {
        assertTrue(true);
    }

    @Test
    public void lic8Test() {
        assertTrue(true);
    }

    @Test
    public void lic9TestAngleBiggerOrSmaller() {
        assumeTrue(input.C_PTS >= 1 && input.D_PTS >= 1);
        assumeTrue((input.C_PTS + input.D_PTS) <= (input.NUMPOINTS - 3));
        
        input.D_PTS = 1;
        input.C_PTS = 1;
        input.NUMPOINTS = 5;
        input.EPSILON = 1;

        //26degree/0.451rad angle
        input.X_COORD = new double[]{5, 0, 0, 0, 5};
        input.Y_COORD = new double[]{0, 0, 0, 0, 2.453}; 
        assertTrue(licAnalyzer.lic9(input));
    }

    public void lic9TestCoincidingPoints() {
        assumeTrue(input.C_PTS >= 1 && input.D_PTS >= 1);
        assumeTrue((input.C_PTS + input.D_PTS) <= (input.NUMPOINTS - 3));
        
        input.D_PTS = 1;
        input.C_PTS = 1;
        input.NUMPOINTS = 5;
        input.EPSILON = 1;

        input.X_COORD = new double[]{0, 0, 0, 0, 0};
        input.Y_COORD = new double[]{0, 0, 0, 0, 0}; 
        assertFalse(licAnalyzer.lic9(input));
    }

    public void lic9TestInvalidNumpoints() {
        assumeTrue(input.C_PTS >= 1 && input.D_PTS >= 1);
        assumeFalse((input.C_PTS + input.D_PTS) <= (input.NUMPOINTS - 3));
        
        input.D_PTS = 1;
        input.C_PTS = 1;
        input.NUMPOINTS = 3;
        input.EPSILON = 1;

        input.X_COORD = new double[]{0, 0, 0};
        input.Y_COORD = new double[]{0, 0, 0}; 
        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic9(input));
    }

    public void lic9TestInvalidCpts() {
        assumeFalse(input.C_PTS >= 1 && input.D_PTS >= 1);
        assumeTrue((input.C_PTS + input.D_PTS) <= (input.NUMPOINTS - 3));
        
        input.D_PTS = 1;
        input.C_PTS = 0;
        input.NUMPOINTS = 5;
        input.EPSILON = 1;

        input.X_COORD = new double[]{0, 0, 0, 0, 0};
        input.Y_COORD = new double[]{0, 0, 0, 0, 0}; 
        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic9(input));
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
