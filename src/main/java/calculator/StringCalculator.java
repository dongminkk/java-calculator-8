package calculator;

public class StringCalculator {

    public static int add(String input) {
        if (isEmpty(input)) {
            return 0;
        }

        String[] tokens = splitInput(input);
        validateNumbers(tokens);

        return calculateSum(tokens);
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] splitInput(String input) {
        if (isCustomDelimiter(input)) {
            return splitByCustomDelimiter(input);
        }
        return splitByDefaultDelimiters(input);
    }

    private static String[] splitByDefaultDelimiters(String input) {
        return input.split("[,:]");
    }

    private static String[] splitByCustomDelimiter(String input) {
        int delimiterEndIndex = input.indexOf("\n");
        String delimiter = input.substring(2, delimiterEndIndex);
        String numbers = input.substring(delimiterEndIndex + 1);
        return numbers.split(delimiter);
    }

    private static boolean isCustomDelimiter(String input) {
        return input.startsWith("//");
    }

    private static void validateNumbers(String[] tokens) {
        for (String token : tokens) {
            int number = parseNumber(token);
            if (number < 0) {
                throw new IllegalArgumentException("잘못된 입력입니다."); // 음수 예외
            }
        }
    }

    private static int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static int calculateSum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
