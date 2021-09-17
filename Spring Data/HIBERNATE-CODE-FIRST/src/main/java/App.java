import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    private static final String GRINGOTTS_PU = "gringotts";
    private static final String SALES_PU = "sales";
    private static final String UNIVERSITY_PU = "university";
    private static final String HOSPITAL_PU = "hospital";
    private static final String BILL_PU = "bill";


    // IMPORTANT READ FIRST READ-MI BEFORE YOU START THE PROJECT !!!

    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory
                        (BILL_PU); // SET

        EntityManager entityManager =
                entityManagerFactory
                        .createEntityManager();

        Engine engine = new Engine(entityManager);

        engine.run();
    }
}
