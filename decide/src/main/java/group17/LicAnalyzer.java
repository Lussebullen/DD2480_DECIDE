package group17;

public class LicAnalyzer {

    public boolean lic0(InputHandler input) throws Exception {
        if (input.LENGTH1 < 0.0) {
           throw new Exception("Exception thrown from: LIC 0. LENGTH1 < 0");
        } else if (input.X_COORD == null || input.Y_COORD == null) {
            throw new Exception("Exception thrown from: LIC 0. X_COORD or Y_COORD array points to null!");
        }

        for (int i = 1; i < input.NUMPOINTS; ++i) {
            double xCoordinate2 = input.X_COORD[i];
            double yCoordinate2 = input.Y_COORD[i];

            double xCoordinate1 = input.X_COORD[i - 1];
            double yCoordinate1 = input.Y_COORD[i - 1];

            double dx = Math.pow(xCoordinate2 - xCoordinate1, 2);
            double dy = Math.pow(yCoordinate2 - yCoordinate1, 2);
            double distance = Math.sqrt(dx + dy);

            if (distance > input.LENGTH1) {
                return true;
            }
        }
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
