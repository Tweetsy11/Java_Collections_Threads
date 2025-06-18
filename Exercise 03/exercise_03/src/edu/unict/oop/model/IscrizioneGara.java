// PACKAGE
package edu.unict.oop.model;

public class IscrizioneGara {
    
    // ATTRIBUTI
    private final Iscrizione iscrizione;
    private final TipiGara tipiGara;
    
    // COSTRUTTORI
    public IscrizioneGara(Iscrizione iscrizione, TipiGara tipiGara) {
        this.iscrizione = iscrizione;
        this.tipiGara = tipiGara;
    }
    
    // GETTER
    public Iscrizione getIscrizione() {
        return iscrizione;
    }

    public TipiGara getTipiGara() {
        return tipiGara;
    }
    
    // toString
    @Override
    public String toString() {
        return "IscrizioneGara{" + "iscrizione=" + iscrizione + ", tipiGara=" + tipiGara + '}';
    }
     
}
