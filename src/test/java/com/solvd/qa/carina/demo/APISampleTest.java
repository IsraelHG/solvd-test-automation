package com.solvd.qa.carina.demo;

import java.lang.invoke.MethodHandles;

import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.solvd.qa.carina.demo.api.users.DeleteUserMethod;
import com.solvd.qa.carina.demo.api.users.GetUserMethods;
import com.solvd.qa.carina.demo.api.users.PostUserMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUser() throws Exception {
//        LOGGER.info("test");
//        setCases("4555,54545");
        // Preparing of request
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");

//        AtomicInteger counter = new AtomicInteger(0);
//
//        // Making call to endpoint
//        api.callAPIWithRetry()
//                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
//                .peek(rs -> counter.getAndIncrement())
//                .until(rs -> counter.get() == 4)
//                .pollEvery(1, ChronoUnit.SECONDS)
//                .stopAfter(10, ChronoUnit.SECONDS)
//                .execute();

        // Making call to endpoint
        Response response = api.callAPIExpectSuccess();
//        String loc = response.getHeader("Location");
//        LOGGER.info(loc);
//        String name = response.jsonPath().getString("0.name");
//        Assert.assertEquals(name, "asdf", "Name is not expected");
//        LOGGER.info("name=" + name);
        // Validation of response
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUserMissingSomeFields() throws Exception {
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");
        api.getProperties().remove("name");
        api.getProperties().remove("username");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetUsers() {
        GetUserMethods getUsersMethods = new GetUserMethods();
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    public void testDeleteUsers() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        deleteUserMethod.setProperties("api/users/user.properties");
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }
}
