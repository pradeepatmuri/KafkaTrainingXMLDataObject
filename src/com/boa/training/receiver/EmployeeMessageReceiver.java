package com.boa.training.receiver;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.boa.training.domain.Employee;

public class EmployeeMessageReceiver {
	
	public static void main(String[] args) {
		Properties props = new Properties();
		
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.setProperty("value.deserializer", "com.boa.training.Deserializer.EmployeeDeserializer");
		props.setProperty("group.id", "test-group");
		
		KafkaConsumer<String,Employee> consumer = new KafkaConsumer<>(props);
		List<String> topicList = new ArrayList<>();
		topicList.add("emp-topicwith4");
		consumer.subscribe(topicList);
		System.out.println("subscribed to emp-topic");
		while(true) {
			ConsumerRecords<String, Employee> records = consumer.poll(Duration.ofSeconds(3));
			for(ConsumerRecord<String,Employee> record: records) {
				 System.out.println("message received with key: "+record.key());
		            System.out.println("value of the message ");
		            Employee e=record.value();
		            System.out.println(e.getEmpId()+"\t"+e.getEmpName()+"\t"+e.getDesignation());
			}
		}
		
 	}
}
