package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload_POJO.User_POJO;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.*;
//Created for Create, Read, Update and Delete\

public class UserEndPoints2
{

    //Method created for getting URL from properties file
    public static ResourceBundle getUrl()
    {
        //Path is not required getBundle method automatically get the properties file from the resources even .properties extension is not needed
        ResourceBundle routes=ResourceBundle.getBundle("routes");  //load property file
        return routes;
    }


    public static Response createUser(User_POJO payload)      //These end point we will invoke from test classes
    {

        String post_url=getUrl().getString("user_post_url");
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_url);
        return response;
    }


    public static Response readUser(String userName)      //These end point we will invoke from test classes
    {
        String get_url=getUrl().getString("user_get_url");
        Response response =given()
                .pathParam("username", userName)
                .when()
                .get(get_url);

        return response;
    }

    public static Response updateUser(String userName, User_POJO payload)      //These end point we will invoke from test classes
    {
        String update_url=getUrl().getString("user_update_url");
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username", userName)
                .when()
                .put(update_url);
        return response;
    }


    public static Response deleteUser(String userName)      //These end point we will invoke from test classes
    {
        String delete_url=getUrl().getString("user_delete_url");
        Response response =given()
                .pathParam("username", userName)
                .when()
                .delete(delete_url);
        return response;
    }


}

