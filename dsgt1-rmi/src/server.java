import hotel.BookingManager;
import hotel.Manager;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class server {
    public static void main(String args[]) {

        try {
            BookingManager bm = new BookingManager();
            Manager stub = (Manager) UnicastRemoteObject.exportObject(bm, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Manager", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
