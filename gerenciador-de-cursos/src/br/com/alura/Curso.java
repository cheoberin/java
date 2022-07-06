package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Curso {
	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<Aula>();
	private Set<Aluno> alunos = new HashSet<>();
	private Map<Integer, Aluno> matriculaAluno = new HashMap<>();
	private Map<String, Aluno> alunoMatricula = new HashMap<>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return this.nome;
	}

	public String getInstrutor() {
		return this.instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(this.aulas);
	}

	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

	public int getTempoTotal() {
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}

	@Override
	public String toString() {
		return "[Curso: " + this.getNome() + ", tempo total: " + this.getTempoTotal() + ", aulas: " + this.aulas + "]";
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.matriculaAluno.put(aluno.getNumeroMatricula(), aluno);
		this.alunoMatricula.put(aluno.getNome(), aluno);
	}

	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(this.alunos);
	}

	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	public Aluno buscaMatricula(int matricula) {
		return matriculaAluno.get(matricula);
	}

	public Aluno buscaMatriculado(String nome) {
		return alunoMatricula.get(nome);
	}
}
