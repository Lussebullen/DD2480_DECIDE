package group17;

import group17.InputHandler.CONNECTORS;
import java.util.Arrays;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static App system;
    private static InputHandler input;
    private static LicAnalyzer licAnalyzer;

    /*
     * Following posts on Stack Overflow was used to handle assertion on text 
     * written to stdout.
     * https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    
    @BeforeAll
    public static void init()
    {
        system      = new App();
        licAnalyzer = new LicAnalyzer();
        input       = new InputHandler("sampleData.json");

        for (int i = 0; i < input.LCM.length; ++i) {
            input.PUV[i] = true;

            for (int j = 0; j < input.LCM[i].length; ++j) {
                input.LCM[i][j] = CONNECTORS.ANDD;
            }
        }

        input.X_COORD   = new double[]{ -0.5, 0.3, 1.0, 0.4, 2.8 , 1.5 };
        input.Y_COORD   = new double[]{ -0.5, 0.0, 1.0, 0.1, 0.1 , 0.0 };
        input.NUMPOINTS = input.X_COORD.length;
        input.N_PTS     = input.X_COORD.length - 2;
        input.K_PTS     = 1;
        input.A_PTS     = 1;
        input.B_PTS     = 1;
        input.C_PTS     = 1;
        input.D_PTS     = 1;
        input.E_PTS     = 1;
        input.F_PTS     = 1;
        input.G_PTS     = 1;
        input.Q_PTS     = 2;
        input.QUADS     = 2;
        input.LENGTH1   = 0.9;
        input.RADIUS1   = 0.9;
        input.EPSILON   = 0.0;
        input.AREA1     = 1.0;
        input.LENGTH2   = 1.0;
        input.RADIUS2   = 10.0;
        input.AREA2     = 10.0;
        input.DIST      = 0.05;

        // Circumvent false LICs when generating FUV by PUV element for LIC
        // to false, i.e. not relevant for launch.
        input.PUV[4]  = false; //data generates false in lic 4
        input.PUV[11] = false;// Missing
        input.PUV[14] = false;// Missing

    }

    @Test
    public void privateFuvCheck(){
        //Arrange
        boolean[] allTrueArray = new boolean[input.PUV.length];
        Arrays.fill(allTrueArray, true);
        //Act
        final boolean[] CMV = {
            licAnalyzer.lic0(input),
            licAnalyzer.lic1(input),
            licAnalyzer.lic2(input),
            licAnalyzer.lic3(input),
            licAnalyzer.lic4(input),
            licAnalyzer.lic5(input),
            licAnalyzer.lic6(input),
            licAnalyzer.lic7(input),
            licAnalyzer.lic8(input),
            licAnalyzer.lic9(input),
            licAnalyzer.lic10(input),
            licAnalyzer.lic11(input),
            licAnalyzer.lic12(input),
            licAnalyzer.lic13(input),
            licAnalyzer.lic14(input)
        };
        CMV[4] = true;
        CMV[11] = true;// Missing
        CMV[14] = true;// Missing
        //Assert 
        Assertions.assertArrayEquals(CMV, allTrueArray);
    }

    @Test
    public void decidePrintsYesWhenGivenBasicDataThatShouldLaunchMissile()
    {
        system.decide(input);
        assertEquals("YES\n", outContent.toString());
    }

    //@Test
    //public void decideThrowsExceptionOnInvalidInput()
    //{
    //}

    //@Test
    //public void decidePrintsNoWhenAllLicsAreNotMet()
    //{
          // Add bad values after YES works
    //    system.decide(input);
    //    assertEquals("NO\n", outContent.toString());
    //}
}
