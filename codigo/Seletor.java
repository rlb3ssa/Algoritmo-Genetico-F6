package algoritmogeneticof6;

import java.util.ArrayList;
import java.util.Random;

public class Seletor {
    private int roletada=100;
    private double soma;

    public double getSoma() {
        return soma;
    }

    public void setSoma(double soma) {
        this.soma = soma;
    }

    public int getRoletada() {
        return roletada;
    }

    public void setRoletada(int roletada) {
        this.roletada = roletada;
    }
    
    public void roleta(ArrayList<Individuo> individuos){
        ArrayList<Individuo> aux = new ArrayList<>();
        Random aleatorio = new Random();
        double somatorio = 0;
        int i, j, tam_populacao=individuos.size();
        double referencia = 0;
        setSoma(0);
        
        for(j=0;j<tam_populacao;j++){
            setSoma(getSoma()+individuos.get(j).getAptidao());
        }
        for(j=0;j<getRoletada();j++){
            referencia = aleatorio.nextDouble()*getSoma();
            for(i=0;i<tam_populacao;i++){
                somatorio=somatorio + individuos.get(i).getAptidao();
                if(somatorio>=referencia){
                    aux.add(individuos.get(i));
                    break;
                }
            }
            somatorio=0;
        }     
        // Atribuir à Lista da entrada a nova população em ordem dos casais
        individuos = new ArrayList<>(aux);
        
    }   
}
