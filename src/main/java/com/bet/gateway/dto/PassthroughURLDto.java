package com.bet.gateway.dto;

import lombok.*;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class PassthroughURLDto extends BaseDto{
    private static final long serialVersionUId=3L;
    private String name;
    private String domain;
    private String apiUrl;
    private String requestUrl;
    private String method;
    private String routeId;
    private boolean useRewritePathAsApiUrl;

    public PassthroughURLDto(String id, String updatedBy, String createdBy, Long lastModifiedAt, Long createdAt, String name, String domain, String apiUrl, String requestUrl, String method, String routeId, boolean useRewritePathAsApiUrl) {
        super(id, updatedBy, createdBy, lastModifiedAt, createdAt);
        this.name = name;
        this.domain = domain;
        this.apiUrl = apiUrl;
        this.requestUrl = requestUrl;
        this.method = method;
        this.routeId = routeId;
        this.useRewritePathAsApiUrl = useRewritePathAsApiUrl;
    }

    public PassthroughURLDto(String name, String domain, String apiUrl, String requestUrl, String method, String routeId, boolean useRewritePathAsApiUrl) {
        this.name = name;
        this.domain = domain;
        this.apiUrl = apiUrl;
        this.requestUrl = requestUrl;
        this.method = method;
        this.routeId = routeId;
        this.useRewritePathAsApiUrl = useRewritePathAsApiUrl;
    }

    public PassthroughURLDto() {
    }

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
