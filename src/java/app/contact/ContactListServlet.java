
package app.contact;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import app.business.Contact;
import app.data.UserDB;

public class ContactListServlet extends HttpServlet {
    
    String url;
    String message;
    String deleteStatus;
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        int emptyResultSet = 108;
        String allData;
        String noData = "No Data available ";
        
        switch(action) {
            
            case "add":
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String phoneNumber = request.getParameter("phoneNumber");
            
                Contact contact = new Contact(firstName, lastName, email, phoneNumber);
            
                if(UserDB.emailExists(contact.getEmail())) {
                
                    message = "This account already exists, Please use another email";
                    url = "/addContact.jsp";
                
                }
                else {
                
                    UserDB.insert(contact);
                    message = "Here is the info you entered..";
                    request.setAttribute("contact", contact);
                    url = "/thanks.jsp"; 
            
                }
                request.setAttribute("message", message);
                break;
            
            case "showAll":
                
                url = "/viewData.jsp";
                allData = UserDB.findAll();
   
                if(allData.length() == emptyResultSet){
                    
                    request.setAttribute("noData", noData);
      
                }
                else {
                    
                    request.setAttribute("allData", allData);
                    
                }
                break;
                
            case "searchName":
                
                url = "/viewData.jsp";
                String keyword = request.getParameter("search");
                allData = UserDB.findKeyword(keyword);
                
                if(allData.length() == emptyResultSet){
                    
                    
                    request.setAttribute("noData", noData);
                    
      
                }
                else {
                    
                    request.setAttribute("allData", allData);
                    
                }
                
                break;
                
            case "deleteContact":
                
                url = "/viewData.jsp";
                String removeEmail = request.getParameter("removeContact");
                int isDone = UserDB.deleteContact(removeEmail);
                if(isDone == 1){
                    deleteStatus = "Delete Successful";
                }
                else{
                    deleteStatus = "No contact with that email";
                }
                request.setAttribute("deleteStatus", deleteStatus);
                break;
                
            case "deleteTableItem":
                
                url ="/viewData.jsp";
                String idx = request.getParameter("idx");
                int idxInt = Integer.parseInt(idx);
                int isSuccessful =  UserDB.deleteListItem(idxInt);
                if(isSuccessful == 1){
                    deleteStatus = "Del. Successful";
                }
                else{
                    deleteStatus = "Del. failed";
                }
                request.setAttribute("deleteStatus", deleteStatus);
                break;
        }
        getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
    } // doPost
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String action = request.getParameter("action");
        
        if(action.equals("add")) {
            
            url = "/addContact.jsp";
            
        }
        
        else if(action.equals("view")) {
            
            url = "/viewData.jsp";
            
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    } // doGet
    
} // class