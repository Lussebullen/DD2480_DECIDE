package group17;

import group17.InputHandler.CONNECTORS;

public class App 
{
    private boolean[] evaluate_lics(final InputHandler input)
    {
        LicAnalyzer licAnalyzer = new LicAnalyzer();
        final boolean[] lic_signals = {
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

        return lic_signals;
    }

    private boolean[][] calculate_PUM(final boolean[] CMV, 
                                      final CONNECTORS[][] LCM) 
    {
        final int conditionals = CMV.length;
        boolean[][] PUM = new boolean[conditionals][conditionals];
        for (int i = 0; i < conditionals; ++i) {
            for (int j = 0; j < conditionals; ++j) {

                CONNECTORS operation = LCM[i][j];
                switch (operation) {
                    case ANDD:
                        PUM[i][j] = CMV[i] && CMV[j];
                        break;
                    case ORR:
                        PUM[i][j] = CMV[i] || CMV[j];
                        break;
                    case NOTUSED:
                        PUM[i][j] = true;
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

    public void decide(final InputHandler input) {
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
        App missile_system = new App();
        missile_system.decide(input);
        System.out.println( "Hello World!" );

    }
}
