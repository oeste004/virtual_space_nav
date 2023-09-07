import java.awt.Graphics;

/**
 * This class represents a rectilinear polygon with sides parallel to the axis;
 * polygon is given by its vertices listed in counterclockwise order.
 */
public class SimplePolygon extends GeometricObject
{

    private Point[] vertexList; //list of vertices in counterclockwise order
    private int size;   //capacity of array vertexList
    private int vertNumber; //number of vertices of this polygon

    /**
     * Instantiates an empty RectPolygon object. Vertex array size is
     * set to 4.
     */
    public SimplePolygon() {
        size = 100;
        vertexList = new Point[size];
        vertNumber = 0;
    }

    /**
     * Adds a vertex as the last one in the sequence of vertices. Vertex array
     * will be expanded to double its size if vertex cannot be added because
     * array is full.
     *
     * @param v the new vertex
     */
    public void addVertex(Point v) {
        vertexList[vertNumber] = v;
        vertNumber++;
    }

    /**
     * Computes the area of this polygon using shoelace algorithm.
     *
     * @return area of this polygon
     */
    public double area()
    {
        if (vertNumber < 4) return Double.NaN;
        
        double sum1 = 0.0;
        double sum2 = 0.0;
        Point v1, v2;
        
        for (int i = 0; i < vertNumber; i++) {
            v1 = vertexList[i];
            v2 = vertexList[(i + 1) % vertNumber];
            
            sum1 += v1.getX() * v2.getY();
            sum2 += v2.getX() * v1.getY();
        }
        
        double area = 0.5 * Math.abs(sum1 - sum2);
        
        return area;
    }

    /**
     * Determines the smallest rectangle bounding this polygon.
     *
     * @return bounding rectangle
     */
    public Rectangle boundingRectangle()
    {
        double topX = vertexList[0].getX();
        
        for (int i = 1; i < vertNumber; i++) {
            double x = vertexList[i].getX();
            if (x < topX) {
                topX = x;
            }
        }
        
        double topY = vertexList[0].getY();
        
        for (int i = 1; i < vertNumber; i++) {
            double y = vertexList[i].getY();
            if (y > topY) {
                topY = y;
            }
        }
        
        Point p2 = new Point(topX, topY);
        
        double bottomX = vertexList[0].getX();
        
        for (int i = 1; i < vertNumber; i++) {
            double x = vertexList[i].getX();
            if (x > bottomX) {
                bottomX = x;
            }
        }
        
        double bottomY = vertexList[0].getY();
        
        for (int i = 1; i < vertNumber; i++) {
            double y = vertexList[i].getY();
            if (y < bottomY) {
                bottomY = y;
            }
        }

        Point p1 = new Point(bottomX, bottomY);
        
        Rectangle r = new Rectangle(p2,p1);
        return r;
    }

    /**
     * Draws this polygon.
     *
     * @param g graphics context
     */
    @Override
    public void draw(Graphics g)
    {
        int[] xCoord = new int[vertNumber];
        int[] yCoord = new int[vertNumber];
        
        for (int i = 0; i < vertNumber; i++) {
            xCoord[i] = (int)vertexList[i].getX();
            yCoord[i] = (int)vertexList[i].getY();
        }
        
        g.setColor(getInteriorColor());
        g.fillPolygon(xCoord, yCoord, vertNumber);
        
        g.setColor(getBoundaryColor());
        g.drawPolygon(xCoord, yCoord, vertNumber);
    }
    
    public LineSegment[] getEdges() {
        LineSegment[] edges = new LineSegment[vertNumber];
        for (int i = 0; i < vertNumber; i++) {
            LineSegment tempLine = new LineSegment();
            if (i + 1 != vertNumber) {
                Point p1 = vertexList[i];
                Point p2 = vertexList[i+1];
                tempLine.setBegin(p1);
                tempLine.setEnd(p2);
            } else {
                Point p1 = vertexList[i];
                Point p2 = vertexList[0];
                tempLine.setBegin(p1);
                tempLine.setEnd(p2);
            }
            edges[i] = tempLine;
        }
        
        return edges;
    }

    /**
     * Returns the number of vertices in this polygon
     *
     * @return number of vertices in this polygon
     */
    public int getNumberOfVertices()
    {
        return vertNumber;
    }
    
    public Point[] getVertices() {
        Point[] p = new Point[vertNumber];
        
        for (int i = 0; i < vertNumber; i++) {
            p[i] = vertexList[i];
        }
        return p;
    }

    /**
     * Determines the greatest x.
     *
     * @return the greatest x
     */
    public double greatestX()
    {
        double max = vertexList[0].getX();
        
        for (int i = 1; i < vertNumber; i++) {
            double x = vertexList[i].getX();
            if (x > max) {
                max = x;
            }
        }
        
        return max;
    }

    /**
     * Determines the greatest y.
     *
     * @return the greatest y
     */
    public double greatestY()
    {
        double max = vertexList[0].getY();
        
        for (int i = 1; i < vertNumber; i++) {
            double y = vertexList[i].getY();
            if (y > max) {
                max = y;
            }
        }
        
        return max;
    }

    /**
     * Determines if given point is contained in this polygon.
     *
     * @param p given point
     * @return true if p is on the boundary or the interior of this polygon.
     */
    public boolean isPointInRectPolygon(Point p)
    {
        double pX = p.getX();
        double pY = p.getY();
        boolean matchingX = false;
        boolean matchingY = false;
        boolean inside = false;
        int countVert = 0;
        int countHorz = 0;
        
        for (int i = 0; i < vertNumber; i++) {
            Point v1 = vertexList[i];
            Point v2;
            if (i + 1 == vertNumber) {
                v2 = vertexList[0];
            }
            else {
                v2 = vertexList[i+1];
            }
            
            double v1X = v1.getX();
            double v1Y = v1.getY();
            double v2X = v2.getX();
            double v2Y = v2.getY();
            
            //vertical edge
            if (v1X == v2X && pX > v1X){
                if ((pY > v1Y && pY < v2Y) || (pY < v1Y && pY > v2Y)) {
                    countVert++;
                }
            }
            
            //horizontal edge
            if (v1Y == v2Y && pY > v1Y) {
                if ((pX > v1X && pX < v2X) || (pX < v1X && pX > v2X)) {
                    countHorz++;
                }
            }
        }
            
        if ((countVert % 2 != 0) && (countHorz % 2 != 0)) {
            inside = true;
        }
        
        for (int i = 0; i < vertNumber; i++) {
            double x = vertexList[i].getX();
            if (pX == x){
                matchingX = true;
            }
        }
        
        for (int i = 0; i < vertNumber; i++) {
            double y = vertexList[i].getY();
            if (pY == y){
                matchingY = true;
            }
        }
        
        return inside;
    }

    /**
     * Determines the smallest x.
     *
     * @return the smallest x
     */
    public double smallestX()
    {
        double min = vertexList[0].getX();
        
        for (int i = 1; i < vertNumber; i++) {
            double x = vertexList[i].getX();
            if (x < min) {
                min = x;
            }
        }
        
        return min;
    }

    /**
     * Determines the smallest y.
     *
     * @return the smallest y
     */
    public double smallestY()
    {
        double min = vertexList[0].getY();
        
        for (int i = 1; i < vertNumber; i++) {
            double y = vertexList[i].getY();
            if (y < min) {
                min = y;
            }
        }
        
        return min;
    }
    
    public static boolean isThereAnIntersection(SimplePolygon pol1,
            SimplePolygon pol2) {

        LineSegment[] edges1 = pol1.getEdges();
        LineSegment[] edges2 = pol2.getEdges();

        for (int i = 0; i < pol1.getNumberOfVertices(); i ++) {
            LineSegment e1 = edges1[i];

            for (int j = 0; j < pol2.getNumberOfVertices(); j++) {
                LineSegment e2 = edges2[j];
                Point p = new Point();
                if (e1.intersect(e2, p) == 1) return true;
            }
        }

        // boolean intersection = false;
        // int pol1Length = pol1.getNumberOfVertices();
        // int pol2Length = pol2.getNumberOfVertices();
        // LineSegment [] pol1Edges = new LineSegment[pol1Length];
        // LineSegment [] pol2Edges = new LineSegment[pol2Length];
        
        // for (int i = 0; i < pol1Length; i++) {
        //     for(int j = 0; j < pol2Length; i++) {
        //         Point p = new Point();
        //         int temp = pol1Edges[i].intersect(pol2Edges[j], p);
        //         if (temp == 1) {
        //             intersection = true;
        //         }
        //     }
        // }
        return false;
    }

    /**
     * Constructs a String description of this polygon.
     *
     * @return String containing vertices of this polygon.
     */
    @Override
    public String toString()
    {
        String str = "RectPolygon " + super.toString() + "\n";
        for (int i = 0; i < vertNumber; i++) {
            String x = String.valueOf(vertexList[i].getX());
            String y = String.valueOf(vertexList[i].getY());
            
            str += "(" + x + ", " + y + ")";
            
            if (i != vertNumber-1) {
                str += ", \n";
            }
        }

        return str;
    }

    /**
     * Translates this polygon by given vector.
     *
     * @param v given vector
     */
    public void translate(Vector v)
    {
        for (Point p : vertexList) {
            p.translate(v);
        }
    }
}
