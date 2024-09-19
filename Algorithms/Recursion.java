import java.util.Scanner;

public class Recursion {
    
    // Recusion function to print numbers from N to 0
    public static void printNumbersNto0(int num){
        if(num == 0){
            System.out.print("0");
            return;
        }
        System.out.print(num+" ");
        printNumbersNto0(num - 1);
    }

    // Recursion function to print numbers from 0 to N
    public static void printNumbers0toN(int i, int num){
        if(i == num){
            System.out.print(num);
            return;
        }
        System.out.print(i+" ");
        printNumbers0toN(i + 1, num);
    }

    // Recursion function print sum of numbers till N
    public static void printSumofN(int i, int num, int sum){
        if(i == num){
            sum += i;
            System.out.print(sum);
            return;
        }
        sum += i;
        printSumofN(i+1, num, sum);
    }

    // Recursion function to print factorial of N
    public static int printFactorialofN(int num){
        if(num == 0 || num == 1){
            return 1;
        }
        int fact_num_m_1 = printFactorialofN(num - 1);
        int fact_num = num * fact_num_m_1;
        return fact_num;
    }

    // Recursion function to print fibonacci of N
    public static void printFibofN(int a, int b, int num){
        if(num == 0){
            return;
        }
        int c = a + b;
        System.out.print(c+" ");
        printFibofN(b, c, num - 1);
    }

    // Recursion function to print x^n
    public static int printXofN(int x, int n){
        if(n == 0){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        int n_m_1 = printXofN(x, n-1);
        int x_of_n = x * n_m_1;
        return x_of_n;
    }

    // Recursion function to print x^n with stack logn
    public static int printXofLogN(int x, int n){
        if(n == 0){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        if(n % 2 == 0){
            return printXofLogN(x, n/2) * printXofLogN(x, n/2);
        }else{
            return printXofLogN(x, n/2) * printXofLogN(x, n/2) * x;
        }
    }

    // Recrsion function to atchive Tower of Henoi mechanis
    public static void towerOfHenoi(int n, String src, String helper, String dest){
        if(n == 1){
            System.out.println("Transferred disk " + n + " from " + src + " to " + dest);
            return;
        }
        towerOfHenoi(n-1, src, dest, helper);
        System.out.println("Transferred disk "+ n + " from " + src + " to " + dest);
        towerOfHenoi(n-1, helper, src, dest);
    }

    public static void main(String args[]){
        int num;
        try (Scanner scan = new Scanner(System.in)) {
            System.err.print("Enter the number: ");
            num = scan.nextInt();
        }
        System.out.print("Printing number from N to 0: ");
        printNumbersNto0(num);
        System.out.println();
        System.out.print("Printing number from 0 to N: ");
        printNumbers0toN(0, num);
        System.out.println();
        System.out.print("Printing sum fo N: ");
        printSumofN(0, num, 0);
        System.out.println();
        int ans = printFactorialofN(num);
        System.out.print("Printing factorial of N: " + ans);
        System.out.println();
        System.out.print("Printing fibonacci of N: 0 1 ");
        printFibofN(0,1,num-2);
        System.out.println();
        System.out.print("Printing x^n with n stack height: ");
        int xofn = printXofN(2,num);
        System.out.print(xofn);
        System.out.println();
        System.out.print("Printing x^n with logn stack height: ");
        int xoflogn =  printXofLogN(2,num);
        System.out.print(xoflogn);
        System.out.println();
        System.out.print("Print disk position with Tower of Henoi: ");
        towerOfHenoi(num, "Src", "Helper", "Dest");
    }
}
