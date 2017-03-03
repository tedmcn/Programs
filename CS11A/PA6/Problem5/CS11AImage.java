import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class CS11AImage {

	public BufferedImage im = null; //don't modify this
	public int[] packedData = null; //don't modify this
	public int[][][] pixelData = null; //use this to modify the image
	public int height = 0; //read but do not set this
	public int width = 0; //read but do not set this
	
	//Constructor. This allows a program to initialize an instance of
	//this class by using the 'new' keyword.
	public CS11AImage(BufferedImage image) {
		im = image;
		height = im.getHeight();
		width = im.getWidth();
		System.out.println(width);
		System.out.println(height);
		packedData = im.getRGB(0, 0, width, height, null, 0, width);
		unpackPixels();	
	}
	
	public void flipHorizontal() {
		// Traverses array and swaps values in rows to flip horizontally.
		for(int rows = 0; rows < height; rows++) {
			for(int columns = 0; columns < width/2; columns++) {
				int[] pixel = pixelData[rows][columns];
				pixelData[rows][columns] = pixelData[rows][width-1-columns];
				pixelData[rows][width-1-columns] = pixel;
			}
		}
		System.out.println("Flipped Horizontally.");
	}

	public void flipVertical() {
		// Traverse array and swaps values in columns to flip vertically.
		for(int columns = 0; columns < width; columns++) {
			for(int rows = 0; rows < height/2; rows++) {
				int[] pixel = pixelData[rows][columns];
				pixelData[rows][columns] = pixelData[height-1-rows][columns];
				pixelData[height-1-rows][columns] = pixel;
			}
		}
		System.out.println("Flipped Vertically.");
	}
	
	public void invert() {
		/* Traverses array and inverses color in element by finding values difference from
		   255. */
		for(int rows = 0; rows < height; rows++) {
			for(int columns = 0; columns < width; columns++) {
					for(int color = 0; color < 3; color++) {
						pixelData[rows][columns][color] = 255-pixelData[rows][columns][color];
				}
			}
		}
		System.out.println("Inverted.");
	}
	
	public void replaceColor(int[] oldColor, int[] newColor, int range) {
		/* Traverses array and checks if value is within range, then replaces value at 
		   that place with the new color. */
		for(int rows = 0; rows < height; rows++) {
			for(int columns = 0; columns < width; columns++) {
				if (Math.abs(pixelData[rows][columns][0]-oldColor[0]) < range && 
				Math.abs(pixelData[rows][columns][1]-oldColor[1]) < range && 
				Math.abs(pixelData[rows][columns][2]-oldColor[2]) < range) {
					pixelData[rows][columns] = newColor;
				}
			}
		}
		System.out.println("Replaced color");
	}

	
	//Writes the current data in pixelData to a .png image by first packing
	//the data into a 1D array of ints, then calling the write() method of
	//the ImageIO class.
	public boolean writeImage(File file) {	
		//put pixelData into packedData
		packPixels();
		
		//Write new packed array back into BufferedImage
		//bi.setRGB(startX, startY, w, h, rgbArray, offset, scansize)
		im.setRGB(0, 0, width, height, packedData, 0, width);
		
		try{
			ImageIO.write(im, "png", file);
		} catch (IOException e) {
			System.out.println("Writing image failed.");
			return false;
		}
		return true;
	}
	
	
	//Uses bitwise operations to convert one integer into four channels,
	//each with a range from 0 to 255.	
	public void unpackPixels() {
		System.out.println("Getting pixel values from packed data...");
		
		//This is a rows x columns array. That is, it is an array of rows.
		pixelData = new int[height][width][3];
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col ++) {
				pixelData[row][col][0] = (packedData[(row * width) + col] >> 16) & 0xff;
				pixelData[row][col][1] = (packedData[(row * width) + col] >> 8) & 0xff;
				pixelData[row][col][2] = (packedData[(row * width) + col]) & 0xff;
			}
		}
	}

	//Uses bitwise operations to convert four integer (ranging from 0 to 255)
	//into a single integer for use with the BufferedImage class.
	public void packPixels() {
		System.out.println("putting pixel values in packed format...");
		
		for (int row = 0; row < height; row ++) {
			for (int col = 0; col < width; col ++) {
				packedData[(row * width) + col] = ((255 & 0xFF) << 24) | //alpha
	            ((pixelData[row][col][0] & 0xFF) << 16) | //red
	            ((pixelData[row][col][1] & 0xFF) << 8)  | //green
	            ((pixelData[row][col][2] & 0xFF) << 0); //blue
			}
		}
	}
}
