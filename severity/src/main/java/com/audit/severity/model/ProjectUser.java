package com.audit.severity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="project_user")
public class ProjectUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int puid;
	private String uname;
	
	@ManyToOne(targetEntity=ProjectAudit.class)
	@JoinColumn(name="pid")
	@JsonBackReference
	ProjectAudit projectAudit;
}
