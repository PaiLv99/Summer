package myserver.core.httprequesthandler;

import myserver.core.httpenum.HttpMessage;
import myserver.core.httpenum.HttpMethod;
import myserver.core.parser.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;

public class HttpRequestHandlerImpl implements HttpRequestHandler {


    private final HttpRequest httpRequest;

    public HttpRequestHandlerImpl(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Override
    public HttpRequest selectRequestHandler(Socket socket) {

        try( BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ) {

            HttpMethod method;
            String url;
            String protocolVersion;
            String head;
            String body;

            String startLine = in.readLine();
            String[] words = startLine.split(" ");

            method = HttpMethod.valueOf(words[0]);
            url = words[1];
            protocolVersion = words[2];

            String line;
            StringBuilder sb = new StringBuilder();

            while( !isEOF(in) && !(line = in.readLine()).isEmpty() ){
                sb.append(line);
            }
            head = sb.toString();

            sb = new StringBuilder();
            while( !isEOF(in) ){
                sb.append(in.readLine());
            }
            body = sb.toString();

            httpRequest.setRequestObject(method, url, protocolVersion, head, body);

        }catch ( IOException e ){
            e.printStackTrace();
        }
        return httpRequest;
    }

    @Override
    public HttpMessage validHttpRequest(Socket socket) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            if( !isEOF(in) ){
                String line = in.readLine();
                String[] strings = line.split(" ");

                if( strings.length < 3 ){
                    return  HttpMessage.BADREQUEST;
                }

                if( ! strings[2].startsWith("HTTP") ){
                    return HttpMessage.BADREQUEST;
                }

            } else {
                return HttpMessage.BADREQUEST;
            }
        }catch( IOException e ) {
            e.printStackTrace();
        }

        return HttpMessage.OK;
    }

    public static boolean isEOF(BufferedReader br) throws IOException {
        br.mark(1);
        if( br.read() == -1 ){
            return true;
        }
        br.reset();
        return false;
    }
}
