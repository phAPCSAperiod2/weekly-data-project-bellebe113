/**
 * The WeeklyData class stores and analyzes a week’s worth of numeric data.
 * This could represent steps taken, hours of sleep, money spent, screen time,
 * or any other measurable daily value.
 */
public class WeeklyData {
//I want to tell the user the total miles they have walked per day based on the steps 
//If they have reached their weekly step goals 
//If not I want to tell them how much they still need to reach said goal 

    // -------------------------------------------------------------
    // Instance Variables
    // -------------------------------------------------------------
    private int[] steps;
    private int weeklyGoal;
    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Constructs a WeeklyData object by taking in an array of values
     * and making a deep copy (element-by-element) into the internal array.
     *
     * @param input an array representing 7 days of data
     */
    public WeeklyData(int[] input, int goal ) {
        if(input == null)
        {
            steps = new int[0];
        }
        else
        {
            steps = new int[input.length];
            // Copy each value one by one 
            for(int i = 0; i < input.length; i++){
            steps[i] = input[i]; 
            }
        }
        weeklyGoal = goal;
    }


    // -------------------------------------------------------------
    // getTotal
    // -------------------------------------------------------------
    /**
     * Calculates and returns the total of all values in the week.
     *
     * @return the sum of all values in the data array
     */
    public int getTotal() {
        int total = 0;
        for(int i = 0; i < steps.length; i++){
            total += steps[i];
        }
        
        return total;
    }


    // -------------------------------------------------------------
    // getAverage
    // -------------------------------------------------------------
    /**
     * Calculates and returns the average value for the week.
     *
     * @return the average of the values in the array,
     *         or 0.0 if the array is empty
     */
    public double getAverage() {
        if(steps.length == 0)
        {
            return 0.0;
        }
        return (double) getTotal() / steps.length; 
    }


    // -------------------------------------------------------------
    // getMax
    // -------------------------------------------------------------
    /**
     * Finds and returns the highest value in the data array.
     *
     * @return the maximum value
     */
    public double getMax() {
        if (steps.length == 0) return 0;
        int max = steps[0];
        for (int i = 1; i < steps.length; i++) {
            if (steps[i] > max) 
            {
            max = steps[i];
            }
        }
        return max; 
    }


    // -------------------------------------------------------------
    // getMin
    // -------------------------------------------------------------
    /**
     * Finds and returns the lowest value in the data array.
     *
     * @return the minimum value
     */
    public double getMin() {
        if (steps.length == 0) return 0;
        int min = steps[0];
        for (int i = 1; i < steps.length; i++) 
        {
            if (steps[i] < min)
            {
                min = steps[i];
            }
        }
        return min; 
    }


    // -------------------------------------------------------------
    // toString
    // -------------------------------------------------------------
    /**
     * Returns a formatted, multi-line String showing each day’s data.
     *
     * Example:
     * Day 1: 4500
     * Day 2: 6200
     * Day 3: 5100
     *
     * @return a formatted String representing the week’s data
     */
    @Override
    public String toString() {
        String output = "";

    for (int i = 0; i < steps.length; i++) 
    {
        output += "Day " + (i + 1) + ": " + steps[i] + " steps\n";
    }
    output += "Total steps: " + getTotal() + "\n";
    output += checkWeeklyGoal();

    return output;
    }
}
