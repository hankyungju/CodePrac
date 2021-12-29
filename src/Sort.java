public class Sort {
    static int[] array;
    static final int MAX_VALUE = 9;
    static void quick_sort(int start, int end){
        if (start >= end)
            return;
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right){
            while (left <= end && array[left] <= array[pivot]){
                left += 1;
            }

            while (right > start && array[right] >= array[pivot]){
                right -= 1;
            }

            if (left > right) {
                int temp = 0;
                temp = array[right];
                array[right] = array[pivot];
                array[pivot] = temp;
            }
            else{
                int temp = 0;
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        quick_sort(start, right - 1);
        quick_sort(right + 1, end);

    }

    static void counting_sort(){
        int[] max = new int[MAX_VALUE + 1];

        for (int i = 0; i < array.length; i++){
            max[array[i]] += 1;
        }

        for (int i = 0; i <= MAX_VALUE; i++){
            for (int j = 0; j < max[array[i]]; j++){
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        array = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        counting_sort();
        //quick_sort(0, 9);
        //for (int i = 0; i < array.length; i++)
        //    System.out.print(array[i] + " ");
    }
}
