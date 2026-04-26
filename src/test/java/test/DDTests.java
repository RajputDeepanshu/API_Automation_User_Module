package test;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payload_POJO.User_POJO;
import utilities.DataProviders;

public class DDTests
{
    @Test(priority=1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUsers(String userId, String userName, String firstName, String lastName, String email, String pwd, String ph)
    {
        User_POJO userpojo=new User_POJO();
        userpojo.setId(Integer.parseInt(userId));
        userpojo.setUsername(userName);
        userpojo.setFirstName(firstName);
        userpojo.setLastName(lastName);
        userpojo.setEmail(email);
        userpojo.setPassword(pwd);
        userpojo.setPhone(ph);

        Response response= UserEndPoints.createUser(userpojo);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName)
    {
       Response response=UserEndPoints.deleteUser(userName);
       Assert.assertEquals(response.getStatusCode(), 200);
    }
}
