package Lab6;

/** This class tests and processes the programmers through the Payme Interface.
 * @author Nouraldin Hassan
 */
public class PaymeInterfaceTest  {

/** This main method prints the list of programmers polymorphically
 * @param args the string arguments
 */
public static void main(String[] args) {
	 
Payme paymeObjects[] = new Payme[6];

	Invoice invoice = new Invoice("22776", "brakes", 3, 300);
	 SalariedProgrammer salariedProgrammer = new SalariedProgrammer("Chioma", "Nouraldin", "345-67-0001", 9, 1994, 320);
	 HourlyProgrammer hourlyProgrammer = new HourlyProgrammer("Amara", "Nouraldin", "234-56-7770", 9, 1994, 18.95, 40);
	 CommissionProgrammer comissionProgrammer = new CommissionProgrammer("Peter", "Nouraldin", "123-45-6999", 9, 1994, 16500, 0.44);
	 BasePlusCommissionProgrammer basePlusCommissionProgrammer = new BasePlusCommissionProgrammer("Esther", "Nouraldin", "102-34-5888", 9, 1994, 1200, 0.04, 720);
	 paymeObjects[0] = invoice; paymeObjects[1] = invoice; paymeObjects[2] = salariedProgrammer; paymeObjects[3] = hourlyProgrammer; paymeObjects[4] = comissionProgrammer; paymeObjects[5] = basePlusCommissionProgrammer;

 System.out.println("Payment for Invoices and Programmers are processed polymorphically:\n"); 
 
for (Payme currentPayme : paymeObjects ) {
    // output currentPayme and its appropriate payment amount
    System.out.printf("%s \n", currentPayme.toString()); 
       
    if (currentPayme instanceof BasePlusCommissionProgrammer) {
       // downcast Payme reference to BasePlusCommissioProgrammer reference
       BasePlusCommissionProgrammer programmer = (BasePlusCommissionProgrammer) currentPayme;

       double oldBaseSalary = programmer.getBaseSalary();
       programmer.setBaseSalary(1.10 * oldBaseSalary);
       System.out.printf("new base salary with 10%% increase is: $%,.2f\n", programmer.getBaseSalary());
    } 
 
    if (currentPayme == paymeObjects[1]) {
    System.out.println("payment due: " + invoice.getPaymentAmount() + "\n");
    }
	invoice.setPartNumber("33442"); invoice.setPartDescription("gear"); invoice.setQuantity(5); invoice.setPricePerItem(90.99);
	if (currentPayme == paymeObjects[5]) {
		System.out.printf("Payment Due: %.2f\n", basePlusCommissionProgrammer.getPaymentAmount());
	}
 }
}
}


