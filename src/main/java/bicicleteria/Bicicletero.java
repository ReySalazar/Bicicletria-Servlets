package bicicleteria;

public class Bicicletero extends Persona {

    public Bicicletero(String usuario, String password, String nombre, String rol) {
        super(usuario, password, nombre, rol);
    }

    @Override
    public String getVista() {
        return "bicicletero.jsp";
    }

    @Override
    public Object getRecursos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
