/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        float taxDecimalWI = (float) 0.055;
        String orderAmountString = myApp.readInput("What is the order amount? ");
        String state = myApp.readInput("What is the state? ");
        float orderAmount = myApp.convertToFloat(orderAmountString);
        float tax = myApp.calcTax(state, orderAmount, taxDecimalWI);
        float total = myApp.calcTotal(orderAmount, tax);
        String outputString = myApp.generateOutputString(state, orderAmount, tax, total);
        myApp.printOutputString(outputString);
    }

    private void printOutputString(String outputString) { System.out.println(outputString);}
    private String generateOutputString(String state, float orderAmount, float tax, float total) {
        if (state.equals("WI")) {
            return "The subtotal is $" + orderAmount + ".\nThe tax is $" + tax + ".\nThe total is $" + total + ".";
        }
        return "The total is $" + orderAmount;
    }
    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }

    private float convertToFloat(String inputString) {
        float input = Float.parseFloat(inputString);
        return input;
    }

    private float calcTax(String state, float orderAmount, float taxWI) {
        if (state.equals("WI")) {
            float tax = orderAmount * taxWI;
            return tax;
        }
        return 0;
    }

    private float calcTotal(float orderAmount, float tax) {
        float total = orderAmount + tax;
        return total;
    }
}
