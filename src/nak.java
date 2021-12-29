import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class nak {
    static int[] ran;


    public static int run(int left, int right){
        int low, high, pivot, temp;
        low = left;
        high = right + 1;
        pivot = ran[left];
        //0  2             2      0      pivot = 9
        while (high > low) {

            do{
                low++;
            } while(right>=low && ran[low] < pivot);

            do {
                high--;
            } while(left<=high && ran[high] > pivot);

            if (low < high){
                temp = ran[low];
                ran[low] = ran[high];
                ran[high] = temp;
            }

        }

        temp = ran[left];
        ran[left] = ran[high];
        ran[high] = temp;

        return high;
    }
    public static void quick_sort(int left, int right){
        if (left < right){
            int pivot = run(left, right);

            quick_sort(left, pivot - 1);
            quick_sort(pivot + 1, right);
        }
    }

    public static void bubble_sort(){
        int temp;
        for (int i = ran.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (ran[j] > ran[j + 1]){
                    temp = ran[j];
                    ran[j] = ran[j + 1];
                    ran[j + 1] = temp;
                }
            }
        }
    }

    public static void insertion_sort(){
        int key, j;
        for (int i = 1; i < ran.length; i++){
            key = ran[i];
            for (j = i - 1; j >= 0 && ran[j] > key; j--){
                System.out.println("i, j now : " + i + ", " + j);
                    ran[j + 1] = ran[j];
            }
            System.out.println("break. j : " + j);
            ran[j+1] = key;

        }
    }
    public static void main(String[] args) throws IOException {
        String enter;
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        enter = br.readLine();
        num = Integer.parseInt(enter);
        ran = new int[num];
        for (int i = 0; i < num; i++){
            enter = br.readLine();
            ran[i] = Integer.parseInt(enter);
        }
        //quick_sort(0, ran.length - 1);
        bubble_sort();
        //insertion_sort();
        for (int i = 0; i < ran.length; i++){
            System.out.println(ran[i]);
        }
    }
}
