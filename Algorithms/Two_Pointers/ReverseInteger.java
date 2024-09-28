
public class ReverseInteger {

    public static int reverse(int n){
        int reverse = 0;

        while(n != 0){
            int lastDigit = n % 10;

            // if(reverse > 0 && reverse > (Integer.MAX_VALUE - lastDigit) / 10 || reverse < 0 && reverse < (Integer.MIN_VALUE - lastDigit) / 10) return 0;

            int newReverse = reverse * 10 + lastDigit;
            // another way to do same thing
            if((newReverse - lastDigit) / 10 != reverse) return 0;

            reverse=newReverse;
            n /= 10;

        }
        return reverse;
    }
    public static void main(String args[]){
        int n = -123;
        System.out.println(reverse(n));
    }
}
