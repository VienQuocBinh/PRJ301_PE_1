/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

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
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String ADD_CONTACT_CONTROLLER = "AddContactController";
    private static final String LIST_CONTACT_CONTROLLER = "ListContactController";
    private static final String EDIT_CONTACT_CONTROLLER = "EditContactController";
    private static final String REMOVE_CONTACT_CONTROLLER = "RemoveContactController";
    private static final String LIST_GROUP_CONTROLLER = "ListGroupController";
    private static final String ADD_GROUP_CONTROLLER = "AddGroupController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");

            switch (action) {
                case "Add":
                    url = ADD_CONTACT_CONTROLLER;
                    break;
                case "List Contact":
                    url = LIST_CONTACT_CONTROLLER;
                    break;
                case "Edit":
                    url = EDIT_CONTACT_CONTROLLER;
                    break;
                case "RemoveContact":
                    url = REMOVE_CONTACT_CONTROLLER;
                    break;
                case "List Group":
                    url = LIST_GROUP_CONTROLLER;
                    break;
                case "Add Group":
                    url = ADD_GROUP_CONTROLLER;
                    break;
                default:
                    session.setAttribute("ERROR_MESSAGE", "Function is not available");
            }
        } catch (Exception e) {
            log("Error at main controller: " + e.toString());
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
