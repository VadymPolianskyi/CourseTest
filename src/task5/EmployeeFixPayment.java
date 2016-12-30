package task5;


public class EmployeeFixPayment extends Employee {

    private int id;
    private String name;
    private double fixedWage;

    public EmployeeFixPayment(int id, String name, double fixedWage) {
        this.id = id;
        this.name = name;
        this.fixedWage = fixedWage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWage() {
        return fixedWage;
    }

    @Override
    public int getId() {
        return id;
    }
}
