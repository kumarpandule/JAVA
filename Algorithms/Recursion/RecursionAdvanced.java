import java.util.ArrayList;
import java.util.Scanner;

public class RecursionAdvanced {

    // Recursion function to print all parmutations of sa string
    public static void printParmutations(String str, String parmutations){
        if(str.length() == 0){
            System.out.print(parmutations + " ");
            return;
        }
        for(int i=0; i<str.length(); i++){
            char currentChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            printParmutations(newStr, parmutations + currentChar);
        }
    }

    // Recursion function to count find paths in a maze to move from (0,0) to (n,m)
    public static int countPaths(int i, int j, int n, int m){
        if(i == n || j == m){
            return 0;
        }
        if(i == n-1 && j == m-1){
            return 1;
        }
        // Move Downwards
        int downPaths = countPaths(i + 1, j, n, m);

        // Move Right
        int rigthPaths = countPaths(i, j + 1, n, m);

        return downPaths + rigthPaths;
    }

    // Recursion function to count find ways to place tiles of size 1xm in a floor of size nxm
    public static int countTilePlac(int n, int m){
        if(n == m){
            return 2;
        }
        if(n < m){
            return 1;
        }
        // for vertical placements
        int verticalPlac = countTilePlac(n-m, m);

        // for horizontal placements
        int horizontalPlac = countTilePlac(n - 1, m);

        return verticalPlac + horizontalPlac;
    }

    // Recursion function to find the number of ways in which you can invite pepole to your party
    // single or in pairs(couples)
    public static int findWaysToInvite(int n){
        if(n <= 1){
           return 1;
        }
        // invite as a single
        int singleInvites = findWaysToInvite(n-1);

        // to invite in pairs
        int pairInvites = (n-1) * findWaysToInvite(n-2);

        return singleInvites + pairInvites;
    }

    // Recusrion function to print all the subsets of a set of first n natural numbers
    public static void printSubset(ArrayList<Integer> subset){
        for(int i=-0; i<subset.size(); i++){
            System.out.print(subset.get(i));
        }
        System.out.print(" ");
    }

    public static void findSubsetsOfSet(int n, ArrayList<Integer> subset){
        if(n == 0){
            printSubset(subset);
            return;
        }
        // to be there
        subset.add(n);
        findSubsetsOfSet(n-1, subset);

        // not to be there
        subset.remove(subset.size() - 1);
        findSubsetsOfSet(n - 1, subset);
    }

    public static void main(String srgs[]){
        String str;
        try(Scanner sc = new Scanner(System.in)){
            System.out.print("Please enter a string: ");
            str = sc.nextLine();
        }
        System.out.print("Print all parmutations of a str: ");
        printParmutations(str, "");
        System.out.println();
        System.out.print("Print find paths in a maze to move from (0,0) to (n,m) is: " + countPaths(0,0,3,4));
        System.out.println();
        System.out.print("Place tiles of size 1_x_m in a floor of size n_x_m : " + countTilePlac(4,2));
        System.out.println();
        System.out.print("find number of ways to invite guests : " + findWaysToInvite(4));
        System.out.println();
        System.out.print("find Subsets of a set of first natural number is : ");
        ArrayList<Integer> subset = new ArrayList<>();
        findSubsetsOfSet(3, subset);
    }
}
