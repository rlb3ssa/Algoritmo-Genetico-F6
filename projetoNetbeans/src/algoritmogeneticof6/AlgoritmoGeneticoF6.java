package algoritmogeneticof6;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/* Referências */
//https://www.baeldung.com/java-genetic-algorithm
//https://pt.slideshare.net/ArthurEmanuel/java-introducao-ao-swing

public class AlgoritmoGeneticoF6 {
    public static void main(String[] args) {
        // Indivíduo genérico
        Individuo individuo, solucao;
        
        // População de pais e filhos
        Populacao pais, filhos, amostra  = null;
        
        // População genérica        
        ArrayList<Individuo> populacao = new ArrayList<>();
        ArrayList<Individuo> populacao_aux = new ArrayList<>();
        
        // Agentes modificadores
        Gerador gerador = new Gerador(); // Gerador de bits - gerador.bits();
        Ordenador organizador = new Ordenador(); // Ordenar por ordem crescente de aptidão
        Crossover cruzamento = new Crossover(); // Realiza o cruzamento entre dois individuos. Para setar a taxa de crossover: cruzamento.setTaxa_cross(valor entre 0 e 1);
        Mutador mutacao = new Mutador(); // Setar a taxa de mutação: mutacao.setTaxa_mutacao(valor entre 0 e 1);
        Seletor selecao = new Seletor(); // Setar a quantidade de vezes que será feita a roleta(valor): cruzamento.setTaxa_cross(valor entre 0 e 1);
        CrossApres crossApres = new CrossApres(); // Realiza o cruzamento entre dois individuo no modo apresentação
        
        // Definindo variáveis
        Random aleatorio = new Random();       
        int tam_populacao = 100, geracoes=100000, total_individuos=0, mutados=0; // Variáveis modificáveis através do menu de configurações
        int i,g,j; // Contadores
        int menu=0, algo=0, config=0, geracao=0, apres=0, solu=0; // Controladores para os botões do menu
        String transportador = new String(); // Transportador de cromossomo
        ImageIcon icon = new ImageIcon("Gerador.png");
        ImageIcon icon1 = new ImageIcon("Seccionador.png");
        ImageIcon icon2 = new ImageIcon("Aptidao.png");
        ImageIcon icon3 = new ImageIcon("Roleta.png");
        ImageIcon icon4 = new ImageIcon("Cruzamento.png");
        ImageIcon icon5 = new ImageIcon("Mutacao.png");
        ImageIcon icon6 = new ImageIcon("Elitismo.png");
        
        
        
        // Elementos do menu de opções
        Object[] opcoes_menu = {"Algoritmo", "Configurações", "Sair"}; 
        Object[] opcoes_algo = {"Apresentação","Rodar algoritmo","Voltar"};
        Object[] opcoes_config = {"Tamanho da População", "Quantidade de gerações", "Taxa de mutação", "Taxa de crossover","Voltar"};
        Object[] opcoes_solu = {"Sim", "Não"};
        Object[] aux0 = {"Voltar","Divisão do cromossomo"};
        Object[] aux1 = {"Geração", "Calculo de Aptidão"};
        Object[] aux2 = {"Divisão do cromossomo", "Seleção por Roleta"};
        Object[] aux3 = {"Calculo de Aptidão", "Cruzamento"};
        Object[] aux4 = {"Seleção por Roleta",  "Mutação por troca de bit"};
        Object[] aux5 = {"Cruzamento", "Elitismo"};
        Object[] aux6 = {"Mutação por troca de bit","Concluir"};

        // Menu de opções
        while(menu!=2){
            algo=0;
            config=0;
            apres=0;
            menu=JOptionPane.showOptionDialog(null , "Selecione uma opção:" , "Algoritmo Genético - F6" , JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE  ,null , opcoes_menu , 0);
            
            switch(menu){
                
                
//######################################### Botão fechar janela 1 ############################################################################
                case -1 -> menu=2;
//######################################### Botão fechar janela 1 ############################################################################

                
//######################################### Botão Algoritmo ############################################################################
                case 0 -> {
                    while (algo!=2) {
                        algo=JOptionPane.showOptionDialog(null , "Selecione uma opção:" , "Algoritmo" , JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE  ,null , opcoes_algo , 0);
                        switch(algo){
                            // ------------ Botão fechar janela 2 ------------------
                            case -1:
                                algo=2;
                                break;
                                // ----------- Botão fechar janela 2 ---------------
                                // ------------ Apresentação ------------------------------------------------------------------------------------------
                            case 0:
                                geracao=0;
                                apres=0;
                                for(i=0;i<7 && i!=-1;){
                                    switch(i){
                                        case -1:
                                            algo=2;
                                            break;
                                            
                                        case 0:
                                            g = geracoes;
                                            /* Gerando os primeiros indivíduos */
                                            for(j=0;j<tam_populacao;j++){
                                                populacao_aux.add(new Individuo(gerador.bits()));                                  
                                                populacao_aux.get(j).setNumero(Integer.toString(j));
                                            }
                                            /* Criando a População 0 */                                       
                                            amostra = new Populacao(populacao_aux);                                            
                                            organizador.ordenar(amostra.getIndividuos());
                                            transportador = amostra.getIndividuos().get(0).getCromossomo();
                                            apres=JOptionPane.showOptionDialog(
                                                    null,
                                                    "São gerados os primeiros "
                                                            + tam_populacao
                                                            + " indivíduos:\n- - - - - - - - - - - - - - - - - - - - - - [Indivíduo Aleatório] - - - - - - - - - - - - - - - - - - -\n"
                                                            + amostra.getIndividuos().get(aleatorio.nextInt(tam_populacao)).toString()
                                                            +"\n- - - - - - - - - - - - - - - - - - - - - - - [Melhor indivíduo] - - - - - - - - - - - - - - - - - - - -\n"
                                                            + amostra.getIndividuos().get(0).toString()
                                                            +"\n\n", "Geração de Indivíduos" , JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE  ,icon , aux0 , 1);
                                            if(apres==0 || apres==-1){
                                                i=-1;
                                            }
                                            else{
                                                i++;
                                            }
                                            break;
                                            
                                        case 1:
                                            apres=JOptionPane.showOptionDialog(null , "Cada indivíduo tem seu cromossomo(44 bits) dividido em duas \npartes iguais(22 bits)."
                                                    +" Com a primeira parte é calculado o valor\n de X, e com a segunda, o valor de Y."
                                                    +"\n- - - - - - - - - - - - - - - - - - - - - - - - [Melhor indivíduo] - - - - - - - - - - - - - - - - - - - - - - - -\n\nCromossomo: "
                                                    +amostra.getIndividuos().get(0).getCromossomo()
                                                    +"\n\nSeccionamento: ["
                                                    +amostra.getIndividuos().get(0).getParte1()
                                                    +"] ["
                                                    +amostra.getIndividuos().get(0).getParte2()
                                                    +"]\n\nParte 1(0-21): "
                                                    +amostra.getIndividuos().get(0).getParte1()
                                                    +"  ===> X = "
                                                    +amostra.getIndividuos().get(0).getX()
                                                    +"\nParte 2(22-43): "
                                                    +amostra.getIndividuos().get(0).getParte2()
                                                    +"  ===> Y = "
                                                    +amostra.getIndividuos().get(0).getY()
                                                    +"\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n\n" , "Divisão do cromossomo" , JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE  ,icon1 , aux1 , 1);
                                            switch (apres) {
                                                case -1 -> i=-1;
                                                case 0 -> i--;
                                                default -> i++;
                                            }
                                            break;


                                            
                                        case 2:
                                            apres=JOptionPane.showOptionDialog(null , "A partir dos valores de X e Y, cada indivíduo tem sua aptidão calculada.\n\n"
                                                    +"Individuo: "
                                                    +amostra.getIndividuos().get(0).getCromossomo()
                                                    +"\n\nX = "
                                                    +amostra.getIndividuos().get(0).getX()
                                                    +"\nY = "
                                                    +amostra.getIndividuos().get(0).getY()
                                                    +"\n\nAptidão: "
                                                    +amostra.getIndividuos().get(0).getAptidao()
                                                    +"\n\n\n", "Calculo de Aptidão" , JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE  ,icon2 , aux2 , 1);
                                            switch (apres) {
                                                case -1 -> i=-1;
                                                case 0 -> i--;
                                                default -> i++;
                                            }
                                            break;


                                            
                                        case 3:
                                            selecao.roleta(amostra.getIndividuos());
                                            apres=JOptionPane.showOptionDialog(null,"Primeiramente é calculado o somatório da aptidão de todos os indivíduos da população.\n"
                                                                                +"Isto é realizado pelo primeiro 'for' no código ao lado.\n\nSomatório: "
                                                                                +selecao.getSoma()
                                                                                +"\n\nEm seguida um número aleatório entre 0 e "
                                                                                +selecao.getSoma()
                                                                                +" é gerado e armazenado\nna variável 'referencia'. O primeiro membro da população, cuja aptidão somada "
                                                                                +"às\naptidões dos membros precedentes for maior ou igual a este número aleatório, é selecionado.\n"
                                                                                +"\nEstas eatapas são realizadas pelo segundo e terceiro 'for' no código da imagem."
                                                                                +"\n\nPor fim, este processo ocorre até que sejam selecionados 50 casais, sendo possível\nque o mesmo indivíduo seja selecionado mais de uma vez."
                                                                                +"\n\n\n", "Seleção por Roleta", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,icon3, aux3, 1);
                                            switch (apres) {
                                                case -1 -> i=-1;
                                                case 0 -> i--;
                                                default -> i++;
                                            }
                                            break;


                                            
                                        case 4:
                                            String[] controle = new String[7];
                                            controle=crossApres.crossover(amostra.getIndividuos().get(0),amostra.getIndividuos().get(1));                                            
                                            apres=JOptionPane.showOptionDialog(null , "Os cromossomos, do macho e da fêmea, são cortados em uma posição aleatória.\n\nPosição aleatória gerada: "
                                                                                    +controle[0]
                                                                                    +"\nTaxa de crossover: "
                                                                                    +cruzamento.getTaxa_cross()
                                                                                    +"\n\n[Macho]\nCromossomo: "
                                                                                    +amostra.getIndividuos().get(0).getCromossomo()
                                                                                    +"\nCabeça: "
                                                                                    +controle[1]
                                                                                    +"\nCauda: "
                                                                                    +controle[2]
                                                                                    +"\n\n[Fêmea]\nCromossomo: "
                                                                                    +amostra.getIndividuos().get(1).getCromossomo()
                                                                                    +"\nCabeça: "
                                                                                    +controle[3]
                                                                                    +"\nCauda: "
                                                                                    +controle[4]
                                                                                    +"\n\n\nA cabeça do macho é concatenada com a cauda da fêmea, gerando assim o cromossomo do primeiro filho."
                                                                                    +"\n[Filho 1]\nCabeça: "
                                                                                    +controle[1]
                                                                                    +"\nCauda: "
                                                                                    +controle[4]
                                                                                    +"\nCromossomo: "
                                                                                    +controle[5]
                                                                                    +"\n\nDa mesma forma, a cabeça da fêmea é concatenada com a cauda do macho, gerando então o segundo filho."
                                                                                    +"\n[Filho 2]\nCabeça: "
                                                                                    +controle[3]
                                                                                    +"\nCauda: "
                                                                                    +controle[2]
                                                                                    +"\nCromossomo: "
                                                                                    +controle[6]
                                                                                    +"\n\n\n", "Cruzamento" , JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE  ,icon4 , aux4 , 1);
                                            
                                            switch (apres) {
                                                case -1 -> i=-1;
                                                case 0 -> i--;
                                                default -> i++;
                                            }
                                            cruzamento.crossover(amostra.getIndividuos(), geracao);
                                            break;


                                            
                                        case 5:
                                            organizador.ordenar(amostra.getIndividuos());
                                            individuo = new Individuo(amostra.getIndividuos().get(0).getCromossomo());                                     
                                            mutacao.inversao_de_bit(amostra.getIndividuos());
                                            organizador.ordenar(amostra.getIndividuos());
                                            apres=JOptionPane.showOptionDialog(null , "Durante a mutação, cada bit do cromossomo de um indíviduo recebe um valor aleatório entre 0 e 1.\n"
                                                                                    +"Se este valor for menor ou igual à taxa de mutação, aquele bit é trocado:\n- se for 0 é trocado por 1\n- se for 1 é trocado por 0\n"
                                                                                    +"Este procedimento é repetido com todos os indivíduos da população inserida como parâmetro.\n\n"
                                                                                    +"[Quantidade de indivíduos na população]: "
                                                                                    +tam_populacao
                                                                                    +"\n\n[Taxa de mutação]: "
                                                                                    +mutacao.getTaxa_mutacao()
                                                                                    +"\n\n[Melhor individuo]:\nCromossomo antes da mutação - "
                                                                                    +individuo.getCromossomo()
                                                                                    +"\nCromossomo após a mutação    -  "
                                                                                    +amostra.getIndividuos().get(0).getCromossomo()
                                                                                    +"\n\n[Quantidade de bits que sofreram mutações em toda a população]: "
                                                                                    +mutacao.getMutacoes()
                                                                                    +"\n\n", "Mutação por troca de bit" , JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE  ,icon5 , aux5 , 1);
                                                                                    
                                            
                                            switch (apres) {
                                                case -1 -> i=-1;
                                                case 0 -> i--;
                                                default -> i++;
                                            }
                                            break;


                                            
                                        case 6:     
                                            individuo = new Individuo(transportador);
                                            organizador.ordenar(amostra.getIndividuos());                                            
                                            apres=JOptionPane.showOptionDialog(null , "A população de pais é ordenada por aptidão e o melhor indivíduo é selecionado.\n\n"
                                                                                    +"[Melhor Pai]\n"
                                                                                    +individuo.toString()                                                                                                                                                                      
                                                                                    +"\nEm seguida um filho aleatório é substituido, na lista de filhos, pelo pai com maior aptidão.\n"
                                                                                    +"\n[Filho aleatório]\n"
                                                                                    +amostra.getIndividuos().get(aleatorio.nextInt(tam_populacao)).toString()                                             
                                                                                    +"\n\nPor fim, a lista de pais é eliminada e os filhos passam a ser a nova lista de pais."                                                                                   
                                                                                    +"\n\n", "Elitismo" , JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE  ,icon6 , aux6 , 1);
                                            if(apres==0){
                                                i--;
                                            }
                                            else i=-1;
                                            break;
                                            
                                        case 7:                                            
                                            break;
                                            
                                        default:
                                            break;
                                    }
                                    
                                }
                                break;
                                // ------------ Apresentação ----------------------------------------------------------------------------------------
                                
                                // ------------ Rodar Algoritmo -------------------------------------------------------------------------------------
                            case 1:
                                geracao=0;
                                g = geracoes;
                                solu=1;
                                /* Gerando os primeiros indivíduos */
                                for(i=0;i<tam_populacao;i++){          
                                    populacao.add(new Individuo(gerador.bits()));
                                    populacao.get(i).setNumero(Integer.toString(i)+"."+Integer.toString(geracao));
                                }
                                /* Criando a População 0 */
                                pais = new Populacao(new ArrayList<>(populacao));
                                solucao = new Individuo(pais.getIndividuos().get(0).getCromossomo());
                                total_individuos=0;
                                /* Iniciando o ciclo de gerações */
                                while(g>0){
                                    
                                    /* Seleção pela Roleta */
                                    selecao.roleta(pais.getIndividuos());
                                    

                                    /* Cruzamento */                                
                                    cruzamento.crossover(pais.getIndividuos(), geracao);
                                    filhos = new Populacao(new ArrayList<>(pais.getIndividuos()));
                                    
                                    
                                    /* Mutação */
                                    mutacao.inversao_de_bit(filhos.getIndividuos());
                                    mutados+= mutacao.getMutacoes();
                                    
                                    
                                    /* Elitismo */
                                    organizador.ordenar(pais.getIndividuos());
                                    filhos.getIndividuos().remove(aleatorio.nextInt(tam_populacao));
                                    filhos.getIndividuos().add(new Individuo(pais.getIndividuos().get(0).getCromossomo()));
                                    if(solucao.getAptidao()<=pais.getIndividuos().get(0).getAptidao()){
                                        solucao.setCromossomo(pais.getIndividuos().get(0).getCromossomo());
                                    }
                                    System.out.println("\n\n############ GERAÇÃO ["+geracao+"] ############\n"+pais.getIndividuos().get(0).toString()+"########################################");                                    
                                    pais = new Populacao(new ArrayList<>(filhos.getIndividuos()));  
                                    geracao++;
                                    total_individuos+=100;
                                    g--;
                                    
                                    if(solucao.getAptidao()>=0.9999999 && solu!=0){
                                        solu=JOptionPane.showOptionDialog(null , "            Melhor indivíduo encontrado após "
                                                                                +geracao
                                                                                +" gerações:\n"
                                                                                +solucao.toString()
                                                                                +"\nContinuar rodando algoritmo?\n\n" , "Algoritmo Genético - F6" , JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE  ,null , opcoes_solu , 0);
                                        if(solu!=0){
                                            break;
                                        }                                                                               
                                    }
                                    //-----------------Gerar gráfico--------------------------
                                
                                
                                
                                }
                                JOptionPane.showMessageDialog(null, "                             RESULTADOS DAS EVOLUÇÕES\n\nQuantidade de gerações: "
                                                    +geracao                                                        
                                                    +"\nQuantidade de indivíduos: "
                                                    +total_individuos
                                                    +"\nQuantidade de mutações em bits: "
                                                    +mutados
                                                    +"\n\n                    MELHOR INDIVÍDUO DE TODAS AS GERAÇÕES\n\n" 
                                                    + solucao.toString()
                                                    
                                                    +"\n\n");
                                break;
                                // ------------ Rodar Algoritmo ---------------------------------------------------------------------------------------
                                
                                // ---------------- Voltar -----------------
                            case 2:                                                              
                                break;
                                // ---------------- Voltar -----------------
                                
                                // ---------------- Default -----------------
                            default:
                                // Tratamento de exceções
                                break;
                                // ---------------- Default -----------------
                        }
                    } 
                }
                
//######################################### Botão Algoritmo ############################################################################                
                
//######################################### Botão Configurações ############################################################################
                case 1 -> {
                    config=0;
                    while(config!=-1){
                        config=JOptionPane.showOptionDialog(null , "Tamanho da população:  ["
                                                                +tam_populacao
                                                                +"]        Quantidade de gerações:  ["
                                                                +geracoes   
                                                                +"]        Taxa de mutação:  ["
                                                                +mutacao.getTaxa_mutacao()
                                                                +"]        Taxa de crossover:  ["
                                                                +cruzamento.getTaxa_cross()                                                                
                                                                +"]\n\n\nSelecione uma opção:\n\n" , "Configurações" , JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.INFORMATION_MESSAGE  ,null , opcoes_config , 0);
                        
                        switch(config){
                            case -1 -> {
                                break;
                            }
                            case 0 -> {
                            //tamanho da pop
                                transportador=JOptionPane.showInputDialog("Digite o tamanho da população:") ;                                
                                if(transportador!=null){
                                    tam_populacao = Integer.parseInt(transportador);
                                }
                                
                            }
                            case 1 -> {
                            //geracoes
                                transportador=JOptionPane.showInputDialog("Digite a quantidade de gerações:");
                                if(transportador!=null){
                                    geracoes = Integer.parseInt(transportador);
                                }
                            }
                            case 2 -> {
                                transportador=JOptionPane.showInputDialog("Digite a taxa de mutação:");
                                if(transportador!=null){                           
                                    mutacao.setTaxa_mutacao(Double.parseDouble(transportador));
                                }
                                
                            }
                            case 3 -> {
                                transportador=JOptionPane.showInputDialog("Digite a taxa de crossover:");
                                if(transportador!=null){                           
                                    cruzamento.setTaxa_cross(Double.parseDouble(transportador));
                                }                 
                            }                           
                            case 4 -> {
                                config=-1;
                                break;
                            }
                        }
                    }
                    
                }
//######################################### Botão Configurações ############################################################################
                
//######################################### Botão Sair ############################################################################                
                case 2 -> menu=2;               
//######################################### Botão Sair ############################################################################                    
                // Tratamento de exceções    
                default -> {
                }
            }

            
        }
     
    }
    
}


       
        