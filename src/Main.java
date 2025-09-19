/*
Мишин Артём && Бояркин Максим
группа: 24ВП1 && вариант: 9
номер лабораторной работы: 1
задание: расчёт треугольника Паскаля для первого положительного числа в массиве
*/

/*
    System - класс, который обеспечивает взаимодействие пользователя с операционной системой.
    System.in - это поле типа InputStream. System.out - это поле типа PrintStream.
    Это поля, которые ссылаются на объекты потоков (streams).

    print() - это метод, который принадлежит классу PrintStream, выводит строку.
    println() - это метод, который выводит строку в консоль с переводом строки.

    Scanner - это класс для считывания пользовательского ввода из консоли.
    scanner - это экземпляр класса Scanner.
    new - ключевое слово, которое создает экземпляр класса указанного типа, выделяет под него память.
    scanner.nextLine() - метод класса Scanner, используется для считывания целой строки, введенной пользователем.
    Возвращает объект типа String.

    Integer - класс обертка над примитивным типом int, он нужен для работы с примитивами, как с объектами.
    Integer.parseInt - это статические метод класса Integer, который нужен, чтобы преобразовать строку в число.

    Exception - это класс, который описывает ошибку. Наследуется от Throwable.
    NumberFormatException - ошибка преобразования строки в число (отдельный класс ошибки).
    throw — это ключевое слово, используется, чтобы выбросить исключение.
    getMessage() — это метод класса Throwable. Он возвращает сообщение ошибки, которое мы передали при
    создании исключения через new Exception("сообщение")

    try-catch — это конструкция, которая позволяет поймать ошибку и обработать её.
    (Exception e) e - это параметр блока catch, он ссылается на объект исключения, который был выброшен внутри try.

    .split() - это метод класса String, который разбивает строку на части (подстроки) по заданному разделителю и
    возвращает массив строк.

    break — это ключевое слово, которое используется для немедленного выхода из цикла или switch.

*/



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isCorrectInput = false;
        int arraySize = 0;
        int[] numbers = new int[arraySize];
        String[] inputArray = new String[0];

        while (!isCorrectInput) {
            System.out.print("Укажите размер массива: ");

            try {
                int inputSize = Integer.parseInt(scanner.nextLine());
                if (inputSize <= 0) {
                    throw new Exception("ОШИБКА: Размер массива должен быть положительным");
                }
                isCorrectInput = true;
                arraySize = inputSize;
            } catch (NumberFormatException e) {
                System.out.println("ОШИБКА: Размер массива указан не верно");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        isCorrectInput = false;
        while  (!isCorrectInput) {
            System.out.print("Введите массив целых чисел: ");
            String inputLine = scanner.nextLine();
            inputArray = inputLine.split(" ");

            try {
                if (arraySize != inputArray.length) {
                    throw new Exception("ОШИБКА: Размер массива не совпадает с кол-вом введенных значений");
                }

                numbers = new int[arraySize];
                for (int i = 0; i < inputArray.length; i++) {
                    numbers[i] = Integer.parseInt(inputArray[i]);
                }
                isCorrectInput = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        int firstPositiveNum = numbers[0];
        for (int i = 0; i < arraySize; i++) {
            if (numbers[i] > 0) {
                firstPositiveNum = numbers[i];
                break;
            }
        }

        int[][] arrayPascalTriangle = new int[firstPositiveNum][];
        for (int i = 0; i < firstPositiveNum; i++) {
            arrayPascalTriangle[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (j != 0 && j != i) {
                    int leftNum = arrayPascalTriangle[i - 1][j - 1];
                    int rightNum = arrayPascalTriangle[i - 1][j];
                    arrayPascalTriangle[i][j] = leftNum + rightNum;
                } else {
                    arrayPascalTriangle[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < firstPositiveNum; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(arrayPascalTriangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}