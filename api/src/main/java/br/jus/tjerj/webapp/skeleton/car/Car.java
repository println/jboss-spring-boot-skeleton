package br.jus.tjerj.webapp.skeleton.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.jus.tjerj.webapp.skeleton.student.Student;

@Entity
public class Car {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min=2, message="Name should have atleast 2 characters")
	private String model;
	
	@OneToOne
	private Student student;
	
	public Car() {
		super();
	}

	public Car(Long id, String name, Student student) {
		super();
		this.id = id;
		this.model = name;
		this.student = student;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
		
}
