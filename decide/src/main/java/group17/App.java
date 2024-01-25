package group17;


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

    private CONNECTOR[][] calculate_PUM(final boolean[] CMV, 
                                        final CONNECTOR[][] LCM) 
    {
    }

    public void decide(InputHandler input) {
        System.out.println( "Entered DECIDE" );

        final boolean[] CMV = evaluate_lics(input);
        final CONNECTOR[][] LCM = calculate_PUM(CMV, input.LCM);

    }

    public static void main( String[] args )
    {
        InputHandler input = new InputHandler("");
        System.out.println( "Hello World!" );

    }
}
