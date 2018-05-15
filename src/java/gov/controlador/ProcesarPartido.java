/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.controlador;

import gov.modelo.DaoPartidoPolitico;
import gov.modelo.PartidoPolitico;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Nombre de la clase: ProcesarPartido
 * Versión: 1.0
 * Fecha: 15-may-2018
 * Autor: Ulises
 */

public class ProcesarPartido extends HttpServlet {
   
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
        String msj=null;
        DaoPartidoPolitico dao = new DaoPartidoPolitico();
        PartidoPolitico pp = new PartidoPolitico();
        try {
            pp.setNombre(request.getParameter("txtNombre"));
                       
            if(request.getParameter("btnRegistrar")!=null){
                dao.insertar(pp);
                msj="Municipio insertado";
            }else if(request.getParameter("btnModificar")!=null){
                msj="Municipio modificado";
            }else if(request.getParameter("btnEliminar")!=null){
                pp.setIdPartido(Integer.parseInt(request.getParameter("txtIdPartido")));
                dao.eliminar(pp);
                msj="Municipio eliminado";
            }
        } catch (Exception e) {
            msj= e.toString();
        }finally{
            request.getSession().setAttribute("msj", msj);
            response.sendRedirect("Administrador/partidoPolitico.jsp");
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
