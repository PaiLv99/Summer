package myserver.core.httprequesthandler;

import myserver.core.httpenum.HttpMethod;

import java.io.IOException;
import java.net.Socket;

public class HttpRequest {

    private HttpMethod method;
    private String url;
    private String protocolVersion;
    private String head;
    private String body;

    public void setRequestHandler(Socket socket) throws IOException {

    }
}
