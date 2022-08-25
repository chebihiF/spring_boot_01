package org.test.tp01.user;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter @RequiredArgsConstructor
@NoArgsConstructor
public class Authority {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NonNull
    private String name ;
    @ManyToMany
    @JoinTable(
            name = "role",
            joinColumns = @JoinColumn(name = "id_auth"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<User> users ;
}
