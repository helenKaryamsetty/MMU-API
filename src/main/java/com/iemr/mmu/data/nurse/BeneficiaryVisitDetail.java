/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mmu.data.nurse;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mmu.annotation.sqlinjection.SQLInjectionSafe;
import com.iemr.mmu.data.provider.ProviderServiceMapping;

@Entity
@Table(name = "t_benvisitdetail")
public class BeneficiaryVisitDetail {
	@Id
	@Expose
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "BenVisitID")
	private Long benVisitID;
	
	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "VisitCode")
	private Long visitCode;
	// @Expose
	// @OneToOne(fetch = FetchType.LAZY)
	// @JoinColumn(updatable = false, insertable = false, name = "BeneficiaryRegID")
	// private BeneficiaryData beneficiaryData;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@Expose
	@Transient
	private String serviceProviderName;

	@Expose
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(updatable = false, insertable = false, name = "providerServiceMapID")
	private ProviderServiceMapping providerServiceMapping;

	@Expose
	@Column(name = "VisitDateTime")
	private Timestamp visitDateTime;

	@Expose
	@Column(name = "VisitNo")
	private Short visitNo;

	@Expose
	@Column(name = "VisitReasonID")
	private Short visitReasonID;

	@Expose
	@Column(name = "VisitReason")
	private String visitReason;

	@Expose
	@Column(name = "VisitCategoryID")
	private Integer visitCategoryID;

	@Expose
	@Column(name = "VisitCategory")
	private String visitCategory;

	@Expose
	@Column(name = "PregnancyStatus")
	private String pregnancyStatus;

	@Expose
	@Column(name = "RCHID")
	private String rCHID;

	@Expose
	@Column(name = "HealthFacilityType")
	private String healthFacilityType;

	@Expose
	@Column(name = "HealthFacilityLocation")
	private String healthFacilityLocation;

	@Expose
	@Column(name = "ReportFilePath")
	private String reportFilePath;

	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;
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
	@Column(name = "LastModDate", insertable = false)
	private Timestamp lastModDate;

	@Expose
	@Column(name = "VisitFlowStatusFlag", insertable = false)
	private String visitFlowStatusFlag;

	@Expose
	@Column(name = "VanSerialNo")
	private Long vanSerialNo;

	@Expose
	@Column(name = "VehicalNo")
	private String vehicalNo;

	@Expose
	@Column(name = "VanID")
	private Integer vanID;

	@Expose
	@Column(name = "ParkingPlaceID")
	private Integer parkingPlaceID;

	@Expose
	@Column(name = "SyncedBy")
	private String syncedBy;

	@Expose
	@Column(name = "SyncedDate")
	private Timestamp syncedDate;

	@Expose
	@Column(name = "ReservedForChange")
	private String reservedForChange;

	@Expose
	@Transient
	private String[] fileIDs;

	@Expose
	@Transient
	private ArrayList<Map<String, String>> files;

	public BeneficiaryVisitDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BeneficiaryVisitDetail(Long benVisitID, Long beneficiaryRegID, Integer providerServiceMapID,
			Timestamp visitDateTime, Short visitNo, Short visitReasonID, String visitReason, Integer visitCategoryID,
			String visitCategory, String pregnancyStatus, String rCHID, String healthFacilityType,
			String healthFacilityLocation, String reportFilePath, Boolean deleted, String processed, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate, String visitFlowStatusFlag) {
		super();
		this.benVisitID = benVisitID;
		this.beneficiaryRegID = beneficiaryRegID;
		// this.beneficiaryData = beneficiaryData;
		this.providerServiceMapID = providerServiceMapID;
		this.visitDateTime = visitDateTime;
		this.visitNo = visitNo;
		this.visitReasonID = visitReasonID;
		this.visitReason = visitReason;
		this.visitCategoryID = visitCategoryID;
		this.visitCategory = visitCategory;
		this.pregnancyStatus = pregnancyStatus;
		this.rCHID = rCHID;
		this.healthFacilityType = healthFacilityType;
		this.healthFacilityLocation = healthFacilityLocation;
		this.reportFilePath = reportFilePath;
		this.deleted = deleted;
		this.processed = processed;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
		this.visitFlowStatusFlag = visitFlowStatusFlag;
	}

	public BeneficiaryVisitDetail(Long benVisitID, Long beneficiaryRegID, Long visitCode, Integer providerServiceMapID,
			Timestamp visitDateTime, Short visitNo, Short visitReasonID, String visitReason, Integer visitCategoryID,
			String visitCategory, String pregnancyStatus, String rCHID, String healthFacilityType,
			String healthFacilityLocation, String reportFilePath, Boolean deleted, String processed, String createdBy,
			Timestamp createdDate, String modifiedBy, Timestamp lastModDate) {
		super();
		this.benVisitID = benVisitID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.visitCode = visitCode;
		this.providerServiceMapID = providerServiceMapID;
		this.visitDateTime = visitDateTime;
		this.visitNo = visitNo;
		this.visitReasonID = visitReasonID;
		this.visitReason = visitReason;
		this.visitCategoryID = visitCategoryID;
		this.visitCategory = visitCategory;
		this.pregnancyStatus = pregnancyStatus;
		this.rCHID = rCHID;
		this.healthFacilityType = healthFacilityType;
		this.healthFacilityLocation = healthFacilityLocation;
		this.reportFilePath = reportFilePath;
		this.deleted = deleted;
		this.processed = processed;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
	}

	public BeneficiaryVisitDetail(Long benVisitID, Long beneficiaryRegID, Integer providerServiceMapID,
			Timestamp visitDateTime, Short visitNo, Short visitReasonID, String visitReason, Integer visitCategoryID,
			String visitCategory, String pregnancyStatus, String rCHID, String healthFacilityType,
			String healthFacilityLocation, String reportFilePath, String serviceProviderName) {
		super();
		this.benVisitID = benVisitID;
		this.beneficiaryRegID = beneficiaryRegID;
		this.providerServiceMapID = providerServiceMapID;
		this.visitDateTime = visitDateTime;
		this.visitNo = visitNo;
		this.visitReasonID = visitReasonID;
		this.visitReason = visitReason;
		this.visitCategoryID = visitCategoryID;
		this.visitCategory = visitCategory;
		this.pregnancyStatus = pregnancyStatus;
		this.rCHID = rCHID;
		this.healthFacilityType = healthFacilityType;
		this.healthFacilityLocation = healthFacilityLocation;
		this.reportFilePath = reportFilePath;
		this.serviceProviderName = serviceProviderName;
	}

	public Long getVisitCode() {
		return visitCode;
	}

	public void setVisitCode(Long visitCode) {
		this.visitCode = visitCode;
	}

	public String getServiceProviderName() {
		return serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	// public BeneficiaryData getBeneficiaryData() {
	// return beneficiaryData;
	// }
	//
	// public void setBeneficiaryData(BeneficiaryData beneficiaryData) {
	// this.beneficiaryData = beneficiaryData;
	// }

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Timestamp getVisitDateTime() {
		return visitDateTime;
	}

	public void setVisitDateTime(Timestamp visitDateTime) {
		this.visitDateTime = visitDateTime;
	}

	public Short getVisitNo() {
		return visitNo;
	}

	public void setVisitNo(Short visitNo) {
		this.visitNo = visitNo;
	}

	public Integer getVanID() {
		return vanID;
	}

	public void setVanID(Integer vanID) {
		this.vanID = vanID;
	}

	public Short getVisitReasonID() {
		return visitReasonID;
	}

	public void setVisitReasonID(Short visitReasonID) {
		this.visitReasonID = visitReasonID;
	}

	public String getVisitReason() {
		return visitReason;
	}

	public void setVisitReason(String visitReason) {
		this.visitReason = visitReason;
	}

	public Integer getVisitCategoryID() {
		return visitCategoryID;
	}

	public void setVisitCategoryID(Integer visitCategoryID) {
		this.visitCategoryID = visitCategoryID;
	}

	public String getVisitCategory() {
		return visitCategory;
	}

	public void setVisitCategory(String visitCategory) {
		this.visitCategory = visitCategory;
	}

	public String getPregnancyStatus() {
		return pregnancyStatus;
	}

	public void setPregnancyStatus(String pregnancyStatus) {
		this.pregnancyStatus = pregnancyStatus;
	}

	public String getrCHID() {
		return rCHID;
	}

	public void setrCHID(String rCHID) {
		this.rCHID = rCHID;
	}

	public String getHealthFacilityType() {
		return healthFacilityType;
	}

	public void setHealthFacilityType(String healthFacilityType) {
		this.healthFacilityType = healthFacilityType;
	}

	public String getHealthFacilityLocation() {
		return healthFacilityLocation;
	}

	public void setHealthFacilityLocation(String healthFacilityLocation) {
		this.healthFacilityLocation = healthFacilityLocation;
	}

	public String getReportFilePath() {
		return reportFilePath;
	}

	public void setReportFilePath(String reportFilePath) {
		this.reportFilePath = reportFilePath;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
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

	public String getVisitFlowStatusFlag() {
		return visitFlowStatusFlag;
	}

	public void setVisitFlowStatusFlag(String visitFlowStatusFlag) {
		this.visitFlowStatusFlag = visitFlowStatusFlag;
	}

	public ProviderServiceMapping getProviderServiceMapping() {
		return providerServiceMapping;
	}

	public void setProviderServiceMapping(ProviderServiceMapping providerServiceMapping) {
		this.providerServiceMapping = providerServiceMapping;
	}

	public Long getVanSerialNo() {
		return vanSerialNo;
	}

	public void setVanSerialNo(Long vanSerialNo) {
		this.vanSerialNo = vanSerialNo;
	}

	public String getVehicalNo() {
		return vehicalNo;
	}

	public void setVehicalNo(String vehicalNo) {
		this.vehicalNo = vehicalNo;
	}

	public Integer getParkingPlaceID() {
		return parkingPlaceID;
	}

	public void setParkingPlaceID(Integer parkingPlaceID) {
		this.parkingPlaceID = parkingPlaceID;
	}

	public String getSyncedBy() {
		return syncedBy;
	}

	public void setSyncedBy(String syncedBy) {
		this.syncedBy = syncedBy;
	}

	public Timestamp getSyncedDate() {
		return syncedDate;
	}

	public void setSyncedDate(Timestamp syncedDate) {
		this.syncedDate = syncedDate;
	}

	public String getReservedForChange() {
		return reservedForChange;
	}

	public void setReservedForChange(String reservedForChange) {
		this.reservedForChange = reservedForChange;
	}

	public String[] getFileIDs() {
		return fileIDs;
	}

	public void setFileIDs(String[] fileIDs) {
		this.fileIDs = fileIDs;
	}

	public ArrayList<Map<String, String>> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<Map<String, String>> files) {
		this.files = files;
	}

}
