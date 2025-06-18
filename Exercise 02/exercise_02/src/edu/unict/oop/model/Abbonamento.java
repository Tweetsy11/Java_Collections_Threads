// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.enumerations.TipiFasciaPosto;
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.interfaces.VariazioneCostoAbbonamento;

public class Abbonamento {
    
    // ATTRIBUTI
    private final Utente abbonato;
    private final int codiceAbbonamento;
    private final TipiFasciaPosto posto;
    private final double costoBase;
    private double costoAbbonamento;
    
    // COSTRUTTORI
    public Abbonamento(Utente abbonato, int codiceAbbonamento, TipiFasciaPosto posto, double costoAbbonamento) throws EccezioneOperazioneIrrealizzabile {
        this.abbonato = abbonato;
        
        if(codiceAbbonamento < 0){
            throw new EccezioneOperazioneIrrealizzabile("Codice Abbonamento NON può essere NEGATIVO!");
        } else if(codiceAbbonamento == 0){
            throw new EccezioneOperazioneIrrealizzabile("Codice Abbonamento NON può essere NULLO!");
        }else{
            this.codiceAbbonamento = codiceAbbonamento;
        }
        
        this.posto = posto;             
        this.costoBase = 10;
        this.costoAbbonamento = costoAbbonamento;
    }
    
    // GETTER
    public Utente getAbbonato() {
        return abbonato;
    }

    public int getCodiceAbbonamento() {
        return codiceAbbonamento;
    }

    public TipiFasciaPosto getPosto() {
        return posto;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public double getCostoAbbonamento() {
        return costoAbbonamento;
    }
    
    // SETTER
    public void setCostoAbbonamento(double costoAbboanamento) throws EccezioneOperazioneIrrealizzabile {
        if(costoAbboanamento < 0){
            throw new EccezioneOperazioneIrrealizzabile("Costo Abbonamento NON può essere NEGATIVO!");
        } else if(costoAbboanamento == 0){
            throw new EccezioneOperazioneIrrealizzabile("Costo Abbonamento NON può essere NULLO!");
        }else{
            this.costoAbbonamento = costoAbboanamento;
        }
    }

    // toString
    @Override
    public String toString() {
        return "Abbonamento{" + "abbonato=" + abbonato + ", codiceAbbonamento=" + codiceAbbonamento 
                    + ", posto=" + posto + ", costoBase=" + costoBase 
                    + ", costoAbboanamento=" + costoAbbonamento + '}';
    }
    
    // Applicazione della Variazione del Costo dell'Abbonamento
    public double VariazioneCostoAbbonamento(){
           costoAbbonamento = costoBase + ((VariazioneCostoAbbonamento)abbonato).CalcolatoreCosto() + (costoBase * posto.getFattoreMoltiplicativo());
           return costoAbbonamento;       
    }  
}
