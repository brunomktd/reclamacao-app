package br.com.app.core.ports;

public interface Mapper {
    <T> T createMapper (Object source, Class<T> destination);
}
