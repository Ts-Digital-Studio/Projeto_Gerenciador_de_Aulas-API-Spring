# Sistema de Gerenciamento de Aulas - Requisitos e Estrutura em POO

## Requisitos Funcionais

1. **Cadastro de Usuários**: 
   - Permitir o cadastro de alunos, professores e administradores.
   
2. **Login de Usuários**: 
   - Alunos, professores e administradores devem ser capazes de realizar login.

3. **Gerenciamento de Disciplinas**: 
   - Professores podem adicionar, editar e remover disciplinas vinculadas às suas turmas.

4. **Agendamento de Aulas**: 
   - Professores podem agendar aulas para suas disciplinas.

5. **Registro de Presenças**: 
   - Professores devem registrar a presença dos alunos em cada aula.

6. **Atribuição de Notas**: 
   - Professores podem atribuir e editar as notas dos alunos.

7. **Consulta de Horário**: 
   - Alunos e professores devem consultar seus horários de aulas.

8. **Consulta de Notas**: 
   - Alunos devem poder visualizar suas notas.

9. **Geração de Relatórios**: 
   - Administradores devem gerar relatórios de desempenho dos alunos, frequência e aulas realizadas.

---

## Requisitos Não Funcionais

1. **Usabilidade**: 
   - O sistema deve ser fácil de navegar e utilizar para todos os tipos de usuários.
   
2. **Segurança**: 
   - Garantir que somente usuários autorizados possam acessar determinadas funcionalidades.

3. **Desempenho**: 
   - O sistema deve suportar múltiplos acessos simultâneos sem perda de desempenho.

4. **Escalabilidade**: 
   - O sistema deve ser escalável para adicionar novas funcionalidades e mais usuários no futuro.

5. **Compatibilidade**: 
   - Acessível em diferentes dispositivos (computadores, tablets e smartphones).

---

## Regras de Negócio

1. **Restrição de Edição de Notas**: 
   - Apenas professores podem editar notas dos alunos, dentro de um prazo após o término da disciplina.

2. **Máximo de Alunos por Turma**: 
   - Cada turma pode ter até 30 alunos. Novos alunos não podem ser adicionados se o limite for atingido.

3. **Limite de Aulas por Dia**: 
   - O sistema deve impedir que uma turma tenha mais de 6 aulas por dia.

4. **Período de Agendamento de Aulas**: 
   - Aulas devem ser agendadas com no mínimo 24 horas de antecedência.

5. **Frequência Mínima**: 
   - Alunos precisam de frequência mínima de 75% em cada disciplina para serem aprovados.

---
# Estrutura com Relacionamento

## Usuário (Classe Base)
- **Atributos:**
  - `id`
  - `nome`
  - `cpf`
  - `email`
  - `telefone`
  - `endereco`
  - `tipoUsuario` (Enum: Aluno, Professor, Administrador)

- **Métodos:**
  - `realizarLogin()`
  - `consultarHorario()`
  - `consultarNotas()`

---

## Aluno (Herdeiro de Usuário)
- **Atributos:**
  - `turma` (Relacionamento: `@ManyToOne` com Turma)
  - `listaDeNotas` (Relacionamento: `@OneToMany` com Nota)
  - `listaDePresencas` (Relacionamento: `@OneToMany` com Presenca)
  - `listaDeDisciplinas` (Relacionamento: `@ManyToMany` com Disciplina)

- **Métodos:**
  - `consultarPresenca()`
  - `consultarNotas()`
  - `visualizarHorarioAulas()`

---

## Professor (Herdeiro de Usuário)
- **Atributos:**
  - `listaDeDisciplinas` (Relacionamento: `@OneToMany` com Disciplina)
  - `listaDeTurmas` (Relacionamento: `@ManyToMany` com Turma)
  - `horarioAulas` (Relacionamento: `@OneToMany` com Horario)

- **Métodos:**
  - `agendarAula()`
  - `registrarPresenca()`
  - `atribuirNota()`
  - `consultarHorarioAulas()`

---

## Turma
- **Atributos:**
  - `id`
  - `nome`
  - `listaDeAlunos` (Relacionamento: `@OneToMany` com Aluno)
  - `listaDeDisciplinas` (Relacionamento: `@ManyToMany` com Disciplina)
  - `professorResponsavel` (Relacionamento: `@ManyToOne` com Professor)

- **Métodos:**
  - `adicionarAluno()`
  - `removerAluno()`
  - `consultarHorario()`

---

## Disciplina
- **Atributos:**
  - `id`
  - `nome`
  - `professorResponsavel` (Relacionamento: `@ManyToOne` com Professor)
  - `listaDeTurmas` (Relacionamento: `@ManyToMany` com Turma)
  - `cargaHoraria`

- **Métodos:**
  - `consultarHorario()`
  - `listarAlunos()`
  - `cadastrarNota()`

---

## Aula
- **Atributos:**
  - `id`
  - `disciplina` (Relacionamento: `@ManyToOne` com Disciplina)
  - `turma` (Relacionamento: `@ManyToOne` com Turma)
  - `horario` (Relacionamento: `@ManyToOne` com Horario)
  - `status` (Enum: Concluída, Pendente)

- **Métodos:**
  - `agendarAula()`
  - `alterarHorario()`
  - `registrarPresenca()`

---

## Horario
- **Atributos:**
  - `id`
  - `data`
  - `horaInicio`
  - `horaFim`
  - `listaDeAulas` (Relacionamento: `@OneToMany` com Aula)

- **Métodos:**
  - `consultarAulas()`
  - `verificarDisponibilidade()`

---

## Relatório
- **Atributos:**
  - `periodo`
  - `listaDeAulasRealizadas`
  - `listaDeAlunosComNotas`
  - `listaDePresencas`

- **Métodos:**
  - `gerarRelatorioAulas()`
  - `gerarRelatorioPresencas()`
  - `gerarRelatorioDesempenho()`

---

# Exemplo de Relacionamento (Pseudocódigo)

```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario")
public abstract class Usuario {
    @Id
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario; // ALUNO, PROFESSOR, ADMINISTRADOR
}

@Entity
@DiscriminatorValue("ALUNO")
public class Aluno extends Usuario {
    @ManyToOne
    private Turma turma;

    @OneToMany
    private List<Nota> listaDeNotas;

    @OneToMany
    private List<Presenca> listaDePresencas;

    @ManyToMany
    private List<Disciplina> listaDeDisciplinas;

    // Métodos: consultarPresenca(), consultarNotas(), visualizarHorarioAulas()
}

@Entity
@DiscriminatorValue("PROFESSOR")
public class Professor extends Usuario {
    @OneToMany
    private List<Disciplina> listaDeDisciplinas;

    @ManyToMany
    private List<Turma> listaDeTurmas;

    @OneToMany
    private List<Horario> horarioAulas;

    // Métodos: agendarAula(), registrarPresenca(), atribuirNota(), consultarHorarioAulas()
}
