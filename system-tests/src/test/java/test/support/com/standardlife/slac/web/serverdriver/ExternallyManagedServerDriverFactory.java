package test.support.com.standardlife.slac.web.serverdriver;

public class ExternallyManagedServerDriverFactory implements ServerDriverFactory {

    public ServerDriver newServerDriver() throws Exception {
        return new ServerDriver() {
            public void start() throws Exception {
            }

            public void stop() throws Exception {
            }
        };
    }

    public void disposeServerDriver(ServerDriver serverDriver) throws Exception {
    }
}
