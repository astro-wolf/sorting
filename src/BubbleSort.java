public class BubbleSort {

    public static void main(String args[]) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(new int[] { 1,2,3,4,5,6,7,8,9 });
    }

    public int[] sort(int[] arr) {
        int len = arr.length;
        while (len > 0) {
            for (int i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            len--;
        }
        return arr;
    }

}
