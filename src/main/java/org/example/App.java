package org.example;

import java.util.Scanner;

/*
 *   UCF COP 3330 Fall 2021 Assignment 18 Solution
 *   Copyright 2021 Donovan Reynolds
 */
public class App 
{
    public static void main( String[] args )
    {
        String whatToConvert = inputOutput("Press C to convert from Fahrenheit to Celsius.\nPress F to convert from Celsius to Fahrenheit");
        char temperature = whatToConvert.toUpperCase().charAt(0);

        System.out.println("Your choice: " + temperature);
        String text = "Please enter the temperature in ";
        String temperatureText = "";
        boolean check;

        if (temperature == 'C')
        {
            temperatureText = "Fahrenheit";
            check = false;
        }
        else
        {
            temperatureText = "Celsius";
            check = true;
        }
        String tempToConvertText = inputOutput(text + temperatureText);
        int tempToConvert = stringToInt(tempToConvertText,text+temperatureText);
        int finalTemp = formula(tempToConvert,check);

        System.out.println(check ?"The temperature in Fahrenheit is " + finalTemp :"The temperature in Celsius is " + finalTemp);
    }

    public static String inputOutput(String textToSay)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(textToSay);
        return input.nextLine();
    }

    public static int stringToInt(String text, String error)
    {
        int temp = 0;
        boolean check = false;
        while(!check)
        {
            try
            {
                temp = Integer.parseInt(text);
                check = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("You entered a value that is not a number. Please try again.");
                text = inputOutput(error);

            }
        }
        return temp;
    }

    public static double stringToDouble (String text, String error)
    {
        double temp = 0.0;
        boolean check = false;
        while(!check)
        {
            try
            {
                temp = Double.parseDouble(text);
                check = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("You entered a value that is not a number. Please try again.");
                text = inputOutput(error);
            }
        }
        return temp;
    }

    public static int formula(int temp, boolean cToF)
    {
        if (cToF)
            return (temp*9/5)+32;
        else
            return (temp - 32) * 5/9;

    }

}
