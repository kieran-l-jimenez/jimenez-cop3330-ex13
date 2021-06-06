import java.util.Scanner;
import java.lang.Math;


/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Kieran Jimenez
 */
/*
 *A = P(1 + r/n)^(n*t), P is principal amount, r is interest rate annually, t time years, n times compounded per year
 *           "Determining Compound Interest" output
 *What is the principal amount? 1500
 *What is the rate? 4.3
 *What is the number of years? 6
 *What is the number of times the interest is compounded per year? 4
 *$1500 invested at 4.3% for 6 years compounded 4 times per year is $1938.84.
 */
public class App
{
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App myApp = new App();

        System.out.print("What is the principal amount? ");
        double principal = in.nextDouble();
        System.out.print("What is the rate? ");
        double rate = in.nextDouble();
        System.out.print("What is the number of years? ");
        int time = in.nextInt();
        System.out.print("What is the number of times the interest is compounded per year? ");
        int annualCompound = in.nextInt();

        double total = myApp.calculateCompoundInterest(principal, rate, time, annualCompound);

        System.out.printf("$%.2f invested at %.3f%% for %d years compounded %d times per year is $%.2f\n", principal, rate, time, annualCompound, total);
    }

    private double calculateCompoundInterest(double P, double r, int t, int n)
    {
        double result = P * Math.pow(1 + ((r/100) / n), n * t);//A = P(1 + r/n)^(n*t)
        double temp = result;

        temp *= 100;

        if(temp%1 != 0 && temp%1 >= 0.5)
        {
            result -= (temp%1)/100;
            result += 0.01;
        }
        else if(temp%1 != 0)
            result -= (temp%1)/100;

        return result;

    }
}