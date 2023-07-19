package com.solvd.qa.carina.demo.api.comments;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

/**
 * The class represents a PATCH API method to update an existing comment.
 * <p>
 * The `@Endpoint` annotation specifies the URL for the endpoint for this API method.
 * The URL is constructed by combining a base URL, which is obtained from an environment
 * configuration (`config.env.api_url`), with a variable part `${id}`, which stands for
 * the unique identifier of a comment, and a static path `/comments`.
 * This also specifies that the HTTP method type used for this endpoint is PATCH.
 * <p>
 * The `@RequestTemplatePath` annotation specifies the path to the JSON file that is used
 * as the request template for this API method. The location is 'api/comments/_patch/rq.json'
 * which provides the structure of request payload for updating a comment.
 * <p>
 * The `@ResponseTemplatePath` annotation specifies the path to the JSON file that is used
 * as the response template for this API method. The location is 'api/comments/_patch/rs.json'
 * which is used to validate the structure of the API response after updating a comment.
 * <p>
 * The `@SuccessfulHttpStatus` annotation is used to define what should be the HTTP status
 * code for a successful API call, in this case, '200 OK' signifies a successful update operation.
 *
 * @author IsraelHG
 * @see com.zebrunner.carina.api.AbstractApiMethodV2
 * @since version 1.0
 */
@Endpoint(url = "${config.env.api_url}/comments/${id}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/comments/_patch/rq.json")
@ResponseTemplatePath(path = "api/comments/_patch/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchCommentMethod extends AbstractApiMethodV2 {
    public PatchCommentMethod() {}
}