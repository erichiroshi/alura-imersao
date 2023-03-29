package com.erichiroshi.extratoresDeConteudo;

import java.util.List;

import com.erichiroshi.entities.Conteudo;

public interface ExtratorDeConteudo {

    public List<Conteudo> extraiConteudos(String url);
}