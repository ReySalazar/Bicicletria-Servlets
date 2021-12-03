package bicicleteria;

public abstract class Persona {

    private final String nombre;
    private final String usuario;
    private final String password;
    private final String rol;

    public Persona(String usuario, String password, String nombre, String rol) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public abstract String getVista();

    public abstract Object getRecursos();

}
