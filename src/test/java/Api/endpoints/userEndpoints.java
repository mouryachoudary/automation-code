package Api.endpoints;
import static io.restassured.RestAssured.given;

import Api.paylods.pojouser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//created for pefrom create,read,update,delete request the user api
public class userEndpoints {
	public static Response createuser(pojouser userpayload)// payload means request body
		
	{	Response  response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(userpayload)
		.when()
		.post(routes.post_url);
		return response;
	}
public static Response getuser(String userName){
		
	 Response res =given()
			 .contentType(ContentType.JSON)
		.pathParam("username",userName)
		.when()
		.get(routes.get_url);
		return res;
	}
public static Response updateuser( String userName,pojouser userpayload){
	
	 Response response=given()
	 
	 .body(userpayload)
	 .pathParam("username",userName)
	 .when()
	 .put(routes.put_url);
	 return response;
	 
}
public static Response delateuser(String userName){
Response Response=given()
	
	.pathParam("username", userName)
	.when()
	.delete(routes.delate_url);
	return Response;
	}

	
}



