import java.util.Arrays;

public class demo2 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = new int[10];
        System.arraycopy(arr1,0,arr2,3,arr1.length);
        System.out.println(Arrays.toString(arr1)); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(arr2)); // [0, 0, 0, 1, 2, 3, 4, 5, 0, 0]
    }
}
