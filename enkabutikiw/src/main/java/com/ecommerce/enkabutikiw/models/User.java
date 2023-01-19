package com.ecommerce.enkabutikiw.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
@Data
@AllArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 20)
  private String prenom;

  @NotBlank
  @Size(max = 20)
  private String nom;

  @NotBlank
  @Size(max = 20)
  private String telephone;

  @NotBlank
  @Size(max = 20)
  private String adresse;

  @Size(max = 20)
  private String genre;

  @NotBlank
  private String image;



  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();



  public User() {
  }

  public User(String username, String email, String password, String prenom,String nom, String telephone, String adresse, String genre, String image) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.prenom = prenom;
    this.nom = nom;
    this.adresse = adresse;

    this.telephone = telephone;
    this.genre = genre;

    this.image = image;

  }

}
