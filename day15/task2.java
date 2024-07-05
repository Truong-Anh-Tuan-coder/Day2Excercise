package day15;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task2 {
    public static void main (String[] args){
        // lọc phần tử trùng lặp khỏi danh sách  bằng cách sử dụng stream
        List<Integer> ints = Arrays.asList(10,23,22,23,24,24,33,15,26,15);
        List<Integer> filerted = ints.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(filerted);
    }
}
