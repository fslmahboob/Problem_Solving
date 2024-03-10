/**
 * Assignment 2: Image Inversion 
 * 
 * M. Faisal Mahboob 
 * 10/03/2024
 */

import edu.duke.*;
import java.io.*;

public class BatchInversions {
    // Create a method that takes in an image as a parameter to invert it
    public ImageResource imageInvert(ImageResource inImage){
        // Make a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        
        // for each pixel in outImage
        for (Pixel pixel : outImage.pixels()){
            // Look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            
            // Invert red, blue, green and re-assign in variables
            int r = 255 - inPixel.getRed();
            int g = 255 - inPixel.getGreen();
            int b = 255 - inPixel.getBlue();
            
            // Set the pixel's to the new values
            pixel.setRed(r);
            pixel.setGreen(g);
            pixel.setBlue(b);
        }
        return outImage;
    }
    
    public void batchInvert(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            // Create image im by reading File f
            ImageResource im = new ImageResource(f);
            // Call the method imageInvert on im
            ImageResource image_inverted = imageInvert(im);
            // Get name of the original file im, store as String
            String fname = im.getFileName();
            String newName = "inverted-" + fname;
            image_inverted.setFileName(newName);
            image_inverted.draw();
            image_inverted.save();
        }
    }
}
