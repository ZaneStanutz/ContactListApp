
package app.data;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConnectionPool {
    
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    
    private ConnectionPool() {
        
        try{
            InitialContext ic = new InitialContext();
            dataSource = (DataSource)ic.lookup("java:/comp/env/jdbc/contact");
        }catch(NamingException e) {
            System.out.println(e);
        }
    } // constructor
    
    public static synchronized ConnectionPool getInstance(){
        if(pool == null){
            pool = new ConnectionPool();
        }
        return pool;
    
    } // getInstance()
    
    public Connection getConnection() {
        try{
            return dataSource.getConnection();
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    } // getConnection()
    
    public void freeConnection(Connection c) {
        try {
            c.close();
        }catch(SQLException e){
            System.out.println(e);
        }
    } // freeConnection()
    
} // class
