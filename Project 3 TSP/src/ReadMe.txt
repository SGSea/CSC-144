/**********************************************************************
 *  readme template                                                   
 *  TSP Heuristics
 **********************************************************************/

Name: Sam Caldwell

Hours to complete assignment (optional): 8

/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.
 **********************************************************************/
first i set the number of points counter, then i used a number of if and else statements
to see where the head or the point we are at is at compared to the other locations close to it using 
the distanceTo method.it continually finds the closest point to go to untill it is done with points and then returns


/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.
 *  It's sufficient to list only the differences between this
 *  heuristic and the nearest insertion heuristic.
 **********************************************************************/
took distance of current and added it to next and subtracted it from wherever the new point would be, and if that is smaller 
than the min distance you insert the point after that node. done by using a circiularly linked list.

/**********************************************************************
 *  Fill in the distances computed by your heuristics.                
 **********************************************************************/

data file          nearest neighbor     smallest increase      extra credit
-----------------------------------------------------------------------------
tsp10.txt              1566.1363             1655.7462
tsp100.txt              7350.1751            4887.2190
tsp1000.txt            27853.7282            17265.6282
usa13509.txt            77447.5663            27659.9606




/**********************************************************************
 *  Estimate the running time (in seconds) of your two heuristics as
 *  a function of N, using an expression of the form: a * N^b seconds
 *  where b is an integer. DESCRIBE HOW YOU DETERMINED YOUR ANSWER. 
 *  Also list more than 3 data points. You may use TSPTimer.java as 
 *  described in the project description.
 **********************************************************************/

nearest: quadratic b = 2
smallest: quadratic b = 2



/**********************************************************************
 *  Explain why it's better to use a circular linked list instead of an 
 *  array.  
 **********************************************************************/

because your keeping track of your last point each time is essential to the algorithm 
it uses each point to plot the nearest point

/**********************************************************************
 *  If you did the extra credit, explain your heuristic, and how
 *  you went about implementing it.
 **********************************************************************/



/**********************************************************************
 *  If you did the extra credit, give instructions here for 
 *  running it.
 **********************************************************************/



/**********************************************************************
 *  List whatever help (if any) that you received.  Include any 
 *  external resources and the names of any students that helped you.                          
 **********************************************************************/

I talked to joe because I was having issues with my code he helped debug.



/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

at first my shortest did not work at all so i had to recode that, then it was not showing a distance
so i needed to change distance to show that.


/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/
