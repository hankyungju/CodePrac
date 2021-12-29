import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Paren {
    static char[] ch;
    static int max = -987654321;
    public static int ops(int a, int b, char op){
        if (op == '+')
            return a + b;
        else if (op == '-')
            return a - b;
        else if (op == '*')
            return a * b;
        return -1;
    }
    public static int dfs(int index, int sum){
        int temp = 0;
        int result = -1;

        if (index == 0){
            sum = ops(sum, Character.getNumericValue(ch[index]), '+');
        }

        if (index + 1 >= ch.length) {
            if (sum > max)
                max = sum;
            return sum;
        }

        if (index + 4 < ch.length){
            if (ch[index + 1] == '*') {
                temp = sum * ops(Character.getNumericValue(ch[index + 2]), Character.getNumericValue(ch[index + 4]), ch[index + 3]);
                //System.out.println("temp : " + temp);
                result = dfs(index + 4, temp);
            }

            if (ch[index + 1] == '+') {
                temp = sum + ops(Character.getNumericValue(ch[index + 2]), Character.getNumericValue(ch[index + 4]), ch[index + 3]);
                //System.out.println("temp : " + temp);
                result = dfs(index + 4, temp);
            }

            if (ch[index + 1] == '-') {
                temp = sum - ops(Character.getNumericValue(ch[index + 2]), Character.getNumericValue(ch[index + 4]), ch[index + 3]);
                //System.out.println("temp : " + temp);
                result = dfs(index + 4, temp);
            }
        }

        if (index + 2 < ch.length){
            if (ch[index + 1] == '*') {
                temp = ops(sum, Character.getNumericValue(ch[index + 2]), '*');
                //System.out.println("temp : " + temp);
                result = dfs(index + 2, temp);
            }

            if (ch[index + 1] == '+') {
                temp = ops(sum, Character.getNumericValue(ch[index + 2]), '+');
                //System.out.println("temp : " + temp);
                result = dfs(index + 2, temp);
            }

            if (ch[index + 1] == '-') {
                temp = ops(sum, Character.getNumericValue(ch[index + 2]), '-');
                //System.out.println("temp : " + temp);
                result = dfs(index + 2, temp);
            }

        }

        return result;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        int f = Integer.parseInt(first);
        String second = br.readLine();
        ch = new char[second.length()];
        //inputs
        for (int i = 0 ; i < second.length(); i++)
            ch[i] = second.charAt(i);
        dfs(0, 0);
        System.out.print(max);
    }
}
