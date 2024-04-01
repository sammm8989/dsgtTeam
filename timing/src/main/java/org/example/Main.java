package org.example;

import java.io.*;

import hotel.BookingDetail;
import hotel.Manager;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;


public class Main {

    static String host = "dsgt2024team13.japaneast.cloudapp.azure.com";

    static String[] commandSoapGet = {"curl", "--header", "Content-Type: text/xml; charset=utf-8", "-d",
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:gs=\"http://foodmenu.io/gt/webservice\">\n" +
                    "    <soapenv:Header/>\n" +
                    "    <soapenv:Body>\n" +
                    "        <gs:getMealRequest>\n" +
                    "            <gs:name>Portobello</gs:name>\n" +
                    "        </gs:getMealRequest>\n" +
                    "    </soapenv:Body>\n" +
                    "</soapenv:Envelope>\n",
            "http://"+host+":8081/ws"
    };

    static String[] commandSoapAddOrder = {
            "curl",
            "--header",
            "Content-Type: text/xml; charset=utf-8",
            "-d",
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:gs=\"http://foodmenu.io/gt/webservice\">\n" +
                    "    <soapenv:Header/>\n" +
                    "    <soapenv:Body>\n" +
                    "        <gs:addOrderRequest>\n" +
                    "            <gs:order>\n" +
                    "                <gs:orderId>5</gs:orderId>\n" +
                    "                <gs:mealName>Steak</gs:mealName>\n" +
                    "                <gs:quantity>2</gs:quantity>\n" +
                    "            </gs:order>\n" +
                    "        </gs:addOrderRequest>\n" +
                    "    </soapenv:Body>\n" +
                    "</soapenv:Envelope>\n",
            "http://"+host+":8081/ws"
    };


    static String[] commandDeleteMealRest = {
            "curl",// Verbose output
            "-X", "DELETE",  // HTTP method
            host+":7070/rest/meals/kflkgnerong",
            "-H", "Content-type:application/json" , "-v" // Header
    };

    static String[] commandGetMealRest = {
            "curl","-v",// Verbose output
            "GET",  // HTTP method
            host+":7070/rest/meals/5268203c-de76-4921-a3e3-439db69c462a",
            "-H", "Content-type:application/json"  // Header
    };


    static String[] commandPostMealRest = {
            "curl",// Verbose output
            "-X", "POST",  // HTTP method
            host+":7070/rest/meals",
            "-H", "Content-type:application/json",
            "-d","{\"id\": \"kflkgnerong\", \"name\": \"Double Cheese\", \"kcal\": 2000, \"price\": 10.0, \"description\": \"Double Cheese Burger\", \"mealType\": \"MEAT\"}",
            "-v"
    };


    static String[] commandUpdateMealRest = {
            "curl",
            "-v",  // Verbose output (added at the end)
            "-X", "PUT",  // HTTP method
            host+":7070/rest/meals/5268203c-de76-4921-a3e3-439db69c462a",
            "-H", "Content-type:application/json", "-d",
            "{\"id\": \"cfd1601f-29a0-485d-8d21-7607ec0340c8\",\"name\": \"Fish and Chips and Mayo\",\"kcal\": 1000,\"price\": 6.0,\"description\": \"Fried fish with chips with mayo\",\"mealType\": \"FISH\"}"
    };



    static String[] commandDeleteMealRestrpc = {
            "curl",// Verbose output
            "-X", "DELETE",  // HTTP method
            host+":7070/restrpc/meals/kflkgnerong",
            "-H", "Content-type:application/json" , "-v" // Header
    };

    static String[] commandGetMealRestrpc = {
            "curl","-v",// Verbose output
            "-X", "GET",  // HTTP method
            host+":7070/restrpc/meals/4237681a-441f-47fc-a747-8e0169bacea1",
            "-H", "Content-type:application/json"  // Header
    };


    static String[] commandPostMealRestrpc = {
            "curl",// Verbose output
            "-X", "POST",  // HTTP method
            host+":7070/restrpc/meals",
            "-H", "Content-type:application/json",
            "-d","{\"id\": \"kflkgnerong\",\"name\": \"Double Cheese\", \"kcal\": 2000, \"price\": 10.0, \"description\": \"Double Cheese Burger\", \"mealType\": \"MEAT\"}",
            "-v"
    };


    static String[] commandUpdateMealRestrpc = {
            "curl",
            "-v",  // Verbose output (added at the end)
            "-X", "PUT",  // HTTP method
            host+":7070/restrpc/meals/cfd1601f-29a0-485d-8d21-7607ec0340c8",
            "-H", "Content-type:application/json", "-d",
            "{\"id\": \"cfd1601f-29a0-485d-8d21-7607ec0340c8\",\"name\": \"Fish and Chips and Mayo\",\"kcal\": 1000,\"price\": 6.0,\"description\": \"Fried fish with chips with mayo\",\"mealType\": \"FISH\"}"
    };



    public static void main(String[] args) throws InterruptedException, RemoteException {
        Main mn = new Main();
        //Warm up so the overhead processing is already gone
        //If we don't do this the first requests takes long, and we get a skewed dataset
        //We are comparing everything relative to eachother
        //Test RMI adding a reservation

        mn.RMI(host);
        //mn.SOAP();
        //mn.REST();


    }

    public void RMI(String host) throws RemoteException, InterruptedException {
        doRMIGet(host,10);
        doRMIAdd(host,10);

        ArrayList<Long> RMIAdd = doRMIAdd(host,100);
        ArrayList<Long> RMIGet = doRMIGet(host,100);

        System.out.println("RMIAdd = " + RMIAdd);
        System.out.println("RMIGet = " + RMIGet);
    }

    public void SOAP(){

        doCommand(commandSoapGet,5);
        ArrayList<Long> SoapGet = doCommand(commandSoapGet,100);
        doCommand(commandSoapAddOrder,5);

        ArrayList<Long> SoapAdd = doCommand(commandSoapAddOrder,100);

        System.out.println("SoapGet = " + SoapGet);
        System.out.println("SoapAdd = " +  SoapAdd);


    }
    public void REST(){
        doCommand(commandGetMealRest,5);

        ArrayList<Long> RestGet = doCommand(commandGetMealRest,100);
        ArrayList<Long> RestUpdate= doCommand(commandUpdateMealRest,100);
        ArrayList<Long> RestAdd = doCommand(commandPostMealRest,100);
        ArrayList<Long> RestDelete = doCommand(commandDeleteMealRest,100);


        doCommand(commandPostMealRestrpc,5);


        ArrayList<Long> RestGetRpc = doCommand(commandGetMealRestrpc,100);
        ArrayList<Long> RestUpdateRpc= doCommand(commandUpdateMealRestrpc,100);
        ArrayList<Long> RestAddRpc = doCommand(commandPostMealRestrpc,100);
        ArrayList<Long> RestDeleteRpc = doCommand(commandDeleteMealRestrpc,100);




        System.out.println("RestDelete = " + RestDelete);
        System.out.println("RestUpdate = " + RestUpdate);
        System.out.println("RestAdd = " + RestAdd);
        System.out.println("RestGet = " + RestGet);
        System.out.println("RestDeleteRpc = " + RestDeleteRpc);
        System.out.println("RestUpdateRpc = " + RestUpdateRpc);


        System.out.println("RestAddRpc = " + RestAddRpc);
        System.out.println("RestGetRpc = " + RestGetRpc);

    }

    public ArrayList<Long> doRMIAdd(String host, int numberOfTimes) throws InterruptedException, RemoteException {
        BookingDetail bd1 = new BookingDetail("Ansar", 101, LocalDate.now());
        ArrayList<Long> timing = new ArrayList<Long>();
        for (int i = 0; i < numberOfTimes; i++) {
            long startTime = System.currentTimeMillis();
            try {
                Registry registry = LocateRegistry.getRegistry(host);
                Manager stub = (Manager) registry.lookup("Manager");
                stub.addBooking(bd1);

            } catch (AccessException e) {
                throw new RuntimeException(e);
            } catch (NotBoundException e) {
                throw new RuntimeException(e);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            timing.add(System.currentTimeMillis() - startTime);
        }


        return timing;
    }


    public ArrayList<Long> doRMIGet(String host, int numberOfTimes) throws InterruptedException {
        ArrayList<Long> timing = new ArrayList<Long>();
        for (int i = 0; i < numberOfTimes; i++) {
            long startTime = System.currentTimeMillis();
            try {
                Registry registry = LocateRegistry.getRegistry(host);
                Manager stub = (Manager) registry.lookup("Manager");
                stub.getAvailableRooms(LocalDate.now());

            } catch (AccessException e) {
                throw new RuntimeException(e);
            } catch (NotBoundException e) {
                throw new RuntimeException(e);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
            timing.add(System.currentTimeMillis() - startTime);
        }


        return timing;
    }

    public ArrayList<Long> doCommand(String[] command, int numberOfTimes){
        ArrayList<Long> timing = new ArrayList<Long>();
        for(int i = 0; i < numberOfTimes; i++) {
            long startTime = System.currentTimeMillis();
            try {
                ProcessBuilder pb = new ProcessBuilder(command);
                pb.inheritIO();
                Process process = pb.start();
                process.waitFor();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            timing.add(System.currentTimeMillis() - startTime);
        }
        return timing;
    }


}