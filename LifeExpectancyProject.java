import java.util.Scanner;
import java.util.*;
import java.io.*;


public class LifeExpectancyProject{
    public static void main (String[] args) throws FileNotFoundException{
        //creating all of the pathnames for my files
        String pathnameBlue = "/Users/cmckee/Desktop/Seminar/Unit1/LifeExpectancyProject/BlueStates.csv";
        String pathnameRed = "/Users/cmckee/Desktop/Seminar/Unit1/LifeExpectancyProject/RedStates.csv";
        String lifeExpectancyPathname = "/Users/cmckee/Desktop/Seminar/Unit1/LifeExpectancyProject/LifeExpectancyData.csv";
        String babyDataPathname = "/Users/cmckee/Desktop/Seminar/Unit1/LifeExpectancyProject/BabyData.csv";

        //running the functions to get the answers to my two questions 
        returnWinningParty(lifeExpectancyPathname, pathnameBlue);
        incomeQuartileDifference(lifeExpectancyPathname);
    }

    public static void incomeQuartileDifference (String lifeExpectancyPathname) throws FileNotFoundException{
        //creating a file from my pathname that I created in the main
        File lifeExpectancyFile = new File (lifeExpectancyPathname);
        //creating a scanner to scan through the lifeExpectancy file 
        Scanner sc = new Scanner(lifeExpectancyFile);

        //creating an array for the header of the dataset
        String[] headerArr = sc.nextLine().split(",");
        ArrayList<String> header= new ArrayList(Arrays.asList(headerArr));

        //finding the index of the columns that have the dadta I want to use 
        int quartile1MIndex = header.indexOf("le_agg_q1_M");
        int quartile1FIndex = header.indexOf("le_agg_q1_F");
        int quartile2MIndex = header.indexOf("le_agg_q2_M");
        int quartile2FIndex = header.indexOf("le_agg_q2_F");
        int quartile3MIndex = header.indexOf("le_agg_q3_M");
        int quartile3FIndex = header.indexOf("le_agg_q3_F");
        int quartile4MIndex = header.indexOf("le_agg_q4_M");
        int quartile4FIndex = header.indexOf("le_agg_q4_F");
        
        //setting up the array that will hold my final data with the quartile average life Expectancies inside 
        Double[] quartileAveragesAsArr = {0.0,0.0,0.0,0.0};
        ArrayList<Double> quartileAverages = new ArrayList<>(Arrays.asList(quartileAveragesAsArr));

        //each list holds the average of F and M life expectancy per state for that quartile 
        ArrayList<Double> Q1 = new ArrayList<Double>();
        ArrayList<Double> Q2 = new ArrayList<Double>();
        ArrayList<Double> Q3 = new ArrayList<Double>();
        ArrayList<Double> Q4 = new ArrayList<Double>();
        
        //loops through all of the rows (states)
        while(sc.hasNextLine()){
            //isolating the current line and splitting it up by commas so that i can grab values within the line
            ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            
            //getting the first quartile average for the line (state)
            double Q1Sum=0;
            double Q1Average =0;
            Q1Sum += Double.parseDouble(line.get(quartile1MIndex));
            Q1Sum += Double.parseDouble(line.get(quartile1FIndex));
            Q1Average = Q1Sum/2;
            //putting the first quartile average for that state into the arrayList for all of the states' first income quartile average life expectancies
            Q1.add(Q1Average);

            //getting the second quartile average for the line (state)
            double Q2Sum=0;
            double Q2Average = 0;
            Q2Sum += Double.parseDouble(line.get(quartile2MIndex));
            Q2Sum += Double.parseDouble(line.get(quartile2FIndex));
            Q2Average = Q2Sum/2;
            //putting the second quartile average for that state into the arrayList for all of the states' second income quartile average life expectancies
            Q2.add(Q2Average);

            //getting the third quartile average for the line(state)
            double Q3Sum=0;
            double Q3Average = 0;
            Q3Sum += Double.parseDouble(line.get(quartile3MIndex));
            Q3Sum += Double.parseDouble(line.get(quartile3FIndex));
            Q3Average = Q3Sum/2;
            //putting the third quartile average for that state into the arrayList for all of the states' third income quartile average life expectancies
            Q3.add(Q3Average);

            //getting the fourth quartile average for the line(state)
            double Q4Sum=0;
            double Q4Average = 0;
            Q4Sum += Double.parseDouble(line.get(quartile4MIndex));
            Q4Sum += Double.parseDouble(line.get(quartile4FIndex));
            Q4Average = Q4Sum/2;
            //putting the fourth quartile average for that state into the arrayList for all of the states' fourth income quartile average life expectancies
            Q4.add(Q4Average);

        }
        
        //averaging the life expectancies in the list and putting it into the life expectancy array
        //QUARTILE 1
        double sumQ1 = 0;
        for (int i =0; i<Q1.size(); i++){
            sumQ1 += Q1.get(i);
        }
        double averageQ1 = sumQ1/Q1.size();
        //adding to the arrayList holding the final averages
        quartileAverages.set(0,averageQ1);

        //QUARTILE 2
        double sumQ2 = 0;
        for (int i =0; i<Q2.size(); i++){
            sumQ2 += Q2.get(i);
        }
        double averageQ2 = sumQ2/Q2.size();
        //adding to the arrayList holding the final averages
        quartileAverages.set(1,averageQ2);
      
        //QUARTILE 3
        double sumQ3 = 0;
        for (int i =0; i<Q3.size(); i++){
            sumQ3 += Q3.get(i);
        }
        double averageQ3 = sumQ3/Q3.size();
        //adding to the arrayList holding the final averages
        quartileAverages.set(2,averageQ3);
        
        //QUARTILE 4
        double sumQ4 = 0;
        for (int i =0; i<Q4.size(); i++){
            sumQ4 += Q4.get(i);
        }
        double averageQ4 = sumQ4/Q4.size();
        //adding to the arrayList holding the final averages
        quartileAverages.set(3,averageQ4);

        //finding the index of the highest life expectancy
        double indexQuartileMax = quartileAverages.indexOf(max(quartileAverages));
        //everything that i want to be printed out 
        System.out.println("The First Quartile Average Life Expectancy is " + quartileAverages.get(0));
        System.out.println("The Second Quartile Average Life Expectancy is " + quartileAverages.get(1));
        System.out.println("The Third Quartile Average Life Expectancy is " + quartileAverages.get(2));
        System.out.println("The Fourth Quartile Average Life Expectancy is " + quartileAverages.get(3));
        //finding the highest life expectancy
        double maxAverage = max(quartileAverages);
        System.out.println("The winning average life expectancy is " + max(quartileAverages) + " which is Quartile " + ((quartileAverages.indexOf(maxAverage)+1)));
    }

//Assuming all states are either in the redstates data file or the bluestates data file 
    public static void returnWinningParty (String lifeExpectancyPathname, String pathnameBlue) throws FileNotFoundException{
        //creating a files from my pathnames that I created in the main
        File blueStatesFile = new File(pathnameBlue);
        File lifeExpectancyFile = new File(lifeExpectancyPathname);

        //creating a scanner to scan through the lifeExpectancy file (to go through the states)
        Scanner sc = new Scanner(lifeExpectancyFile);
        
        //creating arraylists to hold all of the average life expectancies of each state(whether it iss blue or red)
        ArrayList<Double> blueStatesExpectancy = new ArrayList<Double>();
        ArrayList<Double> redStatesExpectancy = new ArrayList<Double>();

        //creating the header line and splitting it by commas to get the header names to get all of the indexes
        String[] headerArr = sc.nextLine().split(",");
        //turning the header into an arraylist for more functionality
        ArrayList<String> header = new ArrayList<>(Arrays.asList(headerArr));
        
        //getting all of the indexes for the values that i need for each state
        int stateNameIndex = header.indexOf("statename");
        int q1MIndex = header.indexOf("le_agg_q1_M");
        int q1FIndex = header.indexOf("le_agg_q1_F");
        int q2MIndex = header.indexOf("le_agg_q2_M");
        int q2FIndex = header.indexOf("le_agg_q2_F");
        int q3MIndex = header.indexOf("le_agg_q3_M");
        int q3FIndex = header.indexOf("le_agg_q3_F");
        int q4MIndex = header.indexOf("le_agg_q4_M");
        int q4FIndex = header.indexOf("le_agg_q4_F");

        while (sc.hasNextLine()){
            //taking the current line and splitting it and putting it into an arraylist
            ArrayList<String> line = new ArrayList<>(Arrays.asList(sc.nextLine().split(",")));
            
            //adding together all of the data so that i can then average
            double sum= 0;
            //adding all of the individual life expectancies to the sum
            sum+= Double.parseDouble(line.get(q1MIndex));
            sum+= Double.parseDouble(line.get(q1FIndex));
            sum+= Double.parseDouble(line.get(q2MIndex));
            sum+= Double.parseDouble(line.get(q2FIndex));
            sum+= Double.parseDouble(line.get(q3MIndex));
            sum+= Double.parseDouble(line.get(q3FIndex));
            sum+= Double.parseDouble(line.get(q4MIndex));
            sum+= Double.parseDouble(line.get(q4FIndex));
            //creating the average with the sum of all of the life expectancies for that state
            double average = sum/8;

            //testing whether or not the state is democrat 
            //if the state is democrat, add the average life expectancy of that state to the blueStatesExpectancy arraylist
            //if the states isn't democrat, it must be republican and then add it to the redStatesExpectancy arraylist 
            if (isDem(line.get(stateNameIndex), blueStatesFile)){
                blueStatesExpectancy.add(average);
            }
            else{
                redStatesExpectancy.add(average);
            }
            //depending on whether or not this state is republican or democrat add the average onto the list blueStatesExpectancy or redStatesExpectancy
        }

        //average all of the values in the blueLifeExpectancy arraylist
        double sumBlue = 0;
        for (int i =0; i<blueStatesExpectancy.size(); i++){
            sumBlue += blueStatesExpectancy.get(i);
        }
        double blueAverage = sumBlue/blueStatesExpectancy.size();

        //average all of the values in the redLifeExpectancy arraylist
        double sumRed = 0;
        for (int i =0; i<redStatesExpectancy.size(); i++){
            sumRed += redStatesExpectancy.get(i);
        }
        double redAverage = sumRed/redStatesExpectancy.size();

        //printing out the results 
        System.out.println("The average life expectancy for the republican states is " + redAverage);
        System.out.println("The average life expectancy for the democratic states is " + blueAverage);
    }

    public static boolean isDem (String state, File blueStatesFile) throws FileNotFoundException{
        //reading through the blue states file 
        Scanner blueSC = new Scanner(blueStatesFile);
        blueSC.nextLine();
        ArrayList<String> blueStates= new ArrayList<>();
        while (blueSC.hasNextLine()){
            //adds state to the arraylist
            blueStates.add(blueSC.nextLine()); //IS THIS RIGHT 
        }
        //is the state is in the list of states thats democrat return true
        if (blueStates.contains(state)){
            return true;
        }
        //if its not return false 
        else{
            return false;
        }
    }

    //helper method to return the max of an arraylist 
    public static double max (ArrayList<Double> arraylist){
        Double currMax = arraylist.get(0);
        for(int i =1; i< arraylist.size(); i++){
            if (arraylist.get(i)> currMax){
                currMax = arraylist.get(i);
            }
        }
        return currMax;
    }
}