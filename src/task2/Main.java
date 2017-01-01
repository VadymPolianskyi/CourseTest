package task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Завдання 2");

        Polynomial polynomial = new Polynomial();
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть а: ");
        int a = in.nextInt();
        System.out.print("Введіть b: ");
        int b = in.nextInt();
        System.out.print("Введіть n: ");
        int n = in.nextInt();

        System.out.println("Вигляд та результат поліному:");
        polynomial.searchPolynom(a,b,n);
    }
}
