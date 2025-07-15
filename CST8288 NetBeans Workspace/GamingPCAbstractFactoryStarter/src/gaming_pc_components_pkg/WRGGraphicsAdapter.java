/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_components_pkg;

/**
 * This class is for the GraphicsAdapter building procedure of the WRC PC.
 * @see CPU
 * @author Nouraldin Hassan
 */
public class WRGGraphicsAdapter implements GraphicsAdapter {
    private String model;
    private int vramSize;
    private int bits;

    // Constructor
    /**
     * Used to hold the model, virtual RAM Size, and bits of the Graphics Adapter for use with building the gaming PC.
     * @param model the model of the Graphics Adapter.
     * @param vramSize the virtual RAM Size of the Graphics Adapter.
     * @param bits the amount of bits of the Graphics Adapter.
     * @author Nouraldin Hassan
     */
    public WRGGraphicsAdapter(String model, int vramSize, int bits) {
        this.model = model;
        this.vramSize = vramSize;
        this.bits = bits;
    }

    /**
     * Formats the string to the specified values provided in {@link G4LGraphicsAdapter}.
     * @author Nouraldin Hassan
     */
    @Override
    public String toString() {
        return String.format("%s %dGB GDDR6 %d-bit", model, vramSize, bits);
    }
}
