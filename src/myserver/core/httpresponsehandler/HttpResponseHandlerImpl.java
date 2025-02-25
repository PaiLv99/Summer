package myserver.core.httpresponsehandler;

import myserver.core.httpenum.HttpMethod;
import myserver.core.parser.Parser;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class HttpResponseHandlerImpl implements HttpResponseHandlerManager {

    private final Parser parser;
    private final HashMap<HttpMethod, HttpResponse> httpResponseHandlers;

    public HttpResponseHandlerImpl(Parser parser, HashMap<HttpMethod, HttpResponse> httpResponseHandlers) {
        this.parser = parser;
        this.httpResponseHandlers = httpResponseHandlers;
    }

    @Override
    public HttpResponse selectHttpResponseHandler(Socket socket) throws IOException {

        HttpMethod method = parser.parse(socket);

        HttpResponse httpResponseHandler = httpResponseHandlers.get(method);

        httpResponseHandler.setResponseObject(socket);

        return httpResponseHandler;
    }
}
