import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Укажите размер массива: "); // добавить валидацию
        final int arraySize = in.nextInt();
        in.nextLine();

        System.out.print("Введите массив целых чисел: ");
        final String inputLine = in.nextLine();
        final String[] inputArray = inputLine.split(" ");

        try {
            if (arraySize != inputArray.length) {
                throw new Exception("ОШИБКА: Размер не совпадает с кол-вом введенных значений");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        final int[] numbers = new int[arraySize];

        for (int i = 0; i < inputArray.length; i++) {
            try {
                numbers[i] = Integer.parseInt(inputArray[i]);
//                throw new NumberFormatException("ОШИБКА: Размер не совпадает с кол-вом введенных значений");
            } catch (NumberFormatException e) {
                numbers[i] = 0;
                System.out.println("Ошибка" + inputArray[i]);
            }
        }

        int firstPositiveNum = numbers[0];
        for (int i = 0; i < arraySize; i++) {
            if (numbers[i] > 0) {
                firstPositiveNum = numbers[i];
                break;
            }
        }

        System.out.println(firstPositiveNum);


        // n - это начальньное звено то есть вершина треугольника
        // положим его сразу в массив





    }
}