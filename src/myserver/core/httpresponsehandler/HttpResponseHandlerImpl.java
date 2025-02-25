package myserver.core.httpresponsehandler;

import myserver.core.httprequesthandler.HttpRequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class HttpResponseHandlerImpl implements HttpResponseHandler {


    private final HttpResponse httpResponse;

    public HttpResponseHandlerImpl( HttpResponse httpResponse) {

        this.httpResponse = httpResponse;
    }

    @Override
    public HttpResponse selectHttpResponseHandler(Socket socket) {

        httpResponse.setResponseObject(socket);

        return httpResponse;
    }

    @Override
    public HttpResponse createBedResponse(Socket socket) {
        try(PrintWriter out = new PrintWriter(socket.getOutputStream())){
            out.write("HTTP/1.1 400 BADREQUEST\r\n");
        }catch( IOException e ){
            e.printStackTrace();
        }

        return httpResponse;
    }
}
