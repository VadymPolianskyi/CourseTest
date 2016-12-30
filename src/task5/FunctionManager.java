package task5;

import task5.exceptions.IncorrectFormatException;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FunctionManager {
    Scanner in;
    boolean mounthWageCheck;

    public void add() {
        try {
            Employee employee;
            int id = writeID();
            String name = writeName();
            double wage = writeAndCheckWage();
            if (mounthWageCheck) {
                employee = new EmployeeFixPayment(id,name,wage);
            } else {
                employee = new EmployeeHourWage(id, name, wage);
            }

            FileManager.addEmployee(employee);
        } catch (IncorrectFormatException e) {
            System.out.println("Sorry, write data again.");
            add();
        }

    }

    public int writeID() throws IncorrectFormatException {
        try{
            in = new Scanner(System.in);
            System.out.print("Enter new employee id: ");
            int id = in.nextInt();
            checkID(id);
            return id;
        } catch (InputMismatchException e) {
            throw new IncorrectFormatException();
        }
    }

    public String writeName() throws IncorrectFormatException {
        try{
            in = new Scanner(System.in);
            System.out.print("Enter a name and surname of new employee with the space: ");
            String name = in.nextLine();
            name = checkName(name);
            return name;
        } catch (InputMismatchException e) {
            throw new IncorrectFormatException();
        }
    }

    public double writeAndCheckWage() throws IncorrectFormatException {
        try{
            in = new Scanner(System.in);
            System.out.print("Enter 'H' if the salary of employee is hourly \n" +
                    "or 'M' if monthly: ");
            String check = in.nextLine();

            if (check.equals("H")) {
                mounthWageCheck = false;
                System.out.print("Enter employee wages per hour: ");
                return writeWage();
            } else if (check.equals("M")) {
                mounthWageCheck = true;
                System.out.print("Enter employee wages for the month: ");
                return writeWage();
            } else {
                System.out.println("Enter 'H' or 'M'!");
                return writeAndCheckWage();
            }
        } catch (InputMismatchException e) {
            throw new IncorrectFormatException();
        }
    }

    public double writeWage() throws IncorrectFormatException {
        try{
            in = new Scanner(System.in);
            double wage = in.nextDouble();
            wage = checkWage(wage);
            return wage;
        } catch (InputMismatchException e) {
            throw new IncorrectFormatException();
        }
    }


    public int checkID(int id) {
        if (id <0 ) {
            System.out.println("Please enter an integral value id!");
            return writeID();
        }
        return id;
    }

    public String checkName(String name) {
        if (!name.contains(" ")) {
            System.out.println("You enter only one value..");
            return writeName();
        } else if (name.isEmpty()) {
            System.out.println("You have not entered anything.");
            return writeName();
        }
        return name;
    }

    public double checkWage(double wage) {
        if (wage < 0) {
            System.out.println("Please enter an integral value of wages!");
            return writeWage();
        }
        return wage;
    }

    public void sortEmploye() {
        List<Employee> employees = FileManager.readEmployeesFromFile();
        Collections.sort(employees);
        printEmployees(employees);

        System.out.println("\nFirst five: ");
        try {
            for (int i = 0; i <5; i++) {
                    Employee employee = employees.get(i);
                    System.out.print(i+1 + ") " + employee.getName() + "\n");
            }
            System.out.println("\nLast three: ");
            for (int j = employees.size()-1; j>employees.size()-4; j--) {
                Employee employee = employees.get(j);
                System.out.print(j+1 + ") " + employee.getName() + "\n");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Too few workers");
        }
    }

    public void printEmployees(List<Employee> list) {
        System.out.println("ID | Name Surname |  Wage");
        for (Employee temp: list) {
            System.out.print(temp.getId() + " " + temp.getName() + " " + temp.getWage() + "\n");
        }
    }

    public void printComands() {
        System.out.println("List of comands:\n" +
                "sort - to see a sorted list of employees\n" +
                "add - add employee to file\n" +
                "exit - to complete the program\n" +
                "help - see all comands:)\n");
    }
}

