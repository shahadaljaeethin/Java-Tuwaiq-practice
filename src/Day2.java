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
    System.out.println("2nd.program.\nplease enter a mark:");
    double mark = read.nextDouble();
    System.out.println("what is the total of this mark? for example 100");
    double t_mark = read.nextDouble();
    double precentage = mark/t_mark*100;
    System.out.println("precentage= "+precentage+"%");


}
}
