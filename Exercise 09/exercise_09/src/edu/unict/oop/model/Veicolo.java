// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.interfaces.CostoNoleggio;

public abstract class Veicolo implements CostoNoleggio {
    
    // ATTRIBUTI
    private final String marca;
    private final String codiceTelaio;
    private final double costoBase;
    
    // COSTRUTTORI
    public Veicolo(String marca, String codiceTelaio, double costoBase) throws EccezioneOperazioneIrrealizzabile {
        this.marca = marca;
        this.codiceTelaio = codiceTelaio;
        
        if(costoBase < 0){
            throw new EccezioneOperazioneIrrealizzabile("Il Costo Base NON può avere Valore NEGATIVO!");
        }else{
            this.costoBase = costoBase;
        }
    }
    
    // GETTER
    public String getMarca() {
        return marca;
    }

    public String getCodiceTelaio() {
        return codiceTelaio;
    }

    public double getCostoBase() {
        return costoBase;
    }
    
    // toString
    @Override
    public String toString() {
        return "Veicolo{" + "marca=" + marca + ", codiceTelaio=" + codiceTelaio + ", costoBase=" + costoBase + '}';
    }
   
}
