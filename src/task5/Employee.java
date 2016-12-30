package task5;

import java.io.Serializable;

public abstract class Employee implements Comparable<Employee>, Serializable {
    public abstract String getName();
    public abstract double getWage();
    public abstract int getId();

    @Override
    public int compareTo(Employee employee) throws ClassCastException {
        if (!(employee instanceof Employee))
            throw new ClassCastException("A Employee object expected.");
        double ownWage = getWage();
        double wage = employee.getWage();

        if (wage == ownWage) {
            String employeeName1 = getName().toUpperCase();
            String employeeName2 = employee.getName().toUpperCase();

            return employeeName1.compareTo(employeeName2);
        } else {

            return (int) (wage - ownWage);
        }
    }
}
