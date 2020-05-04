package com.assign.onetomany.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;

@Entity
@Table(name="Locality")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalityEntity {
	
	@Id
	@Column(name = "locality_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer locality;
	
	@Column(name = "street_name")
	private String streetName;
	
	@Column(name = "city")
	private String city;


	@OneToMany
	@JoinTable( name="locality_watertank",joinColumns= @JoinColumn(name="locality_id", referencedColumnName="locality_id"),
        inverseJoinColumns= @JoinColumn(name="watertank_id", referencedColumnName="watertank_id")
	)
	private List<WaterTankEntity> waterTankEntities = new ArrayList<WaterTankEntity>();
}
