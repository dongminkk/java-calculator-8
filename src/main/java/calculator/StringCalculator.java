package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        // 형식: //구분자\n숫자
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.matches()) {
            delimiter = matcher.group(1); // 커스텀 구분자 추출
            input = matcher.group(2);     // 나머지 문자열 (숫자 부분)
        }

        String[] tokens = input.split(delimiter);

        int sum = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            sum += number;
        }

        return sum;
    }
}