package sandbox;

import java.math.BigInteger;

public class PiGregoryLeibniz {
    public static void main(String[] args) {
        BigInteger numTerms = new BigInteger("100000000000000000000000");
        double piEstimate = 0;
        int sign = 1;

        for (int i = 0; i < numTerms.intValue(); i++) {
            double term = sign / (2.0 * i + 1.0);
            piEstimate += term;
            sign = -sign;
        }

        piEstimate *= 4.0;
        System.out.println(piEstimate);
    }
}
