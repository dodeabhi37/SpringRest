package com.nit.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "DOCTOR_INFO")
public class Doctor implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DOC_ID")
	private Integer docId;
	@Column(length = 20, name = "DOC_NAME")
	private String docName;
	@Column(length = 20, name = "SPECILIATION")
	private String specilization;
	@Column(name = "INCOME")
	private Double income;
	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", docName=" + docName + ", specilization=" + specilization + ", income="
				+ income + "]";
	}
	
	
	
}
