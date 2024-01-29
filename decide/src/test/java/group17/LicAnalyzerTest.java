package group17;

import org.junit.jupiter.api.Assertions;
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
