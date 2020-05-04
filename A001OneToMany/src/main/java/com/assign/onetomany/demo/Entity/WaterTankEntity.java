package com.assign.onetomany.demo.Entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="WaterTank")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WaterTankEntity {
	
	@Id
	@Column( name="watertank_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer watertank;
	
	@Column( name="capacity")
	private Integer capacity;
	
	
	@Column( name="last_cleaned_date")
	private Date lastCleanedDate;
	

	
	
}
