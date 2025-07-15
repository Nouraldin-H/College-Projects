/*****************************************************************
 * File:  InventoryDao.java
 * Course Materials CST 8277
 * @author Mike Norman
 * @author Teddy Yap
 *
 */
package com.algonquincollege.cst8277.regionalInventory.dao;

import java.util.List;

public interface InventoryDao {

    // TODO - add more to this interface

    // Create
	void createInventory(Inventory inv);
	
    // R - read all inventory for the specified region
    List<Inventory> readAllInventoryForRegion(String region);
    // R - read a specific inventory
    Inventory readInventoryById(int invId);

    // Update
    void updateInventory(Inventory inv);
    
    // Delete
    void deleteInventoryById(int invId);
}