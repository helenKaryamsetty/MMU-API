package com.iemr.mmu.data.nurse;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

@Entity

@Table(name = "t_cancerfamilyhistory")
public class BenFamilyCancerHistory {
	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long ID;
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;
	@Expose
	@Column(name = "CancerDiseaseType")
	private String cancerDiseaseType;
	@Expose
	@Column(name = "FamilyMember")
	private String familyMember;
	@Expose
	@Column(name = "Deleted", insertable = false)
	private Boolean deleted;
	@Expose
	@Column(name = "Processed", insertable = false, updatable = false)
	private Character processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@JsonIgnore
	@Transient
	private List<String> familyMemberList;

	public BenFamilyCancerHistory() {
	}

	public BenFamilyCancerHistory(Long iD, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String cancerDiseaseType, String familyMember, Boolean deleted, Character processed, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate, List<String> familyMemberList) {
		super();
		ID = iD;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.cancerDiseaseType = cancerDiseaseType;
		this.familyMember = familyMember;
		this.deleted = deleted;
		this.processed = processed;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
		this.familyMemberList = familyMemberList;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public String getCancerDiseaseType() {
		return cancerDiseaseType;
	}

	public void setCancerDiseaseType(String cancerDiseaseType) {
		this.cancerDiseaseType = cancerDiseaseType;
	}

	public String getFamilyMember() {
		return familyMember;
	}

	public void setFamilyMember(String familyMember) {
		this.familyMember = familyMember;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Character getProcessed() {
		return processed;
	}

	public void setProcessed(Character processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public List<String> getFamilyMemberList() {
		return familyMemberList;
	}

	public void setFamilyMemberList(List<String> familyMemberList) {
		this.familyMemberList = familyMemberList;
	}

}
