/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_building_pkg;

import gaming_pcs_pkg.GamingPC;

/**
 * This class provides the building procedure for the gaming PC.
 * @author Nouraldin Hassan
 */
public abstract class GamingPCBuilding {
    /**
    * This method creates the Gaming PC.
    * @param typeOfGamingPC the type of gaming PC you want to create.
    * @author Nouraldin Hassan
    */
    protected abstract GamingPC makeGamingPC(String typeOfGamingPC);
    
    public GamingPC orderTheGamingPC(String typeOfGamingPC) {
        GamingPC theGamingPC = makeGamingPC(typeOfGamingPC);
        theGamingPC.equipGamingPC();
        return theGamingPC;
    }
    
}
