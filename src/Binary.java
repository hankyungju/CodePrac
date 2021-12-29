import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary {
        static int ans = -1;
        static int largest = -1;
    public static void binary(int[] arr, int start, int end, int target){
        int mid = (start + end) / 2;
        int sum = 0;

        if (start > end)
            return;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid)
                sum += (arr[i] - mid);
        }
        if (sum >= target){
            ans = mid;
            binary(arr, mid + 1, end, target);
        }
        else if (sum < target){
            binary(arr, start, mid - 1, target);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int target = Integer.parseInt(first[1]);
        String[] second = br.readLine().split(" ");
        int[] items = new int[second.length];
        for (int i = 0; i < second.length; i++) {
            items[i] = Integer.parseInt(second[i]);
            if (items[i] > largest)
                largest = items[i];
        }

        binary(items, 0, largest, target);
        System.out.println(ans);
    }

}
