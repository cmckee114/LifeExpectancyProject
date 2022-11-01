import java.util.Scanner;
import java.util.*;
import java.io.*;

//make a file with red states and blue states and purple states and then read in those files and amke them accesible to the public via pushing it onto github

public class LifeExpectancyProject{
    public static void main (String[] args) throws FileNotFoundException{
        String pathnameBlue = "/Users/cmckee/Desktop/Seminar/Unit1/LifeExpectancyProject/BlueStates.csv";
        String pathnameRed = "/Users/cmckee/Desktop/Seminar/Unit1/LifeExpectancyProject/RedStates.csv";
        String lifeExpectancyPathname = "/Users/cmckee/Desktop/Seminar/Unit1/LifeExpectancyProject/LifeExpectancyData.csv";
        String babyDataPathname = "/Users/cmckee/Desktop/Seminar/Unit1/LifeExpectancyProject/BabyData.csv";


        //running the functions to get the answers to my two questions 
        returnWinningParty(lifeExpectancyPathname, pathnameBlue, pathnameRed);
        // System.out.println(incomeQuartileDifference(babyDataPathname));
        // System.out.println(incomeQuartileDifference(lifeExpectancyPathname));
    }

//     public static void incomeQuartileDifference (String lifeExpectancyPathname) throws FileNotFoundException{
//         File lifeExpectancyFile = new File (lifeExpectancyPathname);
//         Scanner scanner = new Scanner(lifeExpectancyFile);

//         //creating an array for the header of the dataset
//         String[] header = sc.nextLine().split(",");
//         //finding the index of the columns that have the dadta I want to use 
//         int quartile1MIndex = header.indexOf("le_agg_q1_M");
//         int quartile1FIndex = header.indexOf("le_agg_q1_F");
//         int quartile2MIndex = header.indexOf("le_agg_q2_M");
//         int quartile2FIndex = header.indexOf("le_agg_q2_F");
//         int quartile3MIndex = header.indexOf("le_agg_q3_M");
//         int quartile3FIndex = header.indexOf("le_agg_q3_F");
//         int quartile4MIndex = header.indexOf("le_agg_q4_M");
//         int quartile4FIndex = header.indexOf("le_agg_q4_F");
        
//         //setting up the array that will hold my final data with the quartile average life Expectancies inside 
//         double[] quartileAverages = {0,0,0,0};

//         //each list holds the average of F and M life expectancy per state for that quartile 
//         ArrayList<Double> Q1 = new ArrayList<Double>();
//         ArrayList<Double> Q2 = new ArrayList<Double>();
//         ArrayList<Double> Q3 = new ArrayList<Double>();
//         ArrayList<Double> Q4 = new ArrayList<Double>();
        
//         //loops through all of the rows (states)
//         while(sc.hasNextLine()){
//             //DONT FORGET TO PARSE THE DOUBLES
//             //takes the value at the index of q1_M and adds to q1_F, then divides by 2 and adds to the arrayList Q1
//             //takes the value at the index of q2_M and adds to q2_F, then divides by 2 and adds to the arrayList Q2
//             //takes the value at the index of q3_M and adds to q3_F, then divides by 2 and adds to the arrayList Q3
//             //takes the value at the index of q4_M and adds to q4_F, then divides by 2 and adds to the arrayList Q4

//         }
        
//         //averagint the life expectancies in the list and putting it into the life expectancy array
//         //QUARTILE 1
//         double sumQ1 = 0;
//         for (int i =0; i<Q1.size(); i++){
//             sumQ1 += Q1.get(i);
//         }
//         double averageQ1 = sumQ1/Q1.size();
//         //adding to the array
//         quartileAverages[0] = averageQ1;

//         //QUARTILE 2
//         double sumQ2 = 0;
//         for (int i =0; i<Q2.size(); i++){
//             sumQ2 += Q2.get(i);
//         }
//         double averageQ2 = sumQ2/Q2.size();
//         //adding to the array
//         quartileAverages[1] = averageQ2;
      
//         //QUARTILE 3
//         double sumQ3 = 0;
//         for (int i =0; i<Q3.size(); i++){
//             sumQ3 += Q3.get(i);
//         }
//         double averageQ3 = sumQ3/Q3.size();
//         //adding to the array
//         quartileAverages[2] = averageQ3;
        
//         //QUARTILE 4
//         double sumQ4 = 0;
//         for (int i =0; i<Q4.size(); i++){
//             sumQ4 += Q4.get(i);
//         }
//         double averageQ4 = sumQ4/Q4.size();
//         //adding to the array
//         quartileAverages[3] = averageQ4;

//         indexQuartileMax = indexOf(quartiles.max());
//         //everything that i want to be printed out 
//         System.out.println("The First Quartile Average Life Expectancy is " + quartiles[0]);
//         System.out.println("The Second Quartile Average Life Expectancy is " + quartiles[1]);
//         System.out.println("The Third Quartile Average Life Expectancy is " + quartiles[2]);
//         System.out.println("The Fourth Quartile Average Life Expectancy is " + quartiles[3]);
//         System.out.println("The winning average life expectancy is " + quartiles.max() " which is Quartile " + (indexOf(quartiles.max())+1));
//         //is .max() not a statement that i can use?
//         //is indexOf not a function I can use?
//     }

//Assuming all states are either in the redstates data file or the bluestates data file 
    public static void returnWinningParty (String lifeExpectancyPathname, String pathnameBlue, String pathnameRed) throws FileNotFoundException{
        File blueStatesFile = new File(pathnameBlue);
        File redStatesFile = new File(pathnameRed);
        File allStatesFile = new File(lifeExpectancyPathname);

        Scanner sc = new Scanner(allStatesFile);
        
        ArrayList<Double> blueStatesExpectancy = new ArrayList<Double>();
        ArrayList<Double> redStatesExpectancy = new ArrayList<Double>();

        String[] headerArr = sc.nextLine().split(",");
        ArrayList<String> header = new ArrayList<>(Arrays.asList(headerArr));
        
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
            sum+= Double.parseDouble(line.get(q1MIndex))+ Double.parseDouble(line.get(q1FIndex))+ Double.parseDouble(line.get(q2MIndex))+ Double.parseDouble(line.get(q2FIndex))+ Double.parseDouble(line.get(q3MIndex))+ Double.parseDouble(line.get(q3FIndex))+ Double.parseDouble(line.get(q4MIndex))+ Double.parseDouble(line.get(q4FIndex));
            //creating the average with the sum of all of the life expectancies for that state
            double average = sum/8;

            if (isDem(line.get(stateNameIndex), blueStatesFile)==true){
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
        for (int i =0; i<blueStatesExpectancy.size(); i++){
            sumRed += redStatesExpectancy.get(i);
        }
        double redAverage = sumRed/redStatesExpectancy.size();

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
}