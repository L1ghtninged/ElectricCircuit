/**
 * This holds a value of resistance
 */
public class Resistor {
    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Resistor(double value) {
        this.value = value;
        Main.arrayOfResistors.add(this);


    }

    public String getSize() {
        return value + " Ω";
    }


    /**
     * Returns R + index of this resistor
     * @return string
     */
    @Override
    public String toString() {
        return "R" + (Main.arrayOfResistors.indexOf(this) + 1);
    }
}
