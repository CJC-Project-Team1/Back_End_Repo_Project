package com.infy.Small_Business_Finance_App.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cibil 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cibilId;
	private Integer cibilScore;
	private String cibilRemark;

}
