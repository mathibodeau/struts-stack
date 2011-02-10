package test.support.com.standardlife.slac.web.serverdriver;

import com.pyxis.matchers.ExceptionImposter;

public class SingletonServerDriverFactory implements ServerDriverFactory {

    private JettyDriver server;

    public ServerDriver newServerDriver() {
        if (server == null) {
            createServer();
        }
        return server;
    }

    private void createServer() {
        server = new JettyDriver();
        registerServerToStopOnShutdown();
        startServer();
    }

    public void disposeServerDriver(ServerDriver serverDriver) throws Exception {
    }

    public void startServer() {
        start(server);
    }

    private void start(ServerDriver server) {
        try {
            server.start();
        } catch (Exception e) {
            throw ExceptionImposter.imposterize(e);
        }
    }

    private void registerServerToStopOnShutdown() {
        server.stopOnShutdown();
    }
}
