package task2;

public class СountVowels {
    public int countVowels(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return (int) input.toLowerCase().chars()
                .filter(c -> "aeiouy".indexOf(c) != -1)
                .count();
    }

}
