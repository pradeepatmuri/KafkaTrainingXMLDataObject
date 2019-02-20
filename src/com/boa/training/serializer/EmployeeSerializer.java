package com.boa.training.serializer;

import java.io.StringWriter;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.kafka.common.serialization.Serializer;

import com.boa.training.domain.Employee;

public class EmployeeSerializer implements Serializer<Employee>{

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] serialize(String topic, Employee data) {
		byte[] array =null;
		// TODO Auto-generated method stub
		try {
			JAXBContext context = JAXBContext.newInstance(Employee.class);
			Marshaller marshaller = context.createMarshaller();
			StringWriter writer = new StringWriter();
			marshaller.marshal(data, writer);
			String xmlContent =writer.toString();
			System.out.println("converted to XML"+xmlContent);
			array = xmlContent.getBytes();
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return array;
	}
	

}
