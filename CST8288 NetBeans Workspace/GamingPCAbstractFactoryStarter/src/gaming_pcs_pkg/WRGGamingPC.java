/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pcs_pkg;

import gaming_pc_factories_pkg.GamingPCFactory;

/**
 * This class is for the WRG Gaming PC that would have the components assembled as defined in {@link GamingPC}.
 * @author Nouraldin Hassan
 */
public class WRGGamingPC extends GamingPC {

    GamingPCFactory theGamingPCFactory;
    
    public WRGGamingPC(GamingPCFactory theGamingPCFactory) {
        this.theGamingPCFactory = theGamingPCFactory;
    }
    
    public void equipGamingPC() {
        System.out.println("Adding components to WRG Gaming PC " + getName());
        // Insert code to assign CPU, RAM, storage, and graphics adapter to suitable ones
        this.cpu = theGamingPCFactory.createCPU();
        this.ram = theGamingPCFactory.createRAM();
        this.storage = theGamingPCFactory.createStorage();
        this.graphicsAdapter = theGamingPCFactory.createGraphicsAdapter();
    }
    
}
