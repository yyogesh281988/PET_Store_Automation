package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created for CRUD Operations

public class UserEndPoints {

	
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		
		return routes;
	}
	
	public static  Response createUser(User payload)
	{
		Response response=given().log().all().contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(getURL().getString("post_URL"));
		return response;
	}
	
	public static  Response readUser(String username)
	{
		Response response=given().log().all().pathParam("username", username).when()
		.get(getURL().getString("get_URL"));
		return response;
	}
	
	public static  Response updateUser(String user,User payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", user)
		.body(payload)
		.when()
		.put(getURL().getString("update_URL"));
		return response;
	}
	
	public static  Response deleteUser(String userName)
	{
		Response response=given().pathParam("username", userName).when()
		.delete(getURL().getString("delete_URL"));
		return response;
	}
	
	
}
