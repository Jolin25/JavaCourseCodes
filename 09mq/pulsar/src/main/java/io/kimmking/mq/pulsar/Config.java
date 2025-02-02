package io.kimmking.mq.pulsar;

import lombok.SneakyThrows;
import org.apache.pulsar.client.api.PulsarClient;

public class Config {
    /**
     * 创建 Pulsar client
     * @date 2022/7/31
     * @param
     * @return
     */
    @SneakyThrows
    public static PulsarClient createClient() {
        return PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .build();
    }

}
