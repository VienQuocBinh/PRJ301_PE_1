/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.ContactDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LucasBV
 */
@WebServlet(name = "AddContactController", urlPatterns = {"/AddContactController"})
public class AddContactController extends HttpServlet {

    private static final String ERROR = "AddContact.jsp";
    private static final String SUCCESS = "ListContactController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;

        try {
            HttpSession session = request.getSession();
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            int group = Integer.parseInt(request.getParameter("group"));
            String phoneNumber = request.getParameter("phoneNumber");
            String pattern = "[0-9]+";

            String errorMessage = "";
            if (firstName == null || firstName.trim().isEmpty()) {
                errorMessage += "Enter first name ";
            }
            if (lastName == null || lastName.trim().isEmpty()) {
                errorMessage += "Enter last name ";
            }
            if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
                errorMessage += "Enter phoneNumber ";
            }
            if (!phoneNumber.matches(pattern)) {
                errorMessage += "Phone number must not contain character";
                session.setAttribute("ADD_CONTACT_ERROR", errorMessage);
            } else {
                ContactDAO contactDao = new ContactDAO();
                contactDao.insertContact(firstName, lastName, group, phoneNumber);
                url = SUCCESS;
            }

        } catch (Exception e) {
            log("Error at AddContactController: " + e.toString());
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
