

import java.util.ArrayList;

public class Populacao {
    ArrayList<Individuo> individuos = new ArrayList<>();

    public Populacao(ArrayList<Individuo> individuos) {
        this.individuos=individuos;
    }    

    public ArrayList<Individuo> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(ArrayList<Individuo> individuos) {
        this.individuos = individuos;
    }   
}
