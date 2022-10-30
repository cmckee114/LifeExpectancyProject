import java.util.Scanner;
import java.util.*;
import java.util.io;

//make a file with red states and blue states and purple states and then read in those files and amke them accesible to the public via pushing it onto github

public class LifeExpectancyProject{
    public static void main (String[] args) throws FileNotFoundException{
        String pathnameBlue = "/Users/cmckee/Desktop/Seminar/Unit1/LifeExpectancyProject/Unit1/LifeExpectancyProject/LifeExpectancyProject.csv";
        String pathnameRed = "/Users/cmckee/Desktop/Seminar/Unit1/LifeExpectancyProject/Unit1/LifeExpectancyProject/RedStates.csv";
        String lifeExpectancyPathname = "/Users/cmckee/Desktop/Seminar/Unit1/LifeExpectancyProject/Unit1/LifeExpectancyProject/BlueStates.csv";
        
        //System.out.println(returnWinningParty(pathnameBlue, pathnameRed));
        //System.out.println(incomeQuartileDifference(lifeExpectancyPathname));
    
    }

    public static void incomeQuartileDifference (String lifeExpectancyPathname) throws FileNotFoundException{
        File lifeExpectancyFile = new File (lifeExpectancyPathname);
        Scanner scanner = new Scanner(lifeExpectancyFile);
        
        double[] quartiles = {0,0,0,0};
        ArrayList<Double> Q1 = new ArrayList<Double>();
        ArrayList<Double> Q2 = new ArrayList<Double>();
        ArrayList<Double> Q3 = new ArrayList<Double>();
        ArrayList<Double> Q4 = new ArrayList<Double>();

        //reads through the lifeExpectancy file and stores the values for each quartile into their arraylists
        //averages the values of each of the arraylists and stores the averages into the quartiles array


        //everything that i want to be printed out 
        System.out.println("The First Quartile Average Life Expectancy is " + quartiles[0]);
        System.out.println("The Second Quartile Average Life Expectancy is " + quartiles[1]);
        System.out.println("The Third Quartile Average Life Expectancy is " + quartiles[2]);
        System.out.println("The Fourth Quartile Average Life Expectancy is " + quartiles[3]);
        System.out.println("The winning average life expectancy is " + quartiles.max() " which is Quartile " + (indexOf(quartiles.max())+1) + ".");
    }

    public static void returnWinningParty (String pathnameBlue, String pathnameRed) throws FileNotFoundException{
        File blueStatesFile = new File(pathnameBlue);
        File redStatesFile = new File(pathnameRed);
        
        ArrayList<Double> blueStatesExpectancy = new ArrayList<Double>();
        ArrayList<Double> redStatesExpectancy = new ArrayList<Double>();

        double redAverage;
        double blueAverage;

        //iterate through the blueStatesFile and grab the name of the state and then find the state in the lifeExpectancy file and add that double to blueStatesExpectancy arraylist
        //iterate through the redStatesFile and grab the name of the state and then find the state in the lifeExpectancy file and add that double to redStatesExpectancy arraylist

        //average the redStatesExpectancy by adding the values and dividing by the number of states
        //average the blueStatesExpectancy by adding the values and dividing by the number of states

        System.out.println("The average life expectancy for the republican states is " + redAverage);
        System.out.println("The average life expectancy for the democratic states is " + blueAverage);

    }
}