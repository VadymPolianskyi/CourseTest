package task1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by vadym on 31.12.16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Завдання 1");

        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть номер ряду трикутника Паскаля(від 0 до 66 включно): ");
        int num = in.nextInt();
        System.out.println("Вигляд ряду:");
        System.out.println(Arrays.toString(pascalsTriangle.rowN(num)) + "\n");

    }
}
