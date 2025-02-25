package myserver.core.webserver;

import myserver.core.httprequesthandler.HttpRequest;
import myserver.core.httprequesthandler.HttpRequestHandler;
import myserver.core.httpresponsehandler.HttpResponse;
import myserver.core.httpresponsehandler.HttpResponseHandlerManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServerImpl implements WebServer{

    private final int port;
    private final HttpRequestHandler httpRequestHandlerManager;
    private final HttpResponseHandlerManager httpResponseHandlerManager;

    public WebServerImpl(int port, HttpRequestHandler httpRequestHandlerManager, HttpResponseHandlerManager httpResponseHandlerManager) {
        this.port = port;
        this.httpRequestHandlerManager = httpRequestHandlerManager;
        this.httpResponseHandlerManager = httpResponseHandlerManager;
    }

    @Override
    public void Accept() {
        try( ServerSocket serverSocket = new ServerSocket(port) ){
            while( true ) {
                Socket clientSocket = serverSocket.accept();

                HttpRequest httpRequestHandler = httpRequestHandlerManager.selectRequestHandler(clientSocket);
                HttpResponse httpResponseHandler = httpResponseHandlerManager.selectHttpResponseHandler(clientSocket);

                // was에 넘기는 로직 필요

                clientSocket.close();
            }
        } catch ( IOException e ){
            e.printStackTrace();
        }

    }
}
