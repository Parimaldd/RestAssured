package api.endpoints;
/*
 * post - https://petstore.swagger.io/v2/user
 * get  - https://petstore.swagger.io/v2/user/{userName}
 * put -  https://petstore.swagger.io/v2/user/{userName}
 * Delete-https://petstore.swagger.io/v2/user/{userName}
 * 
 * 
 * 
 */

public class Routes {
	
	public static String base_url= "https://petstore.swagger.io/v2";
	
	public static String  post_url=base_url+"/user";
	public static String  get_url=base_url+"/user/{username}";
	public static String  put_url=base_url+"/user/{username}";
	public static String  delete_url=base_url+"/user/{username}";
	
	
}
