package Api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Api.endpoints.User;
import Api.endpoints.userEndpoints;
import Api.paylods.pojouser;
import io.restassured.response.Response;

public class Usertests {
	  Faker fake;
	  pojouser userpayload;
	
	@BeforeClass
	public void setupdata() {
		fake=new Faker();
		userpayload=new pojouser();
	userpayload.setId(fake.idNumber().hashCode());
	userpayload.setUsername(fake.name().username());
	userpayload.setFirstName(fake.name().firstName());
	userpayload.setLastName(fake.name().lastName());
	userpayload.setEmail(fake.internet().safeEmailAddress());
	userpayload.setPassword(fake.internet().password(5,10));
	userpayload.setPhone(fake.phoneNumber().cellPhone());
	}
	@Test(priority=1)
	public void testpostUser() {
		Response res=userEndpoints.createuser(userpayload);
res.then().log().all();
Assert.assertEquals(res.getStatusCode(),200);
}
	@Test(priority=2)
	public void testgetuser() {
Response res=userEndpoints.getuser(this.userpayload.getUsername());
res.then().log().all();
res.headers();
res.cookies();
Assert.assertEquals(res.getStatusCode(),200);
}
	@Test(priority=3)
	public void updateuser() {
		userpayload.setFirstName(fake.name().firstName());
		userpayload.setLastName(fake.name().lastName());
		userpayload.setEmail(fake.internet().safeEmailAddress());
Response res=userEndpoints.updateuser(this.userpayload.getUsername(),userpayload);
res.then().log().all();
Assert.assertEquals(res.getStatusCode(),415);
//update usernames
Response responseupdate=userEndpoints.getuser(this.userpayload.getUsername());
Assert.assertEquals(responseupdate.statusCode(),200);
}
	@Test(priority=4)
	public void testdelateuser() {
		Response response=userEndpoints.delateuser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
}
}
