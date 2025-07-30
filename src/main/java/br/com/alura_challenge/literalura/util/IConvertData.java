package br.com.alura_challenge.literalura.util;

public interface IConvertData {
    <T> T getData(String json, Class<T> tclass);
}
