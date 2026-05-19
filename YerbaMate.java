public class YerbaMate extends Tea {
    private int numPasses;

    public YerbaMate() {
        this("Unknown yerba mate", 0, 0.0, 0, 0);
    }

    public YerbaMate(String name, int ounces, double price, int brewTemp, int numPasses) {
        super(name, ounces, price, brewTemp);

        if (numPasses < 0) {
            System.out.println("ERROR: bad yerba mate data!");
            System.exit(0);
        }

        this.numPasses = numPasses;
    }

    public YerbaMate(YerbaMate other) {
        super(other);

        if (other == null) {
            System.out.println("ERROR: cannot copy null yerba mate!");
            System.exit(0);
        }

        this.numPasses = other.numPasses;
    }

    public int getNumPasses() {
        return numPasses;
    }

    public void passMate() {
        numPasses++;
        System.out.println("Mate passed. Current pass count: " + numPasses);
    }

    public void refill(int ounces) {
        if (ounces > 0) {
            setOunces(getOunces() + ounces);
        }
    }

    @Override
    public String toString() {
        return String.format("Yerba Mate: %s, %d ounces, brewed @ %d°C, $%.2f, %d passes so far",
                getName(), getOunces(), getBrewTemp(), getPrice(), numPasses);
    }

    @Override
    public boolean equals(Object other) {
        YerbaMate otherMate;

        if (other == null) {
            return false;
        } else if (getClass() != other.getClass()) {
            return false;
        } else {
            otherMate = (YerbaMate) other;
            return super.equals(otherMate) && numPasses == otherMate.numPasses;
        }
    }
}