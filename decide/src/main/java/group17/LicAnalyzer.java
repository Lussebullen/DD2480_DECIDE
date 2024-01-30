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

    /**
     *  Checks if a set of three points is separated by C_PTS and D_PTS, and if angle condition is met.
     *  @returns true, false, or @throws IllegalArgumentException
     *  @param input.NUMPOINTS,C_PTS,D_PTS,EPSILON,X_COORD,Y_COORD
    */
    public boolean lic9(InputHandler input) throws IllegalArgumentException {

        if(input.NUMPOINTS < 5 || input.NUMPOINTS > 100)
            throw new IllegalArgumentException("Exception thrown from: LIC 9. Reason: NUMPOINTS < 5 or NUMPOINTS > 100.");
        else if(input.C_PTS < 1 || input.D_PTS < 1 )
            throw new IllegalArgumentException("Exception thrown from: LIC 9. Reason: C_PTS < 1 or D_PTS < 1.");
        else if(input.C_PTS + input.D_PTS > input.NUMPOINTS - 3)
            throw new IllegalArgumentException("Exception thrown from: LIC 9. Reason: C_PTS + D_PTS > NUMPOINTS - 3");
        GeometryUtils geom = new GeometryUtils();
        double x1,x2,x3,y1,y2,y3 = 0;
        int gap1 = input.C_PTS;
        int gap2 = input.D_PTS;
        for(int i = 0; i < input.NUMPOINTS - (gap1 + gap2); i++)
        {
            x1 = input.X_COORD[i];
            x2 = input.X_COORD[i+gap1+1];
            x3 = input.X_COORD[i+gap1+1+gap2+1];

            y1 = input.Y_COORD[i];
            y2 = input.Y_COORD[i+gap1+1];
            y3 = input.Y_COORD[i+gap1+1+gap2+1];

            //coinciding first or last point is undefined -> false
            if(x1 == x2 && y1 == y2 || x3 == x2 && y3 == x2)
                return false;
            double angle = geom.calcAngle(x1, y1, x2, y2, x3, y3);
            if(angle < (Math.PI - input.EPSILON) || angle > (Math.PI + input.EPSILON))
                return true;

            x1 = input.X_COORD[i];
            x2 = input.X_COORD[i+gap2+1];
            x3 = input.X_COORD[i+gap1+1+gap2+1];

            y1 = input.Y_COORD[i];
            y2 = input.Y_COORD[i+gap2+1];
            y3 = input.Y_COORD[i+gap1+1+gap2+1];  
            
            angle = geom.calcAngle(x1, y1, x2, y2, x3, y3);
            if(angle < (Math.PI - input.EPSILON) || angle > (Math.PI + input.EPSILON))
                return true;
        }
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
