import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Baek{


    public static class Point{
        private int x, y, depth;

        public Point(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) { this.depth = depth;}

    }

    static int[][] array;
    static int[][] array2;
    static boolean[][] passarray;
    static int change = 999999;
    static boolean pass = false;
    public static int[] find(int[][] array, int start, int n){
        int[] answers = new int[n];

        return answers;


        }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String[] num = a.split(" ");
        int[] nums = new int[num.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(num[i]);
        }
        System.out.println(nums[0] + " , " + nums[1]);
        a = br.readLine();
        int start = Integer.parseInt(a);

        int[][] array = new int[nums[0]][nums[0]];
        int[] am;
        for (int i = 0; i < nums[1]; i++){
            a = br.readLine();
            num = a.split(" ");
            System.out.println("numlength = " + num.length);
            am = new int[num.length];
            for (int j = 0; j < num.length; j++) {
                am[j] = Integer.parseInt(num[j]);
            }
            array[am[0] - 1][am[1] - 1] = am[2];
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++)
                System.out.print(array[i][j] + " ");
            System.out.println();
        }


        find(array, start, nums[0]);
    }
}
