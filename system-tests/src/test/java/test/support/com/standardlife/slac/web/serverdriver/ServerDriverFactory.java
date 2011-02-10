package test.support.com.standardlife.slac.web.serverdriver;

public interface ServerDriverFactory {

    ServerDriver newServerDriver() throws Exception;

    void disposeServerDriver(ServerDriver serverDriver) throws Exception;
}
