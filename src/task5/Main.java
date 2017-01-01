package task5;

import java.util.Scanner;

public class Main {
   static boolean exit;
    public static void main(String[] args) {
        FunctionManager functionManager = new FunctionManager();
        Scanner in= new Scanner(System.in);
        exit = false;
        System.out.println("Welcome!");
        functionManager.printComands();
//      this program has four comands:
        while (true) {
            System.out.println("\nEnter your comand:");
            String comand = in.nextLine();
            comand = comand.replaceAll(" ", "");
            switch (comand) {
                case "sort" :
                    functionManager.sortEmploye();
                    break;
                case "add" :
                    functionManager.add();
                    break;
                case "exit" :
                    exit = true;
                    break;
                case "help" :
                    functionManager.printComands();
                    break;
                default:
                    System.out.println("Enter correct comand..");
            }

            if (exit) {
                break;
            }
        }
        System.out.println("Bye!");

    }

}
