// PACKAGE
package edu.unict.oop.model;

// IMPORT
import edu.unict.oop.interfaces.CostoCauzione;
import edu.unict.oop.interfaces.CostoNoleggio;

public class Noleggiamento {
    
    // ATTRIBUTI
    private final Veicolo veicolo;
    private Noleggio noleggio;
    
    // COSTRUTTORI
    public Noleggiamento(Veicolo veicolo, Noleggio noleggio) {
        this.veicolo = veicolo;
        this.noleggio = noleggio;
    }
    
    // GETTER
    public Veicolo getVeicolo() {
        return veicolo;
    }

    public Noleggio getNoleggio() {
        return noleggio;
    }
    
    // SETTER
    public void setNoleggio(Noleggio noleggio) {
        this.noleggio = noleggio;
    }
    
    // toString
    @Override
    public String toString() {
        return "Noleggiamento{" + "veicolo=" + veicolo + ", noleggio=" + noleggio + '}';
    }
    
    // Calcolo del Costo Totale del Noleggio
    public double CostoNoleggio(){
        
        if(veicolo == null || noleggio == null){
            return 0;
        }
        
        double costoTotaleNoleggio;

        costoTotaleNoleggio = (double)noleggio.getDurataNoleggio() * ((CostoNoleggio)veicolo).CalcolatoreCosto();
        return costoTotaleNoleggio;        
    }
   
    // Calcolo del Costo Cauzione del Noleggio
    public double CostoCauzione(){
        // DA IMPLEMENTARE
        
        if(veicolo == null || noleggio == null){
            return 0;
        }        
        
        double costoCauzione;
        
        if(veicolo instanceof CostoCauzione){
            costoCauzione = ((CostoCauzione)veicolo).CalcolatoreCauzione();
        } else {
            costoCauzione = 0;
        }

        return costoCauzione;    
    }
    
}
