package br.com.app.core.ports.adapters;

import com.google.maps.errors.ApiException;

import java.io.IOException;
import java.util.List;

public interface GoogleCoordinates {
    List<Double> getCoordinates(String localidade) throws IOException, InterruptedException, ApiException;
}
