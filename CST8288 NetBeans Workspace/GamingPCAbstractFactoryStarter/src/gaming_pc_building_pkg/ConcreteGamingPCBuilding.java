/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_building_pkg;

import gaming_pc_factories_pkg.G4LGamingPCFactory;
import gaming_pc_factories_pkg.WRGGamingPCFactory;
import gaming_pcs_pkg.G4LGamingPC;
import gaming_pcs_pkg.GamingPC;
import gaming_pcs_pkg.WRGGamingPC;
import gaming_pc_factories_pkg.GamingPCFactory;

/**
 * This class uses the procedure provided in {@link GamingPCBuilding} to create the PC.
 * @author Nouraldin Hassan
 */
public class ConcreteGamingPCBuilding extends GamingPCBuilding {
    /**
    * This method creates the Gaming PC.
    * @param typeOfGamingPC the type of gaming PC you want to create.
    * @author Nouraldin Hassan
    */
    @Override
    protected GamingPC makeGamingPC(String typeOfGamingPC) {
        GamingPC theGamingPC = null;
        if ("G4L".equalsIgnoreCase(typeOfGamingPC)) {
            GamingPCFactory theGamingPCFactory = new G4LGamingPCFactory();
            theGamingPC = new G4LGamingPC(theGamingPCFactory);
            theGamingPC.setName("G4L G15CE-RI516S-CA Gaming Desktop");
            System.out.println("Created G4L Gaming PC " + theGamingPC.getName()); 
        }
        else if ("WRG".equalsIgnoreCase(typeOfGamingPC)) {
            GamingPCFactory theGamingPCFactory = new WRGGamingPCFactory();
            theGamingPC = new WRGGamingPC(theGamingPCFactory);
            theGamingPC.setName("WRG Codex SE 12TH-054CA Gaming Desktop Computer");
            System.out.println("Created WRG Gaming PC " + theGamingPC.getName()); 
        }
        return theGamingPC;
    }

}
