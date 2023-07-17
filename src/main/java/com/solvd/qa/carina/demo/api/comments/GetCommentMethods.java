package com.solvd.qa.carina.demo.api.comments;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/comments", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/comments/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetCommentMethods extends AbstractApiMethodV2 {

    public GetCommentMethods() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }

}
