package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * O @JsonAlias serve para ler o Json e passar o valor da chave para o paramêtro
 * sem ocorrer o erro de não achar a chave com o nome do atributo...
 * O @JsonProperty Ele lê o Json e retorna o mesmo nome se você for transformar os Atributos em Json novamente...
 */ 
// O @JsonIgnoreProperties as propriedades que não mapeei ele vai ignorar o ignoreUnknown vem false por default...
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(
    @JsonAlias("Title") String titulo,  
    @JsonAlias("totalSeasons") Integer temporadas,
    @JsonAlias("imdbRating") String avaliacao) {
    
}
