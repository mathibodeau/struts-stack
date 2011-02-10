package test.support.com.standardlife.slac.db;

import com.standardlife.slac.domain.policy.Policy;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseCleaner {

    private static final Class<?>[] ENTITY_TYPES = {
            // classes of entities to be flush from the database
            Policy.class
    };

    private static final String[] SEQUENCE_NAMES = {
            // names of sequences to be cleaned from database
    };

    private final Session session;

    public DatabaseCleaner(Session session) {
        this.session = session;
    }

    public void clean() {
        Transaction transaction = session.beginTransaction();
        for (Class<?> entityType : ENTITY_TYPES) {
            deleteEntities(entityType);
        }
        for (String sequenceName : SEQUENCE_NAMES) {
            resetSequence(sequenceName);
        }
        transaction.commit();
    }

    private void resetSequence(String sequenceName) {
        session.createSQLQuery("truncate " + sequenceName).executeUpdate();
    }

    private void deleteEntities(Class<?> entityType) {
        session.createQuery("delete from " + entityNameOf(entityType)).executeUpdate();
    }

    private String entityNameOf(Class<?> entityType) {
        return entityType.getName();
    }
}
