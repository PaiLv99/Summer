package myserver.core.httprequesthandler;

import myserver.core.httpenum.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

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

    public void setRequestObject(Socket socket)  {
        try( BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ) {

            String startLine = in.readLine();
            String[] words = startLine.split(" ");

            method = HttpMethod.valueOf(words[0]);
            url = words[1];
            protocolVersion = words[2];

            head = in.readLine();

            // empty line 처리
            in.readLine();

            if( in.ready() ){
                body = in.readLine();
            }

        }catch ( IOException e ){
            e.printStackTrace();
        }
    }
}
