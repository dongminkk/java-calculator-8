package calculator;

public class StringCalculator {

    public static int add(String input) {
        //입력이 비어있거나 null이면 0 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }


        String[] tokens = input.split(",|:");

        //각 숫자를 더하기
        int sum = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            sum += number;
        }

        //결과 반환
        return sum;
    }
}