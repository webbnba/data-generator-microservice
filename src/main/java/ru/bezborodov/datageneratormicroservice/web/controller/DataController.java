package ru.bezborodov.datageneratormicroservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bezborodov.datageneratormicroservice.model.Data;
import ru.bezborodov.datageneratormicroservice.model.test.DataTestOptions;
import ru.bezborodov.datageneratormicroservice.service.KafkaDataService;
import ru.bezborodov.datageneratormicroservice.service.TestDataService;
import ru.bezborodov.datageneratormicroservice.web.dto.DataDto;
import ru.bezborodov.datageneratormicroservice.web.dto.DataTestOptionsDto;
import ru.bezborodov.datageneratormicroservice.web.mapper.DataMapper;
import ru.bezborodov.datageneratormicroservice.web.mapper.DataTestOptionsMapper;

@RestController
@RequestMapping("api/v1/data")
@RequiredArgsConstructor
public class DataController {

    private final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;
    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    @PostMapping("/send")
    public void send(@RequestBody DataDto dataDto) {
        Data data = dataMapper.toEntity(dataDto);
        kafkaDataService.send(data);
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }
}
