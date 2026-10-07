//task 1
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static  int[] createArray(){
        System.out.println("Enter any positive number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) { arr[i] = rand.nextInt(); }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int findAbsInArray(int[] arr){
        if (arr.length == 0) return -1;
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if(Math.abs(arr[i]) < Math.abs(arr[answer])){ answer = i; }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = createArray();
        int answer = findAbsInArray(arr);
        System.out.println(arr[answer]);
    }
}
