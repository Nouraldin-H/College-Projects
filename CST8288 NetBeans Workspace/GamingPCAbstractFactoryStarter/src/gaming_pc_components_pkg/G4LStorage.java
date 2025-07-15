/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gaming_pc_components_pkg;

/**
 * This class is for the Storage building procedure of the G4L PC.
 * @see CPU
 * @author Nouraldin Hassan
 */
public class G4LStorage implements Storage {
    private int capacity;
    private String type;

    // Constructor
    /**
     * Used to hold the capacity and type of the Storage for use with building the gaming PC.
     * @param capacity the size of the Storage.
     * @param type the type of the Storage.
     * @author Nouraldin Hassan
     */
    public G4LStorage(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
    }

    /**
     * Formats the string to the specified values provided in {@link G4LRAM}.
     * @author Nouraldin Hassan
     */
    @Override
    public String toString() {
        return String.format("%dGB %s storage", capacity, type);
    }
}
