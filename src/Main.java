import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Укажите размер массива: ");
        int arraySize = 0;
        try {
            final int inputSize = Integer.parseInt(in.nextLine());
            if (inputSize <= 0) {
                throw new Exception("ОШИБКА: Размер массива должен быть положительным");
            }
            arraySize = inputSize;
        } catch (NumberFormatException e) {
            System.out.println("ОШИБКА: Размер массива указан не верно");
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.print("Введите массив целых чисел: ");
        final String inputLine = in.nextLine();
        final String[] inputArray = inputLine.split(" ");

        try {
            if (arraySize != inputArray.length) {
                throw new Exception("ОШИБКА: Размер массива не совпадает с кол-вом введенных значений");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        final int[] numbers = new int[arraySize];

        for (int i = 0; i < inputArray.length; i++) {
            try {
                numbers[i] = Integer.parseInt(inputArray[i]);
            } catch (NumberFormatException e) {
                numbers[i] = 0;
                System.out.println("ОШИБКА: Символ " + inputArray[i] + " не является целым числом");
                return;
            }
        }

        int firstPositiveNum = numbers[0];
        for (int i = 0; i < arraySize; i++) {
            if (numbers[i] > 0) {
                firstPositiveNum = numbers[i];
                break;
            }
        }

        final int[][] arrayPascalTriangle = new int[firstPositiveNum][];
        for (int i = 0; i < firstPositiveNum; i++) {
            arrayPascalTriangle[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j != 0 && j != i) {
                    final int leftNum = arrayPascalTriangle[i - 1][j - 1];
                    final int rightNum = arrayPascalTriangle[i - 1][j];
                    arrayPascalTriangle[i][j] = leftNum + rightNum;
                } else {
                    arrayPascalTriangle[i][j] = 1;
                }
            }
        }

        // это вывод
        for (int i = 0; i < firstPositiveNum; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(arrayPascalTriangle[i][j]);
            }
            System.out.println();
        }
    }
}