import java.util.Random;
import java.util.Scanner;

public class D3Conditional {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Q1:\n");

        //1.Write a program that checks the role of the user
        System.out.print("Welcome user!\nplease enter your role:");
        String role = read.next();
        if(role.equals("admin")) System.out.println("Welcome admin!");
        else if(role.equals("superuser")) System.out.println("Welcome superuser!");
        else System.out.println("Welcome user!");

        //2.Take three numbers from the user and print the greatest number.
        System.out.print("Q2:\n");
        System.out.print("1.Enter a number:");
        int num1 = read.nextInt();
        System.out.print("2.Enter a number:");
        int num2 = read.nextInt();
        System.out.print("3.Enter a number:");
        int num3 = read.nextInt();
        int greatest =0;
        if(num1>=num2 && num1>=num3) greatest=num1;
        else if(num2>=num1 && num2>=num3) greatest=num2;
        else greatest=num3;
        System.out.println("the greateset number is: "+greatest);

        System.out.print("Q3:\n");

        //.Write a Java program that generates an integer between 1 and 7
        //and displays the name of the weekday
        Random dayInt = new Random();
        int day = dayInt.nextInt(7);
        day++; //since the random from 0-6
        switch(day){
            case 1: System.out.println("Sunday!"); break;
            case 2: System.out.println("Monday!"); break;
            case 3: System.out.println("tuesday!"); break;
            case 4: System.out.println("Wensday!"); break;
            case 5: System.out.println("Thursday!"); break;
            case 6: System.out.println("Friday!"); break;
            case 7: System.out.println("Saturday!"); break;
        }
        System.out.print("Q4:\n");

//Write a program that takes a numeric score as input and prints
//the corresponding letter grade using the following grading scale:
        System.out.println("what is your score? (0-100)");
        int score = read.nextInt();
        if(score>=90) System.out.println("You got 'A'"); else
        if(score>=80) System.out.println("You got 'B'"); else
        if(score>=70) System.out.println("You got 'C'"); else
        if(score>=60) System.out.println("You got 'D'"); else System.out.println("You got didtn't pass :(");
        System.out.print("Q5:\n");
/*
Write a Java program that takes a person's age as input and
categorizes them into one of three age categories: "Child,"
"Teenager," or "Adult" using an if statement.
 */
        System.out.print("What is your age?");
        int age = read.nextInt();
        if(age>=20) System.out.println("You are an adult"); else
        if(age>=19) System.out.println("You are an Teenager"); else
        System.out.println("You are a child");



    }
}
