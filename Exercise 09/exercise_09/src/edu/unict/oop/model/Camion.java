// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Camion extends Furgone {
    
    // ATTRIBUTI
    private final double cubatura;
    
    // COSTRUTTORI
    public Camion(String marca, String modello, String codiceTelaio, double costoBase, String targa, double cubatura) throws EccezioneOperazioneIrrealizzabile {
        super(marca, modello, codiceTelaio, costoBase, targa);
        
        if(cubatura < 0){
            throw new EccezioneOperazioneIrrealizzabile("La Cubatura di un Camion NON può essere NEGATIVA!");
        } else if(cubatura == 0){
            throw new EccezioneOperazioneIrrealizzabile("La Cubatura di un Camion NON può essere NULLA!");
        } else{
            this.cubatura = cubatura;
        }
    }
    
    // GETTER
    public double getCubatura() {
        return cubatura;
    }
    
    // toString
    @Override
    public String toString() {
        return "Furgone{" + "marca=" + super.getMarca() + "modello=" + super.getModello()
                    + ", codiceTelaio=" + super.getCodiceTelaio() + ", costoBase=" + super.getCostoBase() 
                    + ", targa=" + super.getTarga() + ", cubatura=" + cubatura + '}';
    }     

    @Override
    public double CalcolatoreCosto() {
        double costoBase = super.getCostoBase();
        double costoAggiuntivo = cubatura * 10;
        double costoTotaleAlGiorno = costoBase + costoAggiuntivo;
        return costoTotaleAlGiorno;
    }
    
    @Override
    public Patente getPatente() {
        // DA IMPLEMENTARE
        return null;  
    }

    @Override
    public double CalcolatoreCauzione() {
        double costoCauzione = (CalcolatoreCosto() * 7)/2;
        return costoCauzione;
    }   
}
