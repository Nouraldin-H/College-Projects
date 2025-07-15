package polymorphism_and_inheritance;

//Parent class Payment
public abstract class Payment {
 public abstract double getPaymentAmount(); // Abstract method to calculate payment amount
}

//Child class Invoice that inherits from Payment
 class Invoice extends Payment {
 private String partNumber; 
 private String partDescription;
 private int quantity;
 private double pricePerItem;

 public Invoice(String part, String description, int count, double price) {
	 partNumber = part;
     partDescription = description;
     quantity = count;
     pricePerItem = price;
}

// ... Constructor and other methods ...

 // Override the getPaymentAmount() method to calculate payment amount based on quantity and price per item
 @Override
 public double getPaymentAmount() {
     return getQuantity() * getPricePerItem(); // calculate total cost
 }

public String getPartNumber() {
	return partNumber;
}

public void setPartNumber(String partNumber) {
	this.partNumber = partNumber;
}

public String getPartDescription() {
	return partDescription;
}

public void setPartDescription(String partDescription) {
	this.partDescription = partDescription;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public double getPricePerItem() {
	return pricePerItem;
}

public void setPricePerItem(double pricePerItem) {
	this.pricePerItem = pricePerItem;
}

@Override
public String toString() {
    return String.format("%s: \n%s: %s (%s) \n%s: %d \n%s: $%,.2f", 
            "invoice", "part number", getPartNumber(), getPartDescription(), 
            "quantity", getQuantity(), "price per item", getPricePerItem());
}
}

class Main {
 public static void main(String[] args) {
     // Create an instance of Invoice
     Invoice invoice = new Invoice("A001", "Product A", 2, 10.00);

     // Display the invoice information and payment amount
     System.out.println("First invoice:");
     System.out.println(invoice);
     System.out.printf("Payment amount: $%.2f%n\n", invoice.getPaymentAmount());

     // Change the values of the invoice instance using setter methods
     invoice.setPartNumber("A002");
     invoice.setPartDescription("Product B");
     invoice.setQuantity(3);
     invoice.setPricePerItem(5.50);

     // Display the updated invoice information and payment amount
     System.out.println("Second invoice:");
     System.out.println(invoice);
     System.out.printf("Payment amount: $%.2f%n", invoice.getPaymentAmount());
 }
}
