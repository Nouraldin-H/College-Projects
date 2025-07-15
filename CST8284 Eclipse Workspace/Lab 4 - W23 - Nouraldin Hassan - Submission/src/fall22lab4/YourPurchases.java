package fall22lab4;
/*
 * Assessment: Lab Exercise 4
 * Student Name: Nouraldin Hassan
 * Lab Professor Name: Dave Houtman, Sandra Iroakazi
 * Lab Section Number: 300/301
 * Due Date: Feb 24, 2023
 * Description: 
 */
/**
 * @author Nouraldin Hassan
 */

/**
   You were at Walmart near your home to make some purchases last weekend. 
   You had so much coins including nickels, dimes, etc and wanted to just use them all for your purchases. 
   A cash register sums up the sales and then computes the change due to you.
*/
public class YourPurchases
{
/**
 * the value is initialized permanently to 0.25, or 25 cents in the context of finance
 */
public static final double QUARTER_VALUE = 0.25;
/**
 * the value is initialized permanently to 0.1, or 10 cents in the context of finance
 */
   public static final double DIME_VALUE = 0.1;
   /**
    * the value is initialized permanently to 0.05, or 5 cents in the context of finance
    */
   public static final double NICKEL_VALUE = 0.05;
   /**
    * the value is initialized permanently to 0.01, or 1 cent in the context of finance
    */
   public static final double PENNY_VALUE = 0.01;

   private double purchase;
   private double payment;

   /**
      Constructs a cash register - your purchases - with no money in it.
   */
   public YourPurchases()
   {
      purchase = 0;
      payment = 0;
   }

   
   /**
   Returns the amount of purchases.
   @return amount of purchases
	*/
	public double getPurchase()
	{
	   return purchase;
	  
	}

	
	/**
	Returns the amount of payment.
	@return amount of payments
	*/
	public double getPayment()
	{
	return payment;
	
	}

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount) 
   {
      purchase = purchase + amount;
     
   }
   
   /**
      Enters the payment received from the customer.
      @param dollars the number of dollars in the payment
      @param quarters the number of quarters in the payment
      @param dimes the number of dimes in the payment
      @param nickels the number of nickels in the payment
      @param pennies the number of pennies in the payment
   */
   public void receivePayment(int dollars, int quarters, 
         int dimes, int nickels, int pennies)
   {
      payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE
            + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;
   }
   
   /**
      Computes and returns the change due. This is done with some error in the calculations
      @return the change due to the customer
   */
   public double CalculateChange()
   {
      double change = payment + purchase; // was changed from + to - for JUnit testing purposes.
      
      return change;
   }

/**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {
      double change = payment - purchase;
      purchase = 0;
      payment = 0;
      return change;
   }
}

