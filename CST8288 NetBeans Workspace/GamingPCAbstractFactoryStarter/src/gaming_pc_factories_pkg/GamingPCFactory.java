/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_factories_pkg;

import gaming_pc_components_pkg.CPU;
import gaming_pc_components_pkg.GraphicsAdapter;
import gaming_pc_components_pkg.RAM;
import gaming_pc_components_pkg.Storage;

/**
 * This interface is used for the creation of the Gaming PC.
 * @author Nouraldin Hassan
 */

// Here is where the required components are defined
public interface GamingPCFactory {
    /**
     * Creates the CPU from what type of CPU is returned.
     * @return a new CPU to use for the Gaming PC.
     */
    public CPU createCPU();
    /**
     * Creates the RAM from what type of RAM is returned.
     * @return a new RAM to use for the Gaming PC.
     */
    public RAM createRAM();
    /**
     * Creates the Storage from what type of Storage is returned.
     * @return a new Storage to use for the Gaming PC.
     */
    public Storage createStorage();
    /**
     * Creates the Graphics Adapter from what type of Graphics Adapter is returned.
     * @return a new Graphics Adapter to use for the Gaming PC.
     */
    public GraphicsAdapter createGraphicsAdapter();
    
}
