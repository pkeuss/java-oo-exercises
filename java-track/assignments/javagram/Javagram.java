package javagram;

import javagram.filters.*;

import java.io.File;
//import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath = "";
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Image path (relative to " + dir + "):");
				relPath = in.next();				
				/*
				String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				*/
				imagePath = (dir + File.separator + relPath);
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		int selection = displayFilterMenu(in);		
		
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
		Filter filter = getFilter(selection);			

		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		}
		else {
			if(fileName.compareTo(relPath) == 0){
				boolean choiceIsOK = false;
				System.out.println("The original file is " + relPath + ", you are trying to save the filter image as " + fileName +
									"\nAre you sure you want to overwrite the original file?");
				do{
			    	String userinput = in.next();
			    	char choice = userinput.toLowerCase().charAt(0);
			    	switch(choice){
			    		case 'y':
			    			choiceIsOK = true;
			    			break;
			    		case 'n':
			    			choiceIsOK = true;
			    			System.out.println("Save image to (relative to " + dir + ")");
			    			fileName = in.next();
			    			break;
			    		default:
			    			System.out.println("Type 'yes' or 'no' to indicate if you want to overwrite the original file: ");
			    			break;
			    	}
			    }while(!choiceIsOK);
			}
			/*else{
				String absFileName = dir + File.separator + fileName;
				processed.save(absFileName);
				System.out.println("Image saved to " + absFileName);
			}*/
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);			
		}	
		
		// close input scanner
		in.close();
	}
	
	// TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	// TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int select) {
		// TODO - create some more filters, and add logic to return the appropriate one
		try{
			if (select == 1){
				return new BlueFilter();
			}
			else if (select == 2){
				return new GrayscaleFilter();
			}
			else if (select == 3){
				return new BlurFilter();
			}
			else if (select == 4){
				return new BrightnessFilter();
			}
			else if (select == 5){
				return new InvertFilter();
			}
			else{
				throw new IllegalArgumentException();
			}
		}
		catch (IllegalArgumentException e){
			System.out.println("Invalid Filter");
			e.printStackTrace();
		}
		return new BlueFilter();
		
	}
	
	private static int displayFilterMenu(Scanner in){
		boolean invalidSelection = false;
		int selection = 0;
		do{
			invalidSelection = false;
			
			try{
				System.out.println("Wlecome to the Filter Menu!\nType a number that corresponds to the Filter you want to use on your picture:");
				System.out.println("1. Blue Filter");
				System.out.println("2. Gray Scale Filter");
				System.out.println("3. Blur Filter");
				System.out.println("4. Brightness Filter");
				System.out.println("5. Invert Filter");
				
				selection = in.nextInt();
				
				if((selection < 1) || (selection > 5)){
					throw new IllegalArgumentException();
				}
			} 
			catch (IllegalArgumentException e){
				System.out.println("Invalid Selection");
				invalidSelection = true;				
			}
			
		}while(invalidSelection == true);
		
		return selection;
	}

}