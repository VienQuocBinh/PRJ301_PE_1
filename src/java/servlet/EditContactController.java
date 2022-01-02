/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.ContactDAO;
import dao.FriendGroupDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import obj.Contact;
import obj.FriendGroup;

/**
 *
 * @author LucasBV
 */
@WebServlet(name = "EditContactController", urlPatterns = {"/EditContactController"})
public class EditContactController extends HttpServlet {

    private static final String SUCCESS = "ListContactController";
    private static final String ERROR = "EditContact.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int contactID = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            int groupID = Integer.parseInt(request.getParameter("group"));
            String errorMessage = "";
            if (firstName == null || firstName.trim().isEmpty()) {
                errorMessage += "Enter first name ";
            }
            if (lastName == null || lastName.trim().isEmpty()) {
                errorMessage += "Enter last name ";
            }
            String pattern = "[0-9]+";
            if (phone == null || phone.trim().isEmpty() || !phone.matches(pattern)) {
                errorMessage += "Invalid phone number";
            } else {
                ContactDAO contactDao = new ContactDAO();
                contactDao.updateContact(contactID, firstName, lastName, groupID, phone);
                url = SUCCESS;
            }
            request.setAttribute("EDIT_ERROR", errorMessage);
        } catch (Exception e) {
            log("Error at EditContactController " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
