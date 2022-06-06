
package dto;

public class Ubicacion {

    private Double lat;
    private Double lng;
    private String dato;
    
    public Ubicacion() {
    }

    public Ubicacion(Double lat, Double lng, String dato) {
        this.lat = lat;
        this.lng = lng;
        this.dato = dato;
    }
    
    
    public Ubicacion(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;

    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

   



}
