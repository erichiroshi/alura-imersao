package com.erichiroshi;

import java.util.List;

import com.erichiroshi.entities.Conteudo;
import com.erichiroshi.extratoresDeConteudo.ExtratorDeConteudo;
import com.erichiroshi.geradoresDeFigurinhas.GeradoraDeFigurinhas;
import com.erichiroshi.utils.LerProperties;

public class App {
	public static void main(String[] args) {
		String url = LerProperties.lerPropriedade("urlNasa");
		API api = API.NASA;

		ExtratorDeConteudo extratorDeConteudo = api.getExtratorDeConteudo();
		List<Conteudo> conteudos = extratorDeConteudo.extraiConteudos(url);
		imprimeLista(conteudos);

		GeradoraDeFigurinhas geradoraDeFigurinhas = api.getGeradoraDeFigurinhas();
		gerarFigurinhas(geradoraDeFigurinhas, conteudos);
	}

	private static void imprimeLista(List<Conteudo> conteudos) {
		conteudos.forEach(System.out::println);
	}

	private static void gerarFigurinhas(GeradoraDeFigurinhas geradoraDeFigurinhas, List<Conteudo> conteudos) {
		for (Conteudo conteudo : conteudos) {
			geradoraDeFigurinhas.cria(conteudo);
		}
	}

}