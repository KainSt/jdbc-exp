import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="purchaselist")
public class Purchaselist {

    @Column(name = "student_name")

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subscriptions",
    joinColumns = {@JoinColumn(name = "course_id")},
    inverseJoinColumns = {@JoinColumn(name ="student_id")})
    private List<Student> studentList;

    @Column(name = "course_name")
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;



}
