package com.yps.ypsconnect.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.yps.ypsconnect.model.Admission.StudentType;
import com.yps.ypsconnect.model.Student.Gender;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "COURSE")
@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)

public class Course implements Serializable {


	private static final long serialVersionUID = -4423964478689438403L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COURSE_ID", unique = true, nullable = false)
	private Integer courseID;

	@Column(name = "COURSE_NAME", nullable = false)
	private String courseName;

	@Column(name = "STUDENT_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private StudentType studentType;

	
	@Column(name = "APPLICATION_FEE", nullable = false, unique = false)
	private Double applicationFee;

	@Column(name = "REGISTRATION_FEE", nullable = false, unique = false)
	private Double registrationFee;

	@Column(name = "ACTIVITY_FEE", nullable = false, unique = false)
	private Double activityFee;

	@Column(name = "STATIONARY_FEE", nullable = false, unique = false)
	private Double stationaryFee;

	@Column(name = "TERM1_FEE", nullable = false, unique = false)
	private Double term1Fee;

	@Column(name = "TERM2_FEE", nullable = false, unique = false)
	private Double term2Fee;

	@Column(name = "TERM3_FEE", nullable = false, unique = false)
	private Double term3Fee;

}
