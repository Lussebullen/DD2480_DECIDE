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

    /*
     * Evaluate if three points exists such that point 1 and 2 are seperated by quantity1 and point 2 and point 3 are
     * seperated by quantity2 with area greater than AREA1.
     *
     * @param quantity1 Number of consecutive intervening points between point 1 and point 2
     * @param quantity2 Number of consecutive intervening points between point 2 and point 3
     * @param input Class holding relevant data
     *
     * @return boolean True if such points exists, false otherwise
     */
    private boolean helperLic10ThreePointsSeperatedBy(int quantity1, int quantity2, InputHandler input)
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

    /*
     * Evaluates existance of a set of three points seperated by E_PTS and F_PTS 
     * respecively that together has area greather than AREA1.
     *
     * @param  input  object whose members hold data for the problem; relevant 
                      fields for lic10 are: NUMPOINTS, E_PTS, F_PTS, AREA1.
     * @return        true if set exists, false otherwise
     */
    public boolean lic10(InputHandler input) throws Exception {
        if (input.E_PTS < 1 || input.F_PTS < 1) {
            throw new Exception("Exception thrown from: LIC 10. E_PTS < 1 or F_PTS < 1.");
        } else if (input.NUMPOINTS < input.E_PTS + input.F_PTS + 3) {
            throw new Exception("Exception thrown from: LIC 10. NUMPOINTS is lower than E_PTS + F_PTS + 3.");
        }

        if (input.NUMPOINTS < 5) {
            return false;
        }

        boolean pointsFound = helperLic10ThreePointsSeperatedBy(input.E_PTS, input.F_PTS, input);
        if (!pointsFound) {
            // Reverse order
            pointsFound = helperLic10ThreePointsSeperatedBy(input.F_PTS, input.E_PTS, input);
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
