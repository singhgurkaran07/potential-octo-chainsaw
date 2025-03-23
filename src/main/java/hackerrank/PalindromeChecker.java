package hackerrank;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
*A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.

Given a string , print Yes if it is a palindrome, print No otherwise.

Constraints

 A will consist at most 50 lower case english letters.
* */
public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println(isPalindromeUsingJava7("madam") ? "Yes" : "No");
        System.out.println(isPalindromeUsingJava8("madam") ? "Yes" : "No");
        System.out.println(reverseString("zinnia"));
        System.out.println(reverseStringUsingJava8("zinnia"));
        System.out.println(reverseStringUsingRecursion("ratna"));
        System.out.println(reverseStringUsing2Pointers("ratna"));
    }

    public static Boolean isPalindromeUsingJava7(String a) {

        for (int i = 0; i < a.length() / 2; i++) {
            if (a.charAt(i) != a.charAt(a.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static Boolean isPalindromeUsingJava8(String a) {

        return IntStream.range(0, a.length() / 2)
                .allMatch(i -> a.charAt(i) == a.charAt(a.length() - 1 - i));
    }

    // Straight forward way to reverse a string using stringBuilder

    /*
    * Using the StringBuilder approach to reverse a string is efficient and works well for strings of any reasonable
    * length. However, the practicality and efficiency of this approach depend on the context and the length of the
    * string:

        When is it useful?
        General-purpose string reversal:

        If you need to reverse strings for tasks like checking palindromes or encoding/decoding operations,
        * the StringBuilder method is simple and effective.
        Short to moderately long strings:

        For most applications involving user inputs, file lines, or text processing, this method is efficient due
        * to its
        𝑂(𝑛)
        O(n) time complexity, where
        𝑛
        n is the length of the string.
        What about very long strings?
        Memory constraints:

        If the string is extremely large (e.g., gigabytes), reversing it in memory could lead to memory issues.
        * This is because the StringBuilder creates a copy of the string, effectively doubling the memory usage
        * temporarily.
        Alternative for very large strings:

        For extremely long strings, consider reversing chunks of the string instead of the entire string at once.
        * For example:
        Process the string in parts (e.g., reversing lines in a file or chunks in a stream).
        Use disk-based storage for intermediate results if memory is insufficient.
        Streaming approach:

        For scenarios where the entire string cannot be loaded into memory, use an iterative approach with character
        * buffers.
        Conclusion
        The StringBuilder approach is efficient and sufficient for most practical cases. However, for extremely
        * large strings, consider:

        Reversing the string in chunks.
        Using streaming or disk-based techniques to handle the reversal.
    * */

    public static String reverseString(String a) {
        return new StringBuilder(a).reverse().toString();
    }

    public static String reverseStringUsingJava8(String a) {
        return IntStream.range(0, a.length())
                .mapToObj(i -> a.charAt(a.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static String reverseStringUsingRecursion(String a) {
        int n = a.length();
        if (n > 0) {
            return a.charAt(n - 1) + reverseStringUsingRecursion(a.substring(0, n - 1));
        }
        return "";
    }

    public static String reverseStringUsing2Pointers(String a) {
        char[] chars = a.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n/2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - 1 - i];
            chars[n - 1 - i] = temp;
        }
        return new String(chars);
    }
}
