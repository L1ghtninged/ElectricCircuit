import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {

    public static ArrayList<Resistor> arrayOfResistors = new ArrayList<>();



    public static void main(String[] args){
        Circuit circuit = new Circuit();

        double voltage = -1;
        int user;
        /**
         * This asks for the voltage
         */
        do{
            try{
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Set voltage:");
                voltage = scanner1.nextDouble();

            }catch(InputMismatchException e){
                System.out.println("Please, write numbers");
            }
        }while(voltage<=0);
        /**
         * This repeats until user types 0
         */
        do{
            try{
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Add connection(1), Delete connection(2), Info about connections(3), Change voltage(4), Display Connections(5), Exit(0)");
                user = scanner1.nextInt();

            }catch(InputMismatchException e){
                System.out.println("Please, write numbers");
                user = -1;
            }
            /**
             * Adds a connection, that user chooses
             */
            if(user==1){
                double r1;
                double r2;
                boolean parallel;
                double response = 0;

                do{
                    try{
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Enter R"+(arrayOfResistors.size()+1));
                        response = scanner1.nextDouble();

                    }catch (InputMismatchException e){
                        System.out.println("Please, write numbers");
                    }

                }while(response<=0);
                r1 = response;
                response = 0;
                do{
                    try{
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Enter R"+(arrayOfResistors.size()+2));
                        response = scanner1.nextDouble();

                    }catch (InputMismatchException e){
                        System.out.println("Please, write numbers");
                    }

                }while(response<=0);
                r2 = response;
                response = 0;
                do{
                    try{
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Will the connection be serial(1) or parallel ?(2)");
                        response = scanner1.nextDouble();

                    }catch (InputMismatchException e){
                        System.out.println("Please, write numbers");
                    }
                }while(response<=0);
                if(response==1){
                    parallel = false;
                }
                else{
                    parallel = true;
                }
                circuit.addConnection(new Connection(new Resistor(r1),new Resistor(r2),parallel));

            }
            /**
             * Removes a connection, that user chooses
             */

            else if (user==2&&circuit.containsIndex(0)) {
                System.out.println(circuit);
                int response;
                do {
                    try{
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Enter the number of the connection that you want to delete: ");
                        response = scanner1.nextInt();
                    }catch(InputMismatchException e){
                        System.out.println("Please, write numbers");
                        response = 0;
                    }

                }while(!(circuit.containsIndex(response-1)));
                circuit.removeConnection(response-1);
                System.out.println("Connection was removed");

            }
            else if(user==2){

                System.out.println("There are no connections to delete");
            }

            /**
             * Prints the values of all created connections
             */
            else if(user==3){
                System.out.println(circuit.infoOfConnections(voltage));

                /**
                 * Changes the voltage
                 */
            } else if (user==4) {
                do{
                    try{
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Set voltage:");
                        voltage = scanner1.nextDouble();

                    }catch (InputMismatchException e){
                        System.out.println("Please, write numbers");
                        voltage = 0;
                    }
                }while(voltage<=0);
            }
            /**
             * Prints the toString() method from the circuit
             */
            else if(user==5){
                System.out.println(circuit);
            }

        }while(user!=0);
        System.out.println("Goodbye!");

    }


}