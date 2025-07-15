/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_components_pkg;

/**
 * This class is for the CPU building procedure of the WRG PC.
 * @see CPU
 * @author Nouraldin Hassan
 */
public class WRGCPU implements CPU {
    private String model;
    private double clockSpeed;
    private double clockSpeedMax;
    private float cache;

    // Constructor
    /**
     * Used to hold the model, clock speed, maximum clock speed, and cache of the CPU for use with building the gaming PC.
     * @param model the model of the CPU.
     * @param clockSpeed the clock speed of the CPU.
     * @param clockSpeedMax the maximum clock speed of the CPU.
     * @param cache the cache of the CPU.
     * @author Nouraldin Hassan
     */
    public WRGCPU(String model, double clockSpeed, double clockSpeedMax, float cache) {
        this.model = model;
        this.clockSpeed = clockSpeed;
        this.clockSpeedMax = clockSpeedMax;
        this.cache = cache;
    }
    
    /**
     * Formats the string to the specified values provided in {@link G4LCPU}.
     * @author Nouraldin Hassan
     */
    @Override
    public String toString() {
        return String.format("%s %.1f-%.1f GHz %.0fMB Cache", model, clockSpeed, clockSpeedMax, cache);
    }
}
