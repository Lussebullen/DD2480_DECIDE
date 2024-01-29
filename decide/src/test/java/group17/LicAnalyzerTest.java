package group17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
    public void lic0ReturnsTrueIfConsecutivePointsGreaterThanLENGTH1ApartExists() {
        // Arrange
        input.LENGTH1 = 3.0;
        input.X_COORD = new double[]{1.0, 10.0};
        input.Y_COORD = new double[]{1.0, 10.0};
        input.NUMPOINTS = input.X_COORD.length;

        //Act
        boolean signal = licAnalyzer.lic0(input);

        //Assert
        assertTrue(signal);
    }
    @Test
    public void lic0ReturnsTrueIfConsecutiveNegativePointsGreaterThanLENGTH1ApartExists() {
        // Arrange
        input.LENGTH1 = 3.0;
        input.X_COORD = new double[]{-1.0, -10.0};
        input.Y_COORD = new double[]{-1.0, -10.0};
        input.NUMPOINTS = input.X_COORD.length;

        //Act
        boolean signal = licAnalyzer.lic0(input);

        //Assert
        assertTrue(signal);
    }
    @Test
    public void lic0ReturnsTrueIfConsecutivePointsInQ2AndQ4GreaterThanLENGTH1ApartExists() {
        // Arrange
        input.LENGTH1 = 3.0;
        input.X_COORD = new double[]{1.0, -10.0};
        input.Y_COORD = new double[]{-1.0, 10.0};
        input.NUMPOINTS = input.X_COORD.length;

        //Act
        boolean signal = licAnalyzer.lic0(input);

        //Assert
        assertTrue(signal);
    }
    @Test
    public void lic0ReturnsFalseIfNoConsecutivePointsGreaterThanLENGTH1ApartExists() {
        // Arrange
        input.LENGTH1 = Math.sqrt(2) + 0.00000001;
        input.X_COORD = new double[]{1.0, 2.0};
        input.Y_COORD = new double[]{1.0, 2.0};
        input.NUMPOINTS = input.X_COORD.length;

        //Act
        boolean signal = licAnalyzer.lic0(input);

        //Assert
        assertFalse(signal);
    }

    @Test
    public void lic0ThrowsExceptionIfLENGTH1IsBelowZero() {
        //Arrange
        input.LENGTH1 = -0.00000001;

        //Act, Assert
        assertThrows(Exception.class, () -> licAnalyzer.lic0(input));
    }
    @Test
    public void lic0ThrowsExceptionIfNUMPOINTSIsBelowZero() {
        //Arrange
        input.NUMPOINTS = -1;

        //Act, Assert
        assertThrows(Exception.class, () -> licAnalyzer.lic0(input));
    }
    @Test
    public void lic0ThrowsExceptionIfNullPointingCoordinateArray() {
        //Arrange
        input.X_COORD = null;
        input.Y_COORD = null;

        //Act, Assert
        assertThrows(Exception.class, () -> licAnalyzer.lic0(input));
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
