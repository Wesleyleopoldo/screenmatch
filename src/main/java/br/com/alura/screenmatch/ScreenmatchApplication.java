package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.model.DadosEpisodeo;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporadas;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner{

	@Autowired
	ConsumoAPI consumoAPI;

	@Autowired
	ConverteDados converteDados;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();

		principal.exibirMenu();

		// var json = consumoAPI.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=6585022c");

		// System.out.println(json);

		// json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");

		// DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);

		// System.out.println(dados);

		// json = consumoAPI.obterDados("https://omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");

		// DadosEpisodeo dadosEpisodeo = converteDados.obterDados(json, DadosEpisodeo.class);

		// System.out.println(dadosEpisodeo);

		// List<DadosTemporadas> listDadosTemporadas = new ArrayList<>();

		// for(int indice = 1; indice <= dados.temporadas(); indice ++) {
		// 	json = consumoAPI.obterDados("https://omdbapi.com/?t=gilmore+girls&season="+ indice + "&apikey=6585022c");
			
		// 	DadosTemporadas temporada = converteDados.obterDados(json, DadosTemporadas.class);

		// 	listDadosTemporadas.add(temporada);
		// }

		// listDadosTemporadas.forEach(System.out::println);
	}

}
