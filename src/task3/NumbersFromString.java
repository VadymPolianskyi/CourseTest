package task3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class NumbersFromString {

    public void print(String input) {
        int max = 0;
        int min = 0;

        //видаляємо всі непотрібні символи зі нашої стрічки
        input = input.replaceAll("[^0-9, /,+,-,*]+", " ");
        //створюємо список з нашими елементами
        List<String> allNumb = Arrays.asList(input.trim().split(" "));
        Iterator<String> numbersIterator = allNumb.iterator();

        int i = 0;

        while (numbersIterator.hasNext()) {
            String element = numbersIterator.next();
            //кожен елемент списку перевіряється на наявність знаків математичної
            //операції та повертається вже обрахований, або у попередньому вигляді, якщо
            //знаки відсутні
            int number = checkNumber(element);

            if (i==0) {
                max = number;
                min = number;
                i++;
            }

            if (number> max) max = number;
            if (number < min) min = number;

            System.out.println(number);

        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    public int checkNumber(String element) {
        if (element.contains("+")) {
            int plusIndex = element.indexOf("+");
//            знаходимо кожне число по два боки знаку
            int firstNumber = Integer.parseInt(element.substring(0,plusIndex));
            int secondNumber = Integer.parseInt(element.substring(plusIndex+1, element.length()));
//            робимо відповідну дію над числами та повертаємо результат
            return firstNumber+secondNumber;
//            аналогічно до кожного знаку
        } else if (element.contains("-")) {
            int minusIndex = element.indexOf("-");
            int firstNumber = Integer.parseInt(element.substring(0,minusIndex));
            int secondNumber = Integer.parseInt(element.substring(minusIndex+1, element.length()));
            return firstNumber-secondNumber;
        } else if (element.contains("/")) {
            int divisionIndex = element.indexOf("/");
            int firstNumber = Integer.parseInt(element.substring(0,divisionIndex));
            int secondNumber = Integer.parseInt(element.substring(divisionIndex+1, element.length()));
            return firstNumber/secondNumber;
        } else if (element.contains("*")) {
            int multiplIndex = element.indexOf("*");

            int firstNumber = Integer.parseInt(element.substring(0,multiplIndex));
            int secondNumber = Integer.parseInt(element.substring(multiplIndex+1, element.length()));
            return firstNumber*secondNumber;
        } else {
//            якщо знак математичної операції відсутній. елемент повертається
            return Integer.parseInt(element);
        }
    }
}