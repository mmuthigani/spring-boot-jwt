package kikimodev.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import kikimodev.model.AppUserRole;

@Data
public class UserResponseDTO {

  @ApiModelProperty(position = 0)
  private Integer id;
  @ApiModelProperty(position = 1)
  private String username;
  @ApiModelProperty(position = 2)
  private String email;
  @ApiModelProperty(position = 2)
  private String token;
  @ApiModelProperty(position = 4)
  List<AppUserRole> appUserRoles;

}
