package myserver.core.httpresponsehandler;

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
    public HttpResponse createBadResponse(Socket socket) {
        try(PrintWriter out = new PrintWriter(socket.getOutputStream())){
            out.write("HTTP/1.1 400 bad request\n");
            out.write("Content-Type: text/html; charset=UTF-8\n");
            out.write("Content-Length: 0\n");
            out.write("Connection: close\n");
        }catch( IOException e ){
            e.printStackTrace();
        }

        return httpResponse;
    }
}
