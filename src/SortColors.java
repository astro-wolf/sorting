public class SortColors {

    public static void main(String args[]) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public void sortColors(int[] nums) {
        int zeros = 0, ones = 0, twos = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    zeros++;
                    break;
                case 1:
                    ones++;
                    break;
                case 2:
                    twos++;
                    break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeros > 0) {
                nums[i] = 0;
                zeros--;
            } else if (ones > 0) {
                nums[i] = 1;
                ones--;
            } else if (twos > 0) {
                nums[i] = 2;
                twos--;
            }
        }
        return;
    }

}
