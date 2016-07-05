/*************************************************************************
 *  YOU DO NOT NEED TO MODIFY THIS FILE
 *
 *  Compilation:  javac NearestInsertion.java
 *  Execution:    java NearestInsertion < file.txt
 *  Dependencies: Tour.java Point.java StdIn.java StdDraw.java
 *
 *  Run nearest neighbor insertion heuristic for traveling
 *  salesperson problema nd plot results.
 *
 *  % java NearestInsertion < tsp1000.txt
 *
 *************************************************************************/

public class NearestInsertion {
static double a[][] = {{110.0, 225.0},
{161.0, 280.0},
{325.0, 554.0},
{490.0, 285.0},
{157.0, 443.0},
{283.0, 379.0},
{397.0, 566.0},
{306.0, 360.0},
{343.0, 110.0},
{552.0, 199.0}};
    public static void main(String[] args) {

        // get dimensions
        int w = StdIn.readInt();
        int h = StdIn.readInt();
        StdDraw.setCanvasSize(w, h);
        StdDraw.setXscale(0, w);
        StdDraw.setYscale(0, h);

        // turn on animation mode
        StdDraw.show(0);

        // run smallest insertion heuristic
        Tour tour = new Tour();
       // int i = 0;
        while (!StdIn.isEmpty()) {
            double x =StdIn.readDouble();
            double y =StdIn.readDouble();
            Point p = new Point(x, y);
            
            tour.insertNearest(p);
           
          // i++;
          // if(i == 10) break;
            // uncomment the 4 lines below to animate
             StdDraw.clear();
             tour.draw();
             StdDraw.text(100, 0, "" + tour.distance());
             StdDraw.show(50);
        }

        // draw to standard draw
        System.out.println("not done");
        tour.draw();
        StdDraw.show(0);
        
        // print tour to standard output
        StdOut.printf("Tour distance =  %.4f\n", tour.distance());
        StdOut.printf("Number of points = %d\n", tour.size());
        tour.show();
    }

}
