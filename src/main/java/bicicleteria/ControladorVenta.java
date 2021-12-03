/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicicleteria;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author REY
 */
public class ControladorVenta extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;
    ModeloVenta m = new ModeloVenta();

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
            throws Exception {
//        this.request = request;
//        this.response = response;
//         Leer el parámetro del formulario
        String parametro = request.getParameter("instruccion");
        RequestDispatcher v = null;
        this.request = request;
        this.response = response;
        if (parametro != null) {
//        if (parametro == null) {
//            parametro = "obtener";
//        }
//
//        // Rederigir el flujo de instrucción al método adecuado
//        switch (parametro) {
//            case "obtener":
//                obtenerBicicleta(request, response);
//                break;
//            case "eliminar":
//                venderBicicleta(request, response);
//                break;
//            default:
//                obtenerBicicleta(request, response);
//        }

            String coArt = request.getParameter("CBici"); // Capturamos el codigo de la bicicleta
            m.eliminarBicicleta(coArt);
            obtenerBicicleta(request, response);
        } else {

            request.setAttribute("recursos", m.getBicicletas());
            v = request.getRequestDispatcher("/vendedor.jsp");
        }
        v.forward(request, response);
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
        //processRequest(request, response);
        obtenerBicicleta(request, response);
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
        //processRequest(request, response);
        obtenerBicicleta(request, response);
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

    private void obtenerBicicleta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.request = request;
        this.response = response;
        // --------- Obtener la lista de productos desde el modelo-------
        List<String> bicicletas = new ArrayList<String>();
        bicicletas = m.getBicicletas();

        if (bicicletas == null) {
            request.setAttribute("mensajeError", "No se encontraron bicicletas para vender");
            RequestDispatcher v = request.getRequestDispatcher("error.jsp");
            v.forward(request, response);
        } else {
            request.setAttribute("ListaBicicletas", bicicletas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/vendedor.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void obtenerPieza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.request = request;
        this.response = response;
        // --------- Obtener la lista de piezas desde el modelo-------
        List<Pieza> piezas;
        try {
            piezas = m.getPiezas();

            // -------- Agregar lista de piezas al request --------------
            request.setAttribute("ListaPiezas", piezas); // 1er argumento: nombramos a la lista como querramos, 2do argumento: pasamos la lista

            // --------- Enviar ese request a la página jsp ----------------
            RequestDispatcher dispatcher = request.getRequestDispatcher("/bicicletero.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
