package task4;

class Rental {

    private Kind kind;
// I changed kind from int to enum Kind
// because kind = 1, = 2, = 3 - what does it mean? Is it magic numbers?))

    private int days;

    private double basePrice;

//  I have added WEEK to good redability of code
    public final int WEEK = 7;

// Other fields, constructors, get, set, etc. //

    public Rental(Kind kind, int days, double basePrice) {
        this.kind=kind;
        this.days=days;
//        have added base price to constructor
//        we use it in the method "amountFor" but we dont have any values
        this.basePrice = basePrice;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind=kind;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days=days;
    }

    public double getBasePrice() {
// Calculation of Price.
    return basePrice;
// . . .
    }

    private double amountFor(Rental rental) {
        double result;


// Another code.


        result=days*getBasePrice();

        switch (kind) {
            case WEEKLY:
                result *= 1.5;
                break;
            case DAILY:
                result *= 2;
                break;
            case HOURLY:
                result *= 2.5;
                break;
            default:
                break;
        }

        if (rental.getDays()>WEEK) {
            result=result*3;
        }
// Other calculation.

        return result;
    }

// Other methods.

}