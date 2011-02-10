package test.support.com.standardlife.slac.web.serverdriver;

public class PrototypeServerDriverFactory implements ServerDriverFactory {

    public ServerDriver newServerDriver() throws Exception {
        ServerDriver serverDriver = new JettyDriver();
        serverDriver.start();
        return serverDriver;
    }

    public void disposeServerDriver(ServerDriver serverDriver) throws Exception {
        serverDriver.stop();
    }
}
