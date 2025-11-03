package com.audit.severity.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Project_Audit")
public class ProjectAudit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int projectId;
	@Column(unique=true)
	private String projectName;
	private String projectManagerName,applicationOwnername;
	
	@OneToMany(mappedBy="projectAudit",cascade = { CascadeType.ALL })
//	@JsonBackReference
	List<AuditDetails> auditDetails=new ArrayList<>();
	
	@OneToMany(mappedBy="projectAudit",cascade = { CascadeType.ALL })
	@JsonBackReference
	List<ProjectUser> projectUsers=new ArrayList<>();
	
	public ProjectAudit(String projectName, String projectManagerName, String applicationOwnername) {
		super();
		this.projectName = projectName;
		this.projectManagerName = projectManagerName;
		this.applicationOwnername = applicationOwnername;
	}
	
	
}
