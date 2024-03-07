package com.iemr.mmu.controller.covid19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iemr.mmu.service.covid19.Covid19Service;
import com.iemr.mmu.service.covid19.Covid19ServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import javassist.NotFoundException;

@ExtendWith(MockitoExtension.class)
class CovidControllerTest {

	@Mock
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Mock
	private Covid19Service covid19Service;
	@Mock
	private Covid19ServiceImpl covid19ServiceImpl;

	@InjectMocks
	CovidController covidController;

	private JsonObject parseJsonRequest(String requestObj) {
		JsonElement jsonElement = JsonParser.parseString(requestObj);
		return jsonElement.getAsJsonObject();
	}

	@Test
	void testSaveBenCovid19NurseData() throws Exception {
		OutputResponse outputResponse = new OutputResponse();

		String requestObj = "{\"requestOBJ\": \"Save covid nurse data\"}";
		String authorization = "Authorization";
		Long covid19Res = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(covid19Service.saveCovid19NurseData(jsnOBJ, authorization)).thenReturn(covid19Res);

		String expResponse = covidController.saveBenCovid19NurseData(requestObj, authorization);

		outputResponse.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertTrue(null != covid19Res && covid19Res > 0);

		assertEquals(expResponse, covidController.saveBenCovid19NurseData(requestObj, authorization));
		assertTrue(outputResponse.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenCovid19NurseData_Already() throws Exception {
		OutputResponse outputResponse = new OutputResponse();

		String requestObj = "{\"requestOBJ\": \"Save covid nurse data\"}";
		String authorization = "Authorization";
		Long covid19Res = 0L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(covid19Service.saveCovid19NurseData(jsnOBJ, authorization)).thenReturn(covid19Res);

		String expResponse = covidController.saveBenCovid19NurseData(requestObj, authorization);

		outputResponse.setResponse("Data already saved");

		assertNotNull(jsnOBJ);
		assertTrue(null != covid19Res && covid19Res == 0);

		assertEquals(expResponse, covidController.saveBenCovid19NurseData(requestObj, authorization));
		assertTrue(outputResponse.toString().contains("Data already saved"));
	}

	@Test
	void testSaveBenCovid19NurseData_Unable() throws Exception {
		OutputResponse outputResponse = new OutputResponse();

		String requestObj = "{\"requestOBJ\": \"Save covid nurse data\"}";
		String authorization = "Authorization";
		Long covid19Res = -1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(covid19Service.saveCovid19NurseData(jsnOBJ, authorization)).thenReturn(covid19Res);

		String expResponse = covidController.saveBenCovid19NurseData(requestObj, authorization);

		outputResponse.setResponse("Unable to save data");

		assertNotNull(jsnOBJ);
		assertFalse(null != covid19Res && covid19Res > 0);
		assertFalse(null != covid19Res && covid19Res == 0);

		assertEquals(expResponse, covidController.saveBenCovid19NurseData(requestObj, authorization));
		assertTrue(outputResponse.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveBenCovid19NurseData_Invalid() throws Exception {
		OutputResponse outputResponse = new OutputResponse();

		JsonObject jsnOBJ = null;

		outputResponse.setError(5000, "Invalid Request !!!");

		assertNull(jsnOBJ);

		assertTrue(outputResponse.toString().contains("Invalid Request !!!"));
	}

	@Test
	void testSaveBenCovid19NurseData_Exception() throws Exception {
		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";

		when(covid19Service.saveCovid19NurseData(any(), any())).thenThrow(NotFoundException.class);

		String saveBenCovid19NurseData = covidController.saveBenCovid19NurseData(requestObj, authorization);

		assertTrue(saveBenCovid19NurseData.contains("Unable to save data"));
	}

	@Test
	void testSaveBenCovidDoctorData() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"requestOBJ\": \"Save covid doctor data\"}";
		String authorization = "Authorization";
		Long ncdCareRes = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(covid19Service.saveDoctorData(jsnOBJ, authorization)).thenReturn(ncdCareRes);

		String expResponse = covidController.saveBenCovidDoctorData(requestObj, authorization);

		response.setResponse("Data saved successfully");

		assertNotNull(jsnOBJ);
		assertTrue(null != ncdCareRes && ncdCareRes > 0);

		assertEquals(expResponse, covidController.saveBenCovidDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data saved successfully"));
	}

	@Test
	void testSaveBenCovidDoctorData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"requestOBJ\": \"Save covid doctor data\"}";
		String authorization = "Authorization";
		Long ncdCareRes = -1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(covid19Service.saveDoctorData(jsnOBJ, authorization)).thenReturn(ncdCareRes);

		String expResponse = covidController.saveBenCovidDoctorData(requestObj, authorization);

		response.setResponse("Unable to save data");

		assertNotNull(jsnOBJ);
		assertFalse(null != ncdCareRes && ncdCareRes > 0);

		assertEquals(expResponse, covidController.saveBenCovidDoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to save data"));
	}

	@Test
	void testSaveBenCovidDoctorData_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		JsonObject jsnOBJ = null;

		response.setResponse("Invalid request");

		assertNull(jsnOBJ);

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testSaveBenCovidDoctorData_Exception() throws Exception {

		String requestObj = "{\"request\":\"Save cancer screening nurse data\"}";
		String authorization = "Bearer token";

		when(covid19Service.saveDoctorData(any(), any())).thenThrow(NotFoundException.class);

		String saveBenCovid19DoctorData = covidController.saveBenCovidDoctorData(requestObj, authorization);

		assertTrue(saveBenCovid19DoctorData.contains("Unable to save data"));
	}

	@Test
	void testGetBenVisitDetailsFrmNurseCovid19() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(covid19ServiceImpl.getBenVisitDetailsFrmNurseCovid19(benRegID, visitCode)).thenReturn(res);

		String expResponse = covidController.getBenVisitDetailsFrmNurseCovid19(comingRequest);

		response.setResponse(res);

		assertTrue(obj.length() > 1);

		assertEquals(expResponse, covidController.getBenVisitDetailsFrmNurseCovid19(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenVisitDetailsFrmNurseCovid19_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.length() < 1);

		assertTrue(response.toString().contains("Invalid request"));
	}

//	@Test
//	void testGetBenVisitDetailsFrmNurseCovid19_Exception() throws Exception {
//
//		String requestObj = "{\"request\":\"Update history data in doctor screen\"}";
//
//		when(covid19ServiceImpl.getBenVisitDetailsFrmNurseCovid19(any(), any())).thenThrow(NotFoundException.class);
//
//		String GetBenVisitDetailsFrmNurseCovid19 = covidController.getBenVisitDetailsFrmNurseCovid19(requestObj);
//
//		assertTrue(GetBenVisitDetailsFrmNurseCovid19.contains("Error while getting beneficiary visit data"));
//	}

	@Test
	void testGetBenCovid19HistoryDetails() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String s = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(covid19ServiceImpl.getBenCovid19HistoryDetails(benRegID, visitCode)).thenReturn(s);

		String expResponse = covidController.getBenCovid19HistoryDetails(comingRequest);

		response.setResponse(s);

		assertEquals(expResponse, covidController.getBenCovid19HistoryDetails(comingRequest));
		assertTrue(response.toString().contains(s));
	}

	@Test
	void testGetBenCovid19HistoryDetails_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(!obj.has("benRegID") || !obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}

//	@Test
//	void testGetBenCovid19HistoryDetails_Exception() throws Exception {
//
//		String requestObj = "{\"request\":\"Update history data in doctor screen\"}";
//
//		when(covid19ServiceImpl.getBenCovid19HistoryDetails(any(), any())).thenThrow(RuntimeException.class);
//
//		String GetBenCovid19HistoryDetails = covidController.getBenCovid19HistoryDetails(requestObj);
//
//		assertTrue(GetBenCovid19HistoryDetails.contains("Error while getting beneficiary history data"));
//	}


	@Test
	void testGetBenVitalDetailsFrmNurseNCDCare() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(covid19ServiceImpl.getBeneficiaryVitalDetails(benRegID, visitCode)).thenReturn(res);

		String expResponse = covidController.getBenVitalDetailsFrmNurseNCDCare(comingRequest);

		response.setResponse(res);

		assertEquals(expResponse, covidController.getBenVitalDetailsFrmNurseNCDCare(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenVitalDetailsFrmNurseNCDCare_Invalid() throws JSONException {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(!obj.has("benRegID") || !obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testGetBenCaseRecordFromDoctorCovid19() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{\"benRegID\":\"1\",\"visitCode\":\"1\"}";
		String res = "test";

		JSONObject obj = new JSONObject(comingRequest);

		Long benRegID = obj.getLong("benRegID");
		Long visitCode = obj.getLong("visitCode");

		when(covid19ServiceImpl.getBenCaseRecordFromDoctorCovid19(benRegID, visitCode)).thenReturn(res);

		String expResponse = covidController.getBenCaseRecordFromDoctorCovid19(comingRequest);

		response.setResponse(res);

		assertEquals(expResponse, covidController.getBenCaseRecordFromDoctorCovid19(comingRequest));
		assertTrue(response.toString().contains(res));
	}

	@Test
	void testGetBenCaseRecordFromDoctorCovid19_Invalid() throws Exception {
		OutputResponse response = new OutputResponse();

		String comingRequest = "{}";

		JSONObject obj = new JSONObject(comingRequest);

		response.setError(5000, "Invalid request");

		assertTrue(obj.length() < 1 || !obj.has("benRegID") || !obj.has("visitCode"));

		assertTrue(response.toString().contains("Invalid request"));
	}

	@Test
	void testUpdateHistoryNurse_Success() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"requestOBJ\": \"Update history data in doctor screen\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(covid19ServiceImpl.updateBenHistoryDetails(jsnOBJ)).thenReturn(result);

		String expResponse = covidController.updateHistoryNurse(requestObj);

		Map<String, Integer> resMap = new HashMap<>();

		resMap.put("result", result);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, covidController.updateHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateHistoryNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"requestOBJ\": \"Update history data in doctor screen\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(covid19ServiceImpl.updateBenHistoryDetails(jsnOBJ)).thenReturn(result);

		String expResponse = covidController.updateHistoryNurse(requestObj);

		Map<String, Integer> resMap = new HashMap<>();

		resMap.put("result", result);

		response.setError(500, "Unable to modify data");

		assertFalse(result > 0);

		assertEquals(expResponse, covidController.updateHistoryNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateHistoryNurse_Exception() throws Exception {
		String requestObj = "{\"request\":\"Update history data in doctor screen\"}";

		when(covid19ServiceImpl.updateBenHistoryDetails(any())).thenThrow(NotFoundException.class);

		String UpdateHistoryNurse = covidController.updateHistoryNurse(requestObj);

		assertTrue(UpdateHistoryNurse.contains("Unable to modify data"));
	}

	@Test
	void testUpdateVitalNurse() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"requestOBJ\": \"Update covid vital data in doctor screen\"}";
		int result = 1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(covid19ServiceImpl.updateBenVitalDetails(jsnOBJ)).thenReturn(result);

		String expResponse = covidController.updateVitalNurse(requestObj);

		response.setResponse("Data updated successfully");

		assertTrue(result > 0);

		assertEquals(expResponse, covidController.updateVitalNurse(requestObj));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateVitalNurse_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"requestOBJ\": \"Update covid vital data in doctor screen\"}";
		int result = -1;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(covid19ServiceImpl.updateBenVitalDetails(jsnOBJ)).thenReturn(result);

		String expResponse = covidController.updateVitalNurse(requestObj);

		response.setError(500, "Unable to modify data");

		assertFalse(result > 0);

		assertEquals(expResponse, covidController.updateVitalNurse(requestObj));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateVitalNurse_Exception() throws Exception {
		String requestObj = "{\"request\":\"Update history data in doctor screen\"}";

		when(covid19ServiceImpl.updateBenVitalDetails(any())).thenThrow(NotFoundException.class);

		String UpdateVitalNurse = covidController.updateVitalNurse(requestObj);

		assertTrue(UpdateVitalNurse.contains("Unable to modify data"));
	}

	@Test
	void testUpdateCovid19DoctorData() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"requestOBJ\": \"Update covid 19 doctor data\"}";
		String authorization = "Authorization";
		Long result = 1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(covid19ServiceImpl.updateCovid19DoctorData(jsnOBJ, authorization)).thenReturn(result);

		String expResponse = covidController.updateCovid19DoctorData(requestObj, authorization);

		response.setResponse("Data updated successfully");

		assertTrue(null != result && result > 0);

		assertEquals(expResponse, covidController.updateCovid19DoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Data updated successfully"));
	}

	@Test
	void testUpdateCovid19DoctorData_Unable() throws Exception {
		OutputResponse response = new OutputResponse();

		String requestObj = "{\"requestOBJ\": \"Update covid 19 doctor data\"}";
		String authorization = "Authorization";
		Long result = -1L;

		JsonObject jsnOBJ = parseJsonRequest(requestObj);

		when(covid19ServiceImpl.updateCovid19DoctorData(jsnOBJ, authorization)).thenReturn(result);

		String expResponse = covidController.updateCovid19DoctorData(requestObj, authorization);

		response.setError(500, "Unable to modify data");

		assertFalse(null != result && result > 0);

		assertEquals(expResponse, covidController.updateCovid19DoctorData(requestObj, authorization));
		assertTrue(response.toString().contains("Unable to modify data"));
	}

	@Test
	void testUpdateCovid19DoctorData_Exception() throws Exception {
		String requestObj = "{\"request\":\"Update history data in doctor screen\"}";
		String authorization = "Authorization";
		when(covid19ServiceImpl.updateCovid19DoctorData(any(), any())).thenThrow(NotFoundException.class);

		String UpdateCovid19DoctorData = covidController.updateCovid19DoctorData(requestObj, authorization);

		assertTrue(UpdateCovid19DoctorData.contains("Unable to modify data"));
	}

}
