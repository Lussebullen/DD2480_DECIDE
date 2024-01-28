package group17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.Exception;

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
    public void lic9Test() {
        assertTrue(true);
    }

    @Test
    public void lic10IsTrueIfThreePointsSeperatedByTwoAndFourPointsExistsWithAreaGreaterThan49() {
        //Arrange
        input.X_COORD = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 11.0};
        input.Y_COORD = new double[]{1.0, 0.0, 0.0, 11.0, 0.0, 0.0, 0.0, 0.0, 1.0};

        input.NUMPOINTS = 9;
        input.E_PTS = 2;
        input.F_PTS = 4;
        input.AREA1 = 49.0;

        try {
            //Act
            boolean signal = licAnalyzer.lic10(input);

            // Assert
            assertTrue(signal);
        } catch (Exception e) {}
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
