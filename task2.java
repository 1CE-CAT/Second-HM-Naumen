import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class task2 {
    //Метод создающий список размером n и заполняющий его рандомными значениями
    public static  List<Double> createList(){
        System.out.println("Enter any positive number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        List<Double> arr = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) { arr.add(rand.nextDouble()); }
        System.out.println(arr);
        return arr;
    }

    public static List<Double> QuickSort(List<Double> arr){
        List<Double> result = new ArrayList<>();
        if (arr.size() <= 1) { return arr; }
        double supp = arr.get(arr.size() / 2);
        List<Double> left = new ArrayList<>();
        List<Double> right = new ArrayList<>();
        List<Double> middle = new ArrayList<>();
        for (double i: arr){
            if (i < supp) { 
                left.add(i);
            }
            else if (i == supp) {
                middle.add(i);
            }
            else {
                right.add(i);
            }
        }
        result.addAll(QuickSort(left));
        result.addAll(middle);
        result.addAll(QuickSort(right));
        return result;
    }

    public static void main(String[] args) {
        List<Double> arr = createList();
        List<Double> sorted = QuickSort(arr);
        System.out.println(sorted);

    }
}
