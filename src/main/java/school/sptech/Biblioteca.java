package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nome;
    private List<Livro> livros;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public Biblioteca() {
    }

    public void adicionarLivro(Livro livro) throws ArgumentoInvalidoException {

        if (livro == null) {
            throw new ArgumentoInvalidoException("O livro não pode ser nulo. Tente novamente.");
        }

        if (livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            throw new ArgumentoInvalidoException("O título do livro escolhido não pode ser nulo. Insira um título válido.");
        }

        if (livro.getAutor() == null || livro.getAutor().isBlank()) {
            throw new ArgumentoInvalidoException("O autor do livro escolhido não pode ser nulo. Insira um autor corretamente.");
        }

        if (livro.getDataPublicacao() == null) {
            throw new ArgumentoInvalidoException("A data de publicação do livro não pode ser nula. Insira uma data corretamente.");
        }

        this.livros.add(livro);
    }

    public Livro buscarLivroPorTitulo(String titulo){

        if (titulo == null || titulo.isBlank()) {
            throw new ArgumentoInvalidoException("O título não pode ser nulo ou vazio. Tente novamente.");
        }

        for (Livro livro : this.livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }

        throw new LivroNaoEncontradoException("Livro não encontrado. Selecione um livro válido.");

    }

    public void removerLivroPorTitulo(String titulo) throws LivroNaoEncontradoException, ArgumentoInvalidoException{
        Livro livro = buscarLivroPorTitulo(titulo);
        livros.remove(livro);
    }

    public Integer contarLivros(){
        return this.livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) throws ArgumentoInvalidoException{
        List<Livro> livrosPorAno = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.getDataPublicacao().getYear() <= ano) {
                livrosPorAno.add(livro);
            }
        }
        return livrosPorAno;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
