package leetcode.FizzBuzz;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static List<String> fizzBizz(int n){
        return IntStream.range(1,n+1).mapToObj(i -> i%15 == 0 ? "FizzBuzz": i%3 == 0 ? "Fizz" : i%5 == 0 ? "Buzz" : Integer.toString(i)).collect(Collectors.toList());
    }
    public static void main(String[] args){
        int n = 30;
        List<String> listString = fizzBizz(n);
        listString.stream().forEach(System.out::println);
    }
}
