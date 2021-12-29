import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Recursive {
    static String[][] in;
    static boolean[][] bool;
    static int b = 0, w = 0;
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static int bfs(int x, int y, int maxx, int maxy){
        Queue<Pair> queue = new LinkedList<>();
        String team = "";
        //queue.offer(new Pair(x, y));
        int[] xx = {-1, 1, 0, 0};
        int[] yy = {0, 0, -1, 1};
        int val = 0;
        int count = 1;
        queue.offer(new Pair(x, y));
        team = in[x][y];
        //begins
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            x = p.x;
            y = p.y;
            for (int i = 0; i < 4; i++){
                int nx = x + xx[i];
                int ny = y + yy[i];
                if (nx >= maxx || nx < 0 || ny >= maxy || ny < 0) {
                    continue;
                }

                if (in[nx][ny].equals(team) && !bool[nx][ny]){
                    bool[nx][ny] = true;
                    queue.offer(new Pair(nx, ny));
                    count++;
                }
            }
        }

        if (count > 1)
            return count - 1;
        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String[] num = a.split(" ");
        int[] numm = new int[num.length];
        for (int i = 0; i < num.length; i++)
            numm[i] = Integer.parseInt(num[i]);
        String[] s = new String[numm[1]];
        in = new String[numm[1]][numm[0]];
        for (int i = 0; i < numm[1]; i++) {
            s[i] = br.readLine();
            String[] ss = s[i].split("");
            for (int j = 0; j < numm[0]; j++) {
                //in[i][j] = Integer.parseInt(ss[j]);
                in[i][j] = ss[j];
            }
        }

        bool = new boolean[numm[1]][numm[0]];

        int count = 0;
        for (int i = 0; i < numm[1]; i++)
            for (int j = 0; j < numm[0]; j++){
                if(!bool[i][j]){
                    if (in[i][j].equals("W"))
                        w += Math.pow(bfs(i, j, numm[1], numm[0]), 2);
                    else if (in[i][j].equals("B"))
                        b += Math.pow(bfs(i, j, numm[1], numm[0]), 2);
                }
            }

        System.out.println(w + " "  + b);




        //System.out.println(bfs(0, 0, numm[0], numm[1]));
    }
}
