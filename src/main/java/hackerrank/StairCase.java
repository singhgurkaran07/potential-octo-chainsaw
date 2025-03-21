package hackerrank;

import java.util.stream.IntStream;

public class StairCase {

    /*
    *
    *   Staircase detail
            This is a staircase of size :

               #
              ##
             ###
            ####
     *
     *
    * */

    public static void main(String[] args) {
        staircase(6);
    }

    public static void staircase(int n) {
        // Write your code here
        /*IntStream.rangeClosed(1,n)
                .mapToObj(i -> " ".repeat(n-i) + "#".repeat(i))
                .forEach(System.out::println);*/

        IntStream.rangeClosed(1,n)
                .mapToObj("#"::repeat)
                .forEach(System.out::println); // no more complex for loops required for pattern

    }
}
