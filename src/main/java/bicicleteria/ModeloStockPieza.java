package bicicleteria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ModeloStockPieza {

    private String jdbcDriver;
    private String dbName;
    private String urlRoot;
    private ActionListener listener;
   

    public ModeloStockPieza() {
        jdbcDriver = "com.mysql.cj.jdbc.Driver";
        urlRoot = "jdbc:mysql://127.0.0.1/";
        dbName = "bicicleteria";
        listener = null;
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            reportException(e.getMessage());
        }
    }

    public boolean alta(String nom, String codigo, ModeloVenta mv) {
        boolean estaPieza = false;
        Pieza pz = new Pieza(codigo, nom);
        List<Pieza> piezas = mv.getPiezas();
        estaPieza = piezas.contains(pz);
        if (!estaPieza) {
           try {
                Connection con = DriverManager.getConnection(urlRoot + dbName, "", "");
                Statement stmt = con.createStatement();
                stmt.execute("INSERT INTO piezas(pieza,codigo) VALUES('" + nom + "','" + codigo + "');");
                stmt.close();
            } catch (SQLException ex) {
                reportException(ex.getMessage());
            }
        }
        return estaPieza;
    }

    public void baja(String cod) {
        try {
            Connection con = DriverManager.getConnection(urlRoot + dbName, "", "");
            Statement stmt = con.createStatement();
            stmt.execute("DELETE FROM bicicletas WHERE Codigo = 'cod';");
            stmt.close();
        } catch (SQLException ex) {
            reportException(ex.getMessage());
        }
    }

    public void addExceptionListener(ActionListener listener) {
        this.listener = listener;
    }

    private void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }
    
}
