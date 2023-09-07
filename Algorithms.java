import java.util.ArrayList;

/**
 * This class implements several algorithms.
 */
public class Algorithms
{
    /**
     * Determines the closest pair of points. Brute-force solution is used.
     * 
     * @param points input points. Array is assumed to be fully populated.
     * @param indices output array containing indices of closest pair
     */
    public static void closestPairOfPoints(Point[] points, int[] indices)
    {
        double minDistance = Double.MAX_VALUE;
        for (int i=0; i<points.length; i++)
        {
            for (int j=i+1; j<points.length; j++)
            {
               double d = points[i].distance(points[j]);
               if (d<minDistance)
               {
                   minDistance = d;
                   indices[0] = i;
                   indices[1] = j;
               }
            }
        }
    }
    
    public static int isPointContainedIn(GeometricObject[] g, Point p)
    {
        RectPolygon[] rArray = (RectPolygon[])g;
        
        for (int i=0; i<g.length; i++)
        {
            if (rArray[i].isPointInRectPolygon(p))
                return i;
        }
        
        return -1;
    }

    public static Boolean isThereAnintersection (SimplePolygon pol1, SimplePolygon pol2) {
        LineSegment[] edges1 = pol1.getEdges();
        LineSegment[] edges2 = pol2.getEdges();

        for (int i = 0; i < pol1.getNumberOfVertices(); i++) {
            LineSegment e1 = edges1[i];

            for (int j = 0; j < pol2.getNumberOfVertices(); j++) {
                LineSegment e2 = edges2[j];
                Point p = new Point();
                if (e1.intersect(e2, p) == 1) return true;
            }
        }
        return false;
    }
}
