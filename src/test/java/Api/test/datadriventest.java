package Api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Api.endpoints.userEndpoints;
import Api.paylods.pojouser;
import Api.utilites.dataproviders;
import io.restassured.response.Response;


public class datadriventest {
	
@Test(priority=1,dataProvider="setdata",dataProviderClass=dataproviders.class)	
public void posttest(String Username,String firstname,String lnmae,String email,String password,String Ph) {
	
	 pojouser  userpayload =new pojouser();
//userpayload.setId(Integer.parseInt(userid));//here int convert to string
userpayload.setUsername(Username);
userpayload.setFirstName(firstname);
userpayload.setLastName(lnmae);
userpayload.setEmail(email);
userpayload.setPassword(password);
userpayload.setPhone(Ph);
Response res=userEndpoints.createuser(userpayload);
res.then().log().all();
Assert.assertEquals(res.getStatusCode(),200);
}
}
	



