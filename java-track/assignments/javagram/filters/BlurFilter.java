package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class BlurFilter implements Filter{

	@Override
	public Picture process(Picture original) {


		Picture processed = new Picture(original.width(), original.height());
	    
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	    	  int neighborWeight = 35;
	    	  int numOfNeighbors = 0;
	    	  int thisWeight = 40;
	    	  int rSum = 0;
	    	  int gSum = 0;
	    	  int bSum = 0;
	    	  
	    	  if(i != 0){
	    		  Color c1 = original.get(i-1, j);
	    		  rSum += neighborWeight * c1.getRed();
	    		  gSum += neighborWeight * c1.getGreen();
	    		  bSum += neighborWeight * c1.getBlue();
	    		  numOfNeighbors++;
	    	  }
	    	  if(i != (original.width() - 1)){
	    		  Color c2 = original.get(i+1, j);
	    		  rSum += neighborWeight * c2.getRed();
	    		  gSum += neighborWeight * c2.getGreen();
	    		  bSum += neighborWeight * c2.getBlue();
	    		  numOfNeighbors++;
	    	  }
	    	  
	    	  if(j != 0){
	    		  Color c3 = original.get(i, j-1);
	    		  rSum += neighborWeight * c3.getRed();
	    		  gSum += neighborWeight * c3.getGreen();
	    		  bSum += neighborWeight * c3.getBlue();
	    		  numOfNeighbors++;
	    	  }
	    	  if(j != (original.height() - 1)){
	    		  Color c4 = original.get(i, j+1);
	    		  rSum += neighborWeight * c4.getRed();
	    		  gSum += neighborWeight * c4.getGreen();
	    		  bSum += neighborWeight * c4.getBlue();
	    		  numOfNeighbors++;
	    	  }	    	  
	    	  
	    	  rSum += thisWeight * c.getRed();
    		  gSum += thisWeight * c.getGreen();
    		  bSum += thisWeight * c.getBlue();
    		  
	    	//Calculate new color components for pixel
	          int r = rSum / ((numOfNeighbors * neighborWeight) + thisWeight);
	          int g = gSum / ((numOfNeighbors * neighborWeight) + thisWeight);
	          int b = bSum / ((numOfNeighbors * neighborWeight) + thisWeight);
	          
	          processed.set(i, j, new Color(r, g, b));
	    	  
	      }
	    }
	    return processed;
	}

}
