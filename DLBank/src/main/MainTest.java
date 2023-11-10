package main;

import java.util.Collection;

import components.Client;

import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) {
        // Declare an array (Collection) of clients
        Collection<Client> clients = loadClients(3);

        // Use a method to display the contents of the table
        displayClients(clients);
    }

    public static Collection<Client> loadClients(int numClients) {
        return Arrays.asList(
                createClient("name1", "firstname1"),
                createClient("name2", "firstname2"),
                createClient("name3", "firstname3")
                // Add more clients as needed
        );
    }

    private static Client createClient(String lastName, String firstName) {
        return new components.Client(firstName, lastName);
    }

    public static void displayClients(Collection<Client> clients) {
        clients.stream()
                .map(Client::toString)
                .forEach(System.out::println);
    }
}
