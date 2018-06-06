/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.controlador;

import gov.modelo.Ciudadano;
import gov.modelo.DaoVotante;
import gov.modelo.DaoVoto;
import gov.modelo.TipoVoto;
import gov.modelo.Votante;
import gov.modelo.Voto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Nombre de la clase: ProcesarVoto
 * Versión: 1.0
 * Fecha: 03-jun-2018
 * Autor: Ulises
 */

public class ProcesarVoto extends HttpServlet {
   
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
        String[] votDip = null;
        String[] votPP = null;
        Voto voto = new Voto();
        TipoVoto tip = new TipoVoto();
        Ciudadano ciu = new Ciudadano();
        DaoVoto dao = new DaoVoto();
        Votante votante = new Votante();
        DaoVotante daoVot = new DaoVotante();
        int dui = (Integer) request.getSession().getAttribute("dui");
        try {
            if(request.getParameterValues("chkVotDip")!=null) { 
                votDip = request.getParameterValues("chkVotDip");
            }
            if(request.getParameterValues("chkVotPP")!=null) { 
                votPP = request.getParameterValues("chkVotPP");
            }
            ciu.setDui(dui);
            voto.setCiudadano(ciu);
            if(null!=votPP && votPP.length>0 && null!=votDip && votDip.length>0){
                tip.setIdTipoVoto(3);
                voto.setTipoVoto(tip);
                for (int i=0; i<votDip.length; i++) {
                    voto.setDatoVoto(Integer.parseInt(votDip[i]));
                    dao.votar(voto);
                }
            }
            if(null!=votDip && votDip.length>0 && !(null!=votPP && votPP.length>0)){
                tip.setIdTipoVoto(1);
                voto.setTipoVoto(tip);
                for (String votar : votDip) {
                    voto.setDatoVoto(Integer.parseInt(votar));
                    dao.votar(voto);
                }
            }
            if(null!=votPP && votPP.length>0 && !(null!=votDip && votDip.length>0)){
                tip.setIdTipoVoto(2);
                voto.setTipoVoto(tip);
                for (String votar : votPP) {
                    voto.setDatoVoto(Integer.parseInt(votar));
                    dao.votar(voto);
                }
            }
            
            votante.setCiudadano(ciu);
            votante.setEstado("Inactivo");
            daoVot.modificarEstado(votante);
        } catch (Exception e) {
            throw e;
        }finally{
            request.getSession().invalidate(); 
            response.sendRedirect("index.jsp");
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
            Logger.getLogger(ProcesarVoto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProcesarVoto.class.getName()).log(Level.SEVERE, null, ex);
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
