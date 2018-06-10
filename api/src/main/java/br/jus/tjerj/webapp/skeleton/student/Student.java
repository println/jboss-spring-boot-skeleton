package br.jus.tjerj.webapp.skeleton.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="SKLTN_STUDENT", schema = "SKELETON")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_seq")
    @SequenceGenerator(name="student_id_seq", sequenceName = "STUDENT_ID_SEQ", allocationSize = 1)
	private Long id;
	
	@NotNull
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	
	@NotNull
	@Size(min=7, message="Passport should have atleast 2 characters")
	private String passportNumber;
	
	public Student() {
		super();
	}

	public Student(Long id, String name, String passportNumber) {
		super();
		this.id = id;
		this.name = name;
		this.passportNumber = passportNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
		
}
