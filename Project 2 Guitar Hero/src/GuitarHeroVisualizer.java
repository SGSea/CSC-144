/*
 * Author: Sam Caldwell
 * Date Created: 2-17-15
 * Date Modified: 2-23-15
 * 
 * Compilation: %javac GuitarHeroVisualizer.java
 * Execution: java GuitarHeroVisualizer
 * 
 * Description: This is a modified version of my GuitarHero Program that displays in a StdDraw window
 * a sound wave that visually represents the coded sound coming from the computer (the hz and all that). 
 * 
 * Necessary Files: GuitarString.java, RingBuffer.Java
 */


public class GuitarHeroVisualizer {
    public static void main(String[] args) {
        
    	// Create a new string that contains the keyboard letters that will be used
    	
    	String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    	
    	// Create a new GuitarString of the length of the keyboard string
    	
        GuitarString[] Keystring = new GuitarString[keyboard.length()];
        
        for (int i = 0; i < Keystring.length; i++) {
            Keystring[i] = new GuitarString(440*Math.pow(1.05956, i - 24));
        }
        
        // The main input loop
        int SampleNum = 4405;
		StdDraw.setCanvasSize(800, 400);
		StdDraw.setXscale(0, SampleNum);
		StdDraw.setYscale(-0.75, 0.75);
		int t = 0;
		StdDraw.show(0);
        
        while (true) {
            
            // Check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                
                // The user types this character
                char key = StdDraw.nextKeyTyped();
                
                // Pluck the corresponding string
                if (!(keyboard.indexOf(key) == -1)) {
               	 Keystring[keyboard.indexOf(key)].pluck();
                }
            }
            // Compute the superposition of the samples
            double sample = 0.0;
            for (GuitarString gs : Keystring) {
                sample += gs.sample();
                gs.tic();
            }
            
            // Play the audio
            StdAudio.play(sample);
            
            // Display the relevant point on the audio bar
            StdDraw.point(t, sample);
			t++;

			// Refresh the display every SampleNum time steps
			if (t == SampleNum) {
				StdDraw.show(0);
				t = 0;
				StdDraw.clear();
			}
            
          
        }
    }
}