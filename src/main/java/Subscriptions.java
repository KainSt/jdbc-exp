import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="subscriptions")
public class Subscriptions {


    @Id
    private int id;

    @Id
    private  int courseId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
