package vn.edu.likelion.day5;

import com.sun.source.tree.UsesTree;
import jdk.jshell.SourceCodeAnalysis;

import java.nio.file.FileSystemNotFoundException;
import java.sql.SQLSyntaxErrorException;
import java.util.*;

public class HelloYou5 {
    public static void main(String[] args) {
        //task 1
        int[] input= new int[]{5,1,5,7,8,2,3};
        String string = "hello";
        System.out.println("Task1");
        System.out.println(sumNotDuplicateElementInArray(input));
        System.out.println(sumNotDuplicateElementInArrayHashset(input));

        //task 2
        System.out.println("\n\ntask2");
        System.out.println(task2(string));

        //task 3
        System.out.println("\n\ntask3");
        task3(input);

        //task 4
        System.out.println("\n\ntask4");
        stringNotDuplicate("characters");

        //task 5
        System.out.println("\n\ntask5");
        swap2String("hello", "world");
    }

    //  task 1  using index sum all value note duplicate
    static int sumNotDuplicateElementInArray(int[] input) {
        int     output = 0,
                isDuplicated = 0;
        ArrayList inputConverted =  new ArrayList();
        ArrayList indexOfDuplicate = new ArrayList();

        for(var element: input){
            inputConverted.add(element);
        }
        for(int i = 0; i < inputConverted.size(); i++) {
            for(int j = i + 1 ; j < inputConverted.size(); j++) {
                if( i == j ) {
                    continue;
                }
                if( inputConverted.get(i)==inputConverted.get(j) && i != j) {
                    indexOfDuplicate.add(j);
                    isDuplicated++;

                }
            }
            if(isDuplicated == 0  ){
                output += (int) inputConverted.get(i);
            }else {
                output += (int)inputConverted.get(i);
                for(var index : indexOfDuplicate) {
                    inputConverted.remove((int)index);

                }
                isDuplicated = 0;
            }
        }
        return output;
    }
    //task1  using hashset
    static int sumNotDuplicateElementInArrayHashset(int[] input){
        HashSet<Integer> set = new HashSet<Integer>();
        int output = 0;
        for(var value: input){
            set.add((int)value);
        }
        for(var value: set){
            output += (int) value;
        }
        return output;
    }
    //task 2
    static StringBuilder task2(String input){
        StringBuilder builder = new StringBuilder();
        for(char character: input.toCharArray()){
            builder.append(character);
            builder.append(character);
        }
        return builder;
    }
    //task3
    static void task3(int[] input) {
        int oddNumb = 0;
        int evenNumb = 0;
        for(var element: input){
            if(element%2==0){
                evenNumb++;
            }else {
                oddNumb++;
            }
        }
        System.out.println("total odd number in array: " + oddNumb + "\ntotal even number in array: " +evenNumb);
    }
    //task4
    static void stringNotDuplicate(String input) {
        LinkedHashSet inputConverted =  new LinkedHashSet(); // linked hashset is differ with hash set?

        for(var element: input.toCharArray()){
            if (!inputConverted.contains(element)) {
            inputConverted.add(String.valueOf(element));

            }

        }
        System.out.println(inputConverted.toString().replaceAll("[^a-zA-Z]",""));

//        for(var element: inputConverted){
//            System.out.print(element);
//        }
    }
    //task5
    static void swap2String(String string1, String string2){
        System.out.println(string2 + " " + string1);
    }
}
