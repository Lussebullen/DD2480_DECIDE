package group17;

import group17.InputHandler.CONNECTORS;

public class App 
{
    private boolean[] evaluate_lics(InputHandler input)
    {
        LicAnalyzer licAnalyzer = new LicAnalyzer();
        final boolean[] lic_outcomes = {
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

        return lic_outcomes;
    }

    private boolean[][] calculate_PUM(final boolean[] CMV, 
                                      final CONNECTORS[][] LCM) 
    {
        final int CMV_length = CMV.length;
        boolean[][] PUM = new boolean[CMV_length][CMV_length];
        for (int row = 0; row < CMV_length; ++row) {
            for (int col = 0; col < CMV_length; ++col) {

                CONNECTORS operation = LCM[row][col];
                switch (operation) {
                    case ANDD:
                        PUM[row][col] = CMV[row] && CMV[col];
                        break;
                    case ORR:
                        PUM[row][col] = CMV[row] || CMV[col];
                        break;
                    case NOTUSED:
                        PUM[row][col] = true;
                        break;
                }
            }
        }
        return PUM;
    }

    private boolean[] calculate_FUV(final boolean[][] PUM,
                                    final boolean[] PUV)
    {
        final int signals = PUV.length;
        boolean[] FUV = new boolean[signals];
        for (int i = 0; i < signals; ++i) {
            if (PUV[i] == false) {
                FUV[i] = true;
                continue;
            }
            for (int j = 0; j < signals; ++j) {
               if (PUM[i][j] == true || i == j) {
                   continue;
               } else if (PUM[i][j] == false) {
                   return FUV;
               }
            }
            FUV[i] = true;
        }
        return FUV;
    }

    public void decide(InputHandler input) {
        System.out.println( "Entered DECIDE" );

        final boolean[]   CMV = evaluate_lics(input);
        final boolean[][] PUM = calculate_PUM(CMV, input.LCM);
        final boolean[]   FUV = calculate_FUV(PUM, input.PUV);

        for (boolean signal : FUV) {
            if (signal == true) {
                continue;
            } 
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }

    public static void main( String[] args )
    {
        InputHandler input = new InputHandler("");
        System.out.println( "Hello World!" );

    }
}
