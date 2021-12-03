package bicicleteria;

/**
 *
 * @author REY
 */
public class Pieza {

    String tipo;
    String codigo;

    public Pieza(String codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "  " + codigo + "    " + tipo + "   ";
    }

    @Override
    public boolean equals(Object p) {
        return (this.codigo.equals(((Pieza) p).codigo) && this.tipo.equals(((Pieza) p).tipo));
    }
}
