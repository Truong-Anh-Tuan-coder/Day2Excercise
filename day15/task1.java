package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class task1 {
    public static void main(String[] args){
        // tính tổng toàn bộ số chẵn và số lẽ trong list sau dây [1,2,3,4,5,6,7,8,9,10,12,14]
        List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10,12,14);

        int sumOfOddNum = ints.stream()
                .filter( numb -> numb % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        int sumOfEvenNum = ints.stream()
                .filter(numb -> numb %2 == 0 )
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("List of numbers: [1,2,3,4,5,6,7,8,9,10,12,14] ");
        System.out.println("Sumb of even Numbers: " + sumOfEvenNum);
        System.out.println("Sumb of odd Numbers: " + sumOfOddNum);
    }
}
