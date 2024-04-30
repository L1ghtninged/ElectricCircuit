import java.util.ArrayList;

/**
 * Contains an arraylist of all connections and calculates the values
 */
public class Circuit {
    private final ArrayList<Connection> arrayList = new ArrayList<>();

    /**
     * Adds a connection to the circuit
     * @param connection - connection that is getting added
     */
    public void addConnection(Connection connection) {
        arrayList.add(connection);

    }

    /**
     * Removes a connection from the circuit
     * @param index - index of the connection
     */
    public void removeConnection(int index){
        Main.arrayOfResistors.remove(arrayList.get(index).getA());
        Main.arrayOfResistors.remove(arrayList.get(index).getB());
        arrayList.remove(index);
    }

    /**
     * Checks, if a certain index is in the list
     * @param index - is being checked
     * @return boolean
     */
    public boolean containsIndex(int index){
        return index < arrayList.size() && index >= 0;


    }

    /**
     * Returns a string of information of the connections that are in the list
     * @param voltage - used for calculations
     * @return string
     */
    public String infoOfConnections(double voltage) {
        StringBuilder s = new StringBuilder();
        double totalResistance = 0;
        double totalCurrent = 0;
        for (Connection c : arrayList) {
            s.append("Connection " + (arrayList.indexOf(c) + 1));
            s.append("\n");
            s.append(c.getA() + "=" + c.getA().getValue());
            s.append("\n");
            s.append(c.getB() + "=" + c.getB().getValue());
            s.append("\n");
            s.append("Value of connection is: " + c.getValue() + " Ω");
            s.append("\n");
            double current = voltage/c.getValue();
            s.append("Electric current I = U/R = "+voltage+"/"+c.getValue()+" = "+current+" A");
            s.append("\n");
            totalResistance+=c.getValue();
            totalCurrent+=current;


        }
        s.append("\n");
        s.append("Voltage: "+voltage+"\n");
        s.append("Total resistance: "+totalResistance+"\n");
        s.append("Total current: "+totalCurrent+"\n");





        return s.toString();
    }

    /**
     * Returns an image of the connections
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();


        for (Connection c : arrayList) {
            s.append(arrayList.indexOf(c)+1+")"+"\n");
            s.append(c);
            s.append("\n");
        }

        return s.toString();
    }


}
