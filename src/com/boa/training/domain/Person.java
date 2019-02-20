package com.boa.training.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
	@XmlElement(name="PersonId")
	private int id,marks;
	@XmlElement(name="PersonName")
	private String personName;
	@XmlElementWrapper(name="Subjects")
	@XmlElement(name="Subject")
	private List<String> subjects;
	
	public Person() {
		super();
	}

	

	public Person(int id, int marks, String personName, List<String> subjects) {
		super();
		this.id = id;
		this.marks = marks;
		this.personName = personName;
		this.subjects = subjects;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	
}
