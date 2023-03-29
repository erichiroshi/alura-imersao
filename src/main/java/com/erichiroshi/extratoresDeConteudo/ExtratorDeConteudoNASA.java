package com.erichiroshi.extratoresDeConteudo;

import java.util.ArrayList;
import java.util.List;

import com.erichiroshi.clienteHttp.ClienteHttp;
import com.erichiroshi.entities.Conteudo;
import com.erichiroshi.entities.ConteudoNASA;
import com.erichiroshi.extratoresDeConteudo.exceptions.ExtratorDeConteudoExceptions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtratorDeConteudoNASA implements ExtratorDeConteudo{

    @Override
    public List<Conteudo> extraiConteudos(String url) {

        try {
            String json = ClienteHttp.pegarJsonDaUrl(url);

            ObjectMapper objectMapper = new ObjectMapper();
            List<ConteudoNASA> conteudosNASA = objectMapper.readValue(json, new TypeReference<List<ConteudoNASA>>() {});
            return new ArrayList<Conteudo>(conteudosNASA);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ExtratorDeConteudoExceptions("Erro ao extrair o conteúdo");
        }
    }
}