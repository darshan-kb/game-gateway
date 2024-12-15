package com.bet.gateway.model;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
public class PassthroughURL extends BaseModel{
    @Field
    private String name;
    @Field
    private String domain;
    @Field("api_url")
    @Indexed(name = "passthrough_apiUrl")
    private String apiUrl;
    @Field("request_url")
    @Indexed(name = "passthrough_requestUrl")
    private String requestUrl;
    @Field
    private String method;
    @Field
    private String routeId;
    @Field
    private boolean useRewritePathAsApiUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public boolean isUseRewritePathAsApiUrl() {
        return useRewritePathAsApiUrl;
    }

    public void setUseRewritePathAsApiUrl(boolean useRewritePathAsApiUrl) {
        this.useRewritePathAsApiUrl = useRewritePathAsApiUrl;
    }
}
