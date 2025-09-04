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
- Quando uma parte do sistema usa um padrão de nomes para variáveis (por exemplo, camel case, como em notaTotal),
enquanto em outra parte usa-se um outro padrão (por exemplo, snake case, como em nota_total).

- Quando uma parte do sistema usa um determinado framework para manipulação de páginas Web,
enquanto em outra parte usa-se um segundo framework ou então uma versão diferente do primeiro framework.
    -A importância na escolha de uma framework

- Quando em uma parte do sistema resolve-se um problema usando-se uma estrutura de dados X,
enquanto que, em outra parte, um problema parecido é resolvido por meio de uma estrutura Y. 
    -A importância de se aprofundar em estruturas de dados para entrevistas de grande nível

- Quando funções de uma parte do sistema que precisam de uma determinada informação — por exemplo,
o endereço de um servidor — a obtém diretamente de um arquivo de configuração. Porém, em outras funções,
de outras partes do sistema, a mesma informação deve ser passada como parâmetro.

# Informações ocultas
Citado em dos artigos mais importantes e influentes da área de Engenharia de Software,
de todos os tempos, cujo título é On the criteria to be used in decomposing systems into modules. 

Consumo de uma interface para determinada função que é realizada pelas classes (guarda o comportamento). Ou seja não é necessário
o código visível para o usuário, mas ele irá necessitar de comandos para realizar funções de
um sistema. 

Vantagens: 

- Desenvolvimento em paralelo. Suponha que um sistema X foi implementado por meio de classes C1, C2, …, Cn.
Quando essas classes ocultam suas principais informações, fica mais fácil implementá-las em paralelo,
por desenvolvedores diferentes. Consequentemente, teremos uma redução no tempo total de implementação do sistema.

- Flexibilidade a mudanças. Por exemplo, suponha que descobrimos que a classe Ci é responsável pelos problemas de desempenho do sistema.
Quando detalhes de implementação de Ci são ocultados do resto do sistema, fica mais fácil trocar sua implementação por uma classe Ci',
que use estruturas de dados e algoritmos mais eficientes. Essa troca também é mais segura, pois como as classes são independentes,
diminui-se o risco de a mudança introduzir bugs em outras classes.
    -Evoluir o sistema sem quebrar o código

- Facilidade de entendimento. Por exemplo, um novo desenvolvedor contratado pela
empresa pode ser alocado para trabalhar em algumas classes apenas. Portanto,
ele não precisará entender toda a complexidade do sistema, mas apenas a implementação
das classes pelas quais ficou responsável.

# Get e set

É uma forma de encapsular para proteger informações. 

# 04 ago 2025

# O que é uma coesão?

Toda classe deve ser coesa, ou seja cada classe com sua funcionalidade. E quais as vantagens dessa coesão?
- Auxilia no entendimento e manutenção
- Auxilia no reúso por ser mais simples
- Auxilia nos testes

# Acoplamento 
 Indica quanto um módulo depende de outro para funcionar. Códigos desacoplados são aqueles de relação fraca, e não dependem de outros para fazer sua funcionalidade básica. É sempre desejável um baixo nível de acoplamento.

Quando há baixo acoplamento, a aplicação fica mais flexível, reusável e mais organizada.
Exemplo: USB 

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

# 14 ago 2025

# Liskov Substitution Principle
    (Princípio da Substituição de Liskov)

Acontece quando há uma super classe, e eu tenho várias subclasses que herdam desse pai, certo. Para que a subclasse, a classe de as filhos, tenham exatamente os mesmos métodos do pai. Pra eu poder trocar entre filhos sem quebrar o código, essa é a ideia.


# Padrões de Projeto

Link site Design Patterns: https://refactoring.guru/design-patterns

Soluções para problemas que encontramos no código. 

# 21 ago 2025

Tipo: Creational Patterns
1. Singleton
é um padrão de design criacional que permite garantir que uma classe tenha apenas uma instância, ao mesmo tempo em que fornece um ponto de acesso global a essa instância.

Observer 
é um padrão de design comportamental que permite definir um mecanismo de assinatura para notificar vários objetos sobre quaisquer eventos que aconteçam com o objeto que eles estão observando.



# 28 ago 2025
Para definir uma estrutura da arquitetura são divididas em três pontos principais:

1. Características da arquitetura
Requisitos não funcionais, ou seja, não tem necessidade de saber as funcionalidades do sistema, mas se não houver esses requisitos não funcionais da forma correta, o sistema será comprometido. Eles estão ligados diretamente a expectativa do úsuario final.

2. Princípios do design
-Evitar acoplamento, de que maneira? Por meio da troca de mensagem assincrona. É uma maneira de um serviço que tem algo importante alerta a mensagem e quem tem interesse fica esperando e ouve essas mensagens importantes. 
-Uma boa prática que deve ser seguida

3. Decisões da arquitetura 
É a escolha no inicio do projeto que irar permanecer até o final do projeto, ou seja, será a tecnologia utilizada naquele sistema e o mais "aconselhável" seria a tecnologia que mais temos intimidade. Dessa forma irá dominar de uma maneira mais eficaz e não irá perder tempo aprendendo outra tecnologia e realizando o projeto, mas utilizando esse tempo que seria para aprender essa nova tecnologia irá aprimorar seu projeto. 

Esses três pontos guiam o estilo de arquitetura. 

# 01 set 2025

Expectativas de um arquiteto: Tomar decisões difíceis. 

O arquiteto é "chamado" para auxiliar em verificar o problema e identificar o que está quebrando a arquitetura do sistema, mas a arquitetura deve se manter atualizada para aprimorar o software da empresa. E ele auxilia em como essas decisões e as tendências mais atuais podem melhorar a empresa. Além disso o arquiteto deve ter a voz do cliente dentro da empresa, então ele deve lidar com políticas.
Ele deve evitar erros comuns devido suas experiências por isso a orientação dele é um dos papéis mais importantes. 


Segredo do arquiteto :closed_lock_with_key:  
O primeiro segredo para a eficiência e o sucesso na função de arquiteto de software depende de compreender e praticar cada uma dessas expectativas.

* Análise contínua da arquitetura
O primeiro segredo para a eficiência e o sucesso na função de arquiteto de software depende de compreender e praticar cada uma dessas expectativas ou seja O primeiro segredo para a eficiência e o sucesso na função de arquiteto de software depende de compreender e praticar cada uma dessas expectativas.

Existe a técnica conhecida como análise estática de código que identifica erros ou vulnerabilidas no código-fonte e auxilia na qualidade de software e detecção PRECOCE de um problema. 

* Conhecimento do negócio
Capacidade de entender o cliente e levar a expectativa do cliente para a equipe, ele deve ter um bom domínio no negócio da empresa. 

* Lidar com questões políticas 
Clima político da empresa e conseguir lidar bem com ele.

* Operações/DevOps
O objetivo do devOps é entregar valor. Deixar a "briga" de lado e trabalhar em equipe.

Etapas:

* Planejar (Utilizar metodologias ágeis)
* Criar
* Integração (Controle de versão)
* Implantar (colocar para funcionar na empresa)
* Operar (monitorar, controlar, está melhor que a última versão?)
8Comentários contínuos (feedback)

Mas não finaliza no último tópico, pois é um ciclo. Esse ciclo faz nascer a colaboração e um ponto principal é todos sabendo tudo. Como assim? Todos sabem resolver um erro, não existe erro de uma pessoa, mas erro de toda equipe caso haja algo. Isso é devOps como cultura, mas como cargo há uma equipe somente para isso e esses dois modelos funcionam, não existe modelo certo ou errado. 

Essa técnica reduz tempo de ciclo. Não imediatamente, mas ao longo do tempo, conforme a implantação da técnica. 

# 04 set 2025

* Arquitetura X Design 

Como visto anteriormente o arquiteto deve ter uma visão ampliada de todo espaço e de "tudo" que está sendo realizado e assim ele irá conectar o cliente ao desenvolvedor e é nessa transição que pode haver uma confusão entre as responsabilidades de cada membro da equipe e a arquitetura e o design. 

* E como isso pode ser resolvido? Por meio da comunicação, como o ditado popular "quem tem boca vai a Roma" assim também acontece no sucesso de um projeto se houver comunicação entre todos os envolvidos que fazem o projeto ser um projeto. Não deve haver uma quebra de expectativa entre arquiteto, desenvolvedores e usuário final (cliente). Sendo assim as barreiras físicas e virtuais entre arquitetos e desenvolvedores devem ser extintas, deve ser formada uma counicação bidirecional para que todos entendam o objetivo e se caso o projeto dê indicios de "fugir" da expectativa haver alinhamento para reorganizar o caminho a ser trilhado e ambos os envolvidos possam auxiliar aqueles que ainda possuem alguma dificuldade em determinada etapa do projeto, seja em compreender ou aprimorar o produto. 
Resumidamente a arquitetura não "termina' ela estará presente no design para ser o norte do projeto. 

* Arquiteto modelo T

O que seria um arquiteto modelo T? Primeiro, deve-se levar em conta que o arquiteto deve ter conhecimento sobre "tudo" que possível, mas ele não irá ter profundidade de conhecimento em tudo, porque é meramente impossível saber tudo de tudo, claro que ele deve fazer o que tiver ao seu alcance para ser fundamental na essência e complexidade da entrega do produto final, mas ele não irá ter o grau técnico em todas as áreas, então levando em consideração uma pirâmide em que o topo é "O que você sabe", ou seja tecnologias, frameworks, linguagens e ferramentos, o meio da pirâmide sendo "o que você sabe que não sabe", coisas que você ouviu falar, mas não tem um grande grau de conhecimento e o final da pirãmide sendo "o que você não sabe que não sabe", sendo endo inúmeras tecnologias, ferramentas e etc que seriam soluções perfeitas para os maiores problemas dos softwares, nessa pirâmide o arquiteto deve estar no topo e no meio. 

Por que o arquiteto estaria no inicio da pirâmide e não no primeiro estágio e último?

Porque para ele a amplitude é mais valioso que profundade. Caso em algum momento apareça o problema é mais fácil ele saber caminhos para chegar ao objetivo e pedir ajuda aos desenvolvedores para trilhar esses caminhos com as técnicas necessárias, que conhecer apenas um caminho de forma profunda e se caso não der certo acabar sem outros planos para seguir deixando a equipe sem um rumo final. 

Arquitetura é o que você não consegue pesquisar com o Google

O arquiteo deve ver os trade-offs. E o que seria isso? é uma situação em que, ao escolher uma opção, é necessário abrir mão de outra, resultando em ganhos em um aspecto e perdas em outro.

Um exemplo:

Lembra quando em determinada aula da escola o professor fazia a pergunta: O que você quer ser quando crescer? 
Então ele ensinava matérias que formavam base, mas não profundidade para você já sair da escola e se tornar um profissional, mas ele lhe mostrava nortes para escolher uma faculdade ou curso técnico e com isso você conseguiu escolher. Dessa mesma forma é o arquiteto, ele lhe dá o norte e você escolhe o campo profissional. Digamos que o arquiteto é seu professor, você continua sendo o aluno e o seu campo profissional é o projeto de software. 

