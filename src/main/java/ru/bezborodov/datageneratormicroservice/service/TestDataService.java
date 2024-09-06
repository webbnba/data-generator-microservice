package ru.bezborodov.datageneratormicroservice.service;

import ru.bezborodov.datageneratormicroservice.model.test.DataTestOptions;

public interface TestDataService {

    void sendMessages(DataTestOptions testOptions);
}
