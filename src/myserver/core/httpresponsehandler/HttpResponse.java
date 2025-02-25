package myserver.core.httpresponsehandler;

import myserver.core.httpenum.HttpMessage;
import myserver.core.httprequesthandler.HttpRequest;

import java.io.IOException;
import java.net.Socket;

public class HttpResponse {
    private String protocolVersion;
    private int stateCode;
    private HttpMessage httpMessage;
    private String head;
    private String body;

    public void setResponseObject(Socket socket) {

    }
}
