package vn.edu.likelion.day4;

import java.util.zip.CheckedInputStream;


// index of char start count at 0
public class HelloYou4 {
    public static void main(String[] args){
        // task 1
        aString string =  new aString();
        string.set("bbdcd");
        System.out.println(string.findFirstletterNotDuplicate());

        //task 2
        String[] a= new String[] {"red","green","organge","white","black"};
        for(String s:a){
            System.out.print(s+ " ");
        }
        System.out.println();
        for( int i = a.length-1;i>=0;i-- ){
            System.out.print(a[i]+" ");
        }
    }
}
//task 2
class aString{
    String aString;
    int isDuplicate = 0;


    public void set(String aString ){
        this.aString = aString;
    }
    // search from index 0 to end of string
    public String findFirstletterNotDuplicate() {


        for(int i =0; i < aString.length(); i++){

            for(int j =0; j < aString.length(); ++j ){
                if (aString.charAt(i) == aString.charAt(j) && i != j) {
                    isDuplicate = isDuplicate + 1;
                }
            }
            if(isDuplicate == 0){
                isDuplicate =0;
                return "the first non repeated character in String is: " + aString.charAt(i);
            }
            isDuplicate = 0;

        }
        return "null";
    }
}
//task2 1 loop
class a{
    String aString;
    int isDuplicate = 0;


    public void set(String aString ){
        this.aString = aString;
    }

}
