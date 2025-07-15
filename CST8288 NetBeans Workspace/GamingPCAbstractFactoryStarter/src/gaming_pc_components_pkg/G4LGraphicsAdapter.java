/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_components_pkg;

/**
 * This class is for the GraphicsAdapter building procedure of the G4L PC.
 * @see CPU
 * @author Nouraldin Hassan
 */
public class G4LGraphicsAdapter implements GraphicsAdapter {
    private String model;
    private int vramSize;

    // Constructor
    /**
     * Used to hold the model and virtual RAM Size of the Graphics Adapter for use with building the gaming PC.
     * @param model the model of the Graphics Adapter.
     * @param vramSize the virtual RAM Size of the Graphics Adapter.
     * @author Nouraldin Hassan
     */
    public G4LGraphicsAdapter(String model, int vramSize) {
        this.model = model;
        this.vramSize = vramSize;
    }
     /**
     * Formats the string to the specified values provided in {@link G4LGraphicsAdapter}.
     * @author Nouraldin Hassan
     */
    @Override
    public String toString() {
        return String.format("%s %dGB DDR6 graphics", model, vramSize);
    }
}
