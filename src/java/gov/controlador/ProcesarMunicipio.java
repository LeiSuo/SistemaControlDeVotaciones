/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.controlador;

import gov.modelo.DaoMunicipio;
import gov.modelo.Departamento;
import gov.modelo.Municipio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Nombre de la clase: ProcesarMunicipio
 * Versión: 1.0
 * Fecha: 14-may-2018
 * Autor: Ulises
 */

public class ProcesarMunicipio extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String msj=null;
        Municipio mun = new Municipio();
        DaoMunicipio dao = new DaoMunicipio();
        Departamento dep = new Departamento();
        try {
            mun.setNombre(request.getParameter("txtNombre"));
            dep.setIdDepartamento(Integer.parseInt(request.getParameter("cmbDepartamento")));
            mun.setDepartamento(dep);
            if(request.getParameter("btnRegistrar")!=null){
                dao.insertarMunicipio(mun);
                msj="Municipio insertado";
            }else if(request.getParameter("btnModificar")!=null){
                mun.setIdMunicipio(Integer.parseInt(request.getParameter("txtIdMunicipio")));
                dao.modificarMunicipio(mun);
                msj="Municipio modificado";
            }else if(request.getParameter("btnEliminar")!=null){
                mun.setIdMunicipio(Integer.parseInt(request.getParameter("txtIdMunicipio")));
                dao.eliminarMunicipio(mun);
                msj="Municipio eliminado";
            }
        } catch (Exception e) {
            msj=e.toString();
        }finally{
            request.getSession().setAttribute("msj", msj);
            response.sendRedirect("Administrador/municipio.jsp");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProcesarMunicipio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProcesarMunicipio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
