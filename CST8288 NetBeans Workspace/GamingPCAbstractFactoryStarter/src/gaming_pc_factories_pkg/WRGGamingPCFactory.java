/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_factories_pkg;

import gaming_pc_components_pkg.CPU;
import gaming_pc_components_pkg.GraphicsAdapter;
import gaming_pc_components_pkg.RAM;
import gaming_pc_components_pkg.Storage;
import gaming_pc_components_pkg.WRGCPU;
import gaming_pc_components_pkg.WRGGraphicsAdapter;
import gaming_pc_components_pkg.WRGRAM;
import gaming_pc_components_pkg.WRGStorage;

/**
 * This factory implements the GamingPCFactory interface. <br>
 * This is where we define all of the components the WRG gaming PC will use by implementing the methods from the interface. <br>
 * The returned object by each method specifies a specific component that will be used for this gaming PC.
 * @author Nouraldin Hassan
 */

public class WRGGamingPCFactory implements GamingPCFactory {

    /**
     * Defines the CPU object to associate with the WRG gaming PC.
     * @return a new CPU to use for the Gaming PC.
     */
    @Override
    public CPU createCPU() {
        return new WRGCPU("WRG Core i5-12400F 6P+0EC/12T", 2.5, 4.4, 18);
    }
    
    /**
     * Defines the RAM object to associate with the WRG gaming PC.
     * @return a new CPU to use for the Gaming PC.
     */
    @Override
    public RAM createRAM() {
        return new WRGRAM(16, "DDR4", "(2 x 8GB)", 3200);
    }

    /**
     * Defines the Storage object to associate with the WRG gaming PC.
     * @return a new Storage to use for the Gaming PC.
     */
    @Override
    public Storage createStorage() {
        return new WRGStorage(500, "M.2 NVMe");
    }

    /**
     * Defines the Graphics Adapter object to associate with the WRG gaming PC.
     * @return a new Graphics Adapter to use for the Gaming PC.
     */
    @Override
    public GraphicsAdapter createGraphicsAdapter() {
        return new WRGGraphicsAdapter("WRG RTX 3050", 8, 128);
    }
    
}
