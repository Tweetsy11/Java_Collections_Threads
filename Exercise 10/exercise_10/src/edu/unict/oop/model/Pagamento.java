// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.interfaces.Stipendio;

public class Pagamento {
    
    // ATTRIBUTI
    private final PersonaleStipendiato personaleStipendiato;
    
    // COSTRUTTORI
    public Pagamento(PersonaleStipendiato personaleStipendiato) {
        this.personaleStipendiato = personaleStipendiato;
    }
    
    // GETTER
    public PersonaleStipendiato getPersonaleStipendiato() {
        return personaleStipendiato;
    }
    
    // toString
    @Override
    public String toString() {
        return "Pagamento{" + "personaleStipendiato=" + personaleStipendiato + '}';
    }
    
    // Applicazione dello Stipendio al Personale Stipendiato (Amministrativi e Professori)
    public double Stipendio(){
        if(personaleStipendiato == null){
            return 0;
        }
        
        double stipendioTotale; 
        stipendioTotale = ((Stipendio)personaleStipendiato).CalcoloStipendio();
        return stipendioTotale;
    }
      
}
