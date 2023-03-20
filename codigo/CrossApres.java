import java.util.Random;
public class CrossApres {

    public String[] crossover(Individuo macho, Individuo femea){
        String[] aux = new String[7];

        Random aleatorio = new Random();
        int corte;

        corte = aleatorio.nextInt(43);


        aux[0]=Integer.toString(corte);
        aux[1]=macho.getCromossomo().substring(0, corte);
        aux[2]=macho.getCromossomo().substring(corte);
        aux[3]=femea.getCromossomo().substring(0, corte);
        aux[4]=femea.getCromossomo().substring(corte);
        aux[5]=macho.getCromossomo().substring(0, corte)+femea.getCromossomo().substring(corte);
        aux[6]=femea.getCromossomo().substring(0, corte)+macho.getCromossomo().substring(corte);

        return aux;
    }
}