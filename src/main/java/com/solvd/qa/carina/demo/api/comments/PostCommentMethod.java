package com.solvd.qa.carina.demo.api.comments;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

/**
 * The class represents a POST API method to create a new comment.
 * <p>
 * The `@ Endpoint` annotation specifies the URL for the endpoint for this API method.
 * The URL is constructed by combining a base URL, which is obtained from an environment
 * configuration (`config.env.api_url`), with a relative path `/comments`.
 * It also specifies that the HTTP method type used for this endpoint is POST.
 * <p>
 * The `@RequestTemplatePath` annotation specifies the path to the JSON file that is used
 * as the request template for this API method. This is 'api/comments/_post/rq.json' which
 * provides the structure for the request payload.
 * <p>
 * The `@ResponseTemplatePath` annotation specifies the path to the JSON file that is used
 * as the response template for this API method. This is 'api/comments/_post/rs.json' which
 * is used to validate the structure of the API response.
 * <p>
 * The `@SuccessfulHttpStatus` annotation is used to specify what should be the HTTP status
 * code of a successful API call, in this case, '201 Created' is expected for the successful
 * creation of a new comment.
 *
 * @author IsraelHG
 * @see com.zebrunner.carina.api.AbstractApiMethodV2
 * @since version 1.0
 */
@Endpoint(url = "${config.env.api_url}/comments", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/comments/_post/rq.json")
@ResponseTemplatePath(path = "api/comments/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostCommentMethod extends AbstractApiMethodV2 {
    public PostCommentMethod() {}
}