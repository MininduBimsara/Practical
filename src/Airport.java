import java.io.*;
import java.util.Scanner;

public class Airport {
    private Passenger[] passengers;
    private PassengerQueue queue;

    public Airport() {
        passengers = new Passenger[20];
        queue = new PassengerQueue(20);
    }

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;
        do {
            System.out.println("Menu:");
            System.out.println("A: Add passenger to queue");
            System.out.println("V: View passenger queue");
            System.out.println("D: Delete passenger from queue");
            System.out.println("S: Store passenger data into file");
            System.out.println("L: Load passenger data from file");
            System.out.println("R: Run simulation and produce report");
            System.out.println("Q: Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);
            switch (choice) {
                case 'A':
                    addPassenger();
                    break;
                case 'V':
                    queue.display();
                    break;
                case 'D':
                    removePassenger();
                    break;
                case 'S':
                    storePassengerDataToFile();
                    break;
                case 'L':
                    loadPassengerDataFromFile();
                    break;
                case 'R':
                    runSimulationAndProduceReport();
                    break;
                case 'Q':
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 'Q');
        scanner.close();
    }

    private void addPassenger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter passenger's first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter passenger's surname: ");
        String surname = scanner.nextLine();
        Passenger passenger = new Passenger(firstName, surname);
        queue.add(passenger);
        System.out.println("Passenger added to queue.");
    }

    private void removePassenger() {
        Passenger removedPassenger = queue.remove();
        if (removedPassenger != null) {
            System.out.println("Passenger removed from queue: " + removedPassenger.getFirstName() + " " + removedPassenger.getSurName());
        }
    }

    private void storePassengerDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("passenger_data.txt"))) {
            for (Passenger passenger : passengers) {
                if (passenger != null) {
                    writer.println(passenger.getFirstName() + "," + passenger.getSurName());
                }
            }
            System.out.println("Passenger data stored to file successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while storing passenger data: " + e.getMessage());
        }
    }

    private void loadPassengerDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("passenger_data.txt"))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                passengers[index] = new Passenger(parts[0], parts[1]);
                index++;
            }
            System.out.println("Passenger data loaded from file successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while loading passenger data: " + e.getMessage());
        }
    }

    private void runSimulationAndProduceReport() {
        // Implement simulation and report generation
    }
}