package sandbox;

import java.util.Scanner;

public class Factorial 
{
    public static void main(String[] args) 
    {
        int x = 1;
        int factValue = 1;
        Scanner userInput = new Scanner(System.in);
        restart: while(true){
        System.out.println("Please enter a nonzero, nonnegative value to be factorialized.");
        int factInput = userInput.nextInt();

        while(factInput<=0)
        {
            System.out.println("Enter a nonzero, nonnegative value to be factorialized.");
            factInput = userInput.nextInt();
        }

        if(x<1)//This is another way of doing what the above while loop does, I just wanted to have some fun.
        {
            System.out.println("The number you entered is not valid. Please try again.");
            continue restart;
        }
        while(x<=factInput)
        {
            factValue*=x;
            x++;
        }
        System.out.println(factInput+"! = "+factValue);
        userInput.close();
        break restart;
        }
    }
}