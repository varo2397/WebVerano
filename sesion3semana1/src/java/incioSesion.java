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
    @WebServlet(urlPatterns = {"/incioSesion"})
public class incioSesion extends HttpServlet {
    
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
        
        Usuario usuarioLogin = new Usuario();
        
        usuarioLogin.setNombreUsuario(request.getParameter("nombreUsuario"));
        usuarioLogin.setContraseña(request.getParameter("contrasena"));
        
        HttpSession sesion = request.getSession();
        
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) sesion.getAttribute("usuarios");
        Usuario u = new Usuario();
        String mensajeError = "";
        
        if(usuarios != null){
            for(int i = 0; i < usuarios.size(); i++){
                u = usuarios.get(i);
                if(u.getNombre().equals(usuarioLogin.getNombre())){
                    break;
                }
                else if(i == usuarios.size() - 1){
                    mensajeError = "Usuario no existe";
                }
            }
            
            if(u.getContraseña().equals(usuarioLogin.getContraseña())){
                mensajeError = "Has iniciado sesion";
            }
            else{
                mensajeError = "Contraseñas incorrectas";
            }
        }
        
        else{
            mensajeError = "No existen usuarios";
        }
        
        sesion.setAttribute("mensajeError", mensajeError);
        
        response.sendRedirect("inicioSesion.jsp");
        
        
        
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
