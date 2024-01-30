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

    /**
     * Calculates and returns the distance between the points (x1,y1), (x2,y2).
     * @param x1 X coordinate of first point.
     * @param y1 Y coordinate of first point.
     * @param x2 X coordinate of second point.
     * @param y2 Y coordinate of second point.
     * @return double
     */
    public double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

     /**
     * Calculates the area of the triangle between the points (x1, y1), (x2, y2) and (x3, y3).
     * The distance between the first two points is treated as the length of the hypotenuse.
     * The angle is formed at point (x2, y2).
     * 
     * @param x1 The x coodinate of the first point
     * @param y1 The y coodinate of the first point
     * @param x2 The x coodinate of the second point where the angle is formed
     * @param y2 The y coodinate of the second point where the angle is formed
     * @param x3 The x coodinate of the third point
     * @param y3 The y coodinate of the third point
     * @return The area of the triangle defined by the points.
     */
    public double calcTriangleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double angle = calcAngle(x1, y1, x2, y2, x3, y3);
        double hypotenuse = dist(x1, y1, x2, y2);
        double height = Math.sin(angle) * hypotenuse;
        double base = dist(x2, y2, x3, y3);

        double triangleArea = height * base / 2;
        return triangleArea;
    }
}
