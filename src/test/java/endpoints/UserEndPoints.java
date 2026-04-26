package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload_POJO.User_POJO;

import static io.restassured.RestAssured.*;
//Created for Create, Read, Update and Delete\

public class UserEndPoints
{
     public static Response createUser(User_POJO payload)      //These end point we will invoke from test classes
     {
         Response response =given()
                 .contentType(ContentType.JSON)
                 .accept(ContentType.JSON)
                 .body(payload)
         .when()
                 .post(Routes.user_post_url);
          return response;
     }


    public static Response readUser(String userName)      //These end point we will invoke from test classes
    {
        Response response =given()
                .pathParam("username", userName)
        .when()
                .get(Routes.user_get_url);

        return response;
    }

    public static Response updateUser(String userName, User_POJO payload)      //These end point we will invoke from test classes
    {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParam("username", userName)
        .when()
                .put(Routes.user_update_url);
        return response;
    }


    public static Response deleteUser(String userName)      //These end point we will invoke from test classes
    {
        Response response =given()
                .pathParam("username", userName)
        .when()
                .delete(Routes.user_delete_url);
        return response;
    }


}

