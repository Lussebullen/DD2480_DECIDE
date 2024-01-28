package group17;

public class LicAnalyzer {

    public boolean lic0(InputHandler input) {
        return false;
    }

    public boolean lic1(InputHandler input) {
        return false;
    }

    public boolean lic2(InputHandler input) {
        return false;
    }

    public boolean lic3(InputHandler input) {
        return false;
    }

    public boolean lic4(InputHandler input) {
        return false;
    }

    public boolean lic5(InputHandler input) {
        return false;
    }

    public boolean lic6(InputHandler input) {
        return false;
    }

    public boolean lic7(InputHandler input) {
        return false;
    }

    public boolean lic8(InputHandler input) {
        return false;
    }

    public boolean lic9(InputHandler input) {
        return false;
    }

    private boolean helperLic10ThreePointsSeperateBy(int quantity1, int quantity2, InputHandler input)
    {
        for (int i = quantity1 + quantity2 + 2; i < input.NUMPOINTS; ++i) {
            int vertex3 = i;
            int vertex2 = i - quantity1 - 1;
            int vertex1 = i - quantity1 - quantity2 - 2;

            //Calculate triangle area from three points using shoelace formula
            double xCoordinate1 = input.X_COORD[vertex1];
            double yCoordinate1 = input.Y_COORD[vertex1];

            double xCoordinate2 = input.X_COORD[vertex2];
            double yCoordinate2 = input.Y_COORD[vertex2];

            double xCoordinate3 = input.X_COORD[vertex3];
            double yCoordinate3 = input.Y_COORD[vertex3];

            double triangleArea = 0.5 * Math.abs( (xCoordinate1 - xCoordinate3) * (yCoordinate2 - yCoordinate1)
                                                 -(xCoordinate1 - xCoordinate2) * (yCoordinate3 - yCoordinate1)
                                                );
            if (triangleArea > input.AREA1) {
                return true;
            }
        }

        return false;
    }

    public boolean lic10(InputHandler input) throws Exception {
        if (input.E_PTS < 1 || input.F_PTS < 1) {
            throw new Exception("Exception thrown from: LIC 10. E_PTS < 1 or F_PTS < 1.");
        } else if (input.NUMPOINTS < input.E_PTS + input.F_PTS + 3) {
            throw new Exception("Exception thrown from: LIC 10. NUMPOINTS is lower than E_PTS + F_PTS + 3.");
        }

        if (input.NUMPOINTS < 5) {
            return false;
        }

        boolean pointsFound = helperLic10ThreePointsSeperateBy(input.E_PTS, input.F_PTS, input);
        if (!pointsFound) {
            // Reverse order
            pointsFound = helperLic10ThreePointsSeperateBy(input.F_PTS, input.E_PTS, input);
        }
        return pointsFound;

    }

    public boolean lic11(InputHandler input) {
        return false;
    }

    public boolean lic12(InputHandler input) {
        return false;
    }

    public boolean lic13(InputHandler input) {
        return false;
    }

    public boolean lic14(InputHandler input) {
        return false;
    }

    public boolean lic15(InputHandler input) {
        return false;
    }

}
