import java.util.Scanner;

/**
 * The Choice class represents all the methods which can respond to the inputs from users.
 */
public class Choice {
    /**
     * This method can receive a mark (between 0% to 100%), and the system will return the corresponding letter grade.
     * The system will check if the user enters the valid mark, if not the system will return "Please enter valid choice." .
     * @param mark The input of the users.
     * @return The String includes the letter grade or a warning.
     */
    public static String gradeGenerator(int mark) {
        if (mark >= 0 && mark <= 100) {
            if (mark > 69) {
                return "A";
            } else if (mark > 59) {
                return "B";
            } else if (mark > 49) {
                return "C";
            } else if (mark > 39) {
                return "D";
            } else {
                return "E";
            }
        } else {
            return "Please enter valid mark.";
        }
    }

    /**
     * This method can receive a lower number and an upper number, system will calculate the square, cube, and square root of all the numbers between them.
     * @param lowerNumber The lower number which user entered.
     * @param upperNumber The upper number which user entered.
     */
    public static void dataCalculator(int lowerNumber,int upperNumber){
        System.out.println();
        System.out.printf("%-10s%-10s%-10s%-15s%n", "Value", "Square", "Cube", "Square Root");
        for (int i = lowerNumber; i <upperNumber+1 ; i++) {
            double square = i*i;
            double cube = square*i;
            double sqrt = Math.sqrt(i);
            System.out.printf("%-10.2f%-10.2f%-10.2f%-15.4f%n",(double)i,square,cube,sqrt);
            System.out.println("\n");
        }
    }

    /**
     * This method allows user to enter as many numbers as they want, and the system will show the maximum, minimum, sum, and average of all the numbers when user enter "Stop".
     * The system can check if user enter the valid input, if not, system will give a warning and let user enter another input.
     */
    public static void dataProcessor() {
        int sum = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double average = 0;
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number (integer) or type 'stop' to end:");
        String input = sc.next();
        while (!input.equalsIgnoreCase("stop")) {
            try {
                num = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number (integer) or type 'stop' to end.");
                input = sc.next();
                continue;
            }
            sum += num;
            count++;
            average = (double) sum/count;
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            System.out.println("Please enter another number (integer) or type 'stop' to end:");
            input = sc.next();
        }
        if(count == 0) {
            System.out.println("There is no number!");
        }else {
            System.out.println("The maximum is " + max + ".");
            System.out.println("The minimum is " + min + ".");
            System.out.println("The sum is " + sum + ".");
            System.out.println("The average is " + average + ".");
        }

    }

    /**
     * The method allow user to enter multiple marks (between 0% to 100%), and the system will give the corresponding letter grades.
     * The system can check if user enter the valid input, if not, system will give a warning and let user enter another input.
     * Once user enters invalid marks three times, the system will not allow to enter.
     */
    public static void gradeGenerator2 () {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        do {
            if (count >= 3) {
                System.out.println("Enter the invalid mark three times, entering is finished");
                return;
            }

            System.out.println("Please enter your mark (between 0 to 100): % or enter \"-1\" to stop entering");
            int mark = sc.nextInt();

            if (mark == -1) {
                System.out.println("You have exited entering.");
                return;
            } else if (mark < 0 || mark > 100) {
                System.out.println("Please enter valid mark.");
                System.out.println("If you enter invalid marks three times, the system will not allow to enter.");
                count++;
            } else {
                gradeGenerator(mark);
                count = 0;
            }
        } while (true);
    }







    /**
     * This method displays a goodbye message to the user and end the program.
     */
    public static void exit(){
        System.out.println("Goodbye, thank you for using!");
        System.exit(0);
    }

    /**
     * This method displays an error message to the user when they enter an invalid choice.
     */
    public static void Error(){
        System.out.println("Please enter valid choice.");
    }
}
