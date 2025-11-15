import java.util.*;
public class Day6Arrays {

public static void main(String[] args) {
    Scanner read = new Scanner(System.in);
    int size1;
    System.out.println("Welcome, enter the length of array you want to make (must contains at least two).");
    while(true){
    size1 = read.nextInt();
    if(size1>=2) break;
    System.out.println("please write again, (must contains at least two)");

    }
    int[] numbers1 = new int[size1];
    for(int i=0;i<numbers1.length;i++){
     System.out.println("please write the "+(i+1)+"th number");
    numbers1[i] = read.nextInt(); }
    System.out.print("number #"+numbers1[0]+" and #"+numbers1[numbers1.length-1]+" are ");
    if(numbers1[0]==numbers1[(numbers1.length-1)])   System.out.println("are equals.");
    else  System.out.println("are NOT equals.");
    System.out.println("Q1 ended.");
    System.out.println("************");

    int[] numbers2 = {1, 4, 17, 7, 25, 3, 100};
    double average2 = 0,sum2 =0;
    for(int i=0;i<numbers2.length;i++) sum2+=numbers2[i];
    average2 = sum2/numbers2.length;
    ArrayList larger = new ArrayList();
    for(int i=0;i<numbers2.length;i++) {
    if(average2<numbers2[i]) larger.add(numbers2[i]);
    }
    System.out.print("The numbers which larger than the average: ("+average2+") are: ");
    System.out.println(larger);
    System.out.println("Q2 ended.");
    System.out.println("************");



    int[] numbers3 = {20,30,40,50,60};
    for(int i=0;i<numbers3.length;i++)
    System.out.print(numbers3[i]+",");
    System.out.println("");
    if(numbers3[0]>numbers3[4])
    System.out.println("#"+numbers3[0]+" is larger than #"+numbers3[4]+".");
    else     System.out.println("#"+numbers3[4]+" is larger than #"+numbers3[0]+".");
    System.out.println("Q3 ended.");
    System.out.println("************");


    ArrayList<String> swap = new ArrayList();
    swap.add("first");
    swap.add("second");
    swap.add("last");
    System.out.println("The old list: "+swap);

    String temp1 = swap.get(0), temp2= swap.get(2);
    swap.set(0,temp2);
    swap.set(2,temp1);

    System.out.println("The new list: "+swap);
    System.out.println("Q4 ended.");
    System.out.println("************");


ArrayList oddFirst = new ArrayList();
int[] numbers5 = {2,3,40,1,5,9,4,10,7};
int index =0;
    System.out.println("the list before: ");

while(index<numbers5.length) {
    System.out.print(numbers5[index]+",");
    if (numbers5[index] % 2 == 0)
        oddFirst.add(numbers5[index]);
    else
        oddFirst.add(0,numbers5[index]);
    index++;
}
System.out.println("\nthe list after: "+oddFirst);

    System.out.println("Q5 ended.");
    System.out.println("************");

   int[] array1 = {1,2,3,4,5};
   int[] array2 = {1,2,3,4,5};
   if(array1.length!=array2.length)
       System.out.println("arrays are NOT equals.");
   else {
       boolean equals = true;
       for (int i = 0; i < array1.length; i++){
        if(array1[i]!=array2[i]){
                  equals = false;
                          break;}
           System.out.println("# ["+array1[i]+" and "+array2[i]+"] are same.");
       }
    if(equals)
     System.out.println("YES, arrays are equals.");
    else
     System.out.println("NO, arrays are NOT equals.");

   }
    System.out.println("Q6 ended.");
    System.out.println("************");


    //test
    ArrayList empty = new ArrayList();
    System.out.print("1. -->"+empty);
    empty.add("string");
    empty.add(13);
    System.out.print("2. -->"+empty);

}
}
