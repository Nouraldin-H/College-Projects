/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_components_pkg;

/**
 * This class is for the RAM building procedure of the WRG PC.
 * @see CPU
 * @author Nouraldin Hassan
 */
public class WRGRAM implements RAM {
    private int size;
    private String type;
    private String extraType;
    private int clockSize;
    
    // Constructor
    /**
     * Used to hold the size and type of the RAM for use with building the gaming PC.
     * @param size the size of the RAM.
     * @param type the type of the RAM.
     * @param extraType the extra type of the RAM.
     * @param clockSize the clock size of the RAM.
     * @author Nouraldin Hassan
     */
    public WRGRAM(int size, String type, String extraType, int clockSize) {
        this.size = size;
        this.type = type;
        this.extraType = extraType;
        this.clockSize = clockSize;
    }

    /**
     * Formats the string to the specified values provided in {@link G4LRAM}.
     * @author Nouraldin Hassan
     */
    @Override
    public String toString() {
        return String.format("%dGB %s RAM %s %d MHz", size, type, extraType, clockSize);
    }
}
