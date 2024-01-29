package group17;

public class LicAnalyzer {

    GeometryUtils geoUtils = new GeometryUtils();

    public boolean lic0(InputHandler input) {
        return false;
    }

    public boolean lic1(InputHandler input) {
        return false;
    }

    /**
     * This function calculates Launch Interceptor Condition (LIC) number 2
     *  
     * @param input.NUMPOINTS,EPSILON,X_COORD,Y_COORD
     * @return true if any 3 consecutive points make an angle outside of the EPSILON radius around PI/180 deg
     */
    public boolean lic2(InputHandler input) {

        if (input.NUMPOINTS < 3 || input.NUMPOINTS > 100) {
            throw new IllegalArgumentException("NUMPOINTS must be between 2 (inclusive) and 100 (inclusive)");
        }

        if (input.EPSILON < 0 || input.EPSILON >= Math.PI) {
            throw new IllegalArgumentException("EPSILON must be between 0 (inclusive) and PI (non-inclusive");
        }

        for (int i = 0; i < input.NUMPOINTS - 2; i++) {
            double x1 = input.X_COORD[i], y1 = input.Y_COORD[i];
            double x2 = input.X_COORD[i+1], y2 = input.Y_COORD[i+1];
            double x3 = input.X_COORD[i+2], y3 = input.Y_COORD[i+2];

            if (x2 == x1 && y2 == y1 || x2 == x3 && y2 == y3) {
                continue;
            }

            double angle = geoUtils.calcAngle(x1, y1, x2, y2, x3, y3);

            if (angle < (Math.PI - input.EPSILON) || angle > (Math.PI + input.EPSILON)) {
                return true;
            }
        }

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

    /**
     * This function calculates Launch Interceptor Condition (LIC) number 7
     *
     * @param input.NUMPOINTS,LENGTH1,X_COORD,Y_COORD,K_PTS
     * @return true if the set of two data points separated by input.K_PTS point's distance is greater than LENGTH1
     */
    public boolean lic7(InputHandler input) {

        if (input.NUMPOINTS < 3 || input.NUMPOINTS > 100) {
            throw new IllegalArgumentException("NUMPOINTS must be between 2 (inclusive) and 100 (inclusive)");
        }

        if (input.K_PTS < 1 || input.K_PTS > input.NUMPOINTS-2) {
            throw new IllegalArgumentException("K_PTS must be between 1 (inclusive) and input.NUMPOINTS-2 (inclusive)");
        }

        if (input.LENGTH1 < 0) {
            throw new IllegalArgumentException("LENGTH1 must be a positive number");
        }

        for (int i = 0; i < input.NUMPOINTS - input.K_PTS - 1; i++) {
            double x1 = input.X_COORD[i], y1 = input.Y_COORD[i];
            double x2 = input.X_COORD[i + input.K_PTS + 1], y2 = input.Y_COORD[i + input.K_PTS + 1];

            if (geoUtils.dist(x1, y1, x2, y2) > input.LENGTH1) {
                return true;
            }
        }
        return false;
    }

    public boolean lic8(InputHandler input) {
        return false;
    }

    public boolean lic9(InputHandler input) {
        return false;
    }

    public boolean lic10(InputHandler input) {
        return false;
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
