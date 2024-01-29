package group17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

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
        public void lic4TestQptsDoNotCover() {
            assumeTrue(input.Q_PTS >= 2 && input.Q_PTS <= input.NUMPOINTS);
            assumeTrue(input.QUADS >= 1 && input.QUADS <= 3);
            assumeTrue(input.Q_PTS > input.QUADS);
            
            input.Q_PTS = 3;
            input.QUADS = 2;
            input.NUMPOINTS = 4;
            input.X_COORD = new double[]{0, 2, -4, 1};
            input.Y_COORD = new double[]{1, 3, -5, 4};
            assertFalse(licAnalyzer.lic4(input));
        }

        public void lic4TestQptsDoCover() {
            assumeTrue(input.Q_PTS >= 2 && input.Q_PTS <= input.NUMPOINTS);
            assumeTrue(input.QUADS >= 1 && input.QUADS <= 3);
            assumeTrue(input.Q_PTS > input.QUADS);
            
            input.Q_PTS = 3;
            input.QUADS = 2;
            input.NUMPOINTS = 4;
            input.X_COORD = new double[]{0, -2, -4, 1};
            input.Y_COORD = new double[]{1, 3, -5, 4};
            assertTrue(licAnalyzer.lic4(input));
        }

        public void lic4TestQuadsHigerOrEqualThanQptsCoverage() {
            assumeTrue(input.Q_PTS >= 2 && input.Q_PTS <= input.NUMPOINTS);
            assumeTrue(input.QUADS >= 1 && input.QUADS <= 3);
            assumeFalse(input.Q_PTS > input.QUADS);
            
            input.Q_PTS = 3;
            input.QUADS = 3;
            input.NUMPOINTS = 4;
            input.X_COORD = new double[]{0, -2, -4, 1};
            input.Y_COORD = new double[]{1, 3, -5, 4};
            assertFalse(licAnalyzer.lic4(input));
        }

        public void lic4TestInvalidInputQpts() {
            assumeFalse(input.Q_PTS >= 2 && input.Q_PTS <= input.NUMPOINTS);
            assumeTrue(input.QUADS >= 1 && input.QUADS <= 3);
            
            input.Q_PTS = 1;
            input.QUADS = 3;
            input.NUMPOINTS = 4;
            input.X_COORD = new double[]{0, -2, -4, 1};
            input.Y_COORD = new double[]{1, 3, -5, 4};
            assertFalse(licAnalyzer.lic4(input));
            assertThrows(IllegalArgumentException.class, () ->  licAnalyzer.lic4(input));
        }

        public void lic4TestInvalidInputQuads() {
            assumeTrue(input.Q_PTS >= 2 && input.Q_PTS <= input.NUMPOINTS);
            assumeFalse(input.QUADS >= 1 && input.QUADS <= 3);
            
            input.Q_PTS = 3;
            input.QUADS = 4;
            input.NUMPOINTS = 4;
            input.X_COORD = new double[]{0, -2, -4, 1};
            input.Y_COORD = new double[]{1, 3, -5, 4};
            assertFalse(licAnalyzer.lic4(input));
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
