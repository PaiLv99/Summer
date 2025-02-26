package myserver.core.httprequesthandler;

import myserver.core.httpenum.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.http.HttpHeaders;

public class HttpRequest {

    private HttpMethod method;
    private String url;
    private String protocolVersion;
    private String head;
    private String body;

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setRequestObject(HttpMethod method, String url, String protocolVersion, String head, String body)  {
        this.method = method;
        this.url = url;
        this.protocolVersion = protocolVersion;
        this.head = head;
        this.body = body;
    }


}
