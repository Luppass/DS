package e1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record Billetes(String origen, String destino, float precio, String fecha, float tiempo) {

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public float getPrecio() {
        return precio;
    }

    public Date getFecha() throws ParseException {
        return new SimpleDateFormat("dd/MM/yy").parse(fecha);
    }
}
