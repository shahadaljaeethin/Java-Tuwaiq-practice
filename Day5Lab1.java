import java.util.Scanner;


public class Day5Lab1 {
    public void main(String[] args) {
       //Q1---------------------------------------
        Scanner read = new Scanner(System.in);
        System.out.println("Welcome to Q1, enter two numbers to show their addition, multiply, subtract, divide and remainder.");
        System.out.println("Enter the first number:");
        int number1q1 = read.nextInt();
        System.out.println("Enter the first number:");
        int number2q1 = read.nextInt();
        System.out.println("["+number1q1+"+"+number2q1+"="+(number1q1+number2q1)+"]");
        System.out.println("["+number1q1+"-"+number2q1+"="+(number1q1-number2q1)+"]");
        System.out.println("["+number1q1+"x"+number2q1+"="+(number1q1*number2q1)+"]");
        System.out.println("["+number1q1+"/"+number2q1+"="+(number1q1/number2q1)+"]");
        System.out.println("["+number1q1+" mod "+number2q1+"="+(number1q1%number2q1)+"]");

        //Q2---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q2, enter a numbers to show its  multiply table.");
        int numberq2 = read.nextInt();
        for(int i=1;i<=10;i++)
            System.out.println("["+i+"x"+numberq2+"= "+(i*numberq2)+"]");

        //Q3---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q3, this is a calculator of area and perimeter of a circle.");
        System.out.println("please enter the Radius:");
        double radius, pi= 3.14, area,perimeter;
        radius = read.nextDouble();
        //calculation
        //I found these formulas, but in the mathimatic side I am not sure.
        perimeter= 2*pi*radius;
        area= pi*(radius*radius);
        //show results
        System.out.println("Perimeter is : "+perimeter);
        System.out.println("Area is : "+area);

        //Q4---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q4, here is a calculator of the average of numbers you write.");
        //loop : to enter the set as user need.
        double numberq4, sumq4=0,choiceq4,average;
        int countq4=0;
        while(true){
        System.out.println("Enter the "+(countq4+1)+"th. number");
        numberq4 = read.nextDouble();
        countq4++;
        sumq4+=numberq4;
        //to end the set.
            System.out.println("****do you want to finish input?****\npress ( 1 ) to finish, or any other number to continue.");
            choiceq4 = read.nextInt();
            if(choiceq4==1) break;
        }
        //calculation and result:
        average = sumq4/countq4;
        System.out.println("the average of these "+countq4+" numbers is "+average);


       // Q5---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q5, here is a calculating and guessing game ! enter two numbers and guess their sum!");
        System.out.println("Enter the first number: ");
        int number1q5 = read.nextInt();
        System.out.println("now the second number: ");
        int number2q5 = read.nextInt();
        System.out.println("now the third number, just guess:)! : ");
        int number3q5 = read.nextInt();
        if(number3q5==(number1q5+number2q5))
               System.out.println("WOW! yes "+number3q5+" is their sum!");
        else   System.out.println("NOPE~ number "+number3q5+" is NOT their sum!");
        //Q6---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q6, lets reverse a word!");
        System.out.println("Enter a word:");
        String wordq6 = read.next();
        //loop to print
             System.out.print("The reverse is ");
             for(int i=wordq6.length()-1;i>=0;i--)
             System.out.print(wordq6.charAt(i));
        //Q7---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q7, lets see if the number is even or odd");
        System.out.println("Enter a number:");
        int numberq7 = read.nextInt();
        if(numberq7%2==0)
            System.out.println("The number is even.");
        else
            System.out.println("The number is odd.");



       // Q8---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q8, this is temperature conversion program  (ºC <--> ºF) ");
        int choiceq8;
        double temp;
        System.out.println("pick from the menu:");
        do {
            choiceq8=0;
            System.out.println(
                            "1. Fahrenheit ---> Celsius\n" +
                            "2. Celsius ---> Fahrenheit\n" +
                            "3. exit"
            ); //end of menu

            choiceq8= read.nextInt();
            switch(choiceq8){
                case 3: break;
                case 1:
                    //google: Celsius = (Fahrenheit - 32) / 1.8
                    System.out.println("enter the temperature: ");
                    temp = read.nextDouble();
                    System.out.println("****Temperature in Celsius is "+((temp-32)/1.8)+"ºC****");
                    break;
                case 2:
                    //google: Fahrenheit = (Celsius * 1.8) + 32
                    System.out.println("enter the temperature: ");
                    temp = read.nextDouble();
                    System.out.println("****Temperature in Fahrenheit is "+((temp*1.8)+32)+"ºF****");
                    break;

            }
            System.out.println("hope it helped!");
        }while(choiceq8!=3);


        //Q9---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q9, Enter a word/sentence:  ");
        read.nextLine();
        String str = read.nextLine();
        int indexq9=0;
        while(true) {
            System.out.println("enter number index between 0 to : "+(str.length()-1));
             indexq9 = read.nextInt();
            if(indexq9>=str.length()||indexq9<0) System.out.println("wrong number try again.");
            else break;
        }
        System.out.println("the character in index("+indexq9+") is "+str.charAt(indexq9));


        //Q10---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q10,here is a program to calculate area and perimeter of a rectangle!");
        double areaq10, perimeterq10, height, width;
        while(true) {
            System.out.println("Enter the width:");
            width = read.nextDouble();
            if(width<0.1)
                System.out.println("number must be over 0.");
            else break;
        } //end of loop - width
        while(true) {
            System.out.println("Enter the height:");
            height = read.nextDouble();
            if(height<0.1)
                System.out.println("number must be over 0.");
            else break;
        } //end of loop - height


        //calculations:- google :  Area of a rectangle = length x width,  P = 2l + 2w.
        areaq10 = width*height;
        perimeterq10 = 2*(width+height);
        System.out.println("The Area is: "+areaq10);
        System.out.println("The perimeter is: "+perimeterq10);


        //Q11---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q11,write two numbers to see facts about their relation.");
        System.out.println("the first number:");
        int num1q11 = read.nextInt();
        System.out.println("the second number:");
        int num2q11 = read.nextInt();
        System.out.println("here is some facts:");
        //facts
        if(num1q11==num2q11)
            System.out.println(num1q11+"=="+num2q11);
        else
            System.out.println(num1q11+"!="+num2q11);
        if(num1q11<=num2q11)
            System.out.println(num1q11+"<="+num2q11);
        if(num1q11<num2q11)
            System.out.println(num1q11+"<"+num2q11);
        if(num1q11>=num2q11)
            System.out.println(num1q11+">="+num2q11);
        if(num1q11>num2q11)
            System.out.println(num1q11+">"+num2q11);



        //Q12---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q12, lets convert the seconds to an HH:MM:SS!");
        System.out.println("enter seconds:");
        int secondsRead = read.nextInt();
        double hours, min, sec;  //86399 example temp note
        min= (secondsRead/60)%60;
        hours = secondsRead/60/60;
        sec = secondsRead%60;
        //sec = min%60;
        System.out.println(hours+" : "+min+" : "+sec);

        //Q13---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q13, enter four numbers please to test them.");
        System.out.println("enter 1th number:");
        int num1q13 = read.nextInt();
        System.out.println("enter 2th number:");
        int num2q13 = read.nextInt();
        System.out.println("enter 3th number:");
        int num3q13 = read.nextInt();
        System.out.println("enter 4th number:");
        int num4q13 = read.nextInt();
        if(num1q13==num2q13&&num1q13==num3q13&&num1q13==num4q13)
        System.out.println("****"+num1q13+","+num2q13+","+num3q13+","+num4q13+" are EQUAL!****");
        else    System.out.println("****"+num1q13+","+num2q13+","+num3q13+","+num4q13+" are NOT equal!****");
//Q14---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q14.");
        System.out.println("enter a number:");
        int num1q14 = read.nextInt();
        if(num1q14>0) System.out.println("the number is positive.");
        else if(num1q14==0) System.out.println("the number is zero.");
        else System.out.println("the number is negative.");

        //Q15---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q15.");
        int pos=0,neg=0,zeros=0;
        do {
            System.out.println("enter a number to count, or press (-1) to end counting.");
            int numq15 = read.nextInt();
            if(numq15>0)
                pos++;
            else if(numq15==0) zeros++;
            else{
                if(numq15==-1)break;
                neg++;

            }
        }while(true);
        System.out.println("#Positive numbers are: "+pos);
        System.out.println("#Negative numbers are: "+neg);
        System.out.println("#Zeros are: "+zeros);



       // Q16---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q16, Enter seqence of numbers together.  for example 1234");
        String numberq16 = read.next();
        for(int i=numberq16.length()-1;i>=0;i--)
            System.out.print(numberq16.charAt(i));


        //Q17---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q17, this program will show the largest and the smallest number entered");
        int largest=0, smallest,choiceq17;
        System.out.print("enter a number:");
        int numq17 = read.nextInt();
        smallest = numq17;
        largest = numq17; //as start defult value
        while(true) {
            System.out.print("enter a number:");
             numq17 = read.nextInt();
            //calculations:
            if(numq17>largest) largest= numq17;
            if(numq17<smallest) smallest=numq17;
            //end of calcu
            System.out.println("Press (1) to show results, or any other number to continue");
            choiceq17 = read.nextInt();
            if(choiceq17==1) break;
        } //end of loop


        System.out.println("The largest number is: "+largest);
        System.out.println("The smallest number is: "+smallest);

        //Q18---------------------------------------
        System.out.println("--------------------------------");
        System.out.println("Welcome to Q18, this program will show how many (a) letter is in the word/sentence");
        int countq18 =0;
        System.out.print("Please enter a word/sentence: ");
        read.nextLine();
        String strq18 = read.nextLine();

        for(int i=0;i<strq18.length();i++){
            if(strq18.charAt(i)=='a') countq18++;
        }
        System.out.println("number of a's is: "+countq18);
        System.out.println("--------------------------------");

        System.out.println("WOHO!!!\n****LAB 1 DONE****");




    }
    }
