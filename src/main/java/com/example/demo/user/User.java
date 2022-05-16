package com.example.demo.user;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class User {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
    @NotNull
    @Column(name="username")
    private  String username;
    @NotNull
    @Column(name="email")
    private  String email;
    @NotNull
    @Column(name="Password")
    private  String password;


    public User(String username,
              String email,String password) {
        this.username = username;
        this.email=email;
        this.password = password;
//        this.loggedIn = false;
    }


}

