package pages;


public class HomePage {

    public static void main(String[] args) {


        int[] arr = {8, 6, 3, 4, 32, 4, 4, 25436, 56, 4, 5, 23, 5, 32, 423, 4, 23, 43, 24, 32, 4, 23, 45, 234, 2};

        //System.out.println(Arrays.toString(arr) + " after reversing the array of integer");

        int temp;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
        for (int list : arr) {
            System.out.print(list + " ");

        }
    }
}