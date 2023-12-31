package kikimodev.model;

import lombok.Data;
import java.sql.Date;
import java.sql.Timestamp;
//import java.util.UUID;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table (name = "Users")
@Data // Create getters and setters
@NoArgsConstructor
public class AppUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
  @Column(unique = true, nullable = false)
  private String username;

  @Column(unique = true, nullable = false)
  private String email;

  @Size(min = 8, message = "Minimum password length: 8 characters")
  private String password;
  
  @CreationTimestamp
  private Timestamp createdDateTime;
  
  @CreationTimestamp
  private Date createdDate;

  @ElementCollection(fetch = FetchType.EAGER)
  List<AppUserRole> appUserRoles;

}
