
/*************************************************************************
 * Name Sam Caldwell
 *
 * Dependencies : RingBuffer.java
 * Description  : 
 *  
 *  This is a template file for GuitarString.java. It lists the constructors
 *  and methods you need, along with descriptions of what they're supposed
 *  to do.
 *  
 *  Note: it won't compile until you fill in the constructors and methods
 *        (or at least commment out the ones whose return type is non-void).
 *
 *****************************************************************************/

public class GuitarString {

    private RingBuffer buffer; // ring buffer
    public int money;

    // create a guitar string of the given frequency
    public GuitarString(double frequency) {
        buffer = new RingBuffer((int) Math.round(44100.0 / frequency));
        while(!buffer.isFull())
        {
            buffer.enqueue(0.0);
        }
        
        money = 0;
    }

    // create a guitar string with size & initial values given by the array
    public GuitarString(double[] init) {
        buffer = new RingBuffer(init.length);
        for(int i = 0; i < init.length; i++)
        {
        	buffer.enqueue(init[i]);
        }
        
        money = 0;
    }

    // pluck the guitar string by replacing the buffer with white noise
    public void pluck() {
    	while(!buffer.isEmpty())
        {
            buffer.dequeue();
        }
        
		double rep;    
        
        while(!buffer.isFull())
        {
        	rep = Math.random() - 0.5;
            buffer.enqueue(rep);
        }
    }

    // advance the simulation one time step
    public void tic() {
    	double first;
        first = buffer.dequeue(); 
        buffer.enqueue(.994*(first + buffer.peek())/2);
        money++;
    }

    // return the current sample
    public double sample() {
        return buffer.peek();
    }

    // return number of times tic was called
    public int time() {
        return money;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < N; i++) {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }

}
