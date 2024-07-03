package day13;

import java.util.ArrayList;
import java.util.Scanner;

public class excercise {
    public static void main(String[] args) {
        // find largest number( prime factor) of a factor
        int aNumb;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a number: ");
        aNumb = scanner.nextInt();

        Afunction afunction = new Afunction() {
            @Override
            public void print() {

                System.out.println("The largest of prime factor of number: " + aNumb + " is " + FindLargestPrime.findLargestPrimeNumb(aNumb));
            }
        };
        afunction.print();

    }

    @FunctionalInterface
    interface Afunction {
        void print();
    }

    class FindLargestPrime {


        public static int findLargestPrimeNumb(int aNumb) {
            ArrayList<Integer> prime = new ArrayList<>();
            int largestNumb = 0;
            prime.add(2);
            prime.add(3);
            for (int i = 4; i < aNumb; i++) {
                if (checkPrime(i)) {
                    prime.add(i);
                }
            }
            for(var element : prime){
                if(aNumb % element == 0){
                    if( largestNumb < element){
                        largestNumb = element;
                    }
                }
            }
            return largestNumb;
        }

        public static boolean checkPrime(int aNumb) {
            if (aNumb < 2) {
                return false;
            }
            int squareRoot = (int) Math.sqrt(aNumb);
            for (int i = 2; i <= squareRoot; i++) {
                if (aNumb % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
//{
//ArrayList<Integer> prime = new ArrayList<>();
//int largestNumb=0;
//int squareRoot = 0;
//            prime.add(2);
//            prime.add(3);
//            for( int i = 4; i<aNumb; i ++){
//squareRoot =(int)Math.sqrt(i);
//                for(int j = 2 ; j < squareRoot ;j++){
//        if(i % j == 0){
//        continue;
//        }
//        }
//        prime.add(i);
//                }
//                        }