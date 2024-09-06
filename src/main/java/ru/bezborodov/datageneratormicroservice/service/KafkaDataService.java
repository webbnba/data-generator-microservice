package ru.bezborodov.datageneratormicroservice.service;

import ru.bezborodov.datageneratormicroservice.model.Data;

public interface KafkaDataService {

    void send(Data data);
}
