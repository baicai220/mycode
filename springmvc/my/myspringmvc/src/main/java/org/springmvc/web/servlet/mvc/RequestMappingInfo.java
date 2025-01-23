package org.springmvc.web.servlet.mvc;

import java.util.Objects;

/**
 * ClassName: RequestMappingInfo
 * Description: 请求映射信息，包含请求路径，还有请求方式.....
 * Datetime: 2024/4/3 15:16
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class RequestMappingInfo {
    /**
     * 请求路径
     */
    private String requestURI;

    /**
     * 请求方式
     */
    private String method;

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public RequestMappingInfo() {
    }

    public RequestMappingInfo(String requestURI, String method) {
        this.requestURI = requestURI;
        this.method = method;
    }

    /**
     * 重点：思考：为什么这个类的hashCode和equals必须重写。
     * RequestMappingInfo a = new RequestMappingInfo("/test", "GET");
     * RequestMappingInfo b = new RequestMappingInfo("/test", "GET");
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestMappingInfo that = (RequestMappingInfo) o;
        return Objects.equals(requestURI, that.requestURI) && Objects.equals(method, that.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestURI, method);
    }
}
