package com.yps.ypsconnect.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name = "ADMISSION")
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)

public class Admission implements Serializable {

	private static final long serialVersionUID = 7813280371992220241L;

	public enum StudentType {

		OLD, NEW, NEWSPECIAL
	};

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student student;

	@OneToOne
	@JoinColumn(name = "COURSE_ID")
	private Course enrolled_course;

	@Column(name = "TOTALFEE", nullable = false)
	private Double totalfee;

	@Column(name = "DISCOUNT", nullable = false)
	private Integer discount;

	@OneToMany(mappedBy = "student")
	private Set<Credit> credit;

	@Column(name = "AMOUNTPAID", nullable = false)
	private Double amount_paid;

	@Column(name = "COMMENTS")
	private String comments;

	@Column(name = "CLEARED", columnDefinition = "SMALLINT default 0", nullable = false)
	private boolean cleared;

}
