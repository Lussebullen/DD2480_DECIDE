package group17;

/**
 * This class contains all the geometry utility functions needed to solve the LICs
 * 
 * @author Group17
 * @verison 1.0
 */
public class GeometryUtils {

    /**
     * The method calcAngle calculates the angle between the two vectors that go from (x2,y2) to (x1,y1) and (x3,y3) respectively 
     * 
     * @param x1 The x coodinate of the first point
     * @param y1 The y coodinate of the first point
     * @param x2 The x coodinate of the second point where the angle is formed
     * @param y2 The y coodinate of the second point where the angle is formed
     * @param x3 The x coodinate of the third point
     * @param y3 The y coodinate of the third point
     * @return The angle between two vectors that go from (x2,y2) to (x1,y1) and (x3,y3) respectively 
     */
    public double calcAngle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double uX = x2 - x1;
        double uY = y2 - y1;
        double vX = x2 - x3;
        double vY = y2 - y3;
        double uv_dotProduct = (uX * vX) + (uY * vY);

        double uMagnitude = Math.sqrt(Math.pow(uX, 2) + Math.pow(uY, 2));
        double vMagnitude = Math.sqrt(Math.pow(vX, 2) + Math.pow(vY, 2));

        return Math.acos(uv_dotProduct / (uMagnitude * vMagnitude));
    }
}