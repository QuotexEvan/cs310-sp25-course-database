package edu.jsu.mcis.cs310.coursedb.dao;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import static edu.jsu.mcis.cs310.coursedb.dao.DAOUtility.getResultSetAsJson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class SectionDAO {
    
    private static final String QUERY_FIND = "SELECT * FROM section WHERE termid = ? AND subjectid = ? AND num = ? ORDER BY crn";
    
    private final DAOFactory daoFactory;
    
    SectionDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    public String find(int termid, String subjectid, String num) {
        
        
        String result = "[]";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        
        try {
            
            Connection conn = daoFactory.getConnection();
       
            if (conn.isValid(0)) {
                // INSERT YOUR CODE HERE
                
                //Creating the query as a PreparedStatement
                ps = conn.prepareStatement(QUERY_FIND);
                
                // Providing the arguments for the PreparedStatement
                ps.setString(1, String.valueOf(termid));
                ps.setString(2, subjectid);
                ps.setString(3, num);
                
                // Executing the PreparedStatement
                boolean hasResults = ps.execute();
                
                // If query has results, then retrieving the data 
                if (hasResults){
             
                    // Getting result set and storing it in the ResultSet variable
                    rs = ps.getResultSet();
                 
                }
               
                // Using the getResultSetAsJson from DAOUtility
                // and passing the ResultSet as the argument
                result = getResultSetAsJson(rs);
               
            }
            
        }
        
        catch (Exception e) { e.printStackTrace(); }
        
        finally {
            
            if (rs != null) { try { rs.close(); } catch (Exception e) { e.printStackTrace(); } }
            if (ps != null) { try { ps.close(); } catch (Exception e) { e.printStackTrace(); } }
            
        }
        
        return result;
        
    }
    
}