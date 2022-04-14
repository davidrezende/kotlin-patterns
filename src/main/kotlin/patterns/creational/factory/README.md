# Factory Method

## Diagrama
![Diagrama Factory Method](../../../../resources/images/factory/diagrama.png)

- Padrão de design de software de **criação**

##Implementando

- O Produto declara a interface, que é comum a todos os objetos que podem ser produzidos pelo criador e suas subclasses.

- Produtos Concretos são implementações diferentes da interface do produto.

- A classe Criador declara o método fábrica que retorna novos objetos produto. É importante que o tipo de retorno desse método corresponda à interface do produto.

  - Você pode declarar o método fábrica como abstrato para forçar todas as subclasses a implementar suas próprias versões do método. Como alternativa, o método fábrica base pode retornar algum tipo de produto padrão.

- Criadores Concretos sobrescrevem o método fábrica base para retornar um tipo diferente de produto.


##Objetivo


## Identificando

Reconhecidos por métodos de criação, que criam objetos de classes concretas, mas os retornam como objetos de tipo ou interface abstrata.

## Vantagens

- Fornece aos usuários uma maneira de estender componentes internos.
- Economizar recursos do sistema **reutilizando objetos existentes em vez de recriá-los sempre**.
- **Princípio de Responsabilidade Única**: Evita acoplamentos entre classes.
  - Você pode mover o código de criação do produto para um único local do programa, facilitando a manutenção do código.
- **Princípio aberto/fechado**
  - Você pode introduzir novos tipos de produtos no programa sem quebrar o código cliente existente.
  - Por exemplo, para adicionar um novo tipo de produto à aplicação, só será necessário criar uma nova subclasse criadora e substituir o método fábrica nela.

## Desvantagens

- O código pode se tornar mais complicado
  - Você precisa introduzir muitas subclasses novas para implementar o padrão. 
    
O melhor cenário é quando você está introduzindo o padrão em uma hierarquia existente de classes criadoras.


