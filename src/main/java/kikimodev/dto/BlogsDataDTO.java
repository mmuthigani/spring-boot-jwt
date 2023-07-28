package kikimodev.dto;

//import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
//import kikimodev.model.AppUserRole;

@Data
@NoArgsConstructor
public class BlogsDataDTO {
	  @ApiModelProperty(position = 0)
	  private String uuid;
	  @ApiModelProperty(position = 1)
	  private String slug;
	  @ApiModelProperty(position = 2)
	  private String title;
	  @ApiModelProperty(position = 3)
	  private String content;
	  @ApiModelProperty(position = 4)
	  private String cover_image;
	  @ApiModelProperty(position = 5)
	  private String status;
	  @ApiModelProperty(position = 6)
	  private String created_by;
	  @ApiModelProperty(position = 7)
	  private String created_at;
	  
}
