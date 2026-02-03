import java.util.Scanner;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------
        Scanner input = new Scanner(System.in);

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------
        System.out.println("This program tracks your steps for one week.");
        System.out.print("Enter your weekly step goal: ");
        int goal = input.nextInt();

        // -------------------------------------------------------------
        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        // -------------------------------------------------------------
        int[] weekData = new int[7];

        // -------------------------------------------------------------
        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
        // -------------------------------------------------------------
        for (int i = 0; i < weekData.length; i++) {
            System.out.print("Enter steps for day " + (i + 1) + ": ");
            int steps = input.nextInt();

            while (steps < 0) {
                System.out.print("Steps cannot be negative. Try again: ");
                steps = input.nextInt();
            }

            weekData[i] = steps;
        }

        // -------------------------------------------------------------
        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        // -------------------------------------------------------------
        WeeklyData week = new WeeklyData(weekData, goal);

        // -------------------------------------------------------------
        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        // -------------------------------------------------------------
        System.out.println("\nWeekly Summary:");
        System.out.println("Total steps: " + week.getTotal());
        System.out.println("Average steps per day: " + week.getAverage());
        System.out.println("Most steps in one day: " + week.getMax());
        System.out.println("Least steps in one day: " + week.getMin());

        // -------------------------------------------------------------
        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        // -------------------------------------------------------------
        System.out.println("\nDaily Breakdown:");
        System.out.println(week);

        // -------------------------------------------------------------
        // TODO 8: Give the user insights about their week
        //         --> "You need to drink more water next week!"
        //         --> "You were very hydrated this week!"
        //         --> etc.
        // -------------------------------------------------------------
       // -------------------------------------------------------------
// TODO 8: Give the user insights about their week
// -------------------------------------------------------------
    int avgSteps = week.getAverage();
    int diff = avgSteps - goal;

    if (avgSteps >= goal) {
    System.out.println("Awesome job! You met your daily step goal.");
    System.out.println("You exceeded your goal by an average of " + diff + " steps per day.");

    System.out.println("Ways to improve even more:");
    System.out.println("- Try increasing your daily goal by 500–1000 steps.");
    System.out.println("- Add one longer walk or workout during the week.");
    System.out.println("- Focus on consistency by matching your best day on slower days.");
    } 
    else {
    System.out.println("You did not meet your daily step goal.");
    System.out.println("You were short by an average of " + Math.abs(diff) + " steps per day.");

    System.out.println("Days that need improvement:");
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    for (int i = 0; i < weekData.length; i++) {
        if (weekData[i] < goal) {
            System.out.println("- " + days[i] + " (" + weekData[i] + " steps)");
        }
    }

    System.out.println("Try adding a short walk or some light exercise on those days!");
    }

        input.close();

    }
}
