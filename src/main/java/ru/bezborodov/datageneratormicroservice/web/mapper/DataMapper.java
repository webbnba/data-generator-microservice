package ru.bezborodov.datageneratormicroservice.web.mapper;

import org.mapstruct.Mapper;
import ru.bezborodov.datageneratormicroservice.model.Data;
import ru.bezborodov.datageneratormicroservice.web.dto.DataDto;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {
}
