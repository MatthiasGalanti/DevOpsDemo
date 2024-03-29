package ch.zhaw.iwi.devops.fizzbuzz;

public class FizzBuzzConverter {

    public String convert(int i) {
        boolean isMultipleOf3 = i % 3 == 0;
        boolean isMultipleOf7 = i % 7 == 0;


        if (isMultipleOf3 && isMultipleOf7) {
            return "FizzBuzz";
        } else if (isMultipleOf3) {
            return "Fizz";
        } else if (isMultipleOf7) {
            return "Buzz";
        }
        return String.valueOf(i);
    }

}
