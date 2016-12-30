package task5;


public class EmployeeHourWage extends Employee {

    private int id;
    private String name;
    private double hourlyRate;

    public EmployeeHourWage( int id, String name, double hourlyRate) {
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWage() {
        return 20.8 * 8 * hourlyRate;
    }

    @Override
    public int getId() {
        return id;
    }
}
