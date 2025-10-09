# Design e Arquitetura de Software 1 - 2025/2 Turma B

Não é possível definir o que um arquiteto de software faz, pois é um ecossistema com uma gama de informações que mudam em um curto período de tempo que pode alterar o 
próprio conceito e função do arquiteto de software, por isso não existe uma definição "correta" para ele, sendo assim ele é moldado conforme as mudanças no mundo tecnológico
Blueprint é o desenho da estrutura do sistema, mostrando as partes e como elas se conectam — é o “projeto” do software.
Roadmap é o plano com as etapas e prazos para construir o sistema — é o “roteiro” do desenvolvimento.
O arquiteto analisa a arquitetura para garantir que o blueprint seja claro e eficiente, e que o roadmap seja viável, para que o sistema funcione bem, seja seguro e fácil de evoluir.

# 31 jul 2025

# O que é uma abstração?

É uma maneira de adquirir conhecimento de fases importantes de um problema com o objetivo de criar uma solução para resolução.

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

# Prefira Composição a Herança 
Por que? Na herança herda tudo, a herança expõe para subclasses detalhes de implementação das classes pai. Logo, frequentemente diz-se que
herança viola o encapsulamento das classes pai, ou seja dificulta todo o desenvolvimento. Utilize as associações. 

E quando posso usar a herança? 
Quando os filhos de uma superclasse não tiverem como um substituir o outro. 
Exemplo de modelagem de dados:
A classe sendo Animal e as subclasses sendo gato e cachorro. Concorda que o gato não pode tornar-se um cachorro? Nesse caso usa-se a herança, mas em um
outro contexto se a classe for Pessoa e as subclasses funcionários e clientes não é adequado, pois uma vez modelado assim o funcionário não pode tornar-se cliente.

# Principio Demiter (Principio do menor conhecimento)
É um princípio com baixo nível de acoplamento, ele interage apenas com os objetos relacionados diretamente a ele. Com essa limitação facilita a manutenção e reduz acoplamento. 

# Open/Closed Principle
    (Princípio do Aberto/Fechado)
Uma classe deve estar fechada para modificações e aberta para extensões. 
É para haver um controle sob o código, mas com a possibilidade de outras pessoas trabalharem por cima do meu código. 

# 14 ago 2025

# Liskov Substitution Principle
    (Princípio da Substituição de Liskov)

Acontece quando há uma super classe, e eu tenho várias subclasses que herdam desse pai. Para que a subclasse, a classe de as filhos, tenham exatamente os mesmos métodos do pai. Pra eu poder trocar entre filhos sem quebrar o código, essa é a ideia.


# Padrões de Projeto

Link site Design Patterns: https://refactoring.guru/design-patterns

Soluções para problemas que encontramos no código. 

# 21 ago 2025
> O que são esses padrões de design e qual a finalidade?
Eles são formas de soluções para problemas comuns
em design de software. Para cada padrão há uma personalização para resolver 
determinado design no código que está sendo trabalhado. 

Tipo estudado: Creational Patterns (Padrões de criação)
Esses padrões fornecem vários mecanismos de criação de objetos, que aumentam a flexibilidade e a reutilização do código existente.
Nesse padrão há 5 tipos, que são: 

1. Factory Method
2. Abstract Factory
3. Builder
4. Prototype
5. Singleton

5. Singleton
O tipo singleton é um padrão de design criacional que permite garantir que uma classe tenha apenas uma instância, ao mesmo tempo em que fornece um ponto de acesso global a essa instância.

Tipo estudado: Behavioral patters
Esses padrões estão relacionados a algoritmos e à atribuição de responsabilidades entre objetos.

Observer (Observador)

O observer, também conhecido como assinante de eventos ou ouvinte é um padrão de design comportamental que permite definir um mecanismo de assinatura para notificar vários objetos sobre quaisquer eventos que aconteçam com o objeto que eles estão observando.

Exemplo: Grupo da família


# 28 ago 2025
Para definir uma estrutura da arquitetura são divididas em alguns pontos principais:

1. Estrutura do sistema:
(como microsserviços, camadas ou microkernel)

2. Características do sistema:
Requisitos não funcionais 
Por exemplo:
        Disponibilidade: Grau em que um sistema está operacional e acessível quando necessário.
        
        Confiabilidade: Capacidade de um sistema funcionar corretamente sem falhas por um período determinado.
        
        Testabilidade: Facilidade com que um sistema pode ser testado para identificar defeitos.
        
        Escalabilidade: Capacidade de um sistema aumentar sua performance ou capacidade com o aumento da demanda.
        
        Segurança: Proteção do sistema contra acessos não autorizados e ameaças.
        
        Agilidade: Rapidez e flexibilidade na adaptação e evolução do sistema.
        
        Tolerância a falhas: Capacidade do sistema continuar funcionando mesmo na presença de erros.
        
        Elasticidade: Habilidade do sistema ajustar automaticamente seus recursos conforme a carga.
        
        Recuperabilidade: Facilidade e rapidez com que o sistema pode ser restaurado após uma falha.
        
        Desempenho: Eficiência com que o sistema executa suas funções, geralmente medido por tempo de resposta e uso de recursos.
        
        Implementabilidade: Facilidade de colocar o sistema em funcionamento no ambiente desejado.
        
        Capacidade de aprendizagem: Capacidade do sistema ou equipe de se adaptar e melhorar com base em experiências anteriores.

Ou seja, não tem necessidade de saber as funcionalidades do sistema, mas se não houver esses requisitos não funcionais da forma correta, o sistema será comprometido. Eles estão ligados diretamente a expectativa do usuário final.


3. Decisões de arquitetura:
É a escolha no inicio do projeto que irar permanecer até o final do projeto, ou seja, será a tecnologia utilizada naquele sistema e o mais "aconselhável" seria a tecnologia que mais temos intimidade. Dessa forma irá dominar de uma maneira mais eficaz e não irá perder tempo aprendendo outra tecnologia e realizando o projeto, mas utilizando esse tempo que seria para aprender essa nova tecnologia irá aprimorar seu projeto.
As decisões da arquitetura formam os limites do sistema e orientam as equipes de desenvolvimento sobre o que é ou não permitido.

4. Princípios de design:
É uma maneira de evitar acoplamento, de que maneira? 
Por meio da troca de mensagem assincrona. É uma maneira de um serviço que tem algo importante alerta a mensagem e quem tem interesse fica esperando e ouve essas mensagens importantes. Uma boa prática que deve ser seguida
Alguma regra estabelecida para determinada aplicação e melhor desempenho.

Esses pontos guiam o estilo de arquitetura. 

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
* Comentários contínuos (feedback)

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

O arquiteto deve ver os trade-offs. E o que seria isso? é uma situação em que, ao escolher uma opção, é necessário abrir mão de outra, resultando em ganhos em um aspecto e perdas em outro.

Um exemplo:

Lembra quando em determinada aula da escola o professor fazia a pergunta: O que você quer ser quando crescer? 
Então ele ensinava matérias que formavam base, mas não profundidade para você já sair da escola e se tornar um profissional, mas ele lhe mostrava nortes para escolher uma faculdade ou curso técnico e com isso você conseguiu escolher. Dessa mesma forma é o arquiteto, ele lhe dá o norte e você escolhe o campo profissional. Digamos que o arquiteto é seu professor, você continua sendo o aluno e o seu campo profissional é o projeto de software. 

# 08 set 2025
Trade-offs 
(Compensação)

Não existe certo e errado. Como diz qualquer desenvolvedor, depende. 

Para o sistema de leilão onde um lance gerado precisa ser processado simultaneamente por vários serviços (Capturar, Rastrear e Analisar), a arquitetura baseada em tópico (publish/subscribe) é a melhor opção, pois permite que a mensagem seja publicada uma única vez e entregue a todos os consumidores inscritos de forma paralela e desacoplada, facilitando a escalabilidade e manutenção, enquanto o uso de filas ponto a ponto exigiria múltiplos envios e maior acoplamento entre produtor e consumidores.

Qual a diferença com banco de dados ?E esse tópico?
-   Trabalha com memória, tudo fica armazenado na memória
-   Tem uma performace maior
-   Conexão em um ponto central 
-   Menos impacto
-   Maior mensagem para passar informação adiante  (valor na nuvem fica maior)

1 para muitos (Ex: Grupo de whatsapp da familia)
E é assim que funciona com notificações de promoções que recebemos diariamente ou mensagens em grupos que você é adicionado.

Na arquitetura de fila...

-  Tópico não guarda mensagem, já a fila guarda. 
-   Existe um padrão de ordem
-   Menor redundância 
-   Mais impacto
-   Maior acoplamento
-   Modular a mensagem conforme necessidade de cada um 

1 para 1 

E por isso que não existe certo ou errado, pois irá depender do que você quer fazer. 

Resumindo: No tópico  escrevo apenas uma vez e todos recebem a mesma mensagem, mas caso um dos consumidores seja desativado não recebe a mensagem mais, já a fila tenho que mandar individual, mas caso um consumidor seja desativado ele pode ser ativado posteriormente e recuperar o que foi perdido. na arquiteura se chama fanout, é como um ventilador, ventila para todo mundo o mesma mensagem. 


# 11 set 2025

Codando...
> eventos


# 15 set 2025 

Codando...
> publisher
> subscriber 

# 02 out 2025

Codando...
>Consumer
>Producer

Exemplo: Comprei algo na amazon, então as etapas acontecem conforme no código e sequência de mensagens no Producer. 

# 06 out 2025

Definição das características arquiteturais

O desafio da equipe nesse capítulo é analisar todas as coisas que o software deve fazer que não estão diretamente relacionadas à funcionalidade do domínio. Sendo assim, as características arquiteturais.
Os arquitetos não gostam do termo "requisitos não funcionais" para caracterizar essas outras funcionalidades por isso é definida como caracteristicas, pois mostra a preocupaçãocrítica para o sucesso. 
Dentro da característica da arquitetura atende a 3 critérios:
-Especifica uma consideração de design fora do domínio
É um aspecto do projeto que não está relacionado diretamente às funções principais do sistema, mas que precisa ser considerado para o funcionamento correto.
-Influencia algum aspecto estrutural de design
Essa questão adicional pode influenciar como o sistema é montado ou organizado internamente.
-É essencial ou importante para o sucesso da aplicação
Embora não esteja explícito nos documentos de requisitos, esse aspecto é fundamental para que o sistema funcione bem, seja seguro e atenda às expectativas dos usuários e normas.

Trade-offs e  arquitetura menos pior
As arquiteturas suportam poucas características porque cada uma demanda esforço de design e impacta as outras. É comum que os arquitetos façam concessões entre características conflitantes para equilibrar o sistema. Buscar a “melhor” arquitetura é difícil; o ideal é a “menos pior”. Arquiteturas com muitas características tendem a ser complexas e difíceis de manter. Por isso, é importante criar projetos iterativos que possam ser ajustados ao longo do tempo.

# 09 out 2025

Circuit Breaker (Padrão disjuntor) - Padrão recente 
* Como funciona?
Quando ele identifica tentativas em um serviço que está gerando falhas que acaba levando grande tempo para recuperação, ele bloqueia o acesso
* Mas por que ele faz isso?
Ao bloquear ele evita a repetição desse acesso malsucedido e dessa forma o sistema tem uma recuperação mais rápida, além de evitar uma perda parcial de conectividade ou até uma falha completa do serviço

* Existe tr~es princípios:

No estado Aberto, o disjuntor bloqueia imediatamente todas as chamadas para a operação protegida, retornando uma exceção ou um valor padrão, sem tentar executar a lógica real. Esse estado é mantido por um período de tempo determinado por um temporizador. A ideia é dar ao sistema tempo suficiente para se recuperar da falha, seja por reinício de serviços, reestabelecimento de conexões ou outras ações externas. Quando o tempo expira, o disjuntor entra no estado Semiaberto, onde permite apenas algumas chamadas de teste passarem.

No estado Semiaberto, o disjuntor verifica se a operação voltou ao normal. Se um número configurado de chamadas for bem-sucedido de forma consecutiva, ele considera que o problema foi resolvido e retorna ao estado Fechado, com o contador de falhas zerado. No entanto, se qualquer uma dessas chamadas falhar, o disjuntor volta imediatamente ao estado Aberto, reiniciando o temporizador. Esse ciclo garante que o sistema só volte a operar plenamente quando for seguro, reduzindo o impacto das falhas e melhorando a estabilidade geral. Além disso, o padrão pode ser personalizado, como aumentar progressivamente o tempo de espera no estado Aberto (backoff) ou gerar eventos de mudança de estado para monitoramento e alertas

