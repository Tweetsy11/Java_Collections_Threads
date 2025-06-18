// PACKAGE
package edu.unict.oop.exceptions;

public class EccezioneOperazioneIrrealizzabile extends Exception {
    
    public EccezioneOperazioneIrrealizzabile(){
        super("Impossibile eseguire l'operazione.");
    }
    
    public EccezioneOperazioneIrrealizzabile(String message){
        super(message);
    }
}
