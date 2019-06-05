/*package com.lms.code.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "industry")
public class Industry {
	@Id
	@Column(name = "INDUSTRY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer industryId;

	@Column(name = "INDUSTRY_NAME")
	private String industryName;

	@OneToMany
	@Column(name = "INDUSTRY_TYPE")
	private String industryType;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

}
*/