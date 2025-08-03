package task4;

import java.util.Arrays;

public class FindMaxOfArray {
    public int findMax(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }
}
