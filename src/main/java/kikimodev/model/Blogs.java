package kikimodev.model;

//import lombok.Builder;
import lombok.Data;
//import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;
import lombok.NoArgsConstructor;

//import java.util.List;

import javax.persistence.Column;
//import javax.persistence.ElementCollection;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
//import javax.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table (name = "Blogs")
@Data // Create getters and setters
@NoArgsConstructor
public class Blogs {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;
	  
	  @Column(length = 255, nullable = false)
	  private String uuid = UUID.randomUUID().toString();
	  
	  @Column(length = 255, nullable = false)
	  private String title;
	  
	  @Column(length = 255, nullable = false)
	  private String slug;
	  
	  @Lob
	  private String content;
	  
	  @Lob
	  private String cover_image;

	  @Column(length = 255, nullable = false)
	  private String created_by;
	  
	  @Column(length = 255, nullable = false)
	  private String status;
	  
	  @CreationTimestamp
	  private Timestamp created_at;
	  
	  @CreationTimestamp
	  private Timestamp updated_at;


}
