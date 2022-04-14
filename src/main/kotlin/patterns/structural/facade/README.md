# Facade/Fachada

## Diagrama
![Diagrama Facade](../../../../resources/images/facade/diagrama-facade.png)

- Padrão de design de software **estrutural**
- **Tornar subsistemas complexos mais fáceis de usar.**
- **Mascarar uma estrutura mais complexa**.
- **Ponto de partida para uma refatoração**
- Captura a complexidade/colaboração do componente e **delega aos métodos apropriados**.

## Quando utilizar / Qual problema ela resolve?

- As **abstrações e implementações** de um subsistema **fortemente acopladas**.
- Quando é necessário um **ponto de entrada para camadas**.
- Um **sistema é muito complexo ou difícil de entender**.
  
**Considere se facades/fachadas adicionais agregariam valor.**

Um cenário onde um ou mais **subsistemas complexos que dependem de muitos objetos diferentes** com interfaces diferentes **(acoplamento forte)**, e que **torna as integrações difíceis de implementar, alterar, testar e reutilizar**.

### Pontos positivos
- Maior **legibilidade** e a **usabilidade** de uma **biblioteca**, **mascarando a interação com componentes mais complexos** por trás de uma única API. 
- **Tornar um subsistema complexo mais fácil de usar.**
- Fornecer uma **interface específica** do contexto **para uma funcionalidade mais genérica**.
- Servir como um **ponto de partida para uma refatoração** mais ampla de sistemas monolíticos ou fortemente acoplados em favor de código mais fracamente acoplado.

### Pontos negativos

- A classe pode **crescer descontroladamente**

## Alternativas
**O Abstract Factory** pode ser usado como **alternativa ao Facade** para **ocultar classes específicas** da plataforma.


## Diferenças

- Os **objetos Facade geralmente são Singletons** porque apenas um objeto Facade é necessário.

- O **Facade define uma nova interface**, enquanto **o Adapter usa uma interface existente**. 
  - **Adapter faz com que duas interfaces existentes funcionem juntas** em vez de definir uma totalmente nova.

- Enquanto **Flyweight** mostra como fazer **muitos objetos pequenos**, **Facade** mostra como fazer **um único objeto** representar um subsistema inteiro.

- O **Mediator** é **semelhante ao Facade**, pois abstrai a funcionalidade das classes existentes.
  O mediador abstrai/centraliza comunicações arbitrárias entre objetos relacionados.
  Ele rotineiramente "agrega valor" e é conhecido/referenciado pelos objetos relacionados.
  Em contraste, a **Facade** define uma interface mais simples para um subsistema, **não adiciona novas funcionalidades e não é conhecido pelas classes do subsistema**.

- **Adapter e Facade são ambos wrappers/embrulhos; mas são tipos diferentes de wrappers.**
  - Facade **produz uma interface mais simples**, já o Adapter **utiliza uma interface existente**.
  - Facade encapsula **vários objetos**, o Adapter encapsula **um único objeto**;
  - O Facade pode fazer o front-end de um único objeto complexo e o Adapter pode envolver vários objetos legados.
