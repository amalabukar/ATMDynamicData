/**
 * Created by amalabukar on 11/17/16.
 */
public class Transaction {
    private String name;
    private String action;
    private int withdraw;

    public void chooseName() throws Exception {
        boolean goBack = true;
        while (goBack == true) {
            System.out.println("What is your name.");
            name = ATM.scanner.nextLine();
            System.out.println("Welcome, " + name);
            if (name.isEmpty()) {
                throw new Exception("Please enter valid name");
            }

            if (ATM.name.containsKey(name)) {
                goBack = false;
            }

            if (!ATM.name.containsKey(name)) {
                System.out.println("Do you want to open an account? [y/n]");
                String answer = ATM.scanner.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    ATM.name.put(name, 100.0);
                    System.out.println(ATM.name.get(name));
                    goBack = false;
                } else if (answer.equalsIgnoreCase("n")) {
                    System.out.println("Have a nice day!");
                    goBack = true;


                }

            }
        }
    }

    public boolean chooseAction() throws Exception {

        System.out.println("What action would you like to do? [ Check Balance/Withdraw/close account/Cancel]");
        action = ATM.scanner.nextLine();

        if (action.equalsIgnoreCase(("Check Balance"))) {
            System.out.println(ATM.name.get(name));


        } else if (action.equalsIgnoreCase("Withdraw")) {
            System.out.println("How much?");
            withdraw = ATM.scanner.nextInt();
        }
        if (withdraw > ATM.name.get(name)) {
            throw new Exception("Invalid");

        } else if (withdraw <= (ATM.name.get(name))) {
            System.out.print("Please take " + " Your new balance is " + " $" + (ATM.name.get(name) - withdraw) + " Have a nice day ");
            Double balance = (ATM.name.get(name) - withdraw);
            ATM.name.put(name, balance);
        }
        System.out.println("$" + withdraw);

        {
            if (action.equalsIgnoreCase("close account")) {
                System.out.println("close account [y/n]");
                String response = ATM.scanner.nextLine();
                if (response.equalsIgnoreCase("y")) {
                    System.out.println("Your account is closed");
                    ATM.name.remove(name);
                    return (false);

                } else if (action.equalsIgnoreCase("n")) {
                    System.out.println("What is your name");
                }

            }

        }
        if (action.equalsIgnoreCase("cancel")) {
            System.out.println("Have a nice day");
            return (false);

        }
        return (true);

    }


}
