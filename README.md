# Algoritmo-Genetico-F6

Este projeto em java utiliza conceitos básicos de um algoritmo genético para maximizar a função F6. 

A pasta [*codigo*](https://github.com/rlBessa/Algoritmo-Genetico-F6/tree/main/codigo) contém todas as classes e as imagens utilizadas no algoritmo.

A pasta [*projetoNetbeans*](https://github.com/rlBessa/Algoritmo-Genetico-F6/tree/main/projetoNetbeans) contém os arquivos dispostos conforme um projeto NetBeans.

## Função F6

  <p align="center">
  <img width="300" src="https://user-images.githubusercontent.com/61857348/194768865-146966e2-6dcc-4025-80cf-de37acd4f585.png" alt="Função F6">
  </p>


## Algoritmo Genético



## O Código
[*Algoritmo-Genetico-F6*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe principal do projeto. Nela ocorre toda a interação entre as classes.

  <p align="left">
  <img width="250" src="https://user-images.githubusercontent.com/61857348/194769879-552a614d-7801-4fe0-8317-2c41897ebee8.png" alt="Tela Inicial">
  </p>

[*Gerador*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe responsável por gerar cada bit do cromossomo de forma aleatória.

[*Individuo*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe que representa possíveis soluções para o problema. Cada instância desta classe representa um candidato à solução. Os principal atributo da classe é o cromossomo - todos as outras atribuições ocorrem a partir dele.

[*Populacao*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe que corresponde a um conjunto determinado de indivíduos (ArrayList de objetos). O tamanho da população é pré-definido em 100 indivíduos, mas pode ser alterado no menu de configurações. 

[*Ordenador*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe responsável por ordenar uma população por ordem decrescente de aptidão, ou seja, o primeiro indivíduo do ArrayList possui a maior aptidão, o segundo possui a segunda maior e assim por diante.

[*Seletor*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java) é a classe que seleciona quais indivíduos formarão casais de acordo com o método da Roleta. Esta função realiza uma ordenação na lista de forma condicional: cada indivíduo selecionado pela roleta é adicionado à lista, permitindo que o mesmo indivíduo seja adicionado mais de uma vez.

[*Crossover*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java)

[*Mutador*](https://github.com/rlBessa/Algoritmo-Genetico-F6/blob/main/codigo/AlgoritmoGeneticoF6.java)



### Dicionário de Classes e Atributos

  * **Cromossomo:** Corresponde a uma string de 44bits. Este atributo funciona como a "assinatura" de um objeto indivíduo. Os 22 primeiros bits serão utilizados para calcular o atributo X do indivíduo e os últimos 22 bits serão utilizados para calcular o atributo Y. Cada indivíduo possui um cromossomo gerado a partir dos cromossomos de seus pais pela função Crossover.
  * **Indivíduo:** A partir do cromossomo, cada indivíduo recebe um valor real para seus atributos X e Y. Estes valores serão utilizados para calcular a aptidão do indivíduo. Desta forma cada indíviduo corresponde a uma *solução* para a função F6.  
  * **Aptidão:**
  * **População:**
  * **Geração:**

### Configurações
  
  <p align="left">
  <img width="550" src="https://user-images.githubusercontent.com/61857348/194770179-a906c85f-7b17-4777-a6a9-939e6d2d2aba.png" alt="Tela Inicial">
  </p>

  * **Tamanho da população:**
  * **Quantidade de gerações:**
  * **Taxa de mutação:**
  * **Taxa de crossover:**
  
### Métodos do Algoritmo

  <p align="left">
  <img width="250" src="https://user-images.githubusercontent.com/61857348/194770182-3083f408-3448-43a3-b6d4-28de229207c6.png" alt="Tela Inicial">
  </p>
  
  
  
