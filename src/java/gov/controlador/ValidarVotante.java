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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Nombre de la clase: ValidarVotante
 * Versión: 1.0
 * Fecha: 22-may-2018
 * Autor: Ulises
 */

public class ValidarVotante extends HttpServlet {
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
        Votante vot=new Votante();
        Ciudadano ciu = new Ciudadano();
        DaoVotante dao = new DaoVotante();
        int estado=0;
        String msj=null;
        List<Votante> lst = new ArrayList<>();
        try {
            if(request.getParameter("btnIngresar")!=null){
            ciu.setDui(Integer.parseInt(request.getParameter("txtDUI")));
            vot.setPassword(request.getParameter("txtPassword"));
            vot.setCiudadano(ciu);
            estado = dao.validarRegistro(vot);
            int idDep=0;
            int idMun=0;
            int dui = 0;
            String envio = null;
            if(estado==0){ // si estado esta en 0 significa que ya ha ejercido el voto
                msj = "El ciudadano ya ha ejercido su voto";
            }else if(estado==1){
                lst = dao.validarSesion(vot);
                if(lst.isEmpty()){
                    msj="Contraseña invalida";
                }else{
                     for(Votante vo:lst){
                        idDep = vo.getCiudadano().getDepartamento().getIdDepartamento();
                        idMun = vo.getCiudadano().getMunicipio().getIdMunicipio();
                        envio = vo.getEstado();
                    }
                    dui = ciu.getDui();
                    request.getSession().setAttribute("idDep",idDep);
                    request.getSession().setAttribute("idMun",idMun);
                    request.getSession().setAttribute("dui", dui);
                    request.getSession().setAttribute("estado", envio );
                }
            }else{
                msj="El ciudadano no esta inscrito como votante para las elecciones";
            }
        }
        } catch (Exception e) {
            throw e;
        }finally{
            request.getSession().setAttribute("msj", msj);
            response.sendRedirect("login.jsp");
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
            Logger.getLogger(ValidarVotante.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ValidarVotante.class.getName()).log(Level.SEVERE, null, ex);
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
