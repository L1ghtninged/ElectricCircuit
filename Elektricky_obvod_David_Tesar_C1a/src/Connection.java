import java.util.Arrays;

/**
 * Contains two resistors, that are connected either serial or parallel
 * Calculates the resistance based on the type
 */
public class Connection {
    private final Resistor a;
    private final Resistor b;
    private final boolean isParallel;
    private double x;
    private double y;
    private double value;


    public Connection() {
        this.a = new Resistor(5);
        this.b = new Resistor(5);
        this.isParallel = false;
        x = a.getValue();
        y = b.getValue();
        setValue();

    }


    public Connection(Resistor a, Resistor b, boolean isParallel) {
        this.a = a;
        this.b = b;
        this.isParallel = isParallel;
        x = a.getValue();
        y = b.getValue();
        setValue();

    }

    /**
     * Calculates the resistance of a parallel connection
     * @return value
     */
    private double parallelValue() {
        return (x * y) / (x + y);

    }

    /**
     * Calculates the resistance of a serial connection
     * @return value
     */

    private double serialValue() {
        return x + y;
    }

    /**
     * Sets the value based on the type of connection
     */
    public void setValue() {
        if (isParallel) {
            value = parallelValue();
        } else {
            value = serialValue();
        }
    }

    public double getValue() {
        return value;
    }

    public Resistor getA() {
        return a;
    }

    public Resistor getB() {
        return b;
    }

    public boolean isParallel() {
        return isParallel;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    /**
     * Displays an image of the connection's type
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (isParallel) {
            String[][] array = {{"      ........"},
                    {"      |      |"},
                    {"○----" + a + "     " + b + "----○"},
                    {"      |      |"},
                    {"      ........"}};
            for (String[] row : array) {
                for (String a : row) {
                    s.append(a);
                    s.append("\n");
                }
            }


        } else {
            s.append("○----" + a + "........." + b + "----○");
            s.append("\n");


        }
        return s.toString();
    }
}
