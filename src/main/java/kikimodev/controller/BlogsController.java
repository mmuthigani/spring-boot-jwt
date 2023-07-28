package kikimodev.controller;

//import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
//import kikimodev.model.AppUser;
import kikimodev.model.Blogs;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import kikimodev.dto.BlogsDataDTO;
//import kikimodev.dto.BlogsResponseDTO;
import kikimodev.service.BlogsService;

@RestController
@RequestMapping("/blog")
@Api(tags = "blog")
@RequiredArgsConstructor
public class BlogsController {

  private final BlogsService blogsService;
  private final ModelMapper modelMapper;
  
  @PostMapping("/create")
  @ApiOperation(value = "${BlogsController.create}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 422, message = "Username is already in use")})
  public String create(@ApiParam("Create Blog") @RequestBody BlogsDataDTO blog) {
    return blogsService.create(modelMapper.map(blog, Blogs.class));
  }
  

  @DeleteMapping(value = "/{slug}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @ApiOperation(value = "${BlogsController.delete}", authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 404, message = "The user doesn't exist"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public String delete(@ApiParam("slug") @PathVariable String slug) {
	  blogsService.delete(slug);
	  return "Blog Deleted Successfuly";
  }


}

