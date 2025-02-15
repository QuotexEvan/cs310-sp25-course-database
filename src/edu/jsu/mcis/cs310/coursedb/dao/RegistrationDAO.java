package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RegistrationDAO {
    
    // Writing queries to pass into prepareStatement
    private static final String Query_Create = "INSERT INTO registration (studentid, termid, crn) VALUES (?,?,?)" ;
    private static final String Query_Delete_1 = "DELETE FROM registration WHERE studentid = ? AND termid = ? AND crn = ?" ;
    private static final String Query_Delete_2 = "DELETE FROM registration WHERE studentid = ? AND termid = ?" ;
    
    private final DAOFactory daoFactory;
    
    RegistrationDAO(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    public boolean create(int studentid, int termid, int crn) {
       
        boolean result = false;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {
                
                // INSERT YOUR CODE HERE
                
                //Creating the query as a PreparedStatement
                ps = conn.prepareStatement(Query_Create);
                
                // Providing the arguments for the PreparedStatement
                ps.setString(1, String.valueOf(studentid));
                ps.setString(2, String.valueOf(termid));
                ps.setString(3, String.valueOf(crn));
                
                // Executing the query and executeUpdate() returns the number of
                // row affected by the query so storing it in an int variable
                int rowsAffected = ps.executeUpdate();
                
                // if one or more rows were affected, then result = true
                result = rowsAffected > 0;
            }
            
        }
        
        catch (Exception e) { e.printStackTrace(); }
        
        finally {
            
            if (rs != null) { try { rs.close(); } catch (Exception e) { e.printStackTrace(); } }
            if (ps != null) { try { ps.close(); } catch (Exception e) { e.printStackTrace(); } }
            
        }
        
        return result;
        
    }

    public boolean delete(int studentid, int termid, int crn) {
        
        boolean result = false;
        
        PreparedStatement ps = null;
        
        try {
            
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {
                
                // INSERT YOUR CODE HERE
                
                //Creating the query as a PreparedStatement
                ps = conn.prepareStatement(Query_Delete_1);
                
                // Providing the arguments for the PreparedStatement
                ps.setString(1, String.valueOf(studentid));
                ps.setString(2, String.valueOf(termid));
                ps.setString(3, String.valueOf(crn));
                
                // Executing the query and executeUpdate() returns the number of
                // row affected by the query so storing it in an int variable
                int rowsAffected = ps.executeUpdate();
                
                // if one or more rows were affected, then result = true
                result = rowsAffected > 0;
                
            }
            
        }
        
        catch (Exception e) { e.printStackTrace(); }
        
        finally {

            if (ps != null) { try { ps.close(); } catch (Exception e) { e.printStackTrace(); } }
            
        }
        
        return result;
        
    }
    
    public boolean delete(int studentid, int termid) {
        
        boolean result = false;
        
        PreparedStatement ps = null;
        
        try {
            
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {
                
                // INSERT YOUR CODE HERE
                
                //Creating the query as a PreparedStatement
                ps = conn.prepareStatement(Query_Delete_2);
                
                // Providing the arguments for the PreparedStatement
                ps.setString(1, String.valueOf(studentid));
                ps.setString(2, String.valueOf(termid));
                
                // Executing the query and executeUpdate() returns the number of
                // row affected by the query so storing it in an int variable
                int rowsAffected = ps.executeUpdate();
                
                // if one or more rows were affected, then result = true
                result = rowsAffected > 0;
                
            }
            
        }
        
        catch (Exception e) { e.printStackTrace(); }
        
        finally {

            if (ps != null) { try { ps.close(); } catch (Exception e) { e.printStackTrace(); } }
            
        }
        
        return result;
        
    }

    public String list(int studentid, int termid) {
        
        String result = null;
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        
        try {
            
            Connection conn = daoFactory.getConnection();
            
            if (conn.isValid(0)) {
                
                // INSERT YOUR CODE HERE
                
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
