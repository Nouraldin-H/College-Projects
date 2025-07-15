/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_main_pkg;

import gaming_pc_building_pkg.ConcreteGamingPCBuilding;
import gaming_pc_building_pkg.GamingPCBuilding;
import gaming_pcs_pkg.GamingPC;

/**
 * This main class serves as the program that runs the procedures of making the gaming PC.
 * @author Nouraldin Hassan
 */
public class GamingPCFactoryTest {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GamingPCBuilding theGamingPCBuilding = new ConcreteGamingPCBuilding();
        
        GamingPC theG4LGamingPC = theGamingPCBuilding.orderTheGamingPC("G4L");
// Commented out below since it somehow prints it again, therefore making duplicate prints.
//        theG4LGamingPC.displayCPUInfo();
//        theG4LGamingPC.displayRAMInfo();
//        theG4LGamingPC.displayStorageInfo();
//        theG4LGamingPC.displayGraphicsAdapterInfo();
        System.out.println(theG4LGamingPC + "\n");
        
        GamingPC theWRGGamingPC = theGamingPCBuilding.orderTheGamingPC("WRG");
        theWRGGamingPC.displayCPUInfo();
        theWRGGamingPC.displayRAMInfo();
        theWRGGamingPC.displayStorageInfo();
        theWRGGamingPC.displayGraphicsAdapterInfo();
        System.out.println(theWRGGamingPC + "\n");
        
    }
    
}
