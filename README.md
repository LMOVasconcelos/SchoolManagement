# Gestão escolar  

O **Sistema de gestão escolar** é uma aplicação desenvolvida para facilitar a gestão de turmas escolares. Com este sistema, você pode adicionar alunos à sua turma e obter informações úteis como a média das notas de cada aluno, a média da turma em cada disciplina e a frequência geral de cada aluno. Além disso, o sistema permite identificar quais alunos estão com desempenho ou frequência abaixo do esperado e precisam de atenção especial.

## Funcionalidades

- **Cadastro de Alunos**: Adicione alunos à sua turma com informações básicas e notas em diferentes disciplinas.
- **Cálculo de Médias**: O sistema calcula automaticamente:
  - A média das notas de cada aluno em todas as disciplinas.
  - A média da turma em cada disciplina.
- **Controle de Frequência**: Acompanhe a frequência geral de cada aluno.
- **Relatórios de Desempenho**:
  - **Desempenho Abaixo da Média**: Visualize quais alunos têm uma média de notas abaixo da média da turma.
  - **Frequência Abaixo de 75%**: Identifique quais alunos têm uma frequência geral abaixo de 75%, destacando aqueles que precisam de atenção especial.

## Aprendizado com React

Durante o desenvolvimento deste projeto, adquiri experiência significativa com o **React**, uma biblioteca popular para construção de interfaces de usuário. Aqui estão alguns dos principais aspectos que aprendi e como eles foram aplicados no projeto:

- **Componentização**: Aprendi a criar componentes reutilizáveis e a gerenciar o estado local e global da aplicação usando o React. No projeto, utilizei componentes para criar o cadastro das informações dos alunos e tabelas de relatórios.

- **Gerenciamento de Estado**: Explorei o uso do **useState** para gerenciar o estado dentro dos componentes e do **useEffect** para lidar com efeitos colaterais, como chamadas a APIs.

- **Roteamento**: Implementei o roteamento com a biblioteca **React Router** para permitir navegação entre diferentes páginas da aplicação, como a seção de cadastro e o relatório.

- **Integração com Backend**: Aprendi a fazer chamadas a APIs usando o **axios** para integrar o frontend com o backend em Spring Boot.

## Tecnologias utilizadas

**BackEnd**
    - Java 17 (LTS)
    - SpringBoot
    - JUnit
    - Mockito
    - H2 Database

**FrontEnd**
    - React
    - Axios
    - Material Design 

## Instrução para executar o backend:

Para executar o .jar via cmd, você pode seguir os seguintes passos:

Abra o prompt de comando (cmd).

Navegue até o diretório onde o arquivo .jar foi criado usando o comando cd. 

cd C:\SchoolManagement\SchoolManagement\api\target

Execute o arquivo .jar usando o comando java -jar. 

java -jar SchoolManagement-0.0.1-SNAPSHOT.jar

Lembre-se de substituir "C:\caminho\para\o\projeto" pelo caminho real para a pasta onde o .jar está localizado.

## Instrução para executar o frontend: 

Abra outro prompt de comando (cmd).

Navegue até o diretorio front, execute npm install para instalar dependências, e depois execute npm run dev

cd C:\SchoolManagement\front

npm install

npm run dev

## Premissas assumidas:
- Número fixo de disciplinas: Carlos ensina exatamente cinco disciplinas para todos os alunos. Portanto não haverá cadastro de matéria.
- Número fixo de nota por matéria: Cada aluno terá apenas uma nota por matéria, portanto para cálculo da média do aluno, serão consideradas as notas de todas as matérias. Dessa forma, a média informada, é a média geral do aluno.
- Edição das notas: As notas não serão editadas.
- Escala de notas: As notas variam de 0 a 10, utilizando números inteiros ou decimais
- Frequência em porcentagem: A presença dos alunos é registrada como um valor percentual de 0 a 100%.
- Turma única: O texto menciona apenas uma turma, então o sistema precisa lidar com os dados de apenas uma turma.
