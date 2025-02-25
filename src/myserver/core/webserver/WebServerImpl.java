package myserver.core.webserver;

import myserver.core.httpenum.HttpMessage;
import myserver.core.httprequesthandler.HttpRequest;
import myserver.core.httprequesthandler.HttpRequestHandler;
import myserver.core.httpresponsehandler.HttpResponse;
import myserver.core.httpresponsehandler.HttpResponseHandler;
import myserver.core.util.Util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerImpl implements WebServer{

    private final int port;
    private final HttpRequestHandler httpRequestHandler;
    private final HttpResponseHandler httpResponseHandler;

    public WebServerImpl(int port, HttpRequestHandler httpRequestHandler, HttpResponseHandler httpResponseHandler) {
        this.port = port;
        this.httpRequestHandler = httpRequestHandler;
        this.httpResponseHandler = httpResponseHandler;
    }

    @Override
    public void Accept() {
        try( ServerSocket serverSocket = new ServerSocket(port) ){
            while( true ) {
                Socket clientSocket = serverSocket.accept();

                if( Util.validHttpRequest(clientSocket) != HttpMessage.OK ) {

                    HttpResponse httpResponse = httpResponseHandler.createBedResponse(clientSocket);

                    clientSocket.close();
                } else {

                    // was에 넘기는 로직 필요

                    HttpRequest httpRequest = httpRequestHandler.selectRequestHandler(clientSocket);
                    HttpResponse httpResponse = httpResponseHandler.selectHttpResponseHandler(clientSocket);

                    clientSocket.close();
                }

            }
        } catch ( IOException e ){
            e.printStackTrace();
        }

    }
}
