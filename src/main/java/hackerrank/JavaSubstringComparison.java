package hackerrank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
* We define the following terms:

Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows:

For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.

A substring of a string is a contiguous block of characters in the string. For example,
* the substrings of abc are a, b, c, ab, bc, and abc.
Given a string,s , and an integer, k, complete the function so that it finds the
* lexicographically smallest and largest substrings of length .

Function Description

Complete the getSmallestAndLargest function in the editor below.

getSmallestAndLargest has the following parameters:

string s: a string
int k: the length of the substrings to find
Returns

string: the string ' + "\n" + ' where and are the two substrings
*
* Sample Input 0

welcometojava
3
Sample Output 0

ava
wel
* */
public class JavaSubstringComparison {

    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava",3)); // get the smallest and largest lexicographical substring from string
        System.out.println(getSubstrings("welcometojava",3));
        System.out.println(5/2);
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        smallest = s.substring(0,k);
        largest = s.substring(0,k);

        for(int i = 1; i < s.length()-k+1; i++) {
            String sub = s.substring(i, i+k);
            if(sub.compareTo(smallest) < 0 ){
                smallest = sub;
            }

            if(sub.compareTo(largest) > 0 ){
                largest = sub;
            }
        }

        return smallest + "\n" + largest;
    }

    public static List<String> getSubstrings(String s, int k) {
        // Generate all substrings of length k using Java 8 streams
        return IntStream.rangeClosed(0, s.length() - k)
                .mapToObj(i -> s.substring(i, i + k))
                .sorted()//lexicographically sorted
                .collect(Collectors.toList());
    }


}
