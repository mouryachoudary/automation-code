package Api.endpoints;
//only urls this class
//https://petstore.swagger.io/v2/user/createWithList....>post
//https://petstore.swagger.io/v2/user/{username}.....>get
//https://petstore.swagger.io/v2/user/{username}......>put
//https://petstore.swagger.io/v2/user/{username}......>delate
public class routes {

public static String base_url="https://petstore.swagger.io/v2";
//usermodule
public static String post_url=base_url+"/user";
public static String get_url=base_url+"/user/{username}";
public static String put_url= base_url+"/user/{username}";
public static String delate_url= base_url+"/user/{username}";
}
