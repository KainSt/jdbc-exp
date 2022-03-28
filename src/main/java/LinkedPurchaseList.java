import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="LinkedPurchaseList")
public class LinkedPurchaseList {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private PurchaseListKey key;



    @Embeddable
    public static class PurchaseListKey implements Serializable {
        @Column(name = "student_id")
        private int studentId;
        @Column(name = "course_id")
        private int courseId;

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PurchaseListKey that = (PurchaseListKey) o;
            return studentId == that.studentId && courseId == that.courseId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, courseId);
        }

        public PurchaseListKey(int studentId, int courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }
    }

}
