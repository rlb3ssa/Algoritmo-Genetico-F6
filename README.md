# Algoritmo-Genetico-F6

Este projeto em java utiliza conceitos básicos de um algoritmo genético para maximizar a função F6. 

A pasta [*codigo*](https://github.com/rlBessa/Algoritmo-Genetico-F6/tree/main/codigo) contém todas as classes e imagens utilizadas no algoritmo e na escrita deste documento.

A pasta [*projetoNetbeans*](https://github.com/rlBessa/Algoritmo-Genetico-F6/tree/main/projetoNetbeans) contém os arquivos dispostos conforme um projeto NetBeans.

## Função F6

  <p align="center">
  <img width="300" src="https://user-images.githubusercontent.com/61857348/194768865-146966e2-6dcc-4025-80cf-de37acd4f585.png" alt="Função F6">
  </p>


## Algoritmo Genético



## O Código

  <p align="center">
    <img width="300" src="https://user-images.githubusercontent.com/61857348/194769879-552a614d-7801-4fe0-8317-2c41897ebee8.png" alt="Tela Inicial">
  </p>
  
### Classes

[*Algoritmo-Genetico-F6*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe principal do projeto. Nela ocorre toda a interação entre as classes.

[*Gerador*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe responsável por gerar cada bit do cromossomo de forma aleatória.
 
  ```cpp
    Gerador gerador = new Gerador();
```

[*Individuo*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe que representa possíveis soluções para o problema. Cada instância desta classe representa um candidato à solução. O principal atributo da classe é o cromossomo - todos as outras atribuições ocorrem a partir dele.
 
  ```cpp
    Individuo individuo = new Individuo(String binario);
```

[*Populacao*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe que corresponde a um conjunto determinado de indivíduos (ArrayList de objetos). O tamanho da população é pré-definido em 100 indivíduos, mas pode ser alterado no menu de configurações. 
 
  ```cpp
    Populacao populacao = new Populacao(ArrayList<Individuo>);
```

[*Ordenador*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe cuja instância é responsável por ordenar uma população por ordem decrescente de aptidão, ou seja, o primeiro indivíduo do ArrayList possui a maior aptidão, o segundo possui a segunda maior e assim por diante.
 
  ```cpp
   Ordenador ordenador = new Ordenador();
```

[*Seletor*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe cuja instância seleciona quais indivíduos formarão casais de acordo com o método da Roleta. Esta função realiza uma ordenação na população de forma condicional: cada indivíduo selecionado pela roleta é adicionado à uma nova lista, permitindo que o mesmo indivíduo seja adicionado mais de uma vez. O método da classe retorna a nova lista com os indivíduos selecionados.
 
  ```cpp
    Seletor seletor = new Seletor();
```

[*Crossover*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe cuja instância realiza o cruzamento entre os indivíduos. A utilização deste recurso espera que a população já tenha sido ordenada pelos métodos da classe Seletor. Desta forma os casais estão dispostos em forma sequencial conforme sua posição na lista (população): 

  * Casal 1 - [0] e [1]
  * Casal 2 - [2] e [3]
  * Casal 3 - [4] e [5]
  * . . .
  * Casal k - posição [n] e posição [n+1]
 
 
  ```cpp
    Crossover cruzamento = new Crossover();
```

[*Mutador*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe cuja a instância é responsável por realizar mutações nos bits de um cromossomo. A ocorrência de uma mutação é controlada pela Taxa de Mutação, pré-definida em 0.008 (0.8%). Um bit é considerado mutado se seu valor for trocado (se for 0, troca para 1 e vice versa).

 
  ```cpp
    Mutador mutador = new Mutador();
```


### Dicionário de Classes e Atributos
  * **Bit:** [No contexto do código] bit é a menor unidade do vetor de caracteres. Para fins de cálculo, cada posição do vetor corresponde a 1 bit - portanto uma palavra de 44 caracteres corresponde a 44bits para o valor de K<sub>i</sub> na fórmula de codificação de binário para real. 
  * **Cromossomo:** Corresponde a uma string de 44bits. Este atributo funciona como a "assinatura" de um objeto indivíduo. Os 22 primeiros bits serão utilizados para calcular o atributo X do indivíduo e os últimos 22 bits serão utilizados para calcular o atributo Y. Cada indivíduo possui um cromossomo gerado a partir dos cromossomos de seus pais pela função Crossover e o cálculo de X e Y é realizado através da fórmula de codificação de binário para real.
  * **Indivíduo:** A partir do cromossomo, cada indivíduo recebe um valor real para seus atributos X e Y. Estes valores serão utilizados para calcular a aptidão do indivíduo. Desta forma, pode-se dizer que cada indíviduo corresponde a uma *solução* para a função F6. 
  * **Aptidão:** É o meio de determinar o quão próximos da solução (máximo global) os valores de X e Y estão. A instância desta classe possui métodos para calcular a aptidão de cada indivíduo a partir dos valores de X e Y. 
  * **População:** Uma classe composta por um ArrayList de indivíduos.
  * **Geração:** Considere uma população inicial "pais". Após passar pelas etapas de Avaliação (Roleta), Cruzamento (Crossover), Mutação (Troca de bits) e Seleção (Elitismo), a população *pais* gerou uma nova população, agora entitulada "filhos". A cada nova população *gerada* a partir de outra damos o nome de geração. Desta forma, podemos dizer que uma geração corresponde ao número de populações distintas geradas. A primeira geração é composta por indivíduos gerados de forma aleatória e recebe o nome de Geração 0, Inicial ou Parental.
  * **Avaliação:**
  * **Cruzamento:**
  * **Mutação:**
  * **Seleção:**

  

### Configurações
  
  <p align="center">
  <img width="550" src="https://user-images.githubusercontent.com/61857348/194770179-a906c85f-7b17-4777-a6a9-939e6d2d2aba.png" alt="Tela Inicial">
  </p>

  * **Tamanho da população:**
  * **Quantidade de gerações:**
  * **Taxa de mutação:**
  * **Taxa de crossover:**
  
### Descrição
  
   <p align="center">
      <img width="300" src="https://user-images.githubusercontent.com/61857348/194770182-3083f408-3448-43a3-b6d4-28de229207c6.png" alt="Tela Inicial">
   </p>

  #### Geração de Indivíduos
  
  dsadasddasd
  
   ```cpp
    public class Gerador {   
        public String bits(){ 

            String novo_cromossomo="";
            Random num_aleatorio = new Random();          
            int n_bits=44; //Declaração do tamanho da palavra(nº de bits)

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
```
      
      
  #### Divisão do Cromossomo   
  
  dasdasdasd
      
   ```cpp
    public class Gerador {   
        public String bits(){ 

            String novo_cromossomo="";
            Random num_aleatorio = new Random();          
            int n_bits=44; //Declaração do tamanho da palavra(nº de bits)

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
```
      
  #### Cálculo de Aptidão
  
  dasdasdas
      
   ```cpp
    public class Gerador {   
        public String bits(){ 

            String novo_cromossomo="";
            Random num_aleatorio = new Random();          
            int n_bits=44; //Declaração do tamanho da palavra(nº de bits)

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
```
       
  #### Seleção por Roleta
  
  asdasda
      
   ```cpp
    public class Gerador {   
        public String bits(){ 

            String novo_cromossomo="";
            Random num_aleatorio = new Random();          
            int n_bits=44; //Declaração do tamanho da palavra(nº de bits)

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
```
      
  #### Cruzamento
  
  adsdasd
      
   ```cpp
    public class Gerador {   
        public String bits(){ 

            String novo_cromossomo="";
            Random num_aleatorio = new Random();          
            int n_bits=44; //Declaração do tamanho da palavra(nº de bits)

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
```
      
  #### Mutação por troca de bit
  
  asdasdasd
      
   ```cpp
    public class Gerador {   
        public String bits(){ 

            String novo_cromossomo="";
            Random num_aleatorio = new Random();          
            int n_bits=44; //Declaração do tamanho da palavra(nº de bits)

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
```
       
  #### Elitismo
  
  asdasdasdsad
      
   ```cpp
    public class Gerador {   
        public String bits(){ 

            String novo_cromossomo="";
            Random num_aleatorio = new Random();          
            int n_bits=44; //Declaração do tamanho da palavra(nº de bits)

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
```
      
