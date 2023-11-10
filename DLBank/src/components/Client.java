package components;

public class Client {
    // Exercise 1.1.1: Creation of the client class

    // Attributes
    private static int lastClientNumber = 0; // To keep track of the last assigned client number
    private int clientNumber;
    private String firstName;
    private String lastName;

    // Constructor
    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientNumber = ++lastClientNumber; // Incremented with each new client
    }

    // Accessors and Mutators
    public int getClientNumber() {
        return clientNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // toString() method
    @Override
    public String toString() {
        return "Client " + clientNumber + ": " + firstName + " " + lastName;
    }
}
