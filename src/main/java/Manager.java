import javax.persistence.*;

public class Manager {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        String query1="";
        String query2="";
        String query3="";
        String query4="";
        int query5=0;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            entityManager = entityManagerFactory.createEntityManager();

            //Transaction1
            EntityTransaction first = entityManager.getTransaction();
            first.begin();

            //add Coach1
            CoachC coachC1 = new CoachC();
            coachC1.setName("Zinedine");
            coachC1.setSurname("Zidane");
            coachC1.setNationality("Francja");
            coachC1.setAge(45);

            entityManager.persist(coachC1);

            //add Coach2
            CoachC coachC2 = new CoachC();
            coachC2.setName("Diego");
            coachC2.setSurname("Simeone");
            coachC2.setNationality("Argentyna");
            coachC2.setAge(47);

            entityManager.persist(coachC2);

            //add Coach3
            CoachC coachC3 = new CoachC();
            coachC3.setName("Ernesto");
            coachC3.setSurname("Valverde");
            coachC3.setNationality("Hiszpania");
            coachC3.setAge(53);

            entityManager.persist(coachC3);


            //add CoachN1
            CoachN coachN1 = new CoachN();
            coachN1.setName("Jorge");
            coachN1.setSurname("Sampaoli");
            coachN1.setNationality("Argentyna");
            coachN1.setAge(58);

            entityManager.persist(coachN1);


            //add CoachN2
            CoachN coachN2 = new CoachN();
            coachN2.setName("Julen");
            coachN2.setSurname("Lopetegui");
            coachN2.setNationality("Hiszpania");
            coachN2.setAge(51);

            entityManager.persist(coachN2);


            //add CoachN3
            CoachN coachN3 = new CoachN();
            coachN3.setName("Didier");
            coachN3.setSurname("Deschamps");
            coachN3.setNationality("Francja");
            coachN3.setAge(49);

            entityManager.persist(coachN3);


            //add CoachN4
            CoachN coachN4 = new CoachN();
            coachN4.setName("Fernando");
            coachN4.setSurname("Santos");
            coachN4.setNationality("Portugalia");
            coachN4.setAge(63);

            entityManager.persist(coachN4);

            first.commit();


            //Transaction2
            EntityTransaction second = entityManager.getTransaction();
            second.begin();

            //add Player1
            Players player1 = new Players();
            player1.setName("Lionel");
            player1.setSurname("Messi");
            player1.setNationality("Argentyna");
            player1.setAge(30);

            entityManager.persist(player1);

            //add Player2
            Players player2 = new Players();
            player2.setName("Andres");
            player2.setSurname("Iniesta");
            player2.setNationality("Hiszpania");
            player2.setAge(33);

            entityManager.persist(player2);

            //add Player3
            Players player3 = new Players();
            player3.setName("Antoine");
            player3.setSurname("Griezmann");
            player3.setNationality("Francja");
            player3.setAge(27);


            entityManager.persist(player3);

            //add Player4
            Players player4 = new Players();
            player4.setName("Fernando");
            player4.setSurname("Torres");
            player4.setNationality("Hiszpania");
            player4.setAge(33);


            entityManager.persist(player4);

            //add Player5
            Players player5 = new Players();
            player5.setName("Cristiano");
            player5.setSurname("Ronaldo");
            player5.setNationality("Portugalia");
            player5.setAge(32);

            entityManager.persist(player5);

            //add Player6
            Players player6 = new Players();
            player6.setName("Sergio");
            player6.setSurname("Ramos");
            player6.setNationality("Hiszpania");
            player6.setAge(31);


            entityManager.persist(player6);

            //add Team1
            LaLigaTeams team1 = new LaLigaTeams();
            team1.setName("Real Madryt");
            team1.setStadium("Santiago Bernabeu");
            team1.setCoach(coachC1);
            team1.getPlayersList().add(player5);
            team1.getPlayersList().add(player6);

            entityManager.persist(team1);

            //add Team2
            LaLigaTeams team2 = new LaLigaTeams();
            team2.setName("Atletico Madryt");
            team2.setStadium("Wanda Metropolitano");
            team2.setCoach(coachC2);
            team1.getPlayersList().add(player3);
            team1.getPlayersList().add(player4);

            entityManager.persist(team2);

            //add Team3
            LaLigaTeams team3 = new LaLigaTeams();
            team3.setName("FC Barcelona");
            team3.setStadium("Camp Nou");
            team3.setCoach(coachC3);
            team1.getPlayersList().add(player1);
            team1.getPlayersList().add(player2);

            entityManager.persist(team3);


            //add National team1
            Nationalteam nteam1 = new Nationalteam();
            nteam1.setCountry("Argentyna");
            nteam1.setRating(4);
            nteam1.getPlayersList().add(player1);
            nteam1.setCoach(coachN1);

            entityManager.persist(nteam1);


            //add National team2
            Nationalteam nteam2 = new Nationalteam();
            nteam2.setCountry("Hiszpania");
            nteam2.setRating(8);
            nteam2.getPlayersList().add(player2);
            nteam2.getPlayersList().add(player4);
            nteam2.getPlayersList().add(player6);
            nteam2.setCoach(coachN2);

            entityManager.persist(nteam2);


            //add National team3
            Nationalteam nteam3 = new Nationalteam();
            nteam3.setCountry("Francja");
            nteam3.setRating(7);
            nteam3.getPlayersList().add(player3);
            nteam3.setCoach(coachN3);

            entityManager.persist(nteam3);


            //add National team4
            Nationalteam nteam4 = new Nationalteam();
            nteam4.setCountry("Portugalia");
            nteam4.setRating(3);
            nteam4.getPlayersList().add(player5);
            nteam4.setCoach(coachN4);

            entityManager.persist(nteam4);

            player1.setClub(team3);
            player1.setTeam(nteam1);

            player2.setClub(team3);
            player2.setTeam(nteam2);

            player3.setClub(team2);
            player3.setTeam(nteam3);

            player4.setClub(team2);
            player4.setTeam(nteam2);

            player5.setClub(team1);
            player5.setTeam(nteam4);

            player6.setClub(team1);
            player6.setTeam(nteam2);

            second.commit();


            //AllPlayersBy2Page
            Queries q1 = new Queries(entityManager);
            query1=q1.getAllPlayersByPage(2).get(0).getName()+" "+q1.getAllPlayersByPage(2).get(0).getSurname()+";";
            query1=query1+q1.getAllPlayersByPage(2).get(1).getName()+" "+q1.getAllPlayersByPage(2).get(1).getSurname()+";";

            //AllNationalTeamsByRating
            Queries q2=new Queries(entityManager);
            for(int i=1;i<=4;i++)
            {query2=query2+q2.getNationalTeamsByRating().get(i-1).getCountry()+";";}

            //OldestCoach
            Queries q3=new Queries(entityManager);
            query3=q3.getOldestCoach().get(0).getName()+" "+q3.getOldestCoach().get(0).getSurname();

            //CampNouPlayers
            Queries q4=new Queries(entityManager);
            for(int i=0;i<q4.getCampNouPlayers().size();i++)
            {query4=query4+q4.getCampNouPlayers().get(i).getName()+" "+q4.getCampNouPlayers().get(i).getSurname()+";";}

            //AmountofSpanishPlayers
            Queries q5=new Queries(entityManager);
            query5=q5.getNumSpanishPlayers();

            entityManager.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManagerFactory.close();
        }


        System.out.println("Page 2: "+query1);
        System.out.println("National Teams: "+query2);
        System.out.println("Oldest Coach: "+query3);
        System.out.println("Argentina Coach: "+query4);
        System.out.println("Num of spanish players: "+query5);
    }

}
