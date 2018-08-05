package br.jus.tjerj.skeleton.features.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.jus.tjerj.skeleton.features.student.Student;

@Entity
@Table(name="SKLTN_CAR", schema = "SKELETON")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_id_seq")
    @SequenceGenerator(name="car_id_seq", sequenceName = "CAR_ID_SEQ",  allocationSize = 1)
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
