package myserver.core.httprequesthandler;

import myserver.core.httpenum.HttpMethod;
import myserver.core.parser.Parser;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class HttpRequestHandlerImpl implements HttpRequestHandler {


    private final HttpRequest httpRequest;

    public HttpRequestHandlerImpl(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Override
    public HttpRequest selectRequestHandler(Socket socket) {

        httpRequest.setRequestObject(socket);

        return httpRequest;
    }
}
