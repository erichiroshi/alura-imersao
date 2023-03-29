package com.erichiroshi.extratoresDeConteudo;

import java.util.ArrayList;
import java.util.List;

import com.erichiroshi.clienteHttp.ClienteHttp;
import com.erichiroshi.entities.Conteudo;
import com.erichiroshi.entities.ConteudoIMDB;
import com.erichiroshi.extratoresDeConteudo.exceptions.ExtratorDeConteudoExceptions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo {

    @Override
    public List<Conteudo> extraiConteudos(String url) {

        try {
            String json = ClienteHttp.pegarJsonDaUrl(url);

            json = json.substring(9);
            json = json.replace(",\"errorMessage\":\"\"}", "");

            ObjectMapper objectMapper = new ObjectMapper();
            List<ConteudoIMDB> conteudosIMDB = objectMapper.readValue(json, new TypeReference<List<ConteudoIMDB>>() {});
            return new ArrayList<>(conteudosIMDB);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ExtratorDeConteudoExceptions("Erro ao extrair o conteúdo");
        }
    }
}