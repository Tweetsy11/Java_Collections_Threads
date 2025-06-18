// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import edu.unict.oop.interfaces.Stipendio;
import java.time.LocalDate;

public abstract class PersonaleStipendiato extends Personaggio implements Stipendio {
    
    // ATTRIBUTI
    private final double stipendioBase;
    private int oreStaordinario;
    private double stipendioTotale;
    
    // COSTRUTTORI
    public PersonaleStipendiato(double stipendioBase, int oreStaordinario, double stipendioTotale, String nome, LocalDate dataDiNascita, String codiceFiscale) throws EccezioneOperazioneIrrealizzabile {
        super(nome, dataDiNascita, codiceFiscale);
        
        if(stipendioBase == 0){
            throw new EccezioneOperazioneIrrealizzabile("Stipendio Base NULLO NON VALIDO!");
        } else if (stipendioBase < 0){ 
            throw new EccezioneOperazioneIrrealizzabile("Stipendio Base NEGATIVO NON VALIDO!");
        }else{
            this.stipendioBase = stipendioBase;
        }
        
        setOreStaordinario(oreStaordinario);
        setStipendioTotale(stipendioTotale);
    }
    
    // GETTER
    public double getStipendioBase() {
        return stipendioBase;
    }

    public int getOreStaordinario() {
        return oreStaordinario;
    }

    public double getStipendioTotale() {
        return stipendioTotale;
    }
  
    // SETTER
    public void setOreStaordinario(int oreStaordinario) throws EccezioneOperazioneIrrealizzabile {
        if(oreStaordinario < 0){
            throw new EccezioneOperazioneIrrealizzabile("Le Ore di Staordinario NON posssono essere NEGATIVE!");
        }else{
            this.oreStaordinario = oreStaordinario;
        }
    }

    public void setStipendioTotale(double stipendioTotale) throws EccezioneOperazioneIrrealizzabile {
        if(oreStaordinario < 0){
            throw new EccezioneOperazioneIrrealizzabile("Lo Stipendio Totale NON può essere NEGATIVO!");
        }else{
            this.stipendioTotale = stipendioTotale;
        }
    }
    
    // toString
    @Override
    public String toString() {
        return "PersonaleStipendiato{" + "stipendioBase=" + stipendioBase + ", oreStaordinario=" + oreStaordinario 
                    + ", stipendioTotale=" + stipendioTotale + '}';
    }
    
    
    
    
}
