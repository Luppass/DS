package e2;

import java.util.Arrays;
import java.util.Objects;

/*
Los apartamentos pueden variar su precio, número de garajes y plazas en un futuro,
para ello la existencia de setters y variables no finales correspondientes
Las plazas de garaje se podrán añadir como parámetros tantas como deseemos
*/

public class Apartment implements Comparable<Apartment>{

    private final String ref_id;
    private float precio_base;
    private float[] plazas_garaje;
    private float surface;
    private final int codigo_postal;

    public Apartment(String ref_id, float precio_base, float surface, int codigo_postal, float...plaza){
        if (precio_base <= 0 || surface <= 0) throw new IllegalArgumentException("Negative values");
        else {
            this.ref_id = ref_id;
            this.precio_base = precio_base;
            this.plazas_garaje = plaza;
            for (float v: plazas_garaje) {
                if(v<=0) throw new IllegalArgumentException("Negative values");
            }
            this.surface = surface;
            this.codigo_postal = codigo_postal;
        }
    }

    public void setPrecio_base(float precio_base) {
        if(precio_base<=0) throw new IllegalArgumentException("Negative price");
        this.precio_base = precio_base;
    }

    public void setPlazas_garaje(float[] plazas_garaje) {
        for (float v: plazas_garaje) {
            if(v<=0) throw new IllegalArgumentException("Negative values");
        }
        this.plazas_garaje = plazas_garaje;

    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public String getRef_id() {
        return ref_id;
    }

    public Float getPrecio_base() {
        return precio_base;
    }

    public float getPlazas_garaje(int i) {
        return plazas_garaje[i];
    }

    public float getSurface() {
        return surface;
    }

    public int getNumPlazas(){
        return plazas_garaje.length;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public float getTotalPrice(){
        float total = getPrecio_base();

        for (int i = 0; i < plazas_garaje.length; i++){
            total+=getPlazas_garaje(i);
        }
        return total;
    }

    @Override
    public int compareTo(Apartment o) {
        return getRef_id().compareTo(o.getRef_id());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return Arrays.equals(plazas_garaje, ((Apartment) o).plazas_garaje)
                && Float.compare(apartment.surface, surface) == 0
                && codigo_postal == apartment.codigo_postal
                && Objects.equals(precio_base, apartment.precio_base);
    }

    @Override
    public int hashCode() {
        return Objects.hash(precio_base, Arrays.hashCode(plazas_garaje), surface, codigo_postal);
    }
}