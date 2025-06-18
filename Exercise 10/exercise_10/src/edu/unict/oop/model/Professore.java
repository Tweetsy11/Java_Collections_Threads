// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.exceptions.EccezioneOperazioneIrrealizzabile;
import java.time.LocalDate;
import java.util.List;

public class Professore extends PersonaleStipendiato {
    
    // ATTRIBUTI
    private List<CompitoDidattico> compitiDidattici;
    private int anzianitaLavorativa;
   
    // COSTRUTTORI
    public Professore(List<CompitoDidattico> compitiDidattici, int anzianitaLavorativa, double stipendioBase, int oreStaordinario, double stipendioTotale, String nome, LocalDate dataDiNascita, String codiceFiscale) throws EccezioneOperazioneIrrealizzabile {
        super(stipendioBase, oreStaordinario, stipendioTotale, nome, dataDiNascita, codiceFiscale);
        this.compitiDidattici = compitiDidattici;
        setAnzianitaLavorativa(anzianitaLavorativa);
    }
    
    // GETTER
    public List<CompitoDidattico> getCompitiDidattici() {
        return compitiDidattici;
    }

    public int getAnzianitaLavorativa() {
        return anzianitaLavorativa;
    }
      
    // SETTER
    public void setCompitiDidattici(List<CompitoDidattico> compitiDidattici) {
        this.compitiDidattici = compitiDidattici;
    }

    public void setAnzianitaLavorativa(int anzianitaLavorativa) throws EccezioneOperazioneIrrealizzabile {
        if(anzianitaLavorativa < 0){
            throw new EccezioneOperazioneIrrealizzabile("Anni Di Anzianità NON possono essere NEGATIVI!"); 
        } else{
            this.anzianitaLavorativa = anzianitaLavorativa;
        }
    }
    
    @Override
    public void setOreStaordinario(int oreStaordinario) throws EccezioneOperazioneIrrealizzabile {
        if(oreStaordinario > 25){
            throw new EccezioneOperazioneIrrealizzabile("Massimo Ore Staordinario per Professore SUPERATE!");
        }else{
            super.getOreStaordinario();
        }
    }      
     
    // toString
    @Override
    public String toString() {
        return "Professore{" + "nome=" + super.getNome() + ", dataDiNascita=" + super.getCodiceFiscale()
                    + ", codiceFiscale=" + super.getCodiceFiscale() + ", stipendioBase=" + super.getStipendioBase()
                    + ", compitiDidattici=" + compitiDidattici + ", oreStaordinario=" + super.getOreStaordinario()
                    + ", anzianitaLavorativa=" + anzianitaLavorativa + ", stipendioTotale=" + super.getStipendioTotale() + '}';
    }    

    @Override
    public double CalcoloStipendio() {
        double stipendioTotale = super.getStipendioBase() + anzianitaLavorativa*(super.getStipendioBase()/50) + (super.getOreStaordinario()*20);
        return stipendioTotale;
    }
 
}
