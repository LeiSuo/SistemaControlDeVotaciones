/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.controlador;

import gov.modelo.Ciudadano;
import gov.modelo.DaoVotante;
import gov.modelo.Votante;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Nombre de la clase: ProcesarVotante
 * Versión: 1.0
 * Fecha: 20-may-2018
 * Autor: Ulises
 */

public class ProcesarVotante extends HttpServlet {
   
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
        HttpSession sesion=request.getSession();
        String nivel = sesion.getAttribute("nivel").toString();
        String msj = null;
        DaoVotante dao = new DaoVotante();
        Votante vot = new Votante();
        Ciudadano ciu = new Ciudadano();
        try {
            ciu.setDui(request.getParameter("txtDui"));
            vot.setCiudadano(ciu);
            vot.setEstado(request.getParameter("cmbEstado"));
            if(request.getParameter("btnRegistrar")!=null){
                vot.setPassword(request.getParameter("txtPassword"));
                int val=dao.validar(vot);
                if(val==1){
                    msj="El votante ya esta registrado";
                }else{
                    dao.insertar(vot);
                    msj="Votante insertado";
                }
            }else if(request.getParameter("btnModificar")!=null){
                vot.setPassword(request.getParameter("txtPassword"));
                dao.modificar(vot);
                msj="Votante modificado";
            }else if(request.getParameter("btnEliminar")!=null){
                dao.eliminar(vot);
                msj="Votante eliminado";
            }
        } catch (Exception e) {
            msj=e.toString();
        }finally{
            request.getSession().setAttribute("msj", msj);
            if(nivel.equals("1")){
                response.sendRedirect("Administrador/votante.jsp");
            }else if(nivel.equals("2")){
                response.sendRedirect("Inscriptor/votante.jsp");
            }
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
