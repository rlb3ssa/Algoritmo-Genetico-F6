package algoritmogeneticof6;

import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

public class Individuo implements Comparable<Individuo>{
    private String cromossomo, parte1, parte2;
    private double aptidao, x, y;
    private String numero;
    private String pai, mae;
    
    

    public Individuo(String cromossomo) {
        this.cromossomo = cromossomo;
        this.seccionador();
        this.calculador();
        this.setAptidao(this.x, this.y);
    }
    
    private void seccionador(){
        String[] seccao = {
            this.cromossomo.substring(0, 22)
            ,this.cromossomo.substring(22)
        };
        this.parte1 = seccao[0];
        this.parte2 = seccao[1];
    }
    
    private void calculador(){
        this.x = decodificador(this.parte1);
        this.y = decodificador(this.parte2);
    }
    
    public double decodificador(String seccao){
        int ki = 22; // numero de bits da seccao
        double real=0; 
        int xibin = Integer.parseInt(seccao, 2); 
        real=((200*xibin)/(pow(2,ki)-1))-100;
        return real;
    }
    
    public final void setAptidao(double xi, double yi) {
        
        this.aptidao = 0.5 - (
            (pow(sin(sqrt(pow(xi,2) + pow(yi,2))),2)-0.5)
            /
            pow((1 + (pow(xi,2) + pow(yi,2))*0.001),2)
        );
        
    }
    
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String familia) {
        
        this.numero = familia;
    }    

    public String getCromossomo() {
        return cromossomo;
    }

    public void setCromossomo(String cromossomo) {
        this.cromossomo = cromossomo;
        this.seccionador();
        this.calculador();
        this.setAptidao(this.x, this.y);
    }

    public double getAptidao() {
        return aptidao;
    }

    
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }  

    public String getParte1() {
        return parte1;
    }

    public void setParte1(String parte1) {
        this.parte1 = parte1;
    }

    public String getParte2() {
        return parte2;
    }

    public void setParte2(String parte2) {
        this.parte2 = parte2;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }
    
    

    @Override
    public String toString() {
        return "Família: "+ this.getNumero() +"\nCromossomo: " + this.getCromossomo() + "\nX = " + this.getX() + "\nY = " + this.getY()+ "\nAptidao = " + this.getAptidao() + "\n";
    }
    
    @Override 
    public int compareTo(Individuo individuo) { 
        if (this.aptidao > individuo.getAptidao()) { 
            return -1; 
        } 
        if (this.aptidao < individuo.getAptidao()) { 
            return 1; 
        } 
        return 0; 
    }
    
}
