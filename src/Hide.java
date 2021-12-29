import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hide {
    static int[][] storage = new int[3][3];

    public static boolean check(){
        if (storage[0][0] == 1 && storage[0][1] == 2 && storage[0][2] == 3
        && storage[1][0] == 4 && storage[1][1] == 5 && storage[1][2] == 6
        && storage[2][0] == 7 && storage[2][1] == 8 && storage[2][2] == 0){
            return true;
        }
        return false;
    }
    public static int go(int time) {
        int indx = -1 , indy = -1;

        if (check())
            return time;
        else {
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++) {
                    if (storage[i][j] == 0){
                        indx = i;
                        indy = j;
                    }
                }
            }
            go(time + 1);
        }
        return time;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a, ind;
        ind = 0;

            for (int i = 0; i < 3; i++) {
                String s = br.readLine();
                String[] ss = s.split(" ");
                for (int j = 0; j < 3; j++) {
                    a = Integer.parseInt(ss[j]);
                    storage[ind][j] = a;
                }
                    ind++;
            }
        System.out.println(check());

    }
}
