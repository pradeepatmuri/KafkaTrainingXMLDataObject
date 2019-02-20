package com.boa.training.domain;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			JAXBContext context = JAXBContext.newInstance(Person.class);
			Marshaller marshaller =context.createMarshaller();
			Employee emp = new Employee(1,"Pradeep","JAVA Developer");
			Person per = new Person(1,100,"Pradeep",Arrays.asList("Maths","Science","Computers"));
			FileOutputStream fout = new FileOutputStream("person.xml");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(per, fout);
			fout.close();
			System.out.println("Marshalling done");
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
