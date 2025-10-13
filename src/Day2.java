import java.util.Scanner;

public class Day2 {
public void main(String args[]) {
	Scanner read = new Scanner(System.in);


    /*Develop a program that takes the weight (in kilograms) and height (in meters)
    as input and calculates the BMI, then prints it.  */
    System.out.println("Hello, this is 1st. program. \nplease enter your weight in KG:");
    double weight = read.nextDouble();
    System.out.println("please enter your height in meters:");
    double height = read.nextDouble();
    double BMI = weight / Math.pow(height,2);
    System.out.println("BMI= "+BMI);




    /*
Write a program that takes the obtained marks and total marks as input and
calculates the percentage, then prints it.

     */
    System.out.println("2th.program.\nplease enter a mark:");
    double mark = read.nextDouble();
    System.out.println("what is the total of this mark? for example 100");
    double t_mark = read.nextDouble();
    double precentage = mark/t_mark*100;
    System.out.println("precentage= "+precentage+"%");

    /*
    Create a program that takes an amount in one currency and an exchange rate
as input, then converts and prints the amount in another currency.
     */
    System.out.println("3th. program.\n please enter your money in USD ($)");
    double USD = read.nextDouble();
    System.out.println("your money in SR is: "+(USD*3.75));


    /*
 Create a program that takes a string as input, calculates its length, and then
reverses the string using the StringBuilder class, finally printing both the length and
reversed string.
     */

    System.out.println("4th. program.\n please enter a word:");
    read.nextLine();
    String word = read.nextLine();
    System.out.println("the length is "+word.length());
    StringBuilder sb = new StringBuilder(word);
    sb.reverse();
    System.out.println("After reverse: " + sb);



    /*
Develop a program that takes a sentence as input and extracts a substring from
it, then prints the extracted substring.
     */
    System.out.println("5th. program.\n please enter a sentence:");
    String sentence = read.nextLine();
    System.out.println("now enter start index, please be make sure to pick right number.");
    int start = read.nextInt();
    read.nextLine();
    System.out.println("now enter end index, please be make sure to pick right number.");
    int end = read.nextInt();
    read.nextLine();

    String newsentence = sentence.substring(start,end);
    System.out.println(newsentence);


/*
Write a program that takes a sentence and a keyword as input, then check if
the keyword is present in the sentence and prints the result
 */

    System.out.println("6th. program.\n please enter a sentence:");
    String sentence_check = read.nextLine();
    System.out.println("please enter a keyword:");
    String keywoard= read.next();
    if(sentence_check.contains(keywoard))     System.out.println("yes it does contains "+keywoard); else System.out.println("no it does NOT contains "+keywoard);


    /*
    Develop a program that takes a sentence and a word to replace as input, then
replace all occurrences of the word with another word and prints the modified
sentence
     */
    System.out.println("7th. program.\n please enter a sentence:");
    read.nextLine();

    String sentence_replace = read.nextLine();
    System.out.println("what word you want to replace?");
    String oldWord = read.next();
    System.out.println("what is the new word?");
    String newWord = read.next();
    sentence_replace = sentence_replace.replace(oldWord,newWord);
    System.out.println(sentence_replace);

    /*
    Write a program that takes two strings as input and check if they are equal,
ignoring the case, then prints whether they are equal or not.
     */
    read.nextLine();
    System.out.println("8th. program.\n please enter a word:");
    String w1 = read.next();
    System.out.println("enter another word:");
    String w2 =read.next();
    sentence_replace = read.nextLine();
    System.out.println(sentence_replace);
    if(w1.equalsIgnoreCase(w2)){
        System.out.println("yes they equals");

    } else System.out.println("no they aint equals");

}
}
