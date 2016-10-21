package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class InvertFilter implements Filter{

	@Override
	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	    	  
	    	  int newColor = 255 - c.getRGB();
	          
	          processed.set(i, j, new Color(newColor));
	    	  
	      }
	    }
		
		return processed;
	}

}
