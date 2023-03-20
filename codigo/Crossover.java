

import java.util.ArrayList;
import java.util.Random;

public class Crossover {
    private double taxa_cross=0.650000;

    public double getTaxa_cross() {
        return taxa_cross;
    }

    public void setTaxa_cross(double taxa_cross) {
        this.taxa_cross = taxa_cross;
    }
    
    public void crossover(ArrayList<Individuo> individuos, int geracao){
        int i;
        Random aleatorio = new Random();
        int corte;
        for(i=0;i<individuos.size();){ 
            if(aleatorio.nextDouble()<=getTaxa_cross()){
                corte = aleatorio.nextInt(43);
                String[] macho = {
                                    individuos.get(i).getCromossomo().substring(0, corte)
                                   ,individuos.get(i).getCromossomo().substring(corte)
                        
                                 };
                
                String[] femea = {
                    
                                    individuos.get(i+1).getCromossomo().substring(0, corte)
                                   ,individuos.get(i+1).getCromossomo().substring(corte)
                        
                                 };
                individuos.get(i).setCromossomo(macho[0]+femea[1]); 
                individuos.get(i).setNumero(Integer.toString(i)+"."+geracao);
                individuos.get(i+1).setCromossomo(femea[0]+macho[1]);
                individuos.get(i+1).setNumero(Integer.toString(i)+"."+geracao);
            } 
            i+=2;
        }
        
    }
}
