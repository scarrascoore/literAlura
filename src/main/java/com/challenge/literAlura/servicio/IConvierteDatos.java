package com.challenge.literAlura.servicio;

public interface IConvierteDatos {
    <T> T convierteDatos(String json, Class<T> clase);
}
