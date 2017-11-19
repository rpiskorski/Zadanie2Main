import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="NationalTeams")

public class Nationalteam {

    @Id
    @GeneratedValue
//            (generator = "gen1")
//    @SequenceGenerator(name="gen1",sequenceName = "National_team")
    @Column(name="Id")
    private int id;


    @Column(name="Country")
    String Country;


    @Column(name="Rating")
    int Rating;

    @OneToMany(mappedBy = "team")
    List<Players> playersList =new ArrayList<>();
//
//    @OneToOne(mappedBy = "national_team")
//    CoachN trener;

    @OneToOne
    @JoinColumn(name="Coach")
    CoachN coachN;

//    @OneToMany
//    @JoinColumn(name="Players",referencedColumnName = "Id")
//    List<Players> playersList=new ArrayList<>();

    public List<Players> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Players> playersList) {
        this.playersList = playersList;
    }

    public CoachN getCoach() {
        return coachN;
    }

    public void setCoach(CoachN coachN) {
        this.coachN = coachN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }


}
