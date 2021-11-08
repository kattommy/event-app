package com.project.eventapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "`user`")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    @Size(min=3 ,message = "Musi zawiewierać conajmniej {min} znaków")
    private String firstName;

    @Column(length = 30)
    @NotBlank(message = "Nie może być puste")
    @Size(min = 3, max = 40, message="{author.validationErrors.lastName.size}")
    private String lastName;

    @Column(length = 50)
    @Pattern(regexp ="^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$",
    message = "Musi posiadać forme email np. a@aa.pl")
    private String email;

    @Column(length = 30)
    @Pattern(regexp = "^[0-9a-zA-Z].{7,}+$", message = "hasło musi zawierać conajmniej z 8 znaków ")
    @NotBlank(message = "Nie może być puste ")
    private String password;

    @Column(length = 30)
    private String role;

    @ManyToMany(mappedBy = "participants")
    @OrderBy("startDateTime DESC")
    private List<Event> participation;


//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role));
//    }
    public  String  fullName(){
        return firstName+ " " +lastName;
    }
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
