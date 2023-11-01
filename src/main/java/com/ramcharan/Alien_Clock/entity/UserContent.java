package com.ramcharan.Alien_Clock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "USER_TBL")
public class UserContent {
    @Id
    private int id;
    private String userName;
    private String password;
    private String email;
}
