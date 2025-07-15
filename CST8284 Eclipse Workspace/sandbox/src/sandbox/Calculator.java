package sandbox;

import java.util.Scanner;

/**
 * @author Nouraldin Hassan
 *
 */
public class Calculator {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        double result;
        switch(operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.printf("Error! Operator is not correct");
                return;
        }

        System.out.printf("%.1f %c %.1f = %.1f", num1, operator, num2, result);
    }
}
