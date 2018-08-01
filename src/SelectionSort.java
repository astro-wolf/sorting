public class SelectionSort {

    public static void main(String args[]) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(new int[]{64,25,12,22,11});
    }

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //find minimum item
            int minIdx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIdx] > arr[j])
                    minIdx = j;
            }
            if (i != minIdx) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
        return arr;
    }

}
