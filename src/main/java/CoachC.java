import javax.persistence.*;

@Entity
@Table(name="CoachC")
public class CoachC {

    @Id
    @GeneratedValue
//            (generator = "gen")
//    @SequenceGenerator(name="gen", sequenceName = "CoachC")
    @Column(name="Id")
    private int id;


    @Column(name="Name")
    String name;


    @Column(name="Surname")
    String surname;


    @Column(name="Nationality")
    String nationality;


//    @OneToOne
//    @JoinColumn(name="La Liga Team")
//    LaLiga_Teams la_liga_team;

    @Column(name="Age")
    int age;

//    public LaLiga_Teams getLa_liga_team() {
//        return la_liga_team;
//    }
//
//    public void setLa_liga_team(LaLiga_Teams la_liga_team) {
//        this.la_liga_team = la_liga_team;
//    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
