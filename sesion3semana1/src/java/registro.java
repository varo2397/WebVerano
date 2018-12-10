/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alv-c
 */
@WebServlet(urlPatterns = {"/registro"})
public class registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuario = new Usuario();
       
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setNombreUsuario(request.getParameter("nombreUsuario"));
        usuario.setContraseña(request.getParameter("contrasena"));
        
        String confirmarContraseña = request.getParameter("confirmarContrasena");
        
        HttpSession sesion = request.getSession();
        
        if(usuario.getContraseña().equals(confirmarContraseña)){
            
            
            if(sesion.getAttribute("usuarios") == null){
                ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
                usuarios.add(usuario);
                sesion.setAttribute("usuarios", usuarios);
            }
            
            else{
                ArrayList<Usuario> usuarios = (ArrayList<Usuario>) sesion.getAttribute("usuarios");
                usuarios.add(usuario);
                sesion.setAttribute("usuarios", usuarios);
            }
            
            response.sendRedirect("index.html");
        }
        
        else{
            sesion.setAttribute("errorContraseña", "Las contraseñas no coinciden, vuelva a intentarlo");
            response.sendRedirect("registro.jsp");
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
