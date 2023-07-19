package com.solvd.qa.carina.demo.api.comments;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

/**
 * The class represents a GET API method to fetch comments.
 * <p>
 * The `@Endpoint` annotation specifies the URL for the endpoint for this API method.
 * The URL is constructed by combining a base URL, which is obtained from an environment
 * configuration (`config.env.api_url`), with a relative path `/comments`.
 * This also specifies that the HTTP method type used for this endpoint is GET.
 * <p>
 * The `@ResponseTemplatePath` annotation specifies the path to the JSON file that is used
 * as the response template for this API method. This is 'api/comments/_get/rs.json' which
 * is used to validate the structure of the API response.
 * <p>
 * The `@SuccessfulHttpStatus` annotation is used to specify what should be the HTTP status
 * code of a successful API call, in this case, it's '200 OK'.
 *
 * @author IsraelHG
 * @see com.zebrunner.carina.api.AbstractApiMethodV2
 * @since version 1.0
 */
@Endpoint(url = "${config.env.api_url}/comments", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/comments/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCommentMethods extends AbstractApiMethodV2 {
    public GetCommentMethods() {
    }
}