// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;

public class Noleggio {
   
    // ATTRIBUTI
    private final long durataNoleggio;
    private final Utente utente;
    private double costoNoleggio;
    private double cauzione;
    
    // COSTRUTTORI
    public Noleggio(long durataNoleggio, Utente utente, double costoNoleggio, double cauzione) {
        this.durataNoleggio = durataNoleggio;
        this.utente = utente;
        this.costoNoleggio = costoNoleggio;
        this.costoNoleggio = cauzione;
    }
    
    // GETTER
    public long getDurataNoleggio() {
        return durataNoleggio;
    }

    public Utente getUtente() {
        return utente;
    }

    public double getCostoNoleggio() {
        return costoNoleggio;
    }
    
    // SETTER
    public void setCostoNoleggio(double costoNoleggio) throws EccezioneOperazioneIrrealizzabile {
        if(costoNoleggio == 0){
            throw new EccezioneOperazioneIrrealizzabile("Il Costo Totale del Noleggio NON può essere NULLO!");
        } else if(costoNoleggio < 0){
            throw new EccezioneOperazioneIrrealizzabile("Il Costo Totale del Noleggio NON può essere NEGATIVO!");
        } else {
            this.costoNoleggio = costoNoleggio;
        }
    }

    public void setCauzione(double cauzione) throws EccezioneOperazioneIrrealizzabile {
        if(cauzione == 0){
            throw new EccezioneOperazioneIrrealizzabile("La Cauzione del Noleggio NON può essere NULLA!");
        } else if(cauzione < 0){
            throw new EccezioneOperazioneIrrealizzabile("La Cauzione del Noleggio NON può essere NEGATIVA!");
        } else {
            this.cauzione = cauzione;
        }
    }
    
    // toString
    @Override
    public String toString() {
        return "Noleggio{" + "durataNoleggio=" + durataNoleggio + ", utente=" + utente 
                    + ", costoNoleggio=" + costoNoleggio + ", cauzione=" + cauzione + '}';
    }
}
