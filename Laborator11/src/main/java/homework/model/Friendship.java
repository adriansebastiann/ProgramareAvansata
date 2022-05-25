package homework.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="friendship")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_friendship")
    private int id;
    @Column(name="userone")
    private int userone;
    @Column(name="usertwo")
    private int usertwo;
}
