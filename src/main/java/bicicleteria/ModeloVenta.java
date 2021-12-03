/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bicicleteria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author REY
 */
public class ModeloVenta {

    private String jdbcDriver;
    private String dbName;
    private String urlRoot;
    private ActionListener listener;

    public ModeloVenta() {
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

    public void addExceptionListener(ActionListener listener) {
        this.listener = listener;
    }

    private void reportException(String exception) {
        if (listener != null) {
            ActionEvent evt = new ActionEvent(this, 0, exception);
            listener.actionPerformed(evt);
        }
    }

    public ArrayList<String> getBicicletas() {
        ArrayList<String> bicicletas = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Establecemos la conexión
            con = DriverManager.getConnection(urlRoot + dbName, "", "");

            // Creamos la instrucción SQL y el Statement
            String sql = "SELECT * FROM bicicletas";
            stmt = con.createStatement();

            // Ejecutamos la sentencia SQL
            rs = stmt.executeQuery(sql);

            // Recorremos el resultado obtenido
            while (rs.next()) {
                String cod = rs.getString(1);
                bicicletas.add(cod);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bicicletas;
    }

    void eliminarBicicleta(String coArt) throws Exception {

        Connection con = DriverManager.getConnection(urlRoot + dbName, "", "");
        String sql = "DELETE FROM bicicletas WHERE Codigo=? LIMIT 1";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, coArt);
        stmt.execute();
    }

    List<Pieza> getPiezas() {
        List<Pieza> piezas = new ArrayList<>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // Establecemos la conexión
            con = DriverManager.getConnection(urlRoot + dbName, "", "");

            // Creamos la instrucción SQL y el Statement
            String sql = "SELECT * FROM piezas";
            stmt = con.createStatement();

            // Ejecutamos la sentencia SQL
            rs = stmt.executeQuery(sql);

            // Recorremos el resultado obtenido
            while (rs.next()) {
                String cod = rs.getString(1);
                String nom = rs.getString(2);

                Pieza piezaTemporal = new Pieza(cod, nom);
                piezas.add(piezaTemporal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return piezas;
    }

    public String altaBicicleta(String[] codPieza) {
        boolean estaCompleto = true;
        String cod = codPieza[0];
        if(codPieza.length == 6){
            for(int i = 0;i<codPieza.length;i++){
                if(cod.equals(codPieza[i])){
                    estaCompleto = true;
                }else{
                    estaCompleto = false;
                    break;
                }
            }
        }
        if (estaCompleto && codPieza.length == 6) {
            try {
                Connection con = DriverManager.getConnection(urlRoot + dbName, "", "");
                Statement stmt = con.createStatement();
                stmt.execute("INSERT INTO `bicicletas`(`Codigo`) VALUES ('" + cod + "');");
                stmt.close();
            } catch (SQLException ex) {
                reportException(ex.getMessage());
            }
        } else {
            cod = null;
        }
        return cod;
    }
    
    public void eliminarPiezas(String cod) throws Exception {
        Connection con = DriverManager.getConnection(urlRoot + dbName, "", "");
        String sql = "DELETE FROM piezas WHERE codigo=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cod);
        stmt.execute();
    }
}
 