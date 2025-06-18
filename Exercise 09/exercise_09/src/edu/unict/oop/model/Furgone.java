// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.interfaces.CostoCauzione;
import edu.unict.oop.interfaces.UtentePatentato;

public abstract class Furgone extends Veicolo implements UtentePatentato, CostoCauzione {
     
    // ATTRIBUTI
    private final String modello;
    private final String targa;
    
    // COSTRUTTORI
    public Furgone(String marca, String modello, String codiceTelaio, double costoBase, String targa) throws EccezioneOperazioneIrrealizzabile {
        super(marca, codiceTelaio, costoBase);
        this.modello = modello;
        this.targa = targa;
    }
    
    // GETTER
    public String getModello() {
        return modello;
    }

    public String getTarga() {
        return targa;
    }
    
    // toString
    @Override
    public String toString() {
        return "Furgone{" + "marca=" + super.getMarca() + "modello=" + modello 
                    + ", codiceTelaio=" + super.getCodiceTelaio() + ", costoBase=" + super.getCostoBase() 
                    + ", targa=" + targa + '}';
    } 
           
}
