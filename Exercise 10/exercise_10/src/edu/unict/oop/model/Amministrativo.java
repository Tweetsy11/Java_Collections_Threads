// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.time.LocalDate;

public class Amministrativo extends PersonaleStipendiato {
    
    // ATTRIBUTI
    private final String ruolo;
    
    // COSTRUTTORI
    public Amministrativo(String ruolo, double stipendioBase, int oreStaordinario, double stipendioTotale, String nome, LocalDate dataDiNascita, String codiceFiscale) throws EccezioneOperazioneIrrealizzabile {
        super(stipendioBase, oreStaordinario, stipendioTotale, nome, dataDiNascita, codiceFiscale);
        this.ruolo = ruolo;
    }
    
    // GETTER
    public String getRuolo() {
        return ruolo;
    }
    
    // SETTER
    @Override
    public void setOreStaordinario(int oreStaordinario) throws EccezioneOperazioneIrrealizzabile {
        if(oreStaordinario > 30){
            throw new EccezioneOperazioneIrrealizzabile("Massimo Ore Staordinario per Amministrativo SUPERATE!");
        }else{
            super.getOreStaordinario();
        }
    }  
    
    // toString
    @Override
    public String toString() {
        return "Amministrativo{" + "nome=" + super.getNome() + ", dataDiNascita=" + super.getCodiceFiscale()
                    + ", codiceFiscale=" + super.getCodiceFiscale() + ", ruolo=" + ruolo 
                    + ", stipendioBase=" + super.getStipendioBase() + ", oreStaordinario=" + super.getOreStaordinario()
                    + ", stipendioTotale=" + super.getStipendioTotale() + '}';
    }    

    @Override
    public double CalcoloStipendio() {
        double stipendioTotale = super.getStipendioBase() + (super.getOreStaordinario()*10);
        return stipendioTotale;
    }

}
