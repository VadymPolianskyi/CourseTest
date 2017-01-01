package task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Завдання 3");
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть строку: ");
        String inputStr = in.nextLine();
        NumbersFromString numbersFromString = new NumbersFromString();
        System.out.println("Результат:");
        numbersFromString.print(inputStr);
    }
}
