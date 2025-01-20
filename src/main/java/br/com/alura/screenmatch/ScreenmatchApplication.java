package br.com.alura.screenmatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.screenmatch.model.DadosSerie;
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
		var json = consumoAPI.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=6585022c");

		// System.out.println(json);

		// json = consumoAPI.obterDados("https://coffee.alexflipnote.dev/random.json");

		DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);

		System.out.println(dados);
	}

}
