package group17;
import java.lang.Math;

public class LicAnalyzer {

    public boolean lic0(InputHandler input) {
        return false;
    }

    
    /** 
     * Calculates and returns the distance between the points (x1,y1), (x2,y2).
     * @param x1 X coordinate of first point.
     * @param y1 Y coordinate of first point.
     * @param x2 X coordinate of second point.
     * @param y2 Y coordinate of second point.
     * @return double
     */
    private double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    
    /** 
     * Calculates and returns the circumradius of the points (x1,y1), (x2,y2), (x3,y3).
     * @param x1 X coordinate of first point.
     * @param y1 Y coordinate of first point.
     * @param x2 X coordinate of second point.
     * @param y2 Y coordinate of second point.
     * @param x3 X coordinate of third point.
     * @param y3 Y coordinate of third point.
     * @return double
     */
    private double circumRadius(double x1, double y1, double x2, double y2, double x3, double y3) {
        double a = dist(x1, y1, x2, y2);
        double b = dist(x2, y2, x3, y3);
        double c = dist(x3, y3, x1, y1);
        double s = (a + b + c) / 2;
        
        return a*b*c / (4*Math.sqrt(s*(s-a)*(s-b)*(s-c)));
    }

    
    /** 
     * Calculates and returns the radius of the smallest enclosing circle for the points (x1,y1), (x2,y2), (x3,y3).
     * @param x1 X coordinate of first point.
     * @param y1 Y coordinate of first point.
     * @param x2 X coordinate of second point.
     * @param y2 Y coordinate of second point.
     * @param x3 X coordinate of third point.
     * @param y3 Y coordinate of third point.
     * @return double
     */
    private double minimumEnclosingRadius(double x1, double y1, double x2, double y2, double x3, double y3) {
        double radius = circumRadius(x1, y1, x2, y2, x3, y3);
        double[] X = new double[] {x1, x2, x3};
        double[] Y = new double[] {y1, y2, y3};
        for (int i=0; i<3; i++) {
            double midX = (X[(i+1) % 3] + X[i]) / 2;
            double midY = (Y[(i+1) % 3] + Y[i]) / 2;
            double radius_temp = dist(X[i], Y[i], X[(i+1) % 3], Y[(i+1) % 3]) / 2;
            // If last point contained, update radius.
            if (dist(midX, midY, X[(i+2) % 3], X[(i+2) % 3]) <= radius_temp) {
                radius = radius_temp;
            }
        }
        return radius;
    }

    
    /** 
     * @param input
     * @return boolean
     */
    public boolean lic1(InputHandler input) {
        double threshold_radius = input.RADIUS1;
        // Number of sets to check enclosing radius for.
        int n = input.NUMPOINTS - 2;
        double[] X = input.X_COORD;
        double[] Y = input.Y_COORD;

        if (n < 1) {
            throw new IllegalArgumentException("There must be 3 or more points to determine circumradius.");
        }
        if (threshold_radius < 0) {
            throw new IllegalArgumentException("RADIUS1 cannot be strictly less than 0.");
        }

        for (int i = 0; i < n; i++) {
            double radius = minimumEnclosingRadius(X[i],Y[i],X[i+1],Y[i+1],X[i+2],Y[i+2]);
            if (radius > threshold_radius) {
                // The three points cannot fit within threshold radius.
                return true;
            }
        }

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
