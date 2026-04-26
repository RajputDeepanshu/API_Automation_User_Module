package test;

import com.github.javafaker.Faker;
import endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload_POJO.User_POJO;

public class UserTests
{
    Faker faker;
    User_POJO userpayload;
    public Logger logger;

    @BeforeClass
    public void setUpData()
    {
      faker=new Faker();
      userpayload=new User_POJO();

      userpayload.setId(faker.idNumber().hashCode());
      userpayload.setUsername(faker.name().username());
      userpayload.setFirstName(faker.name().firstName());
      userpayload.setLastName(faker.name().lastName());
      userpayload.setEmail(faker.internet().emailAddress());
      userpayload.setPassword(faker.internet().password(5, 10));
      userpayload.setPhone(faker.phoneNumber().cellPhone());

      //logs
      logger= LogManager.getLogger(this.getClass());
    }

    @Test(priority=1)
    public void testPostuser()
    {
        logger.info("*********** Creating user *************");

        Response response=UserEndPoints.createUser(userpayload);
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);

        logger.info("*********** User is Created *************");
    }

    @Test(priority =2)
    public void testGetUserByName()
    {
        logger.info("*********** Reading user info  *************");

       Response response=UserEndPoints.readUser(this.userpayload.getUsername());
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("*********** User info is displayed *************");
    }

    @Test(priority=3)
    public void testUpdateUserByName()
    {
        logger.info("*********** Updating user *************");

        //update data
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());

        Response response=UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
        response.then().log().all();

        //response.then().log().body().statusCode(200);  //In this way as well we can apply the assertion (Chai assertion)
        Assert.assertEquals(response.statusCode(), 200);

        //checking data after update
        Response response1=UserEndPoints.readUser(this.userpayload.getUsername());
        Assert.assertEquals(response1.getStatusCode(), 200);

        logger.info("*********** User is updated *************");
    }

   @Test(priority = 4)
    void testDeleteUserByName()
    {
        logger.info("*********** Deleting user *************");

       Response response= UserEndPoints.deleteUser(this.userpayload.getUsername());
       Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("*********** User is deleted *************");
    }
}
