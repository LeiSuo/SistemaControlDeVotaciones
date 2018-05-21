/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.controlador;

import gov.modelo.DaoUsuario;
import gov.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Nombre de la clase: ProcesarUsuarios
 * Versión: 1.0
 * Fecha: 16-may-2018
 * Autor: Ulises
 */

public class ProcesarUsuarios extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DaoUsuario daoUs = new DaoUsuario();
        String msj = null;
        Usuario us = new Usuario();
        try 
        {
            us.setNombre(request.getParameter("txtNombre"));
            us.setUsuario(request.getParameter("txtUsuario"));
            us.setPassword(request.getParameter("txtPassword"));
            us.setNivel(Integer.parseInt(request.getParameter("cmbNivel")));
            if(request.getParameter("btnModificar")!=null){
                    us.setIdUsuario(Integer.parseInt(request.getParameter("txtIdUsuario")));
                    daoUs.modificar(us);
                    msj="usuario modificado Correctamente";
            }
            if(request.getParameter("btnEliminar")!=null){
                us.setIdUsuario(Integer.parseInt(request.getParameter("txtIdUsuario")));
                daoUs.eliminar(us);
                msj="usuario eliminado Correctamente";
            }
            if(request.getParameter("btnRegistrar1")!=null){
                daoUs.insertar(us);
                msj="usuario insertado Correctamente";                
            }
        } 
        catch (Exception e) 
        {
            msj=e.toString();
        }
        finally
        {
            request.getSession().setAttribute("msj", msj);
            response.sendRedirect("Administrador/usuario.jsp");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
