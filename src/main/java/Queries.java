import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Queries {

    private EntityManager entityManager;
    Queries(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }

    public List<Players> getAllPlayersByPage(int nr)
    {
        Query query1=this.entityManager.createQuery("SELECT count(P) FROM Players P");

        long amountofPlayers = (long)query1.getSingleResult();
        long amountofPages=0;
        if(amountofPlayers%2==1)
        {amountofPages = (amountofPlayers/2)+1;}
        else
        {amountofPages = (amountofPlayers/2);}

        if(nr>amountofPages)
        {
            nr=(int)amountofPages;
        }
        Query query2=this.entityManager.createQuery("SELECT P FROM Players P");
        query2.setFirstResult((nr-1)*2);
        query2.setMaxResults(2);
        return query2.getResultList();

    }
    public List<Nationalteam> getNationalTeamsByRating()
    {
        Query query=this.entityManager.createQuery("SELECT n FROM Nationalteam n ORDER BY n.Rating");
        return query.getResultList();
    }

    public List<CoachN> getOldestCoach()
    {
        Query query=this.entityManager.createQuery("SELECT cn1 FROM CoachN cn1 WHERE cn1.age = (SELECT MAX(cn2.age) FROM CoachN cn2)");

        return query.getResultList();
    }

    public List<Players> getCampNouPlayers()
    {
        Query query=this.entityManager.createQuery("SELECT p FROM Players p WHERE p.club = (SELECT c FROM LaLigaTeams c WHERE c.stadium='Camp Nou')");
        return query.getResultList();
    }
    public int getNumSpanishPlayers()
    {
        Query query=this.entityManager.createQuery("SELECT Count(P) FROM Players P WHERE P.nationality = 'Hiszpania' ");
        long spanishplayers=(long)query.getSingleResult();
        return (int)spanishplayers;
    }
}
