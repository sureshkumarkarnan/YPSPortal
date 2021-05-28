package com.yps.ypsconnect.model;



import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="CREDIT")
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)

public class Credit implements Serializable{


	private static final long serialVersionUID = -4282969764636921416L;

	public enum Mode 
	{
		CASH,
		CHEQUE,
		BANKTRANSFER
	}
	@Id
	@Column(name = "BILL_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer billID;
	
	@ManyToOne
	@JoinColumn(name="ID", nullable=false)
	private Student student;
	
    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_PAID", nullable=false)
    private Date datePaid;
	

	@Column(name = "TOTAL_AMOUNT",nullable=false)
    private Number  totalAmount;

    @Column(name = "MODE",nullable=false)
    @Enumerated(EnumType.STRING)
    private Mode mode;
    
	@Column(name = "CHEQUENO")
    private Integer chequeNo;
	

	@Column(name = "BANK")
    private String bank;

	 @Column(name = "IFSCCODE")
    private String ifsccode;
	
	
	@OneToMany(mappedBy = "credit", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<CreditDetail> creditDetails;


	
}
