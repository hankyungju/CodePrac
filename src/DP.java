import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class DP {

    public static int[] b = new int[100];
    public static int fibo(int n){
        System.out.println("Now n : " + n);
        if (n == 1 || n == 2)
            return 1;
        if (b[n] != 0)
            return b[n];
        b[n] = fibo(n - 1) + fibo(n - 2);
        return b[n];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] array;
        int[] a;
        int n = sc.nextInt();
        array = new int[n];
        a = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();

        a[0] = array[0];
        a[1] = Math.max(array[0], array[1]);

        for (int i = 2; i < n; i++) {
            a[i] = Math.max(array[i - 2] + array[i], array[i - 1]);
        }
        System.out.println(a[n - 1]);
    }
}
