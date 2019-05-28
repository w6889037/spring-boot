package com.huxc.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class NewProducer {
    private static Properties props = new Properties();
    static {
        // Kafka服务端的主机名和端口号
        props.put("bootstrap.servers", "localhost:9092");
        // 等待所有副本节点的应答
        props.put("acks", "all");
        // 消息发送最大尝试次数
        props.put("retries", 0);
        // 一批消息处理大小
        props.put("batch.size", 16384);
        // 请求延时
        props.put("linger.ms", 1);
        // 发送缓存区内存大小
        props.put("buffer.memory", 33554432);
        // key序列化
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // value序列化
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 构建拦截器链
        List<String> interceptors = new ArrayList<>();
        interceptors.add("com.huxc.kafka.interceptor.TimeInterceptor");
        interceptors.add("com.huxc.kafka.interceptor.CounterInterceptor");
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);
    }

    public static void main(String[] args) {
//        createProducer();
        createProducerWithCallBack();
    }

    public static void createProducer() {
        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 50; i++) {
            producer.send(new ProducerRecord<>("test", Integer.toString(i), "hello world-" + i));
        }
        producer.close();
    }

    public static void createProducerWithCallBack() {
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(props);
        for (int i = 0; i < 5; i++) {
            kafkaProducer.send(new ProducerRecord<>("test", "hello" + i), (metadata, exception) -> {
                if (metadata != null) {
                    System.err.println(metadata.partition() + "---" + metadata.offset());
                    System.out.println(metadata.topic() + "###############");
                }
            });
        }
        kafkaProducer.close();
    }
}
