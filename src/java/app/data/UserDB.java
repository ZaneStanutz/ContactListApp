
package app.data;

import java.sql.*;
import app.business.Contact;
import app.sql.SQLUtil;

public class UserDB {
    
    public static int insert(Contact contact){
        ConnectionPool pool =  ConnectionPool.getInstance();
        Connection connection = pool.getConnection(); // 
        PreparedStatement ps = null;
        
        String query
                = "INSERT INTO Contact (Email, FIrstName, LastName, PhoneNumber)"
                + "VALUES(?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, contact.getEmail());
            ps.setString(2, contact.getFirstName());
            ps.setString(3, contact.getLastName());
            ps.setString(4, contact.getPhoneNumber());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }  //insert()
    
    
    public static boolean emailExists(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query =  "SELECT Email FROM Contact "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch(SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    } // emailExists()
    
    public static String findAll(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String htmlResult = null;
        
        String query = "SELECT * FROM Contact"; 
        
        try{
            ps = connection.prepareStatement(query);
            rs =  ps.executeQuery();
            htmlResult = SQLUtil.getHtmlTable(rs);
            return htmlResult;
        } catch(SQLException e){
            System.out.println(e);
            return null;
        } 
   
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        
        }  
    } // findAll()
    
    public static String findKeyword(String keyword) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String htmlResult = null;
        
        String query = "SELECT * FROM contact\n" +
                "WHERE  CONCAT(Email, FirstName, LastName)  LIKE '%" + keyword + "%'";        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            htmlResult = SQLUtil.getHtmlTable(rs);
            return htmlResult;
        } catch(SQLException e) {
            System.out.println(e);
            return null;
        }
        finally{
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    } // findKeyword()
    
    public static int deleteContact(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM contact "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        } 
    } // deleteContact()
    
    public static int deleteListItem(int idx) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM contact "
                + "WHERE UserID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idx);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        } 
    } // deleteListItemContact()
    
} // class