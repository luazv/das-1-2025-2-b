# Design e Arquitetura de Software 1 - 2025/2 Turma B

# 31 jul 2025

# O que é uma abstração?

É uma maneira de adquirir conhecimento de fases importantes de um problema com o objetivo de criar
uma solução para resolução.

# Por que a complexidade é um desafio?

O Software é uma abstração que resolve problemas do mundo, então se torna complexo, pois
é resolução de problemas reais. 
Você lembra dos primeiros desafios de programação da graduação? No primeiro
momento que foi solucionado parecia difícil, mas quando você aprende a resolver essa
complexidade começa a fazer sentido e na segunda tentativa começava a parecer mais "fácil". 
Isso é complexidade.

E uma maneira de auxiliar é dividir a complexidade em divisões menores, porque o primeiro objetivo de projeto de software
é decompor um problema em partes menores. 

# Por que aprender orientação a objetos?

Porque são com os objetos que representamos todas as coisas. 

# Boas práticas 
-Quando uma parte do sistema usa um padrão de nomes para variáveis (por exemplo, camel case, como em notaTotal),
enquanto em outra parte usa-se um outro padrão (por exemplo, snake case, como em nota_total).

-Quando uma parte do sistema usa um determinado framework para manipulação de páginas Web,
enquanto em outra parte usa-se um segundo framework ou então uma versão diferente do primeiro framework.
    -A importância na escolha de uma framework

-Quando em uma parte do sistema resolve-se um problema usando-se uma estrutura de dados X,
enquanto que, em outra parte, um problema parecido é resolvido por meio de uma estrutura Y. 
    -A importância de se aprofundar em estruturas de dados para entrevistas de grande nível

-Quando funções de uma parte do sistema que precisam de uma determinada informação — por exemplo,
o endereço de um servidor — a obtém diretamente de um arquivo de configuração. Porém, em outras funções,
de outras partes do sistema, a mesma informação deve ser passada como parâmetro.

# Informações ocultas
Citado em dos artigos mais importantes e influentes da área de Engenharia de Software,
de todos os tempos, cujo título é On the criteria to be used in decomposing systems into modules. 

Consumo de uma interface para determinada função que é realizada pelas classes (guarda o comportamento). Ou seja não é necessário
o código visível para o usuário, mas ele irá necessitar de comandos para realizar funções de
um sistema. 

Vantagens: 

-Desenvolvimento em paralelo. Suponha que um sistema X foi implementado por meio de classes C1, C2, …, Cn.
Quando essas classes ocultam suas principais informações, fica mais fácil implementá-las em paralelo,
por desenvolvedores diferentes. Consequentemente, teremos uma redução no tempo total de implementação do sistema.

-Flexibilidade a mudanças. Por exemplo, suponha que descobrimos que a classe Ci é responsável pelos problemas de desempenho do sistema.
Quando detalhes de implementação de Ci são ocultados do resto do sistema, fica mais fácil trocar sua implementação por uma classe Ci',
que use estruturas de dados e algoritmos mais eficientes. Essa troca também é mais segura, pois como as classes são independentes,
diminui-se o risco de a mudança introduzir bugs em outras classes.
    -Evoluir o sistema sem quebrar o código

-Facilidade de entendimento. Por exemplo, um novo desenvolvedor contratado pela
empresa pode ser alocado para trabalhar em algumas classes apenas. Portanto,
ele não precisará entender toda a complexidade do sistema, mas apenas a implementação
das classes pelas quais ficou responsável.

# Get e set

É uma forma de encapsular para proteger informações. 

# O que é uma coesão?

Toda classe deve ser coesa, ou seja cada classe com sua funcionalidade. E quais as vantagens dessa coesão?
- Auxilia no entendimento e manutenção
- Auxilia no reúso por ser mais simples
- Auxilia nos testes

# Acoplamento 

Exemplo: USB ele não está acoplado, qualquer momento que retiro e coloco em outro dispositivo ele conecta, ao contrário do acoplamento, pois tudo está conectado 

Resumidamente o objetivo do acoplamento é que duas coisas não conversem diretamente. 

# 07 ago 2025
# Clean code & SOLID

# Single Responsibility Principle
    (Princípio da Responsabilidade Única)
Aplicação direta da ideia da coesão. 
É uma maneira de identificar o motivo de uma mudança. 
Um dos princípios recomenda separar apresentação de regras de negócio. Por exemplo: Services <- lógica (use cases), entity <- dados, repository <- JPA spring data, controller <- api rest
**Cada um tem sua responsabilidade. (lógicas diferentes)**

# Open/Closed Principle
    (Princípio do Aberto/Fechado)

# Liskov Substitution Principle
    (Princípio da Substituição de Liskov)

# Interface Segregation Principle
    (Princípio da Segregação de Interfaces)
O objetivo é que os usuários utilizem interfaces somente necessárias, dessa maneira com métodos apenas essenciais. 
Se eu quero "ouvir" um botão é necessário uma interface para isso, assim como se eu quero "ouvir" o movimento de outra coisa deve haver uma interface para isso, mas é importante não adequar uma interface para várias coisas. 

# Dependency Inversion Principle
    (Princípio da Inversão de Dependências)




