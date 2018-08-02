import java.util.HashMap;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 * <p>
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * </p>
 */

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        boolean isValid = validAnagram.isAnagram("anagram", "nagaram");
        System.out.print("We made it through running whole program!");
    }

    public boolean isAnagram(String s, String t) {
        return s.length() == t.length() && checkAnagramWithSort(s, t);
//        return s.length() == t.length() && checkWithMap(s, t);
    }

    //region sorting technique
    private boolean checkAnagramWithSort(String s, String t) {
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        sort(0, first.length - 1, first);
        sort(0, second.length - 1, second);
        int i = 0, j = 0;
        while (i < first.length && j < second.length) {
            if (first[i] != second[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    private void sort(int l, int r, char[] arr) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(l, mid, arr);
            sort(mid + 1, r, arr);

            merge(l, mid, r, arr);
        }
    }

    private void merge(int l, int m, int r, char[] arr) {
        //gotta create two sub-arrays out of one array
        //find length of both arrays
        int n1 = m - l + 1;
        int n2 = r - m;

        char[] leftArr = new char[n1];
        char[] rightArr = new char[n2];
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[l + i];
        for (int i = 0; i < n2; i++)
            rightArr[i] = arr[m + i + 1];

        //merge two sub-arrays into arr
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
                k++;
            } else {
                arr[k] = rightArr[j];
                j++;
                k++;
            }
        }

        //add rest of the values
        while (i < n1) {
            arr[k] = leftArr[i];
            k++;
            i++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            k++;
            j++;
        }
    }
    //endregion

    //region hashing technique
    private boolean checkWithMap(String s, String t) {
        HashMap<Character, Integer> stringMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char currS = t.charAt(i);
            if (stringMap.get(currS) != null) {
                stringMap.put(currS, stringMap.get(currS) + 1);
            } else {
                stringMap.put(currS, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char currS = s.charAt(i);
            if (stringMap.get(currS) == null)
                return false;
            stringMap.put(currS, stringMap.get(currS) - 1);
            if (stringMap.get(currS) != null && stringMap.get(currS) < 0)
                return false;
        }
        for (int values : stringMap.values())
            if (values != 0)
                return false;
        return true;
    }
    //endregion

}
