package bicicleteria;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona {

    public Vendedor(String usuario, String password, String nombre, String rol) {
        super(usuario, password, nombre, rol);
    }

    @Override
    public String getVista() {
        return "vendedor.jsp";
    }

    @Override
    public Object getRecursos() {
        String lista = "";
//        List<String> lista = new ArrayList<String>();
//        ModeloVenta m = new ModeloVenta();
//        lista = m.getBicicletas();
        return lista;
    }

}
