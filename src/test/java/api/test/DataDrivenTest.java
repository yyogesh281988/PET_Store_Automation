package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {

	
	
	@Test(priority=1,dataProvider = "data",dataProviderClass = DataProviders.class)
	public void testPostUser(String userID,String userName,String fname,String lname,String userMail,String pwd,String ph)
	{
		User userPayload=new User();
		
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(userMail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response=UserEndPoints.createUser(userPayload);
		
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
//	@Test(priority=2,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
//	public void testGetUser(String userName)
//	{
//		Response response=UserEndPoints.readUser(userName);
//		
//		Assert.assertEquals(response.getStatusCode(),200);
//		System.out.println(response);
//		
//	}
//	
//	@Test(priority=3,dataProvider = "UserNames",dataProviderClass = DataProviders.class)
//	public void testDeleteUser(String userName)
//	{
//		
//		Response response=UserEndPoints.deleteUser(userName);
//		Assert.assertEquals(response.getStatusCode(),200);
//		
//	}
}
