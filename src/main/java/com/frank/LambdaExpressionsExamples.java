package com.frank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExpressionsExamples {

    static List<String> names     = new ArrayList<>();

    static List<Integer> numList  = new ArrayList<>();

    public static void main(String[] args) {
        /***************************************************************************************
         * Perform Initial/Setup processing for the application
         **************************************************************************************/
        setup();      // Perform start of main processing

        System.out.println("\n-------- Display elements in a List ---------");

//list has its own version of the for each method works just like hte STREAM forEach
        // the List forEach() uses Iterators to traverse the List
                //1. iterators to traverse the list you may safetly add or remove elements in the lambda expression
        //        2. the ordee in which elements is predictable - entry sequence
        //        3. SLIGHTLY FASTER

        names.forEach( (aName) -> {System.out.println("Name: " + aName);});  // List version of forEach()

        //if you have a parameter then you dont need the parenthesis in your lambda expression
// this is the stream version of the for each loop, List for each is better
        names.stream().forEach( (aName) -> {System.out.println("Name: " + aName);});  // List version of forEach()

        /***************************************************************************************
         * stream().map() Stream Interface function
         **************************************************************************************/
        System.out.println("\n-------- Showing first initials   ---------");

        List<String> firstInitials = names.stream().map((aName) -> {return (aName.substring(0,1));})
                .collect(Collectors.toList());

        firstInitials.forEach( (aName) -> {System.out.println("Name: " + aName);});

        /***************************************************************************************
         * stream().filter() Stream Interface function
         **************************************************************************************/
        System.out.println("\n-------- Removing Frank from List ---------");

        List<String> noFrank = names.stream().filter(aName -> {return (!aName.equals("Frank"));})
                                             .collect(Collectors.toList());

        noFrank.forEach( (aName) -> {System.out.println("Name: " + aName);});

        /***************************************************************************************
         * stream().filter() Stream Interface function
         **************************************************************************************/
        System.out.println("\n-------- Find values in ArrayList evenly divisble by 3 ---------");

        System.out.println("Values in numList ArrayList: ");
        numList.forEach( (aNum) -> {System.out.println("Value in List: " + aNum);});

        List<Integer> divBy3 = numList.stream().filter((aNum) -> {return (aNum % 3 == 0 ? true : false); }).collect(Collectors.toList());

        divBy3.forEach( (aNum) -> {System.out.println("\tnumber divisible by 3: " + aNum);});

        /***************************************************************************************
         * stream().reduce() Stream Interface function
         * since stream interface methods may be only be applied to a collections class objects
         * java created a set of equivalent methods for use with a single array
         **************************************************************************************/
        System.out.println("\n-------- Using stream().reduce to sum an ArrayList   ---------");

        System.out.println("Values in numList ArrayList: ");
        numList.forEach( (aNum) -> {System.out.println("Value in List: " + aNum);});
        
        int listTotal = numList.stream().reduce(0, (sum, anElem) -> sum + anElem);
        System.out.println("Sum of elements in ArrayList is: " + listTotal);

        /***************************************************************************************
         * Arrays.reduce() Arrays method
         **************************************************************************************/
        System.out.println("\n-------- Using Arrays.reduce() to sum an array   ---------");

        int numArray[]  = {10, 20, 30,40};
        for(int i=0; i < numArray.length; i++) {
            System.out.println("Array elem " + i + ": " + numArray[i]);
        }

        // The Arrays class provided a stream().reduce() method for a simple array
        int total = Arrays.stream(numArray).reduce(0, (sum, anElem) -> sum + anElem);
        System.out.println("Sum of elements in array is: " + total);


        takeDown();   // Perform end of main() processings
    } // End of main()

    public static void setup() {

        System.out.println("-".repeat(50) + "\nWelcome to Lambda Expressions Example\n" + "-".repeat(50));

        names.add("Frank");
        names.add("Kirk");
        names.add("Spock");
        names.add("Worf");
        names.add("Data");

        numList.add(100);
        numList.add(200);
        numList.add(300);
        numList.add(400);
        numList.add(500);
        numList.add(600);
    }

    public static void takeDown() {
        System.out.println("-".repeat(50) + "\nThanks for visiting Lambda Expressions Example\n" + "-".repeat(50));
    }

} // End if LambdaExpressionsExample class
