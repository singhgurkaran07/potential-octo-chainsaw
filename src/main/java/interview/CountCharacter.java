package interview;

public class CountCharacter {

    //Write a program Using Java 8 to print the number of letter 'W' from the string: "W!6rowwow0wW"
    public static void main(String[] args) {
        count("W!6rowwow0wW");
    }

    public static void count(String word) {
        long count = word.chars().filter(ch -> ch == 'W').count();
        System.out.println(count);
    }
}
