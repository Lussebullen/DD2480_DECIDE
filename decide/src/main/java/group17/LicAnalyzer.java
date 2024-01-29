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

    public boolean lic5(InputHandler input) throws IllegalArgumentException {
        if (input.NUMPOINTS < 0) {
            throw new IllegalArgumentException("Exception thrown from: LIC 5. NUMPOINTS can't be < 0.");
        }
        if (input.X_COORD == null || input.Y_COORD == null) {
            throw new IllegalArgumentException("Exception thrown from: LIC 5. X_COORD or Y_COORD array points to null!");
        }
        for (int i = 1; i < input.NUMPOINTS; ++i) {
            double xCoordinate2 = input.X_COORD[i];
            double xCoordinate1 = input.X_COORD[i - 1];

            if (xCoordinate2 < xCoordinate1) {
                return true;
            }
        }
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
