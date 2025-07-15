/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_factories_pkg;

import gaming_pc_components_pkg.CPU;
import gaming_pc_components_pkg.G4LCPU;
import gaming_pc_components_pkg.G4LGraphicsAdapter;
import gaming_pc_components_pkg.G4LRAM;
import gaming_pc_components_pkg.G4LStorage;
import gaming_pc_components_pkg.GraphicsAdapter;
import gaming_pc_components_pkg.RAM;
import gaming_pc_components_pkg.Storage;

/**
 * This factory implements the GamingPCFactory interface. <br>
 * This is where we define all of the components the G4L gaming PC will use by implementing the methods from the interface. <br>
 * The returned object by each method specifies a specific component that will be used for this gaming PC.
 * @author Nouraldin Hassan
 */

public class G4LGamingPCFactory implements GamingPCFactory {

    /**
     * Defines the CPU object to associate with the G4L gaming PC.
     * @return a new CPU to use for the Gaming PC.
     */
    @Override
    public CPU createCPU() {
        return new G4LCPU("G4L Core i5-11400F", 2.6);
    }
    
    /**
     * Defines the RAM object to associate with the G4L gaming PC.
     * @return a new CPU to use for the Gaming PC.
     */
    @Override
    public RAM createRAM() {
         return new G4LRAM(8, "DDR4"); // Example: 8GB DDR4 RAM
    }

    /**
     * Defines the Storage object to associate with the G4L gaming PC.
     * @return a new CPU to use for the Gaming PC.
     */
    @Override
    public Storage createStorage() {
        return new G4LStorage(512, "PCIe Solid State Drive"); // Example: 512GB PCIe SSD
    }

    /**
     * Defines the Graphics Adapter object to associate with the G4L gaming PC.
     * @return a new CPU to use for the Gaming PC.
     */
    @Override
    public GraphicsAdapter createGraphicsAdapter() {
        return new G4LGraphicsAdapter("G4L GTX1650S", 4);
    }
    
}
