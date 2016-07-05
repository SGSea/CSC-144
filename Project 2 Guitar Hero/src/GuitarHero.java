public class GuitarHero {
    public static void main(String[] args) {
        
    	// create a new string that contains the keyboard letters that will be used
    	
    	String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    	
    	// create a new GuitarString of the length of the keyboard string
    	
        GuitarString[] Keystring = new GuitarString[keyboard.length()];
        
        for (int i = 0; i < Keystring.length; i++) {
            Keystring[i] = new GuitarString(440*Math.pow(1.05956, i - 24));
        }
        
        // the main input loop
        
        while (true) {
            
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                
                // the user types this character
                char key = StdDraw.nextKeyTyped();
                
                // pluck the corresponding string
                if (!(keyboard.indexOf(key) == -1)) {
               	 Keystring[keyboard.indexOf(key)].pluck();
                }
            }
            // compute the superposition of the samples
            double sample = 0.0;
            for (GuitarString gs : Keystring) {
                sample += gs.sample();
                gs.tic();
            }
            StdAudio.play(sample);
            
          
        }
    }
}