public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{12, 11, 13, 5, 6, 7};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1);

        System.out.print("");
    }

    private void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(l, m, r, arr);
        }
    }

    private void merge(int l, int m, int r, int[] arr) {
        //find length for two temp arrays and initialize the arrays
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        //populate the arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int i = 0; i < n2; i++)
            R[i] = arr[i + m + 1];

        //merge two sub-arrays
        int k = l;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //merge the remaining arrays
        if (i < n1) {
            while (i < n1) {
                arr[k] = L[i];
                k++;
                i++;
            }
        }
        if(j < n2) {
            while (j < n2) {
                arr[k] = R[j];
                k++;
                j++;
            }
        }
    }

}
