/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hoo;
/**
 *
 * @author Rohit
 */
public class operation {
    int dayofweek(int d, int m, int y)
    {
     int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
      if(m<3)
       y =y-1;
      return ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
     }

    
}
