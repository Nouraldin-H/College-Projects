/*****************************************************************
 * File:  InventoryDaoImpl.java
 * Course Materials CST 8277
 * @author Mike Norman
 * @author Teddy Yap
 *
 */
package com.algonquincollege.cst8277.regionalInventory.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import javax.sql.DataSource;

@Named
@ApplicationScoped
public class InventoryDaoImpl implements InventoryDao, Serializable {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;

    public static final String GET_ALL_INVENTORY_FOR_REGION_SQL =
    		"SELECT * FROM REGIONAL_INVENTORY WHERE REGION = ?";
    public static final String INSERT_INVENTORY_SQL =
    		"INSERT INTO REGIONAL_INVENTORY(INV_ID, RETAILER_NAME, CURR_INV_LEVEL, REGION, CREATED, UPDATED) VALUES (?, ?, ?, ?, now(), now());";
    public static final String READ_INVENTORY_BY_ID_SQL =
    		"SELECT * FROM REGIONAL_INVENTORY WHERE INV_ID = ?";
    public static final String UPDATE_INVENTORY_BY_ID_SQL =
    		"UPDATE REGIONAL_INVENTORY SET RETAILER_NAME = ?, CURR_INV_LEVEL = ?, REGION = ?, UPDATED = now(), VERSION = VERSION + 1 WHERE INV_ID = ?;";
    public static final String DELETE_INVENTORY_BY_ID_SQL =
    		"DELETE FROM REGIONAL_INVENTORY WHERE INV_ID = ?;";
    
    @Inject
    protected ServletContext ctx;
    private void logMsg(String msg) {
        ctx.log(msg);
    }

    @Resource(lookup="java:app/jdbc/regionalInventory")
    protected DataSource regionalInventoryDataSource;

    protected Connection conn;
    protected PreparedStatement getAllPstmt;
    protected PreparedStatement insertPstmt;
    protected PreparedStatement readByIdPstmt;
    protected PreparedStatement updateByIdPstmt;
    protected PreparedStatement deleteByIdPstmt;
    
    @PostConstruct
    protected void buildConnectionAndStatements() {
        try {
            logMsg("building connection ...");
            conn = regionalInventoryDataSource.getConnection();
            getAllPstmt = conn.prepareStatement(GET_ALL_INVENTORY_FOR_REGION_SQL);
            // build more statements for rest of C-R-U-D interface
            insertPstmt = conn.prepareStatement(INSERT_INVENTORY_SQL);
            readByIdPstmt = conn.prepareStatement(READ_INVENTORY_BY_ID_SQL);
            updateByIdPstmt = conn.prepareStatement(UPDATE_INVENTORY_BY_ID_SQL);
            deleteByIdPstmt = conn.prepareStatement(DELETE_INVENTORY_BY_ID_SQL);
        }
        catch (Exception e) {
            logMsg("something went wrong getting connection: " + e.getLocalizedMessage());
        }
    }

    @PreDestroy
    protected void closeConnectionAndStatements() {
        try {
            logMsg("closing stmts and connection ...");
            getAllPstmt.close();
            // close rest of statements ...
            insertPstmt.close();
            readByIdPstmt.close();
            updateByIdPstmt.close();
            deleteByIdPstmt.close();
            conn.close();
        }
        catch (Exception e) {
            logMsg("something went wrong closing connection: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<Inventory> readAllInventoryForRegion(String region) {
        List<Inventory> inventoryList = new ArrayList<>();
        try {
            getAllPstmt.setString(1, region);
            ResultSet rs = getAllPstmt.executeQuery();
            while (rs.next()) {
                Inventory newInventory = new InventoryDTO();
                newInventory.setId(rs.getInt("INV_ID"));
                newInventory.setRetailerName(rs.getString("RETAILER_NAME"));
                newInventory.setRegion(rs.getString("REGION"));
                newInventory.setInventoryLevel(rs.getInt("CURR_INV_LEVEL"));
                inventoryList.add(newInventory);
            }
            try {
                rs.close();
            }
            catch (SQLException e) {
                logMsg("something went wrong closing resultSet: " + e.getLocalizedMessage());
            }
        }
        catch (SQLException e) {
            logMsg("something went wrong accessing database: " + e.getLocalizedMessage());
        }
        return inventoryList;
    }

    //TODO - fill in rest of C-R-U-D methods
    
    @Override
    public void createInventory(Inventory inv) {
    	try {
    		insertPstmt.setLong(1, inv.getId());
    		insertPstmt.setString(2, inv.getRetailerName());
    		insertPstmt.setLong(3, inv.getInventoryLevel());
    		insertPstmt.setString(4, inv.getRegion());
    		insertPstmt.execute();
    	}
    	catch (SQLException e) {
            logMsg("something went wrong accessing database: " + e.getLocalizedMessage());
    	}
    	
    }
    
    @Override
    public Inventory readInventoryById(int invId) {
    	Inventory inventory = null;
    	try {
    		readByIdPstmt.setLong(1, invId);
    		ResultSet rs = readByIdPstmt.executeQuery();
    		if (rs.next()) {
    			inventory = new InventoryDTO();
    			inventory.setId(rs.getInt("INV_ID"));
    			inventory.setInventoryLevel(rs.getInt("CURR_INV_LEVEL"));
    			inventory.setRegion(rs.getString("REGION"));
    			inventory.setRetailerName(rs.getString("RETAILER_NAME"));
    		}
    	}
    	catch (SQLException e) {
            logMsg("something went wrong accessing database: " + e.getLocalizedMessage());
    	}
    	return inventory;
    }
    
    @Override
    public void updateInventory(Inventory inv) {
    	try {
    		updateByIdPstmt.setString(1, inv.getRetailerName());
    		updateByIdPstmt.setLong(2, inv.getInventoryLevel());
    		updateByIdPstmt.setString(3, inv.getRegion());
    		updateByIdPstmt.setLong(4, inv.getId());
    		updateByIdPstmt.execute();
    	}
    	catch (SQLException e) {
            logMsg("something went wrong accessing database: " + e.getLocalizedMessage());
    	}
    }
    
    @Override
    public void deleteInventoryById(int invId) {
    	try {
    		deleteByIdPstmt.setLong(1, invId);
    		deleteByIdPstmt.execute();
    	}
    	catch (SQLException e) {
            logMsg("something went wrong accessing database: " + e.getLocalizedMessage());
    	}
    }
}