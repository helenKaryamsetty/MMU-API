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
package com.iemr.mmu.repo.quickConsultation;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.quickConsultation.PrescriptionDetail;

import jakarta.transaction.Transactional;

@Repository
public interface PrescriptionDetailRepo extends CrudRepository<PrescriptionDetail, Long> {

	@Query(" SELECT prescriptionID, beneficiaryRegID, benVisitID, providerServiceMapID, diagnosisProvided, "
			+ " instruction, externalInvestigation, visitCode from PrescriptionDetail ba "
			+ " WHERE ba.beneficiaryRegID = :benRegID AND ba.visitCode = :visitCode AND ba.deleted = false "
			+ " ORDER BY createdDate DESC ")
	public ArrayList<Object[]> getBenPrescription(@Param("benRegID") Long benRegID, @Param("visitCode") Long visitCode);

	public ArrayList<PrescriptionDetail> findByBeneficiaryRegIDAndVisitCode(Long benRegID, Long visitCode);
	
	public ArrayList<PrescriptionDetail> findByBeneficiaryRegIDAndVisitCodeOrderByPrescriptionIDDesc(Long benRegID,
			Long visitCode);

	@Query(" SELECT prescriptionID, beneficiaryRegID, benVisitID, providerServiceMapID, diagnosisProvided, instruction, "
			+ " visitCode FROM PrescriptionDetail ba "
			+ " WHERE ba.beneficiaryRegID = :benRegID AND ba.visitCode = :visitCode "
			+ " AND ba.deleted = false ORDER BY createdDate DESC ")
	public ArrayList<Object[]> getGeneralOPDDiagnosisDetails(@Param("benRegID") Long benRegID,
			@Param("visitCode") Long visitCode);

	@Query("SELECT processed from PrescriptionDetail where prescriptionID = :prescriptionID AND "
			+ " beneficiaryRegID=:benRegID AND visitCode = :visitCode")
	public String getGeneralOPDDiagnosisStatus(@Param("benRegID") Long benRegID, @Param("visitCode") Long visitCode,
			@Param("prescriptionID") Long prescriptionID);

	@Query(nativeQuery = true, value = "SELECT ExternalInvestigation FROM t_prescription "
			+ " WHERE BeneficiaryRegID=:benRegID AND VisitCode = :visitCode ORDER BY CreatedDate DESC LIMIT 1")
	public String getExternalinvestigationForVisitCode(@Param("benRegID") Long benRegID,
			@Param("visitCode") Long visitCode);
	@Query("SELECT prescriptionID from PrescriptionDetail a where a.visitCode= :visitCode")
	public Long getPrescriptionID(
			@Param("visitCode") Long visitCode);
	@Transactional
	@Modifying
	@Query("update PrescriptionDetail set diagnosisProvided=:diagnosisProvided, "
			+ " instruction=:instruction, externalInvestigation =:externalInvestigation, "
			+ " modifiedBy=:modifiedBy, processed=:processed, "
			+ " diagnosisProvided_SCTCode =:diagnosisProvided_SCTCode, "
			+ " diagnosisProvided_SCTTerm =:diagnosisProvided_SCTTerm "
			+ " where visitCode=:visitCode AND beneficiaryRegID=:beneficiaryRegID "
			+ " AND prescriptionID=:prescriptionID")
	public int updatePrescription(@Param("diagnosisProvided") String diagnosisProvided,
			@Param("instruction") String instruction, @Param("modifiedBy") String modifiedBy,
			@Param("processed") String processed, @Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("visitCode") Long visitCode, @Param("prescriptionID") Long prescriptionID,
			@Param("externalInvestigation") String externalInvestigation,
			@Param("diagnosisProvided_SCTCode") String diagnosisProvided_SCTCode,
			@Param("diagnosisProvided_SCTTerm") String diagnosisProvided_SCTTerm);

}
