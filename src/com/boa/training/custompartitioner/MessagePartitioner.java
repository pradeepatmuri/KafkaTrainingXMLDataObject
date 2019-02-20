package com.boa.training.custompartitioner;


import java.io.StringReader;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import com.boa.training.domain.Employee;

public class MessagePartitioner implements Partitioner {

	@Override
	public void configure(Map<String, ?> arg0) {
		
	}

	@Override
	public void close() {
		
	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		Employee emp = (Employee) value;
         int partition = 3;
         if(emp.getDesignation().equals("Accountent"))
        	 partition=0;
         else  if(emp.getDesignation().equals("Developer"))
        	 partition = 1;
         else  if(emp.getDesignation().equals("Architect"))
        	 partition =2;
         else
        	 partition =3;
		
		return partition;
	}

}
