package hackerrank;

import java.util.stream.IntStream;

public class StairCase {

    /*
    *
    *   Staircase detail
            This is a staircase of size :

        1) sol
        *
        *        #
                ##
               ###
              ####
            *
       2)  sol   *
            * #
            * ##
            * ###
            * ####
     *
     *
     * 3) solution
     * 12345
     * 1234
     * 123
     * 12
     * 1
     *
     * 4) Solution
     *
     * 1
     * 12
     * 123
     * 1234
     * 12345
     *
    * */

    public static void main(String[] args) {
        staircase(6);
    }

    public static void staircase(int n) {
        // Write your code here

        //1.
        IntStream.rangeClosed(1,n)
                .mapToObj(i -> " ".repeat(n-i) + "#".repeat(i))
                .forEach(System.out::println);


        //2.
        IntStream.rangeClosed(1,n)
                .mapToObj("#"::repeat)
                .forEach(System.out::println); // no more complex for loops required for pattern


        //3 )
        int start = 1; // Starting number
        int end = 5;   // Ending number

        // Generate the staircase pattern
        IntStream.rangeClosed(1, end - start)
                .forEach(i -> {
                    IntStream.range(start, end - i + 2)
                            .forEach(System.out::print);
                    System.out.println();
                });


        /// 4)
        int rows = 5; // Number of rows
        IntStream.rangeClosed(1, rows)
                .forEach(row -> {
                    IntStream.rangeClosed(1, row)
                            .forEach(System.out::print);
                    System.out.println();
                });

    }
}
