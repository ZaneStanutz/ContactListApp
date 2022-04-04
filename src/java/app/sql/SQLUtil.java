
package app.sql;

import java.sql.*;


public class SQLUtil {
        
        public static String  getHtmlTable(ResultSet results)
                throws SQLException{
            
            StringBuilder htmlTable = new StringBuilder();
            ResultSetMetaData metaData = results.getMetaData();
            int columnCount = metaData.getColumnCount();
           
            htmlTable.append("<table>");
            
            // add header row
            htmlTable.append("<tr>");
            for(int i = 1; i <= columnCount; i++){
                if(i == 1) {
                    
                    htmlTable.append("<th>");
                    htmlTable.append("Delete");
                    htmlTable.append("</th>");
                        
                }
                else {
                    
                htmlTable.append("<th>");
                htmlTable.append(metaData.getColumnName(i));
                htmlTable.append("</th>");
                
                }
            }
            htmlTable.append("</tr>");
            
            while(results.next()){
                
                htmlTable.append("<tr>");
                
                for(int i = 1; i <= columnCount; i++){
                    
                    if(i == 1) {
                        
                        htmlTable.append("<td>");
                        
                        htmlTable.append("<form action=\"ContactListServlet\" method=\"post\">\n" +
                                "        <input type=\"hidden\" name=\"action\" value=\"deleteTableItem\"> \n" +
                                "        <input type=\"hidden\" name=\"idx\" value=\"");
                
                        htmlTable.append(results.getString(i));
                        htmlTable.append("\"> \n" +
                                "        <input class=\"lineDel\" type=\"submit\" value=\"Del.\" >\n" +
                                "    </form>");
                        htmlTable.append("</td>");
                    }
                    else{
                        htmlTable.append("<td>");
                        htmlTable.append(results.getString(i));
                        htmlTable.append("</td>");       
                    }
                }
                
                htmlTable.append("</tr>");
            }
        htmlTable.append("</table>");
        return htmlTable.toString();
         
            
        } // getHtmlTable()
        
} //class
