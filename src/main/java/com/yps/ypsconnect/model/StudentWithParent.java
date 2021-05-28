package com.yps.ypsconnect.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.yps.ypsconnect.model.Student.Gender;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@DiscriminatorValue("P" )
public class StudentWithParent extends Student {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="FATHERNAME", columnDefinition = "varchar(80) default ' '")
    private String fathername ;
    
    @Column(name="MOTHERNAME", columnDefinition = "varchar(80) default ' '")
    private String mothername;

	    
}
