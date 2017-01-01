package task5;

import java.io.*;
import java.util.List;

public class FileManager {
//    work with file "employees.txt"

    private static String fileName = "employees.txt";

    public static void writeEmployeeToFile(List<Employee> employees) {
//        writing list of "employees" to file
        try {
            FileOutputStream fo = new FileOutputStream(fileName);
            ObjectOutputStream serial = new ObjectOutputStream(fo);
            serial.writeObject(employees);
            serial.flush();
        } catch (IOException ex) {
            System.out.println("Error object serialization");
        }

    }

    public static List<Employee> readEmployeesFromFile() {
//        reading list of "employees" from file
        try {
            FileInputStream bais = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(bais);

            Object obj = ois.readObject();
            ois.close();
            bais.close();
            return (List<Employee>) obj;
        } catch (IOException e) {
            System.out.println("Have problems with file..");
        } catch (ClassNotFoundException e) {
            System.out.println("Exception in readEmployeesFromFile");
        }

        return null;
    }

    public static void addEmployee(Employee employee) {
        List<Employee> employees = readEmployeesFromFile();

        employees.add(employee);
         writeEmployeeToFile(employees);
    }
}
