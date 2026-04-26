package endpoints;

/*
Common URL: https://petstore.swagger.io/v2

Create User URL: https://petstore.swagger.io/v2/user
Get User URL: https://petstore.swagger.io/v2/user/{username}
Update User URL: https://petstore.swagger.io/v2/user/{username}
Delete User URL: https://petstore.swagger.io/v2/user/{username}
*/

import org.testng.util.Strings;

public class Routes
{
    //User Model Base URL's
     public static String base_url="https://petstore.swagger.io/v2";       //created static so we can call it by using class name

     //Endpoints
    public static String user_post_url=base_url+"/user";
    public static String user_get_url=base_url+"/user/{username}";
    public static String user_update_url=base_url+"/user/{username}";
    public static String user_delete_url=base_url+"/user/{username}";

}
