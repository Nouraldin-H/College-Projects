/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_components_pkg;

/**
 * This class is for the CPU building procedure of the G4L PC.
 * @see CPU
 * @author Nouraldin Hassan
 */
public class G4LCPU implements CPU {
    private String model;
    private double clockSpeed;

    // Constructor
    /**
     * Used to hold the model and clock speed of the CPU for use with building the gaming PC.
     * @param model the model of the CPU.
     * @param clockSpeed the clock speed of the CPU.
     * @author Nouraldin Hassan
     */
    public G4LCPU(String model, double clockSpeed) {
        this.model = model;
        this.clockSpeed = clockSpeed;
    }
    
    /**
     * Formats the string to the specified values provided in {@link G4LCPU}.
     * @author Nouraldin Hassan
     */
    @Override
    public String toString() {
        return String.format("%.1f GHz %s", clockSpeed, model);
    }
}
