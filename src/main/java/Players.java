import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;


@Entity
@Table(name="Players")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Players.class)
public class Players {

    @Id
    @GeneratedValue
//            (generator = "gen3")
//    @SequenceGenerator(name="gen3",sequenceName = "Players")
    @Column(name="Id")
    private int Id;


    @Column(name="Name")
    String name;


    @Column(name="Surname")
    String surname;


    @Column(name="Nationality")
    String nationality;


    @ManyToOne
    @JoinColumn(name="Club")
    LaLigaTeams club;

    @ManyToOne
    @JoinColumn(name="NationalTeam")
    Nationalteam team;

    @Column(name="Age")
    int age;


    public LaLigaTeams getClub() {
        return club;
    }

    public void setClub(LaLigaTeams club) {
        this.club = club;
    }

    public Nationalteam getTeam() {
        return team;
    }

    public void setTeam(Nationalteam team) {
        this.team = team;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


}
