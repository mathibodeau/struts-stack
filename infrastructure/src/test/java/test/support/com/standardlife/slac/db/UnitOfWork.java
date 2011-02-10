package test.support.com.standardlife.slac.db;

import org.hibernate.Session;

public interface UnitOfWork {

    void work(Session session) throws Exception;
}
