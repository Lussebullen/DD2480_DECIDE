package group17;

import group17.InputHandler.CONNECTORS;

public class App 
{
    public void decide(InputHandler input) {
        System.out.println( "Entered DECIDE" );
        LicAnalyzer licAnalyzer = new LicAnalyzer();
        boolean[] CMV = new boolean[15];
        CMV[0]  = licAnalyzer.lic0(input);
        CMV[1]  = licAnalyzer.lic1(input);
        CMV[2]  = licAnalyzer.lic2(input);
        CMV[3]  = licAnalyzer.lic3(input);
        CMV[4]  = licAnalyzer.lic4(input);
        CMV[5]  = licAnalyzer.lic5(input);
        CMV[6]  = licAnalyzer.lic6(input);
        CMV[7]  = licAnalyzer.lic7(input);
        CMV[8]  = licAnalyzer.lic8(input);
        CMV[9]  = licAnalyzer.lic9(input);
        CMV[10] = licAnalyzer.lic10(input);
        CMV[11] = licAnalyzer.lic11(input);
        CMV[12] = licAnalyzer.lic12(input);
        CMV[13] = licAnalyzer.lic13(input);
        CMV[14] = licAnalyzer.lic14(input);
    }

    public static void main( String[] args )
    {
        InputHandler input = new InputHandler("");
        System.out.println( "Hello World!" );

    }
}
