package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = splitInput(input);
        return sum(numbers);
    }

    private static String[] splitInput(String input) {
        if (input.startsWith("//")) {
            // 커스텀 구분자 처리
            int delimiterIndex = input.indexOf("\n");
            String delimiter = input.substring(2, delimiterIndex);
            String numbers = input.substring(delimiterIndex + 1);
            return numbers.split(delimiter);
        }

        // 기본 구분자(, :) 처리
        return input.split("[,:]");
    }

    private static int sum(String[] numbers) {
        int total = 0;
        for (String num : numbers) {
            int number = parseNumber(num);
            total += number;
        }
        return total;
    }

    private static int parseNumber(String num) {
        try {
            int number = Integer.parseInt(num);
            if (number < 0) {
                throw new IllegalArgumentException("잘못된 입력입니다."); // 음수 예외
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다."); // 숫자 아님
        }
    }
}