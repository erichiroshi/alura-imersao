package com.erichiroshi;

import com.erichiroshi.extratoresDeConteudo.ExtratorDeConteudo;
import com.erichiroshi.extratoresDeConteudo.ExtratorDeConteudoIMDB;
import com.erichiroshi.extratoresDeConteudo.ExtratorDeConteudoNASA;
import com.erichiroshi.geradoresDeFigurinhas.GeradoraDeFigurinhas;
import com.erichiroshi.geradoresDeFigurinhas.GeradoraDeFigurinhasIMDB;
import com.erichiroshi.geradoresDeFigurinhas.GeradoraDeFigurinhasNASA;

public enum API {

	IMDB(new ExtratorDeConteudoIMDB(), new GeradoraDeFigurinhasIMDB()),
	NASA(new ExtratorDeConteudoNASA(), new GeradoraDeFigurinhasNASA());

	private ExtratorDeConteudo extratorDeConteudo;
	private GeradoraDeFigurinhas geradoraDeFigurinhas;

	private API(ExtratorDeConteudo extratorDeConteudo, GeradoraDeFigurinhas geradoraDeFigurinhas) {
		this.extratorDeConteudo = extratorDeConteudo;
		this.geradoraDeFigurinhas = geradoraDeFigurinhas;
	}

	public ExtratorDeConteudo getExtratorDeConteudo() {
		return extratorDeConteudo;
	}

	public GeradoraDeFigurinhas getGeradoraDeFigurinhas() {
		return geradoraDeFigurinhas;
	}

}
