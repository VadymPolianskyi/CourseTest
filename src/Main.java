import task1.PascalsTriangle;
import task2.Polynomial;
import task3.NumbersFromString;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//1

        System.out.println("Завдання 1");

        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть номер ряду трикутника Паскаля(від 0 до 66 включно): ");
        int num = in.nextInt();
        System.out.println("Вигляд ряду:");
        System.out.println(Arrays.toString(pascalsTriangle.rowN(num)) + "\n");
//2
        System.out.println("Завдання 2");

        Polynomial polynomial = new Polynomial();
        in = new Scanner(System.in);
        System.out.print("Введіть а: ");
        int a = in.nextInt();
        System.out.print("Введіть b: ");
        int b = in.nextInt();
        System.out.print("Введіть n: ");
        int n = in.nextInt();

        System.out.println("Вигляд та результат поліному:");
        polynomial.searchPolynom(a,b,n);

//3
        System.out.println("Завдання 3");
        in = new Scanner(System.in);
        System.out.print("Введіть строку: ");
        String inputStr = in.nextLine();
        NumbersFromString numbersFromString = new NumbersFromString();
        System.out.println("Результат:");
        numbersFromString.print(inputStr);
    }
}

