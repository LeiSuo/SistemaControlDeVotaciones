

package gov.controlador;

import gov.modelo.Ciudadano;
import gov.modelo.DaoCiudadano;
import gov.modelo.Municipio;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Nombre del documento: ProcesarCiudadano
 *  Versión             : 1.0
 *  Fecha de creación   : 08-may-2018  
 *  autor               : Gerson Baires
 */
public class ProcesarCiudadano extends HttpServlet {
   
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
        DaoCiudadano daoCiuda = new DaoCiudadano();
        String msj = null;
        Ciudadano ciuda = new Ciudadano();
        Municipio muni = new Municipio();
        try 
        {
            ciuda.setDui(request.getParameter("txtDui"));
            ciuda.setNombre(request.getParameter("txtNombre"));
            ciuda.setApellidos(request.getParameter("txtApellidos"));
            muni.setIdMunicipio(Integer.parseInt(request.getParameter("cmbMunicipio")));
            ciuda.setMunicipio(muni);
            ciuda.setGenero(request.getParameter("rdbGenero"));
            ciuda.setEdad(Integer.parseInt(request.getParameter("txtEdad")));
            ciuda.setFechaExpiracion(request.getParameter("txtFechaCad"));
            if(request.getParameter("btnRegistrar")!=null)
            {
                daoCiuda.insertarCiudadano(ciuda);
                msj="Ciudadano Registrado con Exito";
            }
            if(request.getParameter("btnModificar")!=null)
            {
                daoCiuda.modificarCiudadano(ciuda);
                msj="Ciudadano Modificado con Exito";
            }
            if(request.getParameter("btnEliminar")!=null)
            {
                daoCiuda.eliminarCiudadano(ciuda);
                msj="Ciudadano Eliminado con Exito";
            }
        } 
        catch (Exception e) 
        {
            msj = e.toString();
        }
        request.getSession().setAttribute("msj", msj);
        response.sendRedirect("Administrador/ciudadano.jsp");
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
