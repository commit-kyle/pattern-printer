import java.util.Scanner;

public class PatternPrinterImpl extends PatternPrinter {

    /**
     * Starts the pattern printing process
     * @param scanner Used to capture user input
     */
    public void run(Scanner scanner) {
        boolean shouldRestart = true;

        while (shouldRestart) {
            int rows = getRowsFromUser(scanner);

            promptCharacterSelection(scanner);

            this.constructPattern(rows);

            shouldRestart = promptRestart(scanner);
        }

        scanner.close();
    }

    /**
     * Prompts the user to select a character. Alternatively, the default character (*) will be used in the pattern.
     * @param scanner Used to capture user input
     */
    private void promptCharacterSelection(Scanner scanner) {
        System.out.println("Do you want to change the character used for your pattern? (Y/N)");
        String userInput = scanner.nextLine();

        if (userInput.equalsIgnoreCase("Y")) {
            System.out.println("Sweeet! Go ahead and type your character.");

            String userCharacter = scanner.nextLine();
            this.setPatternCharacter(userCharacter);
        } else if (!userInput.equalsIgnoreCase("Y") && !userInput.equalsIgnoreCase("N")) {
            System.out.println("I need 'Y' or 'N', please");
            promptCharacterSelection(scanner);
        } else {
            System.out.println("Using the default character instead (*)");
        }
    }

    /**
     * Prompts the user to define the amount of rows per pattern.
     * We do not continue until its value is correctly defined.
     * @param scanner Used to capture user input
     * @return The amount of rows a user wants in the pattern
     */
    private int getRowsFromUser(Scanner scanner) {
        int rows;

        while (true) {
            System.out.println("How many rows would you like?");

            try {
                rows = Integer.parseInt(scanner.nextLine());

                if (rows > 0) {
                    break;
                } else {
                    System.out.println("I actually need an integer with a positive value.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Whatever you gave me was not an integer...");
            }
        }

        return rows;
    }

    /**
     * Prompts the user on whether they would like to restart the pattern printing process.
     * @param scanner Used to capture user input
     * @return Boolean value which determines whether we restart the pattern printing process
     */
    private boolean promptRestart(Scanner scanner) {
        System.out.println("Cool, right! Wanna go again? (Y/N)");

        boolean shouldRestart = true;
        String userInput = scanner.nextLine();

        if (!userInput.equalsIgnoreCase("Y")) {
            System.out.println("Hope you had fun! Cheers!");
            shouldRestart = false;
        }

        return shouldRestart;
    }
}
