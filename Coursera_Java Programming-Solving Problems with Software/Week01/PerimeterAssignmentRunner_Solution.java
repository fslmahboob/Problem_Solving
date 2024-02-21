import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Declare an int variable, initialise to 0
        int NPoints = 0;
        // Make it a counter to loop through all points
        for (Point currPt : s.getPoints()) {
            NPoints += 1;
        }
        return NPoints;
    }

    public double getAverageLength(Shape s) {
        // Call the class getPerimeter to get the perimeter
        double totalPerim = getPerimeter(s);
        // Call the class getNumPoints to get the total number of points
        int NPoints = getNumPoints(s);
        // Divide them to get the avgLeng
        double avgLeng = totalPerim/NPoints;
        // Return the average length from this method
        return avgLeng;
    }

    public double getLargestSide(Shape s) {
        // Initialise double lrgSide variable and initialise to 0.00 
        double lrgSide = 0.00;
        // Start with last point to calculate distance from first point
        Point prevPt = s.getLastPoint();
        // Iterate through to find distance and store the largest
        for (Point currPt : s.getPoints()) {
            // Find the distance from current point to last point
            double currDist = prevPt.distance(currPt);
            if (currDist > lrgSide) {
                lrgSide = currDist;
            }
            prevPt = currPt;
        }
        // Return the largest side
        return lrgSide;
    }

    public double getLargestX(Shape s) {
        // Initialise lrgX variable and initialise to 0.00
        double lrgX = 0.00;
        for (Point currPt : s.getPoints()){
            int X = currPt.getX();
            if (X > lrgX) {
                lrgX = X;
            }            
        }
        // Return the value of the largest X value
        return lrgX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Create a DirectoryResource
        DirectoryResource dr = new DirectoryResource();
        // Initialise double variable to hold perimeter
        double P0 = 0.00;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            //Create a shape from the FileResource
            Shape s = new Shape(fr);
            // Return the largest perimeter over all the shapes
            double P1 = getPerimeter(s);
            if (P1 > P0) {
                P0 = P1;
            }
        }
        return P0;
    }

    public String getFileWithLargestPerimeter() {
        // Create own Directory Resource
        DirectoryResource dr = new DirectoryResource();
        // Initialise double variable to hold perimeter
        double P0 = 0.00;
        File temp = null;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            //Create a shape from the FileResource
            Shape s = new Shape(fr);
            // Check largest perimeter over all the shapes
            double P1 = getPerimeter(s);
            if (P1 > P0) {
                P0 = P1;
                temp = f;
            }
            // Return file name
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int NPoints = getNumPoints(s);
        System.out.println("No. of Points = " + NPoints);
        double avgLeng = getAverageLength(s);
        System.out.println("Avg. Length = " + avgLeng);
        double lrgSide = getLargestSide(s);
        System.out.println("Largest Side = " + lrgSide);
        double lrgX = getLargestX(s);
        System.out.println("Largest X = " + lrgX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Call getLargetPerimeterMultipleFiles
        double P0 = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter = " + P0);
    }

    public void testFileWithLargestPerimeter() {
        // Call getFileWithLargestPerimeter
        String name = getFileWithLargestPerimeter();
        System.out.println("File name with largest perimeter = " + name);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeterMultipleFiles();
        //pr.testPerimeter();
        pr.testFileWithLargestPerimeter();
    }
}
