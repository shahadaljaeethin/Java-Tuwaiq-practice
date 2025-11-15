import  java.util.*;

public class Lab2 {
    public static void main(String[] args){

    Q(1);
    Scanner r = new Scanner(System.in);
    //find the longest size.
    String[] words = {"cat","dog","red","is","pm"};
    int longestIndex=0;
    for(String w: words){
     if(w.length()>longestIndex) longestIndex = w.length();
    }

    //find words with this size.
    ArrayList<String> longWords = new ArrayList<>();
    for(String w: words){
    if(w.length()==longestIndex){
    longWords.add(w);
                              }
                              }
        print(""+longWords);
        /*
=======================================================================
        */
        Q(2);
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(3);
        numbers.add(3);
        numbers.add(5);
        while(!numbers.isEmpty()){
           numbers = counter(numbers);

        }





/*
=======================================================================
 */
Q(3);
int[] HFH = {1, 4, 17, 7, 25, 3, 100};
ArrayList<Integer> original = new ArrayList<>();
        original.add(1);
        original.add(4);
        original.add(17);
        original.add(7);
        original.add(25);
        original.add(3);
        original.add(100);
        original.sort(null);
        Collections.reverse(original);
        //++++++++++++++++++
        print("Enter K:");
        int k= r.nextInt();
        int theK = original.get(--k);
        print(original+"\nthe K:"+theK);

 /*
=======================================================================
 */
Q(4);
int[] reverse = {5,4,3,2,1};
reverse = reverse(reverse);
for(int n: reverse) System.out.print(","+n);
 /*
=======================================================================
 */
print("");
Q(5);
int choice=0;
String element;
ArrayList list = new ArrayList<>();
while(choice!=5){
    print("Press(1) to add an element.");
    print("Press(2) to display the elements.");
    print("Press(3) to search for an element.");
    print("Press(4) to sort elements.");
    print("Press(5) to stop.");
    choice=r.nextInt();
    if(choice==1) {
        print("Enter the element:");
        element=r.next();
        list.add(element);}
    if(choice==2) print(""+list);
    if(choice==3){
        print("What is the element?");
        element=r.next();
        //search
        if(list.contains(element))
        print("yes it contains "+element+", in index "+list.indexOf(element));
        else print("no it doesn't contains "+element);
    }
    if(choice==4){list.sort(null);
    print("elements sorted.");
    }
}
 /*
=======================================================================
 */
Q(6);
print("Hello, enter minimum value of the range:");
int min = r.nextInt();
int max=min;

do{
print("enter maximum value of the range:");
 max = r.nextInt();}while(max<=min);
print("enter the number of random numbers to generate:");
int times = r.nextInt();
print("numbers within the specified range:");
for(int i=0;i<times;i++)print("#"+rand(min,max));
/*
=======================================================================
*/
Q(7);
/*
=======================================================================
*/
Q(8);
        fibonacci(10);
    }//main


public static void fibonacci(int size){
ArrayList<Integer> numbers = new ArrayList<>();
int seq =0,next;
for(int i=0;i<=size;i++){
    numbers.add(seq);
    if(seq!=0)
    seq+=numbers.get(i-1);
    else seq++;
}
print(""+numbers);

}

public static int rand(int start,int last){
    Random random = new Random();
    int randomNum = random.nextInt(last-start+1)+start;
    return randomNum;
}

public static int[] reverse(int[] array){
    int first = 0;
    int last = array.length-1,holder;
    while (first < last) {
         holder = array[first];
        array[first] = array[last];
        array[last] = holder;

        first++;
        last--;
    }
return array;
 }

public static ArrayList<Integer> counter(ArrayList<Integer> old){
    int counter =0, current = old.get(0);
    for(int i=0;i<old.size();i++){
        if(current==old.get(i)) {
    counter++;
   // old.remove(i);
    }
    }//end loop
    old.removeAll(java.util.Arrays.asList(current));

    print("#number "+current+" occurs "+counter+"times#");
return old;
}




    /*
=======================================================================
   methods for printing */
    static void print(String message){
        System.out.println(message);
    }
    static void Q(int question){
        System.out.println("====================");
        System.out.println("Q"+question+":");
    }


}//class
