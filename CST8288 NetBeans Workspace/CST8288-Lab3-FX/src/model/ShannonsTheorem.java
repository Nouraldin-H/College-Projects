package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * class that implements "model" for an MVC application that calculates Shannon's Theorem
 * @author Nouraldin Hassan
 */
public class ShannonsTheorem {
    private double bandWidth;
    private double signalPower;
    private double noisePower;
    private String testStr;
    
    private final DoubleProperty bandWidthProp =
			 new SimpleDoubleProperty(this, "bandWidth", 0);
    private final DoubleProperty signalPowerProp =
			 new SimpleDoubleProperty(this, "signalPower", 0);
    private final DoubleProperty noisePowerProp =
			 new SimpleDoubleProperty(this, "noisePower", 0);
    private final StringProperty testStrProp =
			 new SimpleStringProperty(this, "testStr", null);

    /**
     * multi-argument constructor
     * @param bandWidth the bandwidth in hertz
     * @param signalPower signal power in watts
     * @param noisePower noise power in watts
     */
    public ShannonsTheorem(double bandWidth, double signalPower, double noisePower) {
        this.bandWidth = bandWidth;
        this.signalPower = signalPower;
        this.noisePower = noisePower;
    }
    /**
     * no-arg constructor sets fields to zero
     */
    public ShannonsTheorem() {
	this(0.0, 0.0, 0.0);
    }
    /**
     * @return the bandWidth
     */
    public double getBandWidth() {
    	return bandWidth;
    }
    
    // PROPERTY
    public final double getBandWidthProp() {
    	return bandWidthProp.get();
    }
    public final DoubleProperty bandWidthProperty() {
		return bandWidthProp;
    }

    /**
     * @param bandWidth the bandWidth to set
     */
    public void setBandWidth(double bandWidth) {
        this.bandWidth = bandWidth;
    }
    
    public final void setBandWidthProperty(double bandWidth) {
        bandWidthProperty().set(bandWidth);
    }
//    public final DoubleProperty bandWidthProperty() {
//		return bandWidth;
//  }

    /**
     * @return the signal power
     */
    public double getSignalPower() {
    	return signalPower;
    }
    
    // PROPERTY
    public final double getSignalPowerProp() {
    	return signalPowerProp.get();
    }
    public final DoubleProperty signalPowerProperty() {
		return signalPowerProp;
    }
    
    /**
     * @param signalPower the signal power to set
     */
    public void setSignalPower(double signalPower) {
	this.signalPower = signalPower;
    }
    
    public final void setSignalPowerProperty(double signalPower) {
        signalPowerProperty().set(signalPower);
    }
    
    /**
     * @return the noise power
     */
    public double getNoisePower() {
	return noisePower;
    }
    
    // PROPERTY
    public final double getNoisePowerProp() {
    	return noisePowerProp.get();
    }
    public final DoubleProperty noisePowerProperty() {
		return noisePowerProp;
    }
    
    /**
     * @param noisePower the noise power to set
     */
    public void setNoisePower(double noisePower) {
	this.noisePower = noisePower;
    }
    
    public final void setNoisePowerProperty(double noisePower) {
        noisePowerProperty().set(noisePower);
    }
	
    private double log2(double x) {
	return Math.log(x)/Math.log(2);
    }
	
    /**
     * @param bw the bandwidth
     * @param sp the signal power
     * @param np the noise power
     * @return maximum data rate
     */
    public double maxDataRate(double bw, double sp, double np) {
        return bw * log2(1 + sp / np);
    }
	
    /**
     * @return maximum data rate
     */
    public double maxDataRate() {
        return maxDataRate(bandWidth, signalPower, noisePower);
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    /**
     * @return string for output
     */
    @Override
    public String toString() {
	return "ShannonsTheory [bandWidth=" + bandWidth + ", signalPower=" + signalPower + ", noisePower=" + noisePower + "]";
    }
	
}
