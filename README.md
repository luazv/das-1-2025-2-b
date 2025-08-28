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
Um dos princípios recomenda separar apresentação de regras de negócio. 
Por exemplo: 
- Services <- lógica (use cases);
- Entity <- dados;
- Repository <- JPA spring data;
- Controller <- api rest. 
**Cada um tem sua responsabilidade. (lógicas diferentes)**

# Interface Segregation Principle
    (Princípio da Segregação de Interfaces)
O objetivo é que os usuários utilizem interfaces somente necessárias, dessa maneira com métodos apenas essenciais. 
Se eu quero "ouvir" um botão é necessário uma interface para isso, assim como se eu quero "ouvir" o movimento de
outra coisa deve haver uma interface para isso, mas é importante não adequar uma interface para várias coisas. 

# 11 ago 2025

# Dependency Inversion Principle
    (Princípio da Inversão de Dependências)
Esse princípio recomenda que uma classe cliente (que precisa de alguma coisa), por exemplo: controladores e deve estabelecer dependências prioritariamente com abstrações (por exemplo: interfaces de serviço) e não com implementações concretas.
pois abstrações (isto é, interfaces) são mais estáveis do que implementações concretas (isto é, classes).

Utilizando o @autowired o controlador se conecta com a interface e a interface conecta-se com o código. Servindo como ponte. (Resumindo: O cliente não conhece só uma interface e alguém vai passar para ele)

Por exemplo: 
esse seria o ClienteService:
interface I { ... } 

esse seria o ClienteServiceImpl:
class C1 implements I { 
  ...
}
esse seria o ClienteServiceImpl2:
class C2 implements I {
  ...
}

Prefira Interfaces a Classes. Qual o objetivo? Reduzir acoplamento. 

Prefira Composição a Herança 
Por que? Na herança herda tudo, a herança expõe para subclasses detalhes de implementação das classes pai. Logo, frequentemente diz-se que
herança viola o encapsulamento das classes pai, ou seja dificulta todo o desenvolvimento. Utilize as associações. 

E quando posso usar a herança? 
Quando os filhos de uma superclasse não tiverem como um substituir o outro. 
Exemplo de modelagem de dados:
A classe sendo Animal e as subclasses sendo gato e cachorro. Concorda que o gato não pode tornar-se um cachorro? Nesse caso usa-se a herança, mas em um
outro contexto se a classe for Pessoa e as subclasses funcionários e clientes não é adequado, pois uma vez modelado assim o funcionário não pode tornar-se cliente.

**Principio Demiter (Principio do menor conhecimento)**
de sua própria classe (caso 1)

de objetos passados como parâmetros (caso 2)

de objetos criados pelo próprio método (caso 3)

de atributos da classe do método (caso 4)

Todo o código chama um objeto

# Open/Closed Principle
    (Princípio do Aberto/Fechado)
Uma classe deve estar fechada para modificações e aberta para extensões. 
É para haver um controle sob o código, mas com a possibilidade de outras pessoas trabalharem por cima do meu código. 


# Liskov Substitution Principle
    (Princípio da Substituição de Liskov)

Acontece quando há uma super classe, e eu tenho várias subclasses que herdam desse pai, certo. Para que a subclasse, a classe de as filhos, tenham exatamente os mesmos métodos do pai. Pra eu poder trocar entre filhos sem quebrar o código, essa é a ideia.


# Padrões de Projeto

Link site Design Patterns: https://refactoring.guru/design-patterns

Soluções para problemas que encontramos no código. 

Tipo: Creational Patterns
1. Singleton
é um padrão de design criacional que permite garantir que uma classe tenha apenas uma instância, ao mesmo tempo em que fornece um ponto de acesso global a essa instância.


# 28.08
Para definir uma estrutura da arquitetura são divididas em três pontos principais:

1. Características da arquitetura
Requisitos não funcionais, ou seja, não tem necessidade de saber as funcionalidades do sistema, mas se não houver esses requisitos não funcionais da forma correta, o sistema será comprometido. Eles estão ligados diretamente a expectativa do úsuario final.

2. Princípios do design

3. Decisões da arquitetura 


Esses três pontos guiam o estilo de arquitetura. 