package com.kukit.platform.registration.domain.role;


import com.kukit.platform.registration.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles", schema = "public")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String roleName;
    @ManyToMany(mappedBy = "roles")
    Collection<User> users;
}
