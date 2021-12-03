package bicicleteria;

import java.util.ArrayList;
import java.util.List;

public class Encargado extends Persona {

    public Encargado(String usuario, String password, String nombre, String rol) {
        super(usuario, password, nombre, rol);
    }

    @Override
    public String getVista() {
        return "encargado.jsp";
    }

    @Override
    public Object getRecursos() {
        List<String> piezas = new ArrayList<String>();
        piezas.add("Asiento");
        piezas.add("Cuadro");
        piezas.add("KitMecanico");
        piezas.add("Manubrio");
        piezas.add("Rueda x2");
        piezas.add("Pedal x2");
        return piezas;
    }

}
