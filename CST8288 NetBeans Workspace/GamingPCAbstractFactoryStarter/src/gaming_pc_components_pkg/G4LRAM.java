/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_components_pkg;

/**
 * This class is for the RAM building procedure of the G4L PC.
 * @see CPU
 * @author Nouraldin Hassan
 */
public class G4LRAM implements RAM {
    private int size;
    private String type;
    
    // Constructor
    /**
     * Used to hold the size and type of the RAM for use with building the gaming PC.
     * @param size the size of the RAM.
     * @param type the type of the RAM.
     * @author Nouraldin Hassan
     */
    public G4LRAM(int size, String type) {
        this.size = size;
        this.type = type;
    }

    /**
     * Formats the string to the specified values provided in {@link G4LRAM}.
     * @author Nouraldin Hassan
     */
    @Override
    public String toString() {
        return String.format("%dGB %s", size, type);
    }
}
