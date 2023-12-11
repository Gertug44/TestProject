package entityScheme;

import org.example.hibernateHelper.HibernateConnection;
import org.example.hibernateHelper.HouseDbWorker;
import org.example.hibernateHelper.PersonDbWorker;
import org.junit.jupiter.api.AfterAll;

public abstract class Test {
    protected static HouseDbWorker houseDb = new HouseDbWorker();
    protected static PersonDbWorker personDb = new PersonDbWorker();
    @AfterAll
    public static void closeSessions(){
        HibernateConnection.killSession();
    }
}
