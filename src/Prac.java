import java.util.*;

public class Prac {


    static class Solution {

        static int count = 0;
        static int real = 0;
        static boolean[][] visited;

        public Solution() {
            int[][] a = {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};

            System.out.println(solution(4, a));

        }

        public void solve(int[][] ori, boolean[][] visited, int curr, int n) {
            if (curr == n){
                return;
            }
            for (int i = 0; i < n; i++){
                if (visited[curr][i] == false && ori[curr][i] == 1){
                    System.out.println("curr and i = " + curr + " , " + i);
                    visited[curr][i] = true;
                    visited[i][curr] = true;
                    solve(ori, visited, i, n);
                    System.out.println("terminate");
                }
            }
        }




        public int solution(int n, int[][] computers) {
            visited = new boolean[n][n];

            for (int i = 0; i < visited.length; i++){
                if (!visited[i][i]){
                    solve(computers, visited, i, n);
                    count++;
                    System.out.println("up");
                }
            }
            return count;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}

