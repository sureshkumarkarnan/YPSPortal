package com.yps.ypsconnect.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import lombok.AccessLevel;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@Table(name = "STUDENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ptype", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
public class Student implements Serializable {

	private static final long serialVersionUID = -3490095930809666192L;

	public static enum Gender {

		MALE, FEMALE
	};

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "REG_ID", length = 8, nullable = false, unique = true)
	private String regId;

	@Column(name = "FULLNAME", length = 80, unique = false)
	@NonNull
	private String fname;

	@Temporal(TemporalType.DATE)
	private Date DOB;

	@Enumerated(EnumType.STRING)
	private Gender gender;
	// other fields, getters and setters

	@Temporal(TemporalType.DATE)
	private Date admittedOn;

	@PrePersist
	void admittedOn() {
		this.admittedOn = new Date();
	}

	@Column(columnDefinition = "boolean default true")
	private Boolean active;

	@Column(name = "ADDRESS", length = 80, nullable = false, unique = false)
	private String address;

	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "EMAIL")) })
	@Embedded
	private EmailAddress email;

	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "EMAIL2")) })
	@Embedded
	private EmailAddress email2;

	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CONTACT")) })
	@Embedded
	private PhoneNumber contact;

	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CONTACT2")) })
	@Embedded
	private PhoneNumber contact2;

	@Column(name = "AADHAARID", length = 12, nullable = true, unique = true)
	private String aadhaarId;

	@Lob
	@Column(name = "PHOTO")
	private Byte[] photo;

	@OneToOne
	@JoinColumn(name = "ADMISSION_ID")
	private Admission admission;

}
