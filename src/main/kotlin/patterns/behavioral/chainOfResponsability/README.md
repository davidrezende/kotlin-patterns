# Chain of responsability

## Diagrama

![Diagrama Strategy](../../../../resources/images/chainOfResponsability/chain-uml-class-diagram.png)

- Padrão de design de software **comportamental**

## Vantagens

- **Princípio da Responsabilidade Única**
  - Evita o acoplamento do remetente de uma solicitação ao seu receptor.

- **Princípio Aberto/Fechado** ( Aberto para extensão, fechado para modificação )
  - Introduz **novos manipuladores sem quebrar** o código do cliente existente.

- Permite **controlar a ordem** de tratamento **dos manipuladores**.
- Cada manipulador na cadeia deve ter referência ao próximo
- Um conjunto de manipuladores e sua ordem podem ser alterados em tempo de execução.

## Desvantagens

- Pode ser quebrado facilmente:
    - se um manipulador não chamar o próximo, o comando será descartado
    - se um manipulador chamar o manipulador errado, pode levar a um ciclo

- Pode criar rastreamentos de pilha profundos, o que pode afetar o desempenho.
- Pode levar à duplicação de código entre os processadores, aumentando a manutenção
- Algumas solicitações podem acabar sem tratamento.

## Exemplo real no Java

- Servlet Filters
    - Permite que vários filtros processem uma solicitação HTTP.
  

    public void doFilter(
      ServletRequest request,
      ServletResponse response,
      FilterChain chain)
      throws IOException, ServletException {

        // process the request

        // pass the request (i.e. the command) along the filter chain
        chain.doFilter(request, response);
    }


