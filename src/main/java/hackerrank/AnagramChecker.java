package hackerrank;

import java.util.Arrays;
import java.util.HashMap;

public class AnagramChecker {

    public static void main(String[] args) {
        System.out.println(isAnagram("madam", "damam") ? "Anagrams" : "Not Anagrams");
        System.out.println(isAnagram("silent", "listen") ? "Anagrams" : "Not Anagrams");
        System.out.println(isAnagram("hello", "zinnia") ? "Anagrams" : "Not Anagrams");
    }

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) return false;

//        HashMap<Character, Integer> freqMap = new HashMap<>();
//        for (char c : a.toCharArray()) {
//            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);//complexity O(n) for each loop
//        }
//
//        for (char c : b.toCharArray()) {
//            if (!freqMap.containsKey(c) || freqMap.get(c) == 0)
//                return false;
//
//            freqMap.put(c, freqMap.get(c) - 1);
//        }

        int[] freq = new int[26];

        // Single loop: Increment for str1 and decrement for str2 simultaneously
        for (int i = 0; i < a.length(); i++) {
            freq[a.toLowerCase().charAt(i) - 'a']++;
            freq[b.toLowerCase().charAt(i) - 'a']--;
        }

        System.out.println(Arrays.toString(freq));
        // Check if all counts are zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;


        /*
        * / Sort and compare
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        *
        *  here we are sorting the arrays and then comparing it is little slow
        *     as sort complexity O(nlogn)
        *
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
        * */
    }

}
