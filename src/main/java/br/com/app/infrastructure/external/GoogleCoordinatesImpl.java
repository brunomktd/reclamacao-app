package br.com.app.infrastructure.external;

import br.com.app.core.ports.adapters.GoogleCoordinates;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
public class GoogleCoordinatesImpl implements GoogleCoordinates {

    @Value("${app.google.apiKey}")
    private String apiKey;

    @Override
    public List<Double> getCoordinates(String localidade) throws IOException, InterruptedException, ApiException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        GeocodingApiRequest request = GeocodingApi.newRequest(context).address(localidade);

        GeocodingResult[] results = request.await();

        GeocodingResult resultado = results[0];

        Geometry geometry = resultado.geometry;

        LatLng location = geometry.location;

        return Arrays.asList(location.lat, location.lng);
    }
}
