package br.com.app.util;

import br.com.app.core.ports.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("mapperUtil")
public class MapperImpl implements Mapper {

    public <T> T createMapper (Object source, Class<T> destination){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(source, destination);
    }
}
