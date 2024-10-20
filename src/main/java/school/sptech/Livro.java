package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {

    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes;

    public Livro(String titulo, String autor, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.avaliacoes = new ArrayList<>();
    }

    public Livro() {

    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas) throws ArgumentoInvalidoException {

        if (descricao == null || descricao.isBlank()) {
            throw new ArgumentoInvalidoException("Descrição inválida. O campo não pode ser nulo e nem ser vazio.");
        }

        if (qtdEstrelas == null || qtdEstrelas < 0 || qtdEstrelas > 5){
            throw new ArgumentoInvalidoException("Quantidade de estrelas inválida. O número deve estar entre 0 e 5.");
        }

        Avaliacao novaAvaliacao = new Avaliacao(descricao, qtdEstrelas);
        avaliacoes.add(novaAvaliacao);
    }

    public Double calcularMediaAvaliacoes(){

        if (avaliacoes.isEmpty()) {
            return 0.0;
        }

        Double mediaAvaliacoes = 0.0;
        Avaliacao avaliacoesDaVez;

        for (int i = 0; i < avaliacoes.size(); i++) {
            avaliacoesDaVez = avaliacoes.get(i);
            mediaAvaliacoes += avaliacoesDaVez.getQtdEstrelas();
        }

        return mediaAvaliacoes / avaliacoes.size();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                '}';
    }
}
