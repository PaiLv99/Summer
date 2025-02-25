package myserver.core.util;

import myserver.core.httpenum.HttpMessage;
import myserver.core.httprequesthandler.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Util {

    public static HttpMessage validHttpRequest(Socket socket) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            if( in.ready() ){
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
}
