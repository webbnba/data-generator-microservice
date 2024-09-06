package ru.bezborodov.datageneratormicroservice.web.mapper;

import org.mapstruct.Mapper;
import ru.bezborodov.datageneratormicroservice.model.test.DataTestOptions;
import ru.bezborodov.datageneratormicroservice.web.dto.DataTestOptionsDto;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto> {
}
