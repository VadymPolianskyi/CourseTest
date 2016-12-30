package task4;

class Rental {

    private int kind;

    private int days;

    private double basePrice;

// Other fields, constructors, get, set, etc. //

    public Rental(int kind, int days, double basePrice) {

        this.kind=kind;

        this.days=days;

        this.basePrice = basePrice;

    }

    public int getKind() {

        return kind;

    }

    public void setKind(int kind) {

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
            case 1:
                result *= 1.5;
                break;
            case 2:
                result *= 2;
                break;
            case 3:
                result *= 2.5;
                break;
            default:
                break;
        }
// Other calculation.

        return result;

    }

// Other methods.

}