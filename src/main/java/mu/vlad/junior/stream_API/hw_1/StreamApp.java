package mu.vlad.junior.stream_API.hw_1;

import java.util.List;
import java.util.OptionalDouble;

/**
 * Напишите программу, которая использует Stream API для обработки списка чисел.
 * Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class StreamApp {
    public static void main(String[] args) {

        OptionalDouble average = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).average();

        System.out.println(average);

    }
}
