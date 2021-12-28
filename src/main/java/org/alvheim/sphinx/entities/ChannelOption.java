import javax.persistence.*;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.alvheim.sphinx.entities.Course;
import org.alvheim.sphinx.entities.Resource;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "chn_o")
public class ChannelOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "mobile_number", unique = true)
    private String mobileNumber;

    @Column(name = "additional_mobile_number", unique = true)
    private String additionalMobileNumber;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Resource> resources = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "channelOption_course",
            joinColumns = { @JoinColumn(name = "channelOption_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") }
    )
    private Set<Course> courses = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        ChannelOption channelOption = (ChannelOption) o;
        return id != null && Objects.equals(id, channelOption.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
