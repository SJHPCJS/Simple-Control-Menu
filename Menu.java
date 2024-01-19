import java.util.Scanner;

/**
 * The menu class represents a menu of data processing.
 * System can display the menu and process user's choice to access to the different processing options.
 */
public class Menu {
    public static void main(String[] args) {
        do {
            new Menu().processUserChoices();
        }while(true);
    }

    /**
     * This is a method to display the menu.
     */
    public void displayMenu(){
    System.out.println("---------------------------------------");
    System.out.println("                 Menu                  ");
    System.out.println("---------------------------------------");
    System.out.println();
    System.out.println("Please select one of the options below.");
    System.out.println("1. Calculate your grade.");
    System.out.println("2. Calculate square,cube and square root.");
    System.out.println("3. Calculate statistics.");
    System.out.println("4. Calculate multiple grades.");
    System.out.println("0. Exit the system.");
    }

    /**
     * This is a method to process the choices form the users.
     * If user types 1, the system will call generateGrade() method in Choice class.
     * If user types 2, the system will call dataCalculator() method in Choice class.
     * (The system will check if the lower number is smaller than upper number. If not, the system will turn the smaller one into lower number and let user enter an upper number.)
     * If user types 3, the system will call dataProcessor() method in Choice class.
     * If user types 4, the system will call gradeGenerator2() method in Choice class.
     * If user types 0, the system will call exit() method in Choice class.
     * If user types anything else, the system will display "Please enter valid choice." to warn users.
     */
    public void processUserChoices(){
        final String Choice1 = "1";
        final String Choice2 = "2";
        final String Choice3 = "3";
        final String Choice4 = "4";
        final String Exit = "0";

        new Menu().displayMenu();
        Scanner sc = new Scanner(System.in);
        String userchoice = sc.next();

        switch (userchoice){
            case Choice1 -> {
                System.out.println("Please enter your mark (between 0 to 100): %");
                int mark = sc.nextInt();
                String letter = Choice.gradeGenerator(mark);
                if(letter.equalsIgnoreCase("Please enter valid mark.")){
                    System.out.println(letter);
                }else System.out.println("Your mark is "+ mark + "% . Your grade is " + letter + ".");
            }

            case Choice2 -> {
                System.out.println("Please enter the lower number:");
                int lowerNumber = sc.nextInt();
                System.out.println("Please enter upper number: ");
                int upperNumber = sc.nextInt();
                while(lowerNumber > upperNumber){
                    lowerNumber = upperNumber;
                    System.out.println("Now lower number is " + lowerNumber + ". Please enter the upper number larger than " + lowerNumber +".");
                    upperNumber = sc.nextInt();
                }
                Choice.dataCalculator(lowerNumber,upperNumber);
            }

            case Choice3 -> Choice.dataProcessor();
            case Choice4 -> Choice.gradeGenerator2();
            case Exit -> Choice.exit();
            default -> Choice.Error();


        }
    }
}