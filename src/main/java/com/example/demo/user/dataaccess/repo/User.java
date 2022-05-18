package com.example.demo.user.dataaccess.repo;

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
    @Column(name="firstname")
    private String firstname;
    @NotNull
    @Column(name="lastname")
    private String lastname;
    @NotNull
    @Column(name="email")
    private  String email;
    @NotNull
    @Column(name="Password")
    private  String password;
    @Column(name="phone")
    private String phone;

    public User(String username, String firstname, String lastname, String email, String password, String phone) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

//    public User(String username,
//                String email, String password) {
//        this.username = username;
//        this.email=email;
//        this.password = password;
////        this.loggedIn = false;
//    }


}

