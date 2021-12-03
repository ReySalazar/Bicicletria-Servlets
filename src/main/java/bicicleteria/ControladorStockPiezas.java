package bicicleteria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorStockPiezas extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;

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
            throws ServletException, IOException, Exception {
        ModeloVenta mv = new ModeloVenta();
        ModeloStockPieza m = new ModeloStockPieza();
        this.request = request;
        this.response = response;
        String parametro = request.getParameter("instruccion");
        PrintWriter out = response.getWriter();
        RequestDispatcher v = null;
        switch (parametro) {
            case "carga":
                String pieza = request.getParameter("nuevaPieza");
                String codigo = request.getParameter("codigo");
                m.addExceptionListener(new ExceptionListener());
                boolean esta = m.alta(pieza, codigo, mv);
                if (esta) {
                    response.setContentType("text/html;charset=UTF-8");
                    out.println("<h1>ERROR</h1><p>El código ya fué asignado a  este tipo de pieza, intente con otro</p>");
                } else {
                    out.println("<h1>Pieza de bicicleta agregada correctamente</h1>");
                }
                v = request.getRequestDispatcher("encargado.jsp");
                break;
            case "eliminar":
                String cod = request.getParameter("codigo");
                mv.eliminarBicicleta(cod);
                out.println("<h1>Venta exitosa!!</h1>");
                v = request.getRequestDispatcher("vendedor.jsp");
                break;
            case "alta":
                String[] piezas = request.getParameterValues("multiple");
                m.addExceptionListener(new ExceptionListener());
                String nom = mv.altaBicicleta(piezas);
                mv.eliminarPiezas(nom);
                if (nom == null) {
                    out.println("<h1>La bicicleta no fue agregada por códigos incompatibles ó piezas insuficientes</h1>");
                } else {
                    out.println("<h1>Bicicleta con código " + nom + " agregada correctamente al stock");
                }
                break;
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private class ExceptionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String exception = e.getActionCommand();
                request.setAttribute("mensajeError", exception);
                RequestDispatcher v = request.getRequestDispatcher("error.jsp");
                v.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControladorStockPiezas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ControladorStockPiezas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
