// PACKAGE
package edu.unict.oop.enumerations;

public enum ModelliBicicletta {
    BIKE(20, 4),
    ELETRIC_BIKE(30, 10);
    
    // ATTRIBUTI
    private double costoAlGiorno;
    private final double costoAllOra;
    
    // COSTRUTTORI
    private ModelliBicicletta(double costoAlGiorno, double costoAllOra) {
        this.costoAlGiorno = costoAlGiorno;
        this.costoAllOra = costoAllOra;
    }
    
    // SETTER
    public void setCostoAlGiorno(double costoAlGiorno) {
        this.costoAlGiorno = costoAlGiorno;
    }
    
}
