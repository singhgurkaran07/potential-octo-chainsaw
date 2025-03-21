package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CompareArrayTriplets {

    public static void main(String[] args) {
        System.out.println(compareTriplets(Arrays.asList(17,28,30), Arrays.asList(99,16,8)));
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
        int bob = 0;
        for(int i=0; i< a.size(); i++) {
            if(Objects.equals(a.get(i), b.get(i))) {
                continue;
            }
            if (a.get(i)>b.get(i)) {
                alice += 1;
            } else {
                bob += 1;
            }
        }

        return Arrays.asList(alice,bob);

        /*
        * using Java 8
        *
        * int alicePoints = (int) java.util.stream.IntStream.range(0, a.size())
                .filter(i -> a.get(i) > b.get(i))
                .count();

        int bobPoints = (int) java.util.stream.IntStream.range(0, b.size())
                .filter(i -> a.get(i) < b.get(i))
                .count();

        *
        * */
    }
}
