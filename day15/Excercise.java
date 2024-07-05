package day15;

import vn.edu.likelion.assignment3.Teacher;

import java.util.Optional;

public class Excercise {
    public static void main(String[] args){
        // tạo 1 đối tương rỗng.
        Optional<String> optionalS = Optional.empty();
        // tạo 1 đối tượng non-null
        String str = "";
        Optional<String> optional2 = Optional.of(str);
        System.out.println(optional2.isPresent());
        // tạo 1 đối tượng cho phe null hoặc non-null
        String str2 = "";
        Optional<String> optional3 = Optional.ofNullable(str2);
    }
}
