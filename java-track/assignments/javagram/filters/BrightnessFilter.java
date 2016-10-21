package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class BrightnessFilter implements Filter{

	@Override
	public Picture process(Picture original) {

		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	    	  
	    	  int addTo = 50;
	    	  
	    	//get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
	          int newR = r + addTo;
	          int newG = g + addTo;
	          int newB = b + addTo;
	          
	          newR = (newR > 255) ? 255 : newR;
	          newG = (newG > 255) ? 255 : newG;
	          newB = (newB > 255) ? 255 : newB;
	          
	          processed.set(i, j, new Color(newR, newG, newB));
	    	  
	      }
	    }
		
		return processed;
	}

}
