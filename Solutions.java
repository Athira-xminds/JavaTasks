/**
 2.Create a list of integer numbers.Using Collectors.toSet() method remove all repeating numbers from the list.
 4.Create a list of integer numbers and find out how many times each number is occuring in that list.
 5.Create a list of integers and find out the minimum value using Collectors.minBy() method.
 6.Using Collectors.teeing() method find the sum and average of a list of integer numbers.
 7.we have a list of products. Each product has a price and a rating. We want to find:
 The product with the lowest price.
 The product with the highest rating.
 Make use of Collectors.teeing() method

 8.using stream map function multiply all elements in an array by 3?

 9.using stream map convert all elements in a string array to upper case?
 10.Using stream map find the length of all elements in the string array?
 */

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;

public class Solutions {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 2, 3, 4, 4, 5);

        Set<Integer> uniqueNumbers = numbers1.stream().collect(Collectors.toSet());

        System.out.println(uniqueNumbers);

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 2, 4, 1, 2, 5);

        Map<Integer, Long> counts = numbers2.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        System.out.println(counts);


        List<Integer> numbers3 = Arrays.asList(42, 12, 89, 7, 55);

        Optional<Integer> min = numbers3.stream().collect(Collectors.minBy(Integer::compareTo));

        min.ifPresent(System.out::println);

        List<Integer> numbers4 = Arrays.asList(10, 20, 30, 40);

        String result = numbers4.stream().collect(Collectors.teeing(Collectors.summingInt(Integer::intValue), Collectors.averagingInt(Integer::intValue), (sum, avg) -> "Sum: " + sum + ", Average: " + avg));

        System.out.println(result);

        int[] numbers5 = {1, 2, 3, 4, 5};

        int[] multipliedByThree = Arrays.stream(numbers5)
                .map(n -> n * 3)
                .toArray();

        System.out.println(Arrays.toString(multipliedByThree));

        String[] words1 = {"kerala", "tamilnadu", "karnataka"};

        String[] upperCased = Arrays.stream(words1).map(String::toUpperCase).toArray(String[]::new);

        System.out.println(Arrays.toString(upperCased));

        String[] words2 = {"java", "python", "collections"};

        int[] lengths = Arrays.stream(words2).mapToInt(String::length).toArray();

        System.out.println(Arrays.toString(lengths));
    }
}
