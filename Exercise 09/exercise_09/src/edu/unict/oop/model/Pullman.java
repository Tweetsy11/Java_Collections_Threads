// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.interfaces.VeicoloConPasseggeri;

public class Pullman extends Furgone implements VeicoloConPasseggeri {
    
    // ATTRIBUTI
    private final int numeroPosti;
    
    // COSTRUTTORI
    public Pullman(String marca, String modello, String codiceTelaio, double costoBase, String targa, int numeroPosti) throws EccezioneOperazioneIrrealizzabile {
        super(marca, modello, codiceTelaio, costoBase, targa);
        
        if(numeroPosti < 0){
            throw new EccezioneOperazioneIrrealizzabile("Il Numero Posti Disponibili in un PullMan NON può essere NEGATIVO!");
        } else if(numeroPosti == 0){
            throw new EccezioneOperazioneIrrealizzabile("Il Numero Posti Disponibili in un PullMan NON può essere NULLO!");
        } else{
            this.numeroPosti = numeroPosti;
        }
    }
    
    // GETTER
    public double getNumeroPosti() {
        return numeroPosti;
    }
    
    // toString
    @Override
    public String toString() {
        return "Furgone{" + "marca=" + super.getMarca() + "modello=" + super.getModello()
                    + ", codiceTelaio=" + super.getCodiceTelaio() + ", costoBase=" + super.getCostoBase() 
                    + ", targa=" + super.getTarga() + ", numeroPosti=" + numeroPosti + '}';
    }  

    @Override
    public int CapienzaPasseggeri() {
        // DA IMPLEMENTARE
        return 0;
    }
    
    @Override
    public double CalcolatoreCosto() {
        double costoBase = super.getCostoBase();
        double costoAggiuntivo = numeroPosti * 15;
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