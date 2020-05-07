package APITest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import utilities.APIUtil;

public class CRUD {

    SoftAssert softAssert;

    @Test
    public void getPostsListStatusCode(){
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        Assert.assertEquals(200,response.statusCode());
    }

    @Test
    public void hitGetNegative() {
        Response response = RestAssured.delete("https://jsonplaceholder.typicode.com/posts/1");
        System.out.println(response.statusCode());
        Assert.assertEquals(200,response.statusCode());
        response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
        System.out.println(response.statusCode());
        //This element has been deleted, still it is shown.
        Assert.assertEquals(404,response.statusCode());

    }

    @Test
    public void hitDeleteNegative() {
        //This element is not exist
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/9999999999");
        System.out.println(response.statusCode());
        Assert.assertEquals(404,response.statusCode());

        response = RestAssured.delete("https://jsonplaceholder.typicode.com/posts/9999999999");
        System.out.println(response.statusCode());
        //Status code is expected Bad Request because the element is not exist
        Assert.assertEquals(400,response.statusCode());
    }

    @Test
    public void putPositive() {

        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/10");
        System.out.println(response.statusCode());
        Assert.assertEquals(200,response.statusCode());

    }




    }
