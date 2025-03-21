package hackerrank;

import java.util.Arrays;
import java.util.List;

public class SumOf {

    public static void main(String[] args) {
        System.out.println(simpleArraySum(Arrays.asList(1, 2, 3, 4, 10, 11)));
        System.out.println(aVeryBigSum(Arrays.asList(1000000001L,1000000002L,1000000003L,1000000004L,1000000005L)));
    }

    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here using Java 8 functional programming

        /*
        * other ways
        * // Summing the list using forEach
        final int[] sum = {0};
        numbers.forEach(num -> sum[0] += num);
        *
        *
        * int sum = numbers.stream()
                         .reduce(0, Integer::sum);
        * */
        return ar.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

     /* Complete the 'aVeryBigSum' function below.
            *
            * The function is expected to return a LONG_INTEGER.
            * The function accepts LONG_INTEGER_ARRAY ar as parameter.
     */

    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        Long l = 0L;
        return ar.stream().reduce(l, Long::sum);
    }
}
