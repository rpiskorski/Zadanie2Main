import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name="LaLigaTeams" )
public class LaLigaTeams {

@Id @GeneratedValue
//        (generator = "gen2")
//@SequenceGenerator(name="gen2",sequenceName = "La Liga")
    @Column(name="Id")
    private int id;

    @Column(name="Name")
    String name;

    @Column(name="Stadium")
    String stadium;


//    @OneToOne(mappedBy = "la_liga_team")
//    CoachC coach;
//
    @OneToMany(mappedBy = "club")
    List<Players> playersList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="Coach")
    CoachC coach;

//    @OneToMany
//    @JoinColumn(name="Players",referencedColumnName = "Id")
//    List<Players> playersList=new ArrayList<>();

    public CoachC getCoach() {
        return coach;
    }

    public void setCoach(CoachC coach) {
        this.coach = coach;
    }

    public List<Players> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Players> playersList) {
        this.playersList = playersList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }


}
