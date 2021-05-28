package com.yps.ypsconnect.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="CREDITDETAIL")
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)

public class CreditDetail implements Serializable{


	private static final long serialVersionUID = -8254339363111896350L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name="BILL_ID", nullable=false)
	private Credit credit;
	
	
	@Column(name = "FEE_TYPE",  nullable = false, length = 100)
    private String feeName;
	
	@Column(name = "AMOUNT",nullable=false)
    private Number  amount;

	
}
