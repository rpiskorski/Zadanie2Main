import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.*;

public class JSONXML {



        static void ToFile (Query q, String name)
        {
            ObjectMapper objectMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();
            String str1;
            String str2;

            try {

                str1=objectMapper.writeValueAsString(q.getResultList());
                FileWriter fileWriter1=new FileWriter(name+".json");
                BufferedWriter bufferedWriter1=new BufferedWriter(fileWriter1);
                bufferedWriter1.write(str1);
                bufferedWriter1.close();
                fileWriter1.close();

                str2=xmlMapper.writeValueAsString(q.getResultList());
                FileWriter fileWriter2=new FileWriter(name+".xml");
                BufferedWriter bufferedWriter2=new BufferedWriter(fileWriter2);
                bufferedWriter2.write(str2);
                bufferedWriter2.close();
                fileWriter2.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        static void FromDatabase()
        {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Query query1 = null;
        Query query2 = null;
        Query query3 = null;
        Query query4 = null;
        Query query5 = null;



            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();

            query1 = entityManager.createQuery("SELECT cc FROM CoachC cc");
            query2 = entityManager.createQuery("SELECT cn FROM CoachN cn");
            query3 = entityManager.createQuery("SELECT ll FROM LaLigaTeams ll");
            query4 = entityManager.createQuery("SELECT nt FROM Nationalteam nt");
            query5 = entityManager.createQuery("SELECT p FROM Players p");

            ToFile(query5, "Players");
            ToFile(query4, "Nationalteam");
            ToFile(query3, "LaLigaTeams");
            ToFile(query2, "CoachN");
            ToFile(query1, "CoachC");

            entityManager.close();


            entityManagerFactory.close();

    }



    public static void main (String args[])
    {
        FromDatabase();
    }





}
