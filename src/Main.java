import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Укажите размер массива: "); // добавить валидацию
        final int arraySize = in.nextInt();

        final int[] enteredNumbers = new int[arraySize];
        System.out.print("Введите массив целых чисел: "); // добавить валидацию
        for (int i = 0; i < arraySize; i++) {
            final int num = in.nextInt();
            enteredNumbers[i] = num;
        }





        // n - это начальньное звено то есть вершина треугольника
        // положим его сразу в массив





    }
}