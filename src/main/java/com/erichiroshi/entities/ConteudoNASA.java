package com.erichiroshi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ConteudoNASA(String title, String url) implements Conteudo {

	@Override
	public String toString() {
		return title + "\n" + url + "\n";
	}
}