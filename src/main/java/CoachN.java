import javax.persistence.*;

@Entity
@Table(name="CoachN")
public class CoachN {

    @Id
    @GeneratedValue
//            (generator = "gen4")
//    @SequenceGenerator(name="gen4", sequenceName = "CoachN")
    @Column(name="Id")
    private int id;


    @Column(name="Name")
    String name;


    @Column(name="Surname")
    String surname;


    @Column(name="Nationality")
    String nationality;


//    @OneToOne
//    @JoinColumn(name="National Team")
//    National_team national_team;


    @Column(name="Age")
    int age;

//    public National_team getNational_team() {
//        return national_team;
//    }
//
//    public void setNational_team(National_team national_team) {
//        this.national_team = national_team;
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
