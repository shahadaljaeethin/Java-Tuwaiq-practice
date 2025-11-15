import java.util.Scanner;
public class Day4loops {
public static void main(String[] args){
/*Q1: Write a program that prints the numbers from 1 to 100 such that:
If the number is a multiple of 3, you need to print "Fizz" instead of that
number.
*/
    for(int i=1;i<=100;i++)
    {
        if(i%3==0){     //in case 3, we can check also on 5.
        System.out.print("\nFizz");
        if(i%5==0) System.out.println("Buzz");
        else System.out.print("\n");
        continue;
    } else
    if(i%5==0)
    {System.out.println("Buzz"); //in case 5 alone.
        continue;
    }//in case 5 alone.
    System.out.println(i); //normal number

    }
/*-------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
 Q2

 Write a Java program to reverse a string.
Test Data: Input a string: The quick brown fox Expected Output: Reverse
string: xof nworb kciuq ehT  */
String word;
Scanner input = new Scanner(System.in);
System.out.println("Enter a word/sentence to reverse it.");
word = input.nextLine();
System.out.print("the reverse of "+word+" is: ");
for(int i=word.length()-1;i>=0;i--){
System.out.print(word.charAt(i));
}


/*-------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
 Q3
 .Write a program to find the factorial value of any number entered
through the keyboard.
 */
System.out.println("\nEnter a number to calculate its factorial.");
    int factorial = input.nextInt();
    for(int f=factorial-1; f>0;f--)
    {
        factorial*=f;
    }
System.out.println("="+factorial);
/*-------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
 Q3
Two numbers are entered through the keyboard. Write a program to find
the value of one number raised to the power of another. (Do not use Java
built-in method)
 */
    System.out.println("Enter a base number:");
    int base = input.nextInt();
    int resultPower=1; //defult
    System.out.println("Enter a power number:");
    int power = input.nextInt();
    for(int i=1; i<=power;i++)
    resultPower*=base;

    System.out.println("Result: "+resultPower);
    /*-------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
 Q5
Write a program that reads a set of integers, and then prints the sum of
the even and odd integers.
 */

    int evenSum = 0,oddSum=0,choice=1,enteredNumber;

    do {
        System.out.print("Enter a number to calculate sum of even and odd numbers:");
        enteredNumber = input.nextInt();
        //if - sums
        if(enteredNumber%2==0)evenSum++; else oddSum++;
        //to continue the program or end it
        while(true){
        System.out.print("Do you want ot continue?\n1.Yes\n2.No");
        choice = input.nextInt();
        if(choice!=1&&choice!=2)
        System.out.println("Invalid choice, try again.");
        else break;}

    }while(choice!=2);

    System.out.println("even sum= " + evenSum);
    System.out.println("odd sum= " + oddSum);
   /*-------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
 Q6
Write a program that prompts the user to input a positive integer. It
should then output a message indicating whether the number is a prime
number.
 */
    int prime;
    boolean isPrime = true;
    while(true){
        System.out.println("Enter a (positive integer) to check if it is a prime number:");
        prime = input.nextInt();
        if(prime<0)
        System.out.println("Invalid number, try again.");
        else break;
    }
    //test prime
    for(int i=prime-1;i>1;i--) {
        if (prime%i==0){
        isPrime=false;
        System.out.println("no it is a prime number.");
        break;}
    }
    if(isPrime)
    System.out.println("YES it is a prime number.");



      /*-------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
 Q7
Use a for loop to print headings for four weeks (Weeks 1 - 4). Then use
another for loop to print the days (Days 1 -7) for each week.
 */
    System.out.println("how many weeks is your program? for example 4.");
    int weeksNumber = input.nextInt();
    for(int i=1; i<=weeksNumber;i++) {
        System.out.println("_______________"); //better UX
        System.out.println("Week ("+i+"):");

        for(int d=1;d<8;d++)
        System.out.println("--Day #"+d);

        System.out.println("_______________"); //better UX

    }
     /*-------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------
 Q8
Write a program thats check if the word is a palindrome or not. hint: A
string is said to be a palindrome if it is the same if we start reading it from
left to right or right to left.
 */
System.out.println("Enter a word to test palindrome:");
String palindrome= input.next();
boolean isPal=true;
int reverseIndex=0; //so we do some loop
String ispalindrome=""; //to test with it
    for(int i=palindrome.length()-1;i>=0;i--)
        ispalindrome+=palindrome.charAt(i);
    for(int i=0;i<palindrome.length();i++)
    {

        if(palindrome.charAt(i)!=ispalindrome.charAt(reverseIndex)){
        isPal=false;
        System.out.println("No, it is NOT palindrome.\n"+palindrome+"!="+ispalindrome);
        break;
    } else reverseIndex++;
    }


        if(isPal) System.out.println("YES it is palindrome.");


}} //end of main$class

