package br.com.alura.screenmatch.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.screenmatch.model.DadosEpisodeo;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporadas;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

public class Principal {

    private Scanner ler = new Scanner(System.in);

    private final String ENDERECO = "https://omdbapi.com/?t=";

    private final String API_KEY = "&apikey=6585022c";

    public Principal() {
    }

    public void exibirMenu() {

        ConsumoAPI consumoAPI = new ConsumoAPI();
        ConverteDados converteDados = new ConverteDados();

        System.out.println("Digite o nome da série para buscar: ");
        String nomeSerie = ler.nextLine().toLowerCase();

        nomeSerie = nomeSerie.replace(" ", "+");

        var json = consumoAPI.obterDados(ENDERECO + nomeSerie + API_KEY);

        DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);

		System.out.println(dados);

        List<DadosTemporadas> listDadosTemporadas = new ArrayList<>();

		for(int indice = 1; indice <= dados.temporadas(); indice ++) {
			json = consumoAPI.obterDados(ENDERECO + nomeSerie + "&season="+ indice + API_KEY);
			
			DadosTemporadas temporada = converteDados.obterDados(json, DadosTemporadas.class);

			listDadosTemporadas.add(temporada);
		}

		// listDadosTemporadas.forEach(System.out::println);

        listDadosTemporadas.forEach(e -> e.episodeos().forEach(episodeo -> System.out.println(episodeo.titulo())));
    }
}
