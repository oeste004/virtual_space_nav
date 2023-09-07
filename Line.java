import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * This class represents a line in the plane, given by the equation
 * ax + by + c = 0
 */
public class Line extends GeometricObject {
    private double a; //x coefficient
    private double b; //y coefficient
    private double c; //constant term
    
    /**
     * Instantiates a line object as -x + y = 0 or y = x
     */
    public Line () {
        a = -1;
        b = 1;
        c = 0;
    }
    
    /**
     * Instantiates a line object as ax + by + c = 0 or y = (-a/b) x + (-c/b)
     */
    public Line(double a, double b, double c) throws IllegalArgumentException {
        //a=0 and b=0 does not define a line
        if (a==0 && b==0) throw new IllegalArgumentException();
        else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    /**
     * Draws this line
     * 
     * @param g graphic context
     */
    @Override
    public void draw(Graphics g) {
        //finds the window size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double maxX = screenSize.width;
        double maxY = screenSize.height;
        
        //obtain two points on this line, (x1, y1) and (x2, y2)
        double x1, y1, x2, y2;
        
        if (!isVertical()) { //line is not vertical
            x1 = 0.0;
            y1 = getY(x1);
            x2 = maxX;
            y2 = getY(x2);
        }
        else { //line is vertical
            y1 = 0.0;
            x1 = getX(y1);
            y2 = maxY;
            x2 = getX(y2);
        }
        
        g.setColor(getBoundaryColor());
        g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    }
    
    /**
     * Returns the coefficient of the X variable in the equation of this line
     * object.
     * 
     * @return coefficient of the X variable in the equation of this line object.
     */
    public double getA() {
        return a;
    }
    
    /**
     * Returns the coefficient of the Y variable in the equation of this line
     * object.
     * 
     * @return coefficient of the Y variable in the equation of this line object.
     */
    public double getB() {
        return b;
    }
    
    /**
     * Returns the independent term of the equation of this line
     * object.
     * 
     * @return independent term of the equation of this line object.
     */
    public double getC() {
        return c;
    }
    
    /**
     * Given x, calculate the value of y
     * 
     * @param x x value
     * @return value of y
     * @throw IllegalState Exception
     */
    public double getY(double x) throws IllegalStateException {
        if (b != 0) {
            return (-a / b) * x + (-c / b);
        }
        else { 
            throw new IllegalStateException("Vertical line cannot be used here");
        }
    }
    
    /**
     * Given y, calculate the value of x
     * 
     * @param y y value
     * @return value of x
     * @throw IllegalState Exception
     */
    public double getX(double y) throws IllegalStateException {
        if (a != 0) {
            return (-b / a) * y + (-c / a);
        }
        else { 
            throw new IllegalStateException("Horizontal line cannot be used here");
        }
    }
    
    /**Determines if this line is vertical
     * 
     * @return true if this line is vertical, false otherwise
     */
    boolean isVertical() {
        return b == 0;
    }
    
    /**
     * Sets the coefficient of the X variable in the equation of this line
     * object
     * 
     * @param a value of the coefficient
     * @throws IllegalStateException if a=0 and b=0
     */
    public void setA(double a) throws IllegalStateException{
        //a=0 and b=0 does not define a line
        if (a==0 && this.b==0) throw new IllegalStateException();
        else {
            this.a = a;
        }
    }
    
    /**
     * Sets the coefficient of the Y variable in the equation of this line
     * object
     * 
     * @param b value of the coefficient
     * @throws IllegalStateException if a=0 and b=0
     */
    public void setB(double b) throws IllegalStateException {
        //a=0 and b=0 does not define a line
        if (this.a==0 && b==0) throw new IllegalStateException();
        else {
            this.b = b;
        }
    }
    
    /**
     * Sets the independent term of the equation of this line object
     * 
     * @param c independent term
     */
    public void setC(double c) {
        this.c = c;
    }
    
    /**
     * Sets this line object as ax + by + c = 0 or y = (-a/b) x + (-c/b)
     */
    public void setLine(double a, double b, double c) throws IllegalStateException {
        //a=0 and b=0 does not define a line
        if (a==0 && b==0) throw new IllegalStateException();
        else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    /**
     * Instantiates a line object that passes through two given points.
     * 
     * @param p One of the points the line passes through
     * @param q One of the points the line passes through
     * @throws IllegalArgumentException 
     */
    public Line(Point p, Point q) throws IllegalArgumentException {
        //Point p and q are the same points
        if (p.getX()==q.getX() && p.getY()==q.getY()) 
            throw new IllegalStateException();
        else {
            if (p.getX()==q.getX()) {
                this.a = 1;
                this.b = 0;
                this.c = -(p.getX());
            }
            else {
                this.a = (q.getY() - p.getY()) / (q.getX() - p.getX());
                this.b = -1;
                this.c = p.getY() - (a * p.getX());
            }
        }
    }
    
    public double distanceFromPoint(Point p) {
        double n;
        double distance;
        
        n = Math.abs((a * p.getX()) + (b * p.getY() + c));
        distance = n / Math.sqrt((Math.pow(a, 2)) + (Math.pow(b, 2)));
        
        return distance;
    }
    
    /**
     * Returns -1, 0, or 1 depending on the relative position of the given point
     * and this line.
     * 
     * Line is not vertical:
     * -1: if point is below the line
     * 0: if point is on the line
     * 1: if point is to the right of the line
     * 
     * @param p point
     * @return -1, 0, or 1 depending on the relative position of p and this line
     */
    public int pointRelativePosition(Point p) {
        int relativePosition = 0;
        
        if (!isVertical()) {
            double yCoord = getY(p.getX());
            if (yCoord > p.getY()) relativePosition = -1;
            else
                if (yCoord == p.getY()) relativePosition = 0;
                else relativePosition = 1;
        }
        else {
            double xCoord = -c/a; //can be also obtained with getX(p.getY())
            if (xCoord > p.getX()) relativePosition = -1;
            else {
                if (xCoord == p.getX()) relativePosition = 0;
                else relativePosition = 1;
            }
        }
        
        return relativePosition;
    }

    
    /**
     * Constructs a String description of this line
     * 
     * @return String containing a description of this line
     */
    @Override
    public String toString() {
        String str = "LINE " + a + " " + b + " " + c + " " + super.toString();
        
        return str;
    }
    
}