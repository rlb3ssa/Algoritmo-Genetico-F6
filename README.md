# Algoritmo-Genetico-F6

Este projeto em java utiliza conceitos básicos de um algoritmo genético para maximizar a função F6. 

A pasta [*codigo*](https://github.com/rlBessa/Algoritmo-Genetico-F6/tree/main/codigo) contém todas as classes e imagens utilizadas no algoritmo e na escrita deste documento.

A pasta [*projetoNetbeans*](https://github.com/rlBessa/Algoritmo-Genetico-F6/tree/main/projetoNetbeans) contém os arquivos dispostos conforme um projeto NetBeans.

## Função F6

  <p align="center">
  <img width="300" src="https://user-images.githubusercontent.com/61857348/194768865-146966e2-6dcc-4025-80cf-de37acd4f585.png" alt="Função F6">
  </p>


## Algoritmo Genético


<p align="center">
  <img width="300" src="https://user-images.githubusercontent.com/61857348/194787726-0ef0e9f9-df87-4e8a-aa1c-70bef235fab8.png" alt="Função F6">
  </p>
  

  <p align="center">
  <img width="300" src="https://user-images.githubusercontent.com/61857348/194788403-d28add02-a2d8-4e38-9202-ad15e3362ffc.png" alt="Função F6">
  </p>
  

## O Código
   <p align="center">
     <img width="300" src="https://user-images.githubusercontent.com/61857348/194769879-552a614d-7801-4fe0-8317-2c41897ebee8.png" alt="Tela Inicial">
   </p>
   
### Classes
>  
> [*Algoritmo-Genetico-F6*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe principal do projeto. Nela ocorre toda a interação entre as classes.
> 
> [*Gerador*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe responsável por gerar cada bit do cromossomo de forma aleatória.
>> 
>>   ```cpp
>>     Gerador gerador = new Gerador();
>> ```
>
> [*Individuo*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe que representa possíveis soluções para o problema. Cada instância desta classe representa um candidato à solução. O principal atributo da classe é o cromossomo - todos as outras atribuições ocorrem a partir dele.
>> 
>>   ```cpp
>>     Individuo individuo = new Individuo(String binario);
>> ```
>
> [*Populacao*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe que corresponde a um conjunto determinado de indivíduos (ArrayList de objetos). O tamanho da população é pré-definido em 100 indivíduos, mas pode ser alterado no menu de configurações. 
>> 
>>   ```cpp
>>     Populacao populacao = new Populacao(ArrayList<Individuo>);
>> ```
>
> [*Ordenador*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe cuja instância é responsável por ordenar uma população por ordem decrescente de aptidão, ou seja, o primeiro indivíduo do ArrayList possui a maior aptidão, o segundo possui a segunda maior e assim por diante.
>> 
>>   ```cpp
>>    Ordenador ordenador = new Ordenador();
>> ```
>
> [*Seletor*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe cuja instância seleciona quais indivíduos formarão casais de acordo com o método da Roleta. Esta função realiza uma ordenação na população de forma condicional: cada indivíduo selecionado pela roleta é adicionado à uma nova lista, permitindo que o mesmo indivíduo seja adicionado mais de uma vez. O método da classe retorna a nova lista com os indivíduos selecionados.
>> 
>>   ```cpp
>>     Seletor seletor = new Seletor();
>> ```
>
> [*Crossover*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe cuja instância realiza o cruzamento entre os indivíduos. A utilização deste recurso espera que a população já tenha sido ordenada pelos métodos da classe Seletor. Desta forma os casais estão dispostos em forma sequencial conforme sua posição na lista (população): 
>> 
>>   * Casal 1 - [0] e [1]
>>   * Casal 2 - [2] e [3]
>>   * Casal 3 - [4] e [5]
>>   * . . .
>>    * Casal k - posição [n] e posição [n+1]
>>  
>> 
>>   ```cpp
>>     Crossover cruzamento = new Crossover();
>> ```
>
> [*Mutador*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe cuja a instância é responsável por realizar mutações nos bits de um cromossomo. A ocorrência de uma mutação é controlada pela Taxa de Mutação, pré-definida em 0.008 (0.8%). Um bit é considerado mutado se seu valor for trocado (se for 0, troca para 1 e vice versa).
>> 
>>   ```cpp
>>     Mutador mutador = new Mutador();
>> ```

  
### Dicionário de Classes e Atributos
> * **Bit:** [No contexto do código] bit é a menor unidade do vetor de caracteres. Para fins de cálculo, cada posição do vetor corresponde a 1 bit - portanto uma palavra de 44 caracteres corresponde a 44bits para o valor de K<sub>i</sub> na fórmula de codificação de binário para real. 
> * **Cromossomo:** Corresponde a uma string de 44bits. Este atributo funciona como a "assinatura" de um objeto indivíduo. Os 22 primeiros bits serão utilizados para calcular o atributo X do indivíduo e os últimos 22 bits serão utilizados para calcular o atributo Y. Cada indivíduo possui um cromossomo gerado a partir dos cromossomos de seus pais pela função Crossover e o cálculo de X e Y é realizado através da fórmula de codificação de binário para real.
> * **Indivíduo:** A partir do cromossomo, cada indivíduo recebe um valor real para seus atributos X e Y. Estes valores serão utilizados para calcular a aptidão do indivíduo. Desta forma, pode-se dizer que cada indíviduo corresponde a uma *solução* para a função F6. 
> * **Aptidão:** É o meio de determinar o quão próximos da solução (máximo global) os valores de X e Y estão. A instância desta classe possui métodos para calcular a aptidão de cada indivíduo a partir dos valores de X e Y. 
> * **População:** Uma classe composta por um ArrayList de indivíduos.
> * **Geração:** Considere uma população inicial "pais". Após passar pelas etapas de Avaliação (Roleta), Cruzamento (Crossover), Mutação (Troca de bits) e Seleção (Elitismo), a população *pais* gerou uma nova população, agora entitulada "filhos". A cada nova população *gerada* a partir de outra damos o nome de geração. Desta forma, podemos dizer que uma geração corresponde ao número de populações distintas geradas. A primeira geração é composta por indivíduos gerados de forma aleatória e recebe o nome de Geração 0, Inicial ou Parental.
> * **Avaliação:** É a técnica de aferir o quão "apto" aquele indivíduo é para solucionar o problema. No caso do algoritmo em questão, a aptidão corresponde ao quão próximo da solução aquele indivíduo está.
> * **Cruzamento:** É a técnica de gerar novos indivíduos a partir dos indivíduos existentes, mantendo características desejáveis. Existem diversos métodos de realizar o cruzamento. Neste algortimo foi utilizado a técnica de Crossover.
> * **Mutação:** É a técnica responsável por promover modificações no cromossomo do invidíduo. Ela permite que o algoritmo saia de "ótimos locais" promovendo o surgimento de características independentes das de seus pais. A técnica de mutação utilizada neste algoritmo é a mutação por troca de bits.
> * **Seleção:** É a técnica para selecionar quais indivíduos formarão os casais para a técnica de cruzamento. Existem diversas formas de selecionar indivíduos. Neste algoritmo foi utilizada a técnica de seleção por roleta.

  


### Configurações
>   
>   <p align="center">
>   <img width="550" src="https://user-images.githubusercontent.com/61857348/194770179-a906c85f-7b17-4777-a6a9-939e6d2d2aba.png" alt="Tela Inicial">
>   </p>
> 
>   * **Tamanho da população:** Quantidade de indivíduos que compõem uma população, ou seja, é o tamanho da ArrayList de indivíduos.
>   * **Quantidade de gerações:** Quantidade de populações máxima que o algoritmo pode atingir. Controla o número máximo de iterações que o programa realizará para buscar soluções.
>   * **Taxa de mutação:** Valor de referência para a ocorrência (ou não) de uma mutação. 
>   * **Taxa de crossover:** Valor de referência para a ocorrência (ou não) de um cruzamento.
  

### Descrição
>   
>    <p align="center">
>       <img width="300" src="https://user-images.githubusercontent.com/61857348/194770182-3083f408-3448-43a3-b6d4-28de229207c6.png" alt="Tela Inicial">
>    </p>
> 
>   O algoritmo possui dois modos de execução:
>
>   - *Apresentação:* mostra o passo a passo da execução através de telas explicativas. O algoritmo roda apenas para explicar a execução, sem buscar pela solução global.
>   - *Rodar Algoritmo* roda o algoritmo sem interrupções até encontrar o indivíduo com aptidão maior que a precisão estabelecida. Por padrão o algoritmo é pré-definido para rodar até encontrar o primeiro indivíduo de aptidão próxima de 1, com precisão de 7 casas decimais - ou seja, o algoritmo roda até encontrar o primeiro indivíduo com aptidao maior ou igual a 0,9999999.
>  
>   A busca pela solução é realizada em ciclos. Cada ciclo é composto pelas etapas mostradas abaixo:
>  
>   #### Geração de Indivíduos
>>   
>>   O algoritmo inicia gerando os primeiros indivíduos de forma aleatória ao chamar esta função como parâmetro do construtor da classe Indivíduo. O tamanho do cromossomo pode ser alterado através da variável *n_bits*:
>>   
>>    ```cpp
>>     public class Gerador {   
>>         public String bits(){ 
>> 
>>             String novo_cromossomo="";
>>             Random num_aleatorio = new Random();          
>>             int n_bits=44; //Declaração do tamanho da palavra(nº de bits)
>> 
>>             while(n_bits>0){
>>                 if(num_aleatorio.nextInt(100)<=50){
>>                     novo_cromossomo=novo_cromossomo+'1';
>>                 }
>>                 else{
>>                     novo_cromossomo=novo_cromossomo+'0';
>>                 }
>>                 n_bits--;
>>             }
>> 
>>             return novo_cromossomo;
>>         }
>>     }
>> ```
>>       
>      
>  #### Divisão do Cromossomo e Cálculo de X e Y  
>>   
>>   Ao instanciar um indivíduo, o cromossomo inserido como parâmetro do construtor será o cromossomo deste indivíduo. Além disso, durante a construção deste objeto, o cromossomo é dividido em duas partes iguais, sendo a primeira equivalente às primeiras 22 posições da String, e a segunda às 22 posições restantes (baseados em um cromossomo padrão de 44 bits). Ambas as partes são decodificadas para um valor real correspondente pelo método *decodificador*, conforme a equação:
>> 
>>    <p align="center">
>>   <img width="550" src="https://user-images.githubusercontent.com/61857348/194780400-6d25dc0e-d4df-4847-8785-08b6fb7b8e13.png" alt="Equação F6">
>>   </p>
>>   
>>  O resultado da decodificação da Parte 1 do cromossomo será o valor de X deste indivíduo. Da mesma forma, o resultado da decodificação da Parte 2 será o valor de Y.
>>       
>>    ```cpp
>>     private void seccionador(){
>>         String[] seccao = {
>>             this.cromossomo.substring(0, 22)
>>             ,this.cromossomo.substring(22)
>>         };
>>         this.parte1 = seccao[0];
>>         this.parte2 = seccao[1];
>>     }
>>     
>>     private void calculador(){
>>         this.x = decodificador(this.parte1);
>>         this.y = decodificador(this.parte2);
>>     }
>>     
>>     public double decodificador(String seccao){
>>         int ki = 22; // numero de bits da seccao
>>         double real=0; 
>>         int xibin = Integer.parseInt(seccao, 2); 
>>         real=((200*xibin)/(pow(2,ki)-1))-100;
>>         return real;
>>     }
>> ```
>      
>  #### Cálculo de Aptidão
>>   
>>   A partir dos valores de X e Y é calculado o valor de aptidão do indivíduo, conforme a equação de aptidão:
>> 
>>    <p align="center">
>>   <img width="550" src="https://user-images.githubusercontent.com/61857348/194780345-bbcad664-15e9-4747-bf13-aaaecbca53fe.png" alt="Equação F6">
>>   </p>
>>       
>>    ```cpp
>>     public final void setAptidao(double xi, double yi) {        
>>         this.aptidao = 0.5 - 
>>             (
>>                 (pow(sin(sqrt(pow(xi,2) + pow(yi,2))),2)-0.5)
>>                 /
>>                 pow((1 + (pow(xi,2) + pow(yi,2))*0.001),2)
>>             );   
>>     }
>> ```
>        
>  #### Seleção por Roleta
>>   
>>   Primeiramente é calculada a soma das aptidões de todos os indivíduos de uma população. Em seguida é sorteado um número aleatório entre 0 e o valor dessa soma. Com o número aleatório armazenado, a lista de indivíduos é varrida da primeira posição (0) para a última (99). A cada indivíduo "varrido", sua apdtidão é somada à aptidão dos indivíduos anteriores. O primeiro membro da população cuja esta soma for maior ou igual ao número aleatório gerado é selecionado e um novo número aleatório é gerado. A varredura se reinicia na posição 0 a cada indivíduo selecionado.  
>>
>>    <p align="center">
>>   <img width="650" src="https://user-images.githubusercontent.com/61857348/194787280-321c6918-5814-458a-8700-f7753dab44ab.png" alt="Equação F6">
>>   </p>
>>
>>  Para o exemplo acima, considere que a população é composta por 10 indivíduos cujas aptidãos são apresentadas em verde na linha Aptidão. Em vermelho é apresentada a aptidão de cada indivíduo somada à de seus antecessores. Note que a cada iteração, um número aleatório entre 0 e a soma total das aptidões é gerado. O primeiro número aleatório (23) é comparado com a aptidão do primeiro indivíduo (8). Como a aptidão é menor, pula para o segundo indivíduo, cuja aptidão somada a de seu antecessor é 10 (8 + 2). Como a aptidão continua sendo menor que o número aleatório, passa para o terceiro indivíduo. Sua aptidão somada à de seus antecessores é 27 (8 + 2 + 17), maior que o número aleatório. Deste forma o terceiro indivíduo é selecionado, outro número aleatório é gerado e a comparação reinicia a partir do primeiro indivíduo novamente.
>>
>>    ```cpp
>>     public void roleta(ArrayList<Individuo> individuos){
>>         ArrayList<Individuo> aux = new ArrayList<>();
>>         Random aleatorio = new Random();
>>         double somatorio = 0;
>>         int i, j, tam_populacao=individuos.size();
>>         double referencia = 0;
>>         setSoma(0);
>>         
>>         for(j=0;j<tam_populacao;j++){
>>             setSoma(getSoma()+individuos.get(j).getAptidao());
>>         }
>>         for(j=0;j<getRoletada();j++){
>>             referencia = aleatorio.nextDouble()*getSoma();
>>             for(i=0;i<tam_populacao;i++){
>>                 somatorio=somatorio + individuos.get(i).getAptidao();
>>                 if(somatorio>=referencia){
>>                     aux.add(individuos.get(i));
>>                     break;
>>                 }
>>             }
>>             somatorio=0;
>>         }     
>>         individuos = new ArrayList<>(aux); // Atribuir à Lista da entrada a nova população em ordem dos casais      
>>     }  
>> ```
>      
>  #### Cruzamento
>>   
>>   Após a roleta a população está ordenada conforme a seleção dos casais, sendo os indivíduos das posições 0 e 1 da lista um casal, os indivíduos das posições 2 e 3 da lista outro casal e assim sucessivamente. No método crossover, um número aleatório entre 0 e o tamanho máximo do cromossomo (43) é gerado. Este número representa o ponto de corte. O cromossomo é cortado nessa posição - a primeira parte da string cortada (da posição 0 até a posição do número gerado) corresponde à cabeça e a segunda parte (da posição do número gerado até 43) corresponde à cauda. Ambos os cromossomos, do macho e da fêmea, passam por este processo e geram dois filhos: 
>>
>>    <p align="center">
>>   <img width="550" src="https://user-images.githubusercontent.com/61857348/194784626-aff4bd79-3078-4263-9b27-978fcbf640fd.png" alt="Equação F6">
>>   </p>
>>
>> - a cabeça do macho concatenada com a cauda da fêmea gera o cromossomo do primeiro filho
>> - a cabeça da fêmea concatenada com a cauda do macho gera o cromossomo do segundo filho
>>
>>    ```cpp
>>     public void crossover(ArrayList<Individuo> individuos, int geracao){
>>         int i;
>>         Random aleatorio = new Random();
>>         int corte;
>>         for(i=0;i<individuos.size();){ 
>>             if(aleatorio.nextDouble()<=getTaxa_cross()){
>>                 corte = aleatorio.nextInt(43);
>>                 String[] macho = {
>>                                     individuos.get(i).getCromossomo().substring(0, corte),
>>                                    individuos.get(i).getCromossomo().substring(corte)                        
>>                                  };
>>                 
>>                 String[] femea = {
>>                                     individuos.get(i+1).getCromossomo().substring(0, corte),
>>                                    individuos.get(i+1).getCromossomo().substring(corte)
>>                                  };
>>                 individuos.get(i).setCromossomo(macho[0]+femea[1]); 
>>                 individuos.get(i).setNumero(Integer.toString(i)+"."+geracao);
>>                 individuos.get(i+1).setCromossomo(femea[0]+macho[1]);
>>                 individuos.get(i+1).setNumero(Integer.toString(i)+"."+geracao);
>>             } 
>>             i+=2;
>>         }     
>>     }
>> ```
>       
>  #### Mutação por troca de bit
>>
>>   Durante a mutação é gerado um valor aleatório entre 0 e 1 para cada bit do cromossomo. Se este valor for menor ou igual à taxa de mutação, o bit correspondente é trocado:
>>
>>  - se for 0 é trocado por 1
>>  - se for 1 é trocado por 0
>>
>>      <p align="center">
>>   <img width="550" src="https://user-images.githubusercontent.com/61857348/194785289-315349e2-1c64-4d5e-8fbd-a6b0c922964c.png" alt="Mutação">
>>   </p>
>>
>>  A taxa de mutação é pré-definida em 0.008 (0.8%) e seu valor pode ser alterado no menu de configurações. 
>>  Este processo é realizado com todos os bits dos cromossomos de todos os indivíduos de uma população.
>>       
>>    ```cpp
>>     public void inversao_de_bit(ArrayList<Individuo> individuos){
>>         int i,j, mutou=0;
>>         double assinatura;
>>         char[] aux = new char[45];
>>         Random aleatorio = new Random();
>>         String cromossomo = new String(); 
>>         setMutacoes(0);
>>         
>>         for(i=0;i<individuos.size();i++){
>>             cromossomo="";
>>             for(j=0;j<individuos.get(i).getCromossomo().length();j++){
>>                 aux[j]=individuos.get(i).getCromossomo().charAt(j);
>>                 assinatura = aleatorio.nextDouble();
>>                 if(assinatura<=getTaxa_mutacao()){
>>                     if(aux[j]=='0') {
>>                         aux[j]='1';
>>                     }
>>                     else if(aux[j]=='1'){
>>                         aux[j]='0';
>>                     }
>>                     mutou++;
>>                 }
>>                 cromossomo=cromossomo+aux[j];                    
>>             }
>>             individuos.get(i).setCromossomo(cromossomo);
>>             setMutacoes(mutou);
>>         }     
>>     }  
>> ```
>       
>  #### Elitismo
>>   
>>   Primeiramente a população (lista) de pais é ordenada por ordem decrescente de aptidão, sendo o primeiro indivíduo da lista o de maior aptidão, o segundo indivíduo da lista o de segunda maior aptidão e assim por diante. Em seguida um filho aleatório é substituído, na população de filhos, pelo pai de maior aptidão (o primeiro indivíduo da população de pais). Por fim a lista de pais é eliminada e a lista de filhos passa ser a nova lista de pais.
>>       
>>    ```cpp
>>       organizador.ordenar(pais.getIndividuos());
>>       filhos.getIndividuos().remove(aleatorio.nextInt(tam_populacao));
>>       filhos.getIndividuos().add(new Individuo(pais.getIndividuos().get(0).getCromossomo()));
>>       pais = new Populacao(new ArrayList<>(filhos.getIndividuos()));
>> ```
      
