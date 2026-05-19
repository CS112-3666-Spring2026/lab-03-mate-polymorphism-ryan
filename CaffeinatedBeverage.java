public class CaffeinatedBeverage {
    private String name;
    private int ounces;
    private double price;

    public CaffeinatedBeverage() {
        this("Unknown beverage", 0, 0.0);
    }

    public CaffeinatedBeverage(String name, int ounces, double price) {
        if (!setAll(name, ounces, price)) {
            System.out.println("ERROR: bad beverage data!");
            System.exit(0);
        }
    }

    public CaffeinatedBeverage(CaffeinatedBeverage other) {
        if (other == null) {
            System.out.println("ERROR: cannot copy null beverage!");
            System.exit(0);
        }

        setAll(other.name, other.ounces, other.price);
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
            return true;
        }

        return false;
    }

    public int getOunces() {
        return ounces;
    }

    public boolean setOunces(int ounces) {
        if (ounces >= 0) {
            this.ounces = ounces;
            return true;
        }

        return false;
    }

    public double getPrice() {
        return price;
    }

    public boolean setPrice(double price) {
        if (price >= 0) {
            this.price = price;
            return true;
        }

        return false;
    }

    public boolean setAll(String name, int ounces, double price) {
        if (name != null && name.length() > 0 && ounces >= 0 && price >= 0) {
            this.name = name;
            this.ounces = ounces;
            this.price = price;
            return true;
        }

        return false;
    }

    public boolean sip(int ounces) {
        if (ounces <= 0) {
            return !isEmpty();
        }

        if (ounces >= this.ounces) {
            this.ounces = 0;
            return false;
        }

        this.ounces -= ounces;
        return true;
    }

    public boolean isEmpty() {
        return ounces == 0;
    }

    @Override
    public String toString() {
        return String.format("%s, %d ounces, $%.2f", name, ounces, price);
    }

    @Override
    public boolean equals(Object other) {
        CaffeinatedBeverage otherBeverage;

        if (other == null) {
            return false;
        } else if (getClass() != other.getClass()) {
            return false;
        } else {
            otherBeverage = (CaffeinatedBeverage) other;
            return name.equals(otherBeverage.name)
                    && ounces == otherBeverage.ounces
                    && Double.compare(price, otherBeverage.price) == 0;
        }
    }
}