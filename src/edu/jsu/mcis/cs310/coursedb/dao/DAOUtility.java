package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        ResultSetMetaData rsmd = null;
        
        try {
        
            if (rs != null) {

                // INSERT YOUR CODE HERE
                
                // Getting metadata from ResultSet
                rsmd = rs.getMetaData();
                
                // Getting the number of columns
                int columnCount = rsmd.getColumnCount();

                // While loop to loop through each  row 
                while (rs.next()) {
                    
                    // Creating a JSON object for the current row
                    JsonObject recordRow = new JsonObject();
                    
                    // for loop to loop through each column
                    for (int i = 1; i <= columnCount; i++) {
                        
                        // Getting the column name
                        String columnName = rsmd.getColumnName(i);
                        
                        // Getting the column value
                        Object columnValue = rs.getObject(i);
                        
                        // Adding the column name and value in the row object
                        recordRow.put(columnName, columnValue);
                }
                    // Adding the row object in the records array
                    records.add(recordRow);
                }
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        // Jsoner.serialize did not work, so using toString method
        return records.toString();
        
    }
    
}
