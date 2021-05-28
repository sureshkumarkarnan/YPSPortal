package com.yps.ypsconnect.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.yps.ypsconnect.model.Student.Gender;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@DiscriminatorValue("NP" )
public class StudentWithoutParent extends Student {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    @Column(name="GUARDIANNAME",columnDefinition = "varchar(80) default ' '")
    private String guardianName;
    
    @Column(name="RELATIONNAME", columnDefinition = "varchar(80) default ' '")
    private String relationName;

	
    
}
