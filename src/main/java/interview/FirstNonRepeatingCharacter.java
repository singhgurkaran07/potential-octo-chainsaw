package interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        firstNonRepeatingChar("SWISS");
    }

    static void firstNonRepeatingChar(String word){

        //using java 8
        Map<Character, Long> characterFreq = word.chars()
                .mapToObj( ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));

        System.out.println(characterFreq.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null)
        );


        // using for loop
        char[] cArr = word.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c : cArr) {//O(n)
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }
            else {
                map.putIfAbsent(c, 1);
            }
        }

        System.out.println(map.entrySet().stream()
                .filter(ch -> ch.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null)
        );
    }
}
