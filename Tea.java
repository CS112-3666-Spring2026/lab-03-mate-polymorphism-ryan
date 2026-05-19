public class Tea extends CaffeinatedBeverage {
    private int brewTemp;

    public Tea() {
        this("Unknown tea", 0, 0.0, 0);
    }

    public Tea(String name, int ounces, double price, int brewTemp) {
        super(name, ounces, price);

        if (!setBrewTemp(brewTemp)) {
            System.out.println("ERROR: bad tea data!");
            System.exit(0);
        }
    }

    public Tea(Tea other) {
        super(other);

        if (other == null) {
            System.out.println("ERROR: cannot copy null tea!");
            System.exit(0);
        }

        setBrewTemp(other.brewTemp);
    }

    public int getBrewTemp() {
        return brewTemp;
    }

    public boolean setBrewTemp(int brewTemp) {
        if (brewTemp >= 0) {
            this.brewTemp = brewTemp;
            return true;
        }

        return false;
    }

    public boolean setAll(String name, int ounces, double price, int brewTemp) {
        if (name != null && name.length() > 0 && ounces >= 0 && price >= 0 && brewTemp >= 0) {
            super.setAll(name, ounces, price);
            this.brewTemp = brewTemp;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("Tea: %s, %d ounces, brewed @ %d°C, $%.2f",
                getName(), getOunces(), brewTemp, getPrice());
    }

    @Override
    public boolean equals(Object other) {
        Tea otherTea;

        if (other == null) {
            return false;
        } else if (getClass() != other.getClass()) {
            return false;
        } else {
            otherTea = (Tea) other;
            return super.equals(otherTea) && brewTemp == otherTea.brewTemp;
        }
    }
}