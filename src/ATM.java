import java.util.Scanner;
import java.util.HashMap;



/**
 * Created by amalabukar on 11/17/16.
 */
public class ATM {

    public static Scanner scanner = new Scanner(System.in);
    public static Transaction transaction = new Transaction();
    public static HashMap <String, Double> name = new HashMap ();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to PNC.");


        transaction.chooseName();



        while (true) {
            boolean keepRunning = transaction.chooseAction();
            if (!keepRunning) {
            transaction.chooseName();

    }



}}}
