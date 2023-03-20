
import java.util.Random;

public class Gerador {   
    public String bits(){ 
        String novo_cromossomo="";
        Random num_aleatorio = new Random();        
        //Declaração do tamanho da palavra(nº de bits)
        int n_bits=44;
        while(n_bits>0){
            if(num_aleatorio.nextInt(100)<=50){
                novo_cromossomo=novo_cromossomo+'1';
            }
            else{
                novo_cromossomo=novo_cromossomo+'0';
            }
            n_bits--;
        }
        return novo_cromossomo;
    }
}
