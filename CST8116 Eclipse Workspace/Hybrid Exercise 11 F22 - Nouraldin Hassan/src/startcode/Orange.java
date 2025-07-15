package startcode;
/*
 * Author: Junior Programmer (Stanley Pieda)
 * Date: Nov 28, 2020
 * Description: Does stuffs
 */

import java.util.Scanner;

public class Orange{
    public static String variety;
    public static double weight;
    private static Scanner keyboard = new Scanner(System.in);
    
    public Orange(){
        System.out.println("Enter food type");
        variety = keyboard.nextLine();  
    }

    public Orange(String VarETY, double Weight){
        this.variety = VarETY;
        weight = Weight;
    }

    public static String getVariety(){
        System.out.println("Enter orange type");
        variety = keyboard.nextLine(); 
        System.out.println("Enter weight");
        weight = keyboard.nextDouble();
        return variety;
    }

    public static void setVariety(String variety){
    	Orange.variety = keyboard.nextLine();
        System.out.println("Please enter an Orange");
    }

    public static String getweight(){
        System.out.println("Enter orange type");
        variety = keyboard.nextLine(); 
        System.out.println("Enter weight");
        weight = keyboard.nextDouble();
        return variety;
    }
    public static void setweight(double weight){
    	Orange.weight = keyboard.nextDouble();
        System.out.println("Please enter a weight");
    }
    
    public static String createReport(){
        System.out.println("Please enter Orange Report");
        String report = keyboard.nextLine() + variety + 42; // I like 42
        System.out.println(report);
        variety = report;
        System.out.println();
        return report + variety + weight;
    }
}
