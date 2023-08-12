import java.util.Scanner;

public class towerofhanoi {
   
 public static void Toh(int n,int A, int B, int C){
    
        if(n==0){
            return;
        }
        Toh(n-1,A,C,B);
        System.out.println(n+"["+A+"->"+B+"]");
        Toh(n-1,C,B,A);
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int A=s.nextInt();
        int B=s.nextInt();
        int C=s.nextInt();
        Toh(n,A,B,C);
        
    }

}
