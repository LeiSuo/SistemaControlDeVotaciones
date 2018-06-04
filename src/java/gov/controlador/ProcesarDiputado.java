/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.controlador;

import gov.modelo.Ciudadano;
import gov.modelo.DaoDiputado;
import gov.modelo.Diputado;
import gov.modelo.PartidoPolitico;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Nombre de la clase: ProcesarDiputado
 * Versión: 1.0
 * Fecha: 16-may-2018
 * Autor: Ulises
 */
@WebServlet("/procesarDip")
@MultipartConfig(maxFileSize = 16177215)
public class ProcesarDiputado extends HttpServlet {
   
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
        DaoDiputado dao = new DaoDiputado();
        Diputado dip = new Diputado();
        Ciudadano ciu = new Ciudadano();
        PartidoPolitico pp = new PartidoPolitico();
        try {
            ciu.setDui(Integer.parseInt(request.getParameter("txtDUI")));
            pp.setIdPartido(Integer.parseInt(request.getParameter("cmbPartido")));
            dip.setCiu(ciu);
            dip.setPartidoPolitico(pp);
            Part filePart = request.getPart("fichero"); //Obtener la parte del archivo cargado
            if (filePart != null){
                dip.setImagen(filePart.getInputStream());// Obtiene flujo de entrada del archivo de carga
            }
            if(request.getParameter("btnRegistrar")!=null){
                int val=dao.validar(dip);
                if(val==1){
                    msj="El diputado ya esta registrado";
                }else{
                    dao.insertar(dip);
                    msj="Diputado insertado";
                }
            }else if(request.getParameter("btnModificar")!=null){
                dip.setIdDiputado(Integer.parseInt(request.getParameter("txtIdDiputado")));
                dao.modificar(dip);
                msj="Diputado modificado";
            }else if(request.getParameter("btnEliminar")!=null){
                dip.setIdDiputado(Integer.parseInt(request.getParameter("txtIdDiputado")));
                dao.eliminar(dip);
                msj="Diputado eliminado";
            }else if(request.getParameter("btnModificar2")!=null){
                dip.setIdDiputado(Integer.parseInt(request.getParameter("txtIdDiputado")));
                dao.modificar2(dip);
            }
        } catch (Exception e) {
            msj= e.toString();
        }finally{
            request.getSession().setAttribute("msj", msj);
            response.sendRedirect("Administrador/diputado.jsp");
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
