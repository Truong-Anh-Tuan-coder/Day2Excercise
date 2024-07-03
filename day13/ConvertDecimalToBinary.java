package day13;

import java.util.Scanner;

public class ConvertDecimalToBinary {
    public static void main(String[] args ){
        Scanner scanner = new Scanner(System.in);
        int input;

        System.out.print("input number to convert: ");
        input = scanner.nextInt();
        converter.convertDecimalToBinary(input);
    }
}
@FunctionalInterface
interface  ConvertDecimalToString {
    public void Convert(int x);
}
class converter{
    static void convertDecimalToBinary(int input){
        int remainder, quotient = input;
        String binaryNum = "";
        while (quotient > 0) {
            remainder = quotient % 2;
            binaryNum
                    = Integer.toString(remainder) + binaryNum;
            quotient = quotient / 2;
        }
        System.out.println("decimal of " + input + " is: " + binaryNum);
    }
}