package ru.bezborodov.datageneratormicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;
import ru.bezborodov.datageneratormicroservice.model.Data;

@Service
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final KafkaSender<String, Object> sender;

    @Override
    public void send(Data data) {
        String topic = switch (data.getMeasurementType()) {
            case TEMPERATURE -> "data-temperature";
            case POWER -> "data-power";
            case VOLTAGE -> "data-voltage";
        };
        sender.send(
                        Mono.just(
                                SenderRecord.create(
                                        topic,
                                        null,
                                        System.currentTimeMillis(),
                                        String.valueOf(data.hashCode()),
                                        data,
                                        null
                                )
                        )
                )
                .subscribe();
    }
}
