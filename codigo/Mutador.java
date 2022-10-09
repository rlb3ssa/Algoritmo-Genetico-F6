package algoritmogeneticof6;

import java.util.ArrayList;
import java.util.Random;

public class Mutador {
    private double taxa_mutacao= 0.008;
    private int mutacoes = 0;
    public double getTaxa_mutacao() {
        return taxa_mutacao;
    }

    public void setTaxa_mutacao(double taxa_mutacao) {
        this.taxa_mutacao = taxa_mutacao;
    }

    public int getMutacoes() {
        return mutacoes;
    }

    public void setMutacoes(int mutacoes) {
        this.mutacoes = mutacoes;
    }
    
    
    public void inversao_de_bit(ArrayList<Individuo> individuos){
        int i,j, mutou=0;
        double assinatura;
        char[] aux = new char[45];
        Random aleatorio = new Random();
        String cromossomo = new String(); 
        setMutacoes(0);
        
        for(i=0;i<individuos.size();i++){
            cromossomo="";
            for(j=0;j<individuos.get(i).getCromossomo().length();j++){
                aux[j]=individuos.get(i).getCromossomo().charAt(j);
                assinatura = aleatorio.nextDouble();
                if(assinatura<=getTaxa_mutacao()){
                    if(aux[j]=='0') {
                        aux[j]='1';
                    }
                    else if(aux[j]=='1'){
                        aux[j]='0';
                    }
                    mutou++;
                }
                cromossomo=cromossomo+aux[j];                    
            }
            individuos.get(i).setCromossomo(cromossomo);
            setMutacoes(mutou);
        }     
    }  
}
