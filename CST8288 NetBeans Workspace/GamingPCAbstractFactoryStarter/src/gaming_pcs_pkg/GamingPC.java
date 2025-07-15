/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pcs_pkg;

import gaming_pc_components_pkg.CPU;
import gaming_pc_components_pkg.GraphicsAdapter;
import gaming_pc_components_pkg.RAM;
import gaming_pc_components_pkg.Storage;

/**
 *
 * @author yapt
 */
public abstract class GamingPC {
    
    private String name;
    
    // Newly defined objects that represent the CPU, RAM, storage, & graphics adapter.
    // These can be changed easily by assigning new parts 
    // in G4LGamingPCFactory or WRGGamingPCFactory
    protected CPU cpu;
    protected RAM ram;
    protected Storage storage;
    protected GraphicsAdapter graphicsAdapter;
    
    /**
     * Gets the name of the gaming PC.
     * @author Nouraldin Hassan
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of the gaming PC.
     * @param name the name of the gaming PC.
     * @author Nouraldin Hassan
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * This method is used for equipping the gaming PC components for the building process.
     * @author Nouraldin Hassan
     */
    public abstract void equipGamingPC();
    
    /**
     * Because the toString() method is defined in CPU, when it is printed the string defined in toString() appears on the screen
     * @author Nouraldin Hassan
     */
    public void displayCPUInfo() {
        System.out.println(getName() + " CPU:  " + cpu);
    }
    
    /**
     * Because the toString() method is defined in RAM, when it is printed the string defined in toString() appears on the screen
     * @author Nouraldin Hassan
     */
    public void displayRAMInfo() {
        System.out.println(getName() + " RAM:  " + ram);
    }
    
    /**
     * Because the toString() method is defined in Storage, when it is printed the string defined in toString() appears on the screen
     * @author Nouraldin Hassan
     */
    public void displayStorageInfo() {
        System.out.println(getName() + " Storage:  " + storage);
    }

    /**
     * Because the toString() method is defined in GraphicsAdapter, when it is printed the string defined in toString() appears on the screen
     * @author Nouraldin Hassan
     */
    public void displayGraphicsAdapterInfo() {
        System.out.println(getName() + " Graphics Adapter:  " + graphicsAdapter);
    }
    
    /**
     * If any gaming PC object is printed to the screen, the following information shows up (See {@link GamingPC} and scroll to this method to see information)
     * @author Nouraldin Hassan
     */
    public String toString() {
        String gamingPCInfo = "The " + getName() + " has\n\t" + cpu + ",\n\t" + 
                ram + ",\n\t" + storage + " , and\n\t" + graphicsAdapter;
        return gamingPCInfo;
    }
    
}
