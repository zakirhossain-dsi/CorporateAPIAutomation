package authentication;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.dataProvider.Excel2ConfigKey;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class LoginAPI2Test {

	@Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
	public void testLoginAPI(Map<String, String> config) throws JSONException {

		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();

		// Setting API's body
		String requestJSON = config.get("Param");

		builder.setBody(requestJSON);

		// Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");

		RequestSpecification requestSpec = builder.build();

		Response responseJSON =	
				given()
					.spec(requestSpec)
				.when()
					.post(config.get("URL"))
				.then()
						.statusCode(200)
						.body(matchesJsonSchemaInClasspath(config.get("SchemaPath")))
						.extract().response();

	}


	@Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
	public void testLogoutAPI(Map<String, String> config) throws JSONException {


		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();

		// Setting API's body
		String requestJSON = config.get("Param");

		builder.setBody(requestJSON);

		// Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");

		RequestSpecification requestSpec = builder.build();

		Response responseJSON =
				given()
					.spec(requestSpec)
				.when()
					.post(config.get("URL"))
				.then()
						.statusCode(200)
						.body(matchesJsonSchemaInClasspath(config.get("SchemaPath")))
						.extract().response();

	}

	@Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
	public void testRequestPasswordResetAPI(Map<String, String> config) throws JSONException {


		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();

		// Setting API's body
		String requestJSON = config.get("Param");

		builder.setBody(requestJSON);
		String st = "{\"Header\": {},\"Params\": {\"UserName\": \"ntm\"}}";
		// Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");

		RequestSpecification requestSpec = builder.build();

		Response responseJSON =
				given()
					.spec(requestSpec)
				.when()
					.post(config.get("URL"))
				.then()
					.statusCode(200)
					.body(matchesJsonSchemaInClasspath(config.get("SchemaPath")))
				.extract().response();

	}


	@Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
	public void testGetUserActionsAPI(Map<String, String> config) throws JSONException {
		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();

		// Setting API's body
		String requestJSON = config.get("Param");
		builder.setBody(requestJSON);
		// Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");

		RequestSpecification requestSpec = builder.build();

		Response responseJSON =
				given()
					.spec(requestSpec)
				.when()
					.post(config.get("URL"))
				.then()
					.statusCode(200)
					.body(matchesJsonSchemaInClasspath(config.get("SchemaPath")))
				.extract().response();

		System.out.println(responseJSON.asString());
	}

	@Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
	public void testGetRolesAuthenticatedUserAPI(Map<String, String> config) throws JSONException {
		// Building request using requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();

		// Setting API's body
		String requestJSON = config.get("Param");
		builder.setBody(requestJSON);
		// Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");

		RequestSpecification requestSpec = builder.build();

		Response responseJSON =
				given()
						.spec(requestSpec)
						.when()
						.post(config.get("URL"))
						.then()
						.statusCode(200)
						.body(matchesJsonSchemaInClasspath(config.get("SchemaPath")))
						.extract().response();

		System.out.println(responseJSON.asString());
	}


}
