/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pcs_pkg;

import gaming_pc_factories_pkg.GamingPCFactory;

/**
 * This class is for the G4L Gaming PC that would have the components assembled as defined in {@link GamingPC}.
 * @author Nouraldin Hassan
 */
public class G4LGamingPC extends GamingPC {
    
    GamingPCFactory theGamingPCFactory;
    
    public G4LGamingPC(GamingPCFactory theGamingPCFactory) {
        this.theGamingPCFactory = theGamingPCFactory;
    }

    public void equipGamingPC() {
        System.out.println("Adding components to G4L Gaming PC " + getName());
        // Insert code to assign CPU, RAM, storage, and graphics adapter to suitable ones
        cpu = theGamingPCFactory.createCPU();
        ram = theGamingPCFactory.createRAM();
        storage = theGamingPCFactory.createStorage();
        graphicsAdapter = theGamingPCFactory.createGraphicsAdapter();

        // Display information about each component
        displayCPUInfo();
        displayRAMInfo();
        displayStorageInfo();
        displayGraphicsAdapterInfo();
    }
    
}
