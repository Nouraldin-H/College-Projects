package sandbox;

import java.util.Random;

public class PiMonteCarlo {
    public static void main(String[] args) {
        int numPoints = 1000000;
        int pointsInside = 0;
        Random rand = new Random();

        for (int i = 0; i < numPoints; i++) {
            double x = rand.nextDouble() * 2 - 1;
            double y = rand.nextDouble() * 2 - 1;
            if (x * x + y * y <= 1) {
                pointsInside++;
            }
        }

        double piEstimate = 4.0 * pointsInside / numPoints;
        System.out.println(piEstimate);
    }
}
