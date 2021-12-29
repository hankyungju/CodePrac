import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.LinkedList;
import java.util.Queue;

public class HidenSeek {

    public static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int realCost = 999999;
    static boolean[] array = new boolean[100001];
    public static void find(int start, int dest){

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 0));
        array[start] = true;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int x = p.x;
            int c = p.y;

            if (x == dest){
                if (c < realCost)
                    realCost = c;
                continue;
            }



            if (x >= 1 && !array[x-1]) {
                queue.offer(new Pair(x - 1, c + 1));
                array[x-1] = true;
            }
            if (x < 100000 && !array[x+1]) {
                queue.offer(new Pair(x + 1, c + 1));
                array[x+1] = true;
            }
            if (x * 2 <= 100000 && !array[x*2]) {
                queue.offer(new Pair(x * 2, c + 1));
                array[x*2] = true;
            }

        }

        return;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inp = input.split(" ");
        int[] in = new int[inp.length];
        for (int i = 0; i < 2; i++)
            in[i] = Integer.parseInt(inp[i]);

        find(in[0], in[1]);
        System.out.println(realCost);
    }

}
