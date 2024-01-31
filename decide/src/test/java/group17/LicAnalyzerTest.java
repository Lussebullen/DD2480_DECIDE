package group17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

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
    public void lic0ReturnsTrueIfConsecutivePositivePointsGreaterThanLENGTH1ApartExists() {
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
    public void lic0ThrowsExceptionIfNUMPOINTSIsBelow2() {
        //Arrange
        input.NUMPOINTS = 1;

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
    public void lic3TestTriangleAreaGreaterThanAREA1() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{0.0, 0.0, 1.0};
        input.Y_COORD = new double[]{1.0, 0.0, 0.0};
        input.AREA1 = 0.25;

        assertTrue(licAnalyzer.lic3(input));
    }

    @Test
    public void lic3TestTriangleAreaSmallerThanAREA1() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{0.0, 0.0, 1.0};
        input.Y_COORD = new double[]{1.0, 0.0, 0.0};
        input.AREA1 = 1.0;

        assertFalse(licAnalyzer.lic3(input));
    }

    @Test
    public void lic3TestInvalidAREA1() {
        input.AREA1 = -1.0;

        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic3(input));
    }

    @Test
    public void lic3TestInvalidNUMPOINTS() {
        input.NUMPOINTS = 2;

        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic3(input));
    }

    @Test
    public void lic4TestQptsDoNotCover() {
        input.Q_PTS = 3;
        input.QUADS = 2;
        input.NUMPOINTS = 4;
        input.X_COORD = new double[]{0, 2, -4, 1};
        input.Y_COORD = new double[]{1, 3, -5, 4};
        assertFalse(licAnalyzer.lic4(input));
    }
    @Test
    public void lic4TestQptsDoCover() {
        input.Q_PTS = 3;
        input.QUADS = 2;
        input.NUMPOINTS = 4;
        input.X_COORD = new double[]{0, -2, -4, 1};
        input.Y_COORD = new double[]{1, 3, -5, 4};
        assertTrue(licAnalyzer.lic4(input));
    }
    @Test
    public void lic4TestQptsEqualNumPoints() {
        input.Q_PTS = 4;
        input.QUADS = 3;
        input.NUMPOINTS = 4;
        input.X_COORD = new double[]{0, -2, -4, 1};
        input.Y_COORD = new double[]{1, 3, -5, -4};
        assertTrue(licAnalyzer.lic4(input));
    }
    @Test
    public void lic4TestQuadsHigerOrEqualThanQptsCoverage() {
        input.Q_PTS = 3;
        input.QUADS = 3;
        input.NUMPOINTS = 4;
        input.X_COORD = new double[]{0, -2, -4, 1};
        input.Y_COORD = new double[]{1, 3, -5, 4};
        assertFalse(licAnalyzer.lic4(input));
    }
    @Test
    public void lic4TestInvalidInputQpts() {
        input.Q_PTS = 1;
        input.QUADS = 3;
        input.NUMPOINTS = 4;
        input.X_COORD = new double[]{0, -2, -4, 1};
        input.Y_COORD = new double[]{1, 3, -5, 4};
        assertThrows(IllegalArgumentException.class, () ->  licAnalyzer.lic4(input));
    }
    @Test
    public void lic4TestInvalidInputQuads() {
        input.Q_PTS = 3;
        input.QUADS = 4;
        input.NUMPOINTS = 4;
        input.X_COORD = new double[]{0, -2, -4, 1};
        input.Y_COORD = new double[]{1, 3, -5, 4};
        assertThrows(IllegalArgumentException.class, () ->  licAnalyzer.lic4(input));
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
    public void lic10IsTrueIfThreePointsSeperatedByTwoAndFourPointsExistsWithAreaGreaterThan49() {
        //Arrange
        input.X_COORD = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 11.0};
        input.Y_COORD = new double[]{1.0, 0.0, 0.0, 11.0, 0.0, 0.0, 0.0, 0.0, 1.0};

        input.NUMPOINTS = input.X_COORD.length;
        input.E_PTS = 2;
        input.F_PTS = 4;
        input.AREA1 = 49.0;

        //Act
        boolean signal = licAnalyzer.lic10(input);

        // Assert
        assertTrue(signal);
    }

    @Test
    public void lic10ThrowsExceptionOnInvalidF_PTS() {
        //Arrange
        input.F_PTS = -1;

        //Act, Assert
        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic10(input));
    }
    @Test
    public void lic10ThrowsExceptionOnInvalidE_PTS() {
        //Arrange
        input.E_PTS = -1;

        //Act, Assert
        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic10(input));
    }
    @Test
    public void lic10ThrowsExceptionOnInvalidNUMPOINTS() {
        //Arrange
        input.NUMPOINTS = 5;
        input.E_PTS = 10;
        input.F_PTS = 10;

        //Act, Assert
        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic10(input));
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
