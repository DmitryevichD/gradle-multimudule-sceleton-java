package ru.open.da.externalservice.clientwithapiexample;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.open.da.service.api.service.ResourceAmqpApi;
import ru.open.da.service.api.service.ResourceRestApi;
import ru.open.da.service.contract.model.message.ResourceMessage;

import java.util.UUID;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class ClientWithApiExampleApplication implements CommandLineRunner {
    private final ResourceAmqpApi resourceAmqpApi;
    private final ResourceRestApi resourceRestApi;

    public static void main(String[] args) {
        SpringApplication.run(ClientWithApiExampleApplication.class, args);
    }

    @SneakyThrows
    @Override
    public void run(String... args) {
        System.out.println("START CLIENT WITH API");

        for (int i = 0; i < 100; i++) {
            val message = new ResourceMessage();
            message.setResourceId(UUID.randomUUID());
            message.setResourceName(UUID.randomUUID().toString());
            resourceAmqpApi.sendMessage(message);
            log.info("SEND BY AMQP: {}", message);
            log.info("GET BY REST: {}", resourceRestApi.getRandomResource());
            Thread.sleep(1000);
        }

    }
}
