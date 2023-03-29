package com.erichiroshi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ConteudoIMDB(String title, String image, Double imDbRating) implements Conteudo {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\u001b[1m\u001b[4mTítulo\u001b[0m: " + this.title() + "\n");
		sb.append("\u001b[1m\u001b[4mPoster\u001b[0m: " + this.image() + "\n");
		sb.append("\u001b[1m\u001b[4mClassificação\u001b[0m: " + imDbRating + "\n");
		sb.append(estrelas(imDbRating) + "\n");

		return sb.toString();
	}

	private String estrelas(Double imDbRating) {
		Integer rankEstrela = (int) Math.round(imDbRating);
		String estrela = "";
		for (int i = 0; i < rankEstrela; i++) {
			estrela += "\u2B50";
		}
		return estrela;
	}

}