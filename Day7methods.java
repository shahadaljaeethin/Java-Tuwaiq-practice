import  java.util.*;


public class Day7methods {
    public static void main(String[] args) {
    q(1);
    Scanner r = new Scanner(System.in);
    int[] nums = new int[3];
        print("Enter first number: ");
        nums[0] = r.nextInt();
        print("Enter first number: ");
        nums[1] = r.nextInt();
        print("Enter first number: ");
        nums[2] = r.nextInt();
//call the method
print("The smallest number is "+smallest(nums));
q(2);
        print("Enter a number to check if it is +/- or zero: ");
        nums[0] = r.nextInt();
        //call the method
        print(checkNum(nums[0]));
/*-----------------------------------------

-------------------------------------------
 */
 q(3);
print("Welcome, please make a password with these three rules:");
// call methods
String pass = setPassword();
print("your password is set.");
    }

static int smallest(int[] l){
int x = l[0];
for(int n: l)  {
if(n<x) x=n;
}
return x;
}

public static String checkNum(int n){
if(n==0)  return "The number is zero.";
if(n>0) return "The number is positive.";
    return "the number is negative";
}

public  static void showRues(){
    print("_________________________________");

    print("# the password must have at least ten characters.");
    print("# the password consists of only letters and digits.");
    print("# the password must contain at least two digits.");
    print("_________________________________");
}
public static String setPassword(){
        Scanner r = new Scanner(System.in);
        String pass="";
        while(true){
        showRues();
        pass = r.next();
        if(length(pass)&&charCheck(pass)&&twoDig(pass)) return pass;

}
}
public static boolean length(String s){
        if(s.length()>9) return true;
         print("Error: *Password must contains at least 10 characters*");
         return false;
}


  public  static boolean charCheck(String s){
        char[] c = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        int allLetters = s.length();
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){ //letter by letter in string

            for(int ch=0;ch<c.length;ch++){
//             print("size: "+allLetters);
            //char by char in array
            if(s.charAt(i)==c[ch])
            allLetters--;

            }

        }
      if(allLetters==0)
return true;
      print("Error: *Password must contains letters and digits only*");
return false;
    }


    static boolean twoDig(String s){
        int digits =0;
        for(int i=0;i<s.length();i++)
        if(s.charAt(i)=='1'||
                s.charAt(i)=='2'||
                s.charAt(i)=='3'||
                s.charAt(i)=='4'||
                s.charAt(i)=='5'||
                s.charAt(i)=='6'||
                s.charAt(i)=='7'||
                s.charAt(i)=='8'||
                s.charAt(i)=='9'
               ) digits++;







        if( digits >= 2)
         return true;
        print("Error: *Password must contains at least 2 digits*");

        return false;
    }

    public static void q(int q){
        System.out.println("======================\nQ"+q);
    }
    public  static void print(String m){
        System.out.println(m);

    }
}
