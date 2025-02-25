import myserver.core.ServerConfig;
import myserver.core.webserver.WebServer;
import myserver.core.webserver.WebServerImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ServerConfig serverConfig = new ServerConfig();

        WebServer webServer = serverConfig.webServer();

        webServer.Accept();

    }
}