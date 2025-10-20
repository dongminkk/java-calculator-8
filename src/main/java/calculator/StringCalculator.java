package calculator;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(input); // 임시 반환
    }
}