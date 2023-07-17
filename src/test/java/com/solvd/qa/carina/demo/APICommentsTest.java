package com.solvd.qa.carina.demo;

import com.solvd.qa.carina.demo.api.comments.GetCommentMethods;
import com.solvd.qa.carina.demo.api.comments.PostCommentMethod;
import com.solvd.qa.carina.demo.api.users.PostUserMethod;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import java.lang.invoke.MethodHandles;

/**
 * This sample shows how create REST API tests.
 *
 * @author israel
 */
public class APICommentsTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "israel")
    public void testGetComments() {
        GetCommentMethods getCommentMethods = new GetCommentMethods();
        getCommentMethods.callAPIExpectSuccess();
        getCommentMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getCommentMethods.validateResponseAgainstSchema("api/comments/_get/rs.schema");
    }


    @Test()
    @MethodOwner(owner = "israel")
    public void testCreateComment() throws Exception {
        // Preparing of request
        PostCommentMethod api = new PostCommentMethod();
        api.setProperties("api/comments/comment.properties");
        // Making call to endpoint
        api.callAPIExpectSuccess();
        // Validation of response
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "israel")
    public void testCreateCommentMissingSomeFields() throws Exception {
        PostCommentMethod api = new PostCommentMethod();
        api.setProperties("api/comments/comment.properties");
        api.getProperties().remove("name");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}
