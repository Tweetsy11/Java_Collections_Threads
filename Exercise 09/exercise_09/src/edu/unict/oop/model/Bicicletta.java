// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.ModelliBicicletta;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Bicicletta extends Veicolo {
    
    // ATTRIBUTI
    private final ModelliBicicletta modello;
    
    // COSTRUTTORI
    public Bicicletta(ModelliBicicletta modello, String marca, String codiceTelaio, double costoBase) throws EccezioneOperazioneIrrealizzabile {
        super(marca, codiceTelaio, costoBase);
        this.modello = modello;
    }
    
    // GETTER
    public ModelliBicicletta getModello() {
        return modello;
    }
    
    // toString
    @Override
    public String toString() {
        return "Bicicletta{" + "marca=" + super.getMarca() + "modello=" + modello 
                    + ", codiceTelaio=" + super.getCodiceTelaio() + ", costoBase=" + super.getCostoBase() + '}';
    }    

    @Override
    public double CalcolatoreCosto() {
        // DA IMPLEMENTARE
        double costoBase = super.getCostoBase();   
        return costoBase;
    }
    
}
