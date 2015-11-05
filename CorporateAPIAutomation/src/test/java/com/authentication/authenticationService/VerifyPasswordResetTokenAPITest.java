package com.authentication.authenticationService;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import authentication.BaseAuthenticationServiceApi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.restassured.response.Response;

import dataProvider.Excel2Json;

public class VerifyPasswordResetTokenAPITest extends BaseAuthenticationServiceApi {

	@Test(dataProvider = "getRequestJSON", dataProviderClass = Excel2Json.class)
	public void testVerifyPasswordResetTokenAPI(JSONObject requestJSON)
			throws JSONException, InterruptedException, JsonProcessingException {

		Response responseAPI = getAPIResponse(requestJSON, "verifyPasswordResetToken", "POST");

		if (responseAPI.getStatusCode() == 200) {

			Assert.assertEquals(responseAPI.jsonPath().getString("Params.ResetToken"),
					requestJSON.getJSONObject("Params").getString("ResetToken"), "ResetToken not found on Response Params");
			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
			
		} else {
			
			Assert.assertEquals(responseAPI.jsonPath().getString("Params.ResetToken"),
					requestJSON.getJSONObject("Params").getString("ResetToken"), "UserName not found on Response Params");
			Assert.assertNull(responseAPI.jsonPath().getString("Data"), "Response Data is not null");
			Assert.assertNotNull(responseAPI.jsonPath().getString("Reasons.ReasonCode"));
		}

		System.out.println("**********Response from [verifyPasswordResetToken]**********");
		System.out.println(responseAPI.getBody().asString());
		System.out.println();

	}

}
