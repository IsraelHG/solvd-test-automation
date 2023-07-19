package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.api.comments.GetCommentMethods;
import com.solvd.qa.carina.demo.api.comments.PatchCommentMethod;
import com.solvd.qa.carina.demo.api.comments.PostCommentMethod;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import java.lang.invoke.MethodHandles;

/**
 * This is a TestNG test class that tests the functionalities of a REST API that manages comments.
 * It implements the IAbstractTest interface which provides a common structure for TestNG tests.
 * <p>The class contains four test methods:</p>
 * <pre>
 *     1. testGetComments(): tests the "GET comments" endpoint.
 *     2. testCreateComment(): tests the "POST comments" endpoint.
 *     3. testCreateCommentMissingSomeFields(): Similar to testCreateComment() but also tests how the API handles missing fields in the request.
 *     4. testPatchComment(): first creates a new comment using the POST endpoint and then updates this comment using the PATCH endpoint.
 * </pre>
 * - All methods in this class are TestNG `@Test` methods, so they are meant to be used for testing. These tests can be run separately or together as part of a suite.<br>
 * - Each method uses the `callAPIExpectSuccess()` method to perform API calls and expects these calls to be successful (i.e., with a 2xx response status).<br>
 * - The `@MethodOwner` annotation is used to specify the owner of these test methods. This can be useful for identifying who to contact with questions or issues about these tests.<br>
 * - The `@TestPriority` annotation is used to specify the priority of each test method. Test priority is used to control the order in which tests are ran.<br>
 *
 * @author IsraelHG
 * @see com.zebrunner.carina.core.IAbstractTest
 * @see com.solvd.qa.carina.demo.api.comments.GetCommentMethods
 * @see com.solvd.qa.carina.demo.api.comments.PostCommentMethod
 * @see com.solvd.qa.carina.demo.api.comments.PatchCommentMethod
 */
public class APICommentsTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    /**
     * This is a TestNG test method designed to test the GET comments endpoint of the API.
     * <p>The test does the following:</p>
     * <pre>
     *      1. Creates an instance of GetCommentMethods class which represents the GET comments API method.
     *      2. Calls the API method expecting success (HTTP status code 2xx).
     *      3. Validates the API response against two criteria:
     *         - The response matches a certain JSON structure using the STRICT mode of JSONCompareMode. This mode ensures every detail matches between the actual and expected JSON.
     *         - The response matches a predefined JSON schema located at "api/comments/_get/rs.schema". This checks whether the response adheres to the schema.
     * </pre>
     * The method is annotated with `@Test` indicating it is a test method from TestNG framework.<br>
     * The `@MethodOwner` annotation indicates that the owner of this test method. This could be useful for tracking who's responsible for the test.<br>
     * The `@TestPriority` annotation is used to determine the priority of this test method. The value `Priority.P1` represents
     * the highest priority.<br>
     *
     * @since version 1.0
     * @see Test
     * @see MethodOwner
     * @see TestPriority
     */
    @Test()
    @TestPriority(Priority.P1)
    @MethodOwner(owner = "IsraelHG")
    public void testGetComments() {
        GetCommentMethods getCommentMethods = new GetCommentMethods();
        getCommentMethods.callAPIExpectSuccess();
        getCommentMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCommentMethods.validateResponseAgainstSchema("api/comments/_get/rs.schema");
    }

    /**
     * This is a TestNG test method that tests the POST comments endpoint of the API.
     *
     * <p>The test follows these steps:</p>
     * <pre>
     *      1. Creates an instance of the PostCommentMethod class, which represents the POST comments API method.
     *      2. Sets the properties for the request from a properties file located at "api/comments/comment.properties".
     *      3. Calls the API endpoint expecting the call to be successful (HTTP status code 2xx).
     *      4. Validates the response from the API call.
     * </pre>
     * This method is annotated with `@Test`, signifying that it's a test method from the TestNG framework.<br>
     * The `@MethodOwner` annotation indicates that the owner of this test method. This could be useful for tracking who's responsible for the test.<br>
     * The `@TestPriority` annotation assigns a priority to this test. The value `Priority.P2` means it has a high but not the highest priority.<br>
     *
     * @since version 1.0
     * @see Test
     * @see MethodOwner
     * @see TestPriority
     */
    @Test()
    @MethodOwner(owner = "IsraelHG")
    @TestPriority(Priority.P2)
    public void testCreateComment() {
        PostCommentMethod api = new PostCommentMethod();
        api.setProperties("api/comments/comment.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    /**
     * This is a TestNG test method that tests the POST comments endpoint of the API, specifically when some
     * fields are missing in the request.
     *
     * <p>The test executes the following steps:</p>
     * <pre>
     *      1. Creates an instance of the PostCommentMethod class, which represents the POST comments API method.
     *      2. Sets the properties for the request from a properties file located at "api/comments/comment.properties".
     *      3. Removes the specified properties from the request.
     *      4. Calls the API endpoint expecting the call to be successful (HTTP status code 2xx). This is possibly expecting the server to handle the missing fields successfully.
     *      5. Validates the response from the API call.
     * </pre>
     * This method has the `@Test` annotation, indicating it's a test method from the TestNG framework.<br>
     * The `@MethodOwner` annotation states that the owner of this test method. This could be useful for identifying who is responsible for the test.<br>
     * The `@TestPriority` annotation assigns this test a `Priority.P3` priority level. This means it has a standard priority level according to the test plan. <br>
     *
     * @since version 1.0
     * @see Test
     * @see MethodOwner
     * @see TestPriority
     */
    @Test()
    @MethodOwner(owner = "IsraelHG")
    @TestPriority(Priority.P3)
    public void testCreateCommentMissingSomeFields() {
        PostCommentMethod api = new PostCommentMethod();
        api.setProperties("api/comments/comment.properties");
        api.getProperties().remove("name");
        api.getProperties().remove("body");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    /**
     * This is a TestNG test method that tests the PATCH comments endpoint of the API.
     *
     * <p>This test encompasses the following steps:</p>
     * <pre>
     *      1. Creates an instance of the PostCommentMethod class and sets properties for the API request using the file
     *      at "api/comments/comment.properties".
     *      2. Calls the POST comment API endpoint, expecting a successful response (HTTP status code 2xx), and retrieves the response.
     *      3. Extracts the "id" field from the returned JSON object, which will be used for the subsequent PATCH request.
     *      4. Creates an instance of the PatchCommentMethod class, replaces the "id" URL placeholder with the extracted post id, and sets the properties using the same property file.
     *      5. Calls the PATCH comment API endpoint expecting a successful response (HTTP status code 2xx), and validates the response.
     * </pre>
     * The presence of the `@Test` annotation indicates that it's a test method from the TestNG framework.<br>
     * The `@MethodOwner` annotation states that the owner of this test method. This could be useful for identifying who is responsible for the test.<br>
     * Using the `@TestPriority` annotation, the priority of this test method is established as `Priority.P4`, which suggests it has a lower priority than P1, P2, and P3.<br>
     *
     * @since version 1.0
     * @see Test
     * @see MethodOwner
     * @see TestPriority
     */
    @Test()
    @MethodOwner(owner = "IsraelHG")
    @TestPriority(Priority.P4)
    public void testPatchComment() {
        // Creates a new comment and uses POST method
        PostCommentMethod api = new PostCommentMethod();
        api.setProperties("api/comments/comment.properties");
        // Makes call to endpoint, retrieves response
        Response response = api.callAPIExpectSuccess();
        String postId = response.jsonPath().getString("id");

        // Update created comment using PATCH method
        PatchCommentMethod patchApi = new PatchCommentMethod();
        patchApi.replaceUrlPlaceholder("id", postId);
        patchApi.setProperties("api/comments/comment.properties");
        patchApi.callAPIExpectSuccess();
        patchApi.validateResponse();
    }
}