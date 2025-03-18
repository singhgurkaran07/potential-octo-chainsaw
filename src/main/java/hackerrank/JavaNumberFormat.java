package hackerrank;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
* Given a double-precision number, , denoting an amount of money, use the NumberFormat class'
* getCurrencyInstance method to convert  into the US, Indian, Chinese, and French currency formats.
* Then print the formatted values as follows:

US: formattedPayment
India: formattedPayment
China: formattedPayment
France: formattedPayment
where  is  formatted according to the appropriate Locale's currency.

Note: India does not have a built-in Locale, so you must construct one where the language is en (i.e., English).

Input Format

A single double-precision number denoting .


* */

public class JavaNumberFormat {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        // Get the currency instance


        String us = NumberFormat
                .getCurrencyInstance(Locale.US).format(payment);
        String india = NumberFormat
                .getCurrencyInstance(Locale.of("en","IN")).format(payment);
        String china = NumberFormat
                .getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat
                .getCurrencyInstance(Locale.FRANCE).format(payment);
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}