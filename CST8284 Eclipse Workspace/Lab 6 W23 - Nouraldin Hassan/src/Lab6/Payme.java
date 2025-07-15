package Lab6;

/** This interface serves to hold the payment amount and deduction methods for further declaration by the abstract class.
 * @author Nouraldin Hassan
 */
public interface Payme {
	/** gets the payment due of the programmer
	 * @return the payment amount in $ CAD
	 */
	double getPaymentAmount();
	/** gets the deductions or income tax of the programmer
	 * @return the deduction amount in $ CAD
	 */
	double getDeductions();
}
