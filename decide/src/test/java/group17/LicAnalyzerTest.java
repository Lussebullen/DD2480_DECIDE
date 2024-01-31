package group17;

import org.junit.jupiter.api.Assertions;
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

///////////////////////////// Lic 0 /////////////////////////////

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
///////////////////////////// Lic 1 /////////////////////////////

    @Test
    public void lic1TestUncontained() {
        input.NUMPOINTS = 4;
        input.X_COORD = new double[]{-1.0, 1.0, 3.0, 7.0};
        input.Y_COORD = new double[]{-1.0, 0.0, 3.0, 3.0};
        input.RADIUS1 = 3;
        assertTrue(licAnalyzer.lic1(input));
    }

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
    public void lic1TestUncontainedZeroRadius2() {
        input.NUMPOINTS = 3;
        input.X_COORD = new double[]{1.0, 1.0, 1.0};
        input.Y_COORD = new double[]{1.0, 0.0, 1.0};
        input.RADIUS1 = 0;
        assertTrue(licAnalyzer.lic1(input));
    }

    @Test
    public void lic1TestTooFewPoints() {
        input.NUMPOINTS = 1;
        input.X_COORD = new double[]{-4.0};
        input.Y_COORD = new double[]{0.0};
        input.RADIUS1 = 3;
        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic1(input));
    }

    @Test
    public void lic1TestManyPoints() {
        input.NUMPOINTS = 101;
        input.RADIUS1 = 3;
        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic1(input));
    }

    @Test
    public void lic1Test2Points() {
        input.NUMPOINTS = 2;
        input.X_COORD = new double[]{-10.0, 0.0};
        input.Y_COORD = new double[]{0.0, 0.0};
        input.RADIUS1 = 3;
        assertFalse(licAnalyzer.lic1(input));
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

///////////////////////////// Lic 3 /////////////////////////////

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

///////////////////////////// Lic 4 /////////////////////////////

    @Test
    public void lic4Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 5 /////////////////////////////

    @Test
    public void lic5ReturnsTrueIfConsecutivePointsWhereLaterXCoordinateIsLowerThanFirstExistsAndBothAreNegativeNumbers() {
        //Arrange
        input.X_COORD = new double[]{-1.0, -1.0000001};
        input.NUMPOINTS = input.X_COORD.length;

        //Act
        boolean signal = licAnalyzer.lic5(input);

        //Assertions
        assertTrue(signal);
    }
    @Test
    public void lic5ReturnsTrueIfConsecutivePointsWhereLaterXCoordinateIsLowerThanFirstExistsAndLaterIsNegativeNumber() {
        //Arrange
        input.X_COORD = new double[]{2.0, -1.0};
        input.NUMPOINTS = input.X_COORD.length;

        //Act
        boolean signal = licAnalyzer.lic5(input);

        //Assert
        assertTrue(signal);
    }
    @Test
    public void lic5ReturnsFalseIfNoConsecutivePointsWhereLaterIsGreaterExistsBothNumberPositive() {
        //Arrange
        input.X_COORD = new double[]{2.0, 2.1};
        input.NUMPOINTS = input.X_COORD.length;

        //Act
        boolean signal = licAnalyzer.lic5(input);

        //Assert
        assertFalse(signal);
    }
    @Test
    public void lic5ReturnsFalseIfNoConsecutivePointsWhereLaterIsGreaterExistsBothNumberNegative() {
        //Arrange
        input.X_COORD = new double[]{-2.1, -2.0};
        input.NUMPOINTS = input.X_COORD.length;

        //Act
        boolean signal = licAnalyzer.lic5(input);

        //Assert
        assertFalse(signal);
    }

    @Test
    public void lic5ThrowsIllegalArgumentExceptionIfNUMPOINTSIsNegative() {
        //Arrange
        input.NUMPOINTS = -1;

        //Act, Assert
        assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic5(input));
    }

    @Test
    public void lic5ThrowsIllegalArgumentExceptionIfInvalidArraysForPointsAreProvided() {
        //Arrange
        input.X_COORD = null;
        input.Y_COORD = null;

        //Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> licAnalyzer.lic5(input));

    }

///////////////////////////// Lic 6 /////////////////////////////

    @Test
    public void lic6Test() {
        assertTrue(true);
    }

///////////////////////////// Lic 7 /////////////////////////////

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