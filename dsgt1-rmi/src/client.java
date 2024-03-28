import hotel.Manager;
import staff.BookingClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class client {
    public static void main(String[] args) {


        try {
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Manager stub = (Manager) registry.lookup("Manager");
            new BookingClient(stub);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

