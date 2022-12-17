package com.binar.chapter5.controller;

import com.binar.chapter5.model.Users;
import com.binar.chapter5.model.Schedules;
import com.binar.chapter5.model.request.UsersRequest;
import com.binar.chapter5.model.response.UsersResponse;
import com.binar.chapter5.service.UsersServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersServiceImpl usersService;

    @Operation(summary = "add new users to system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "request success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsersResponse.class)))
    })
    @PostMapping("/add_users")
    public ResponseEntity addusers(@RequestBody UsersRequest addRequest) {
        try {
            Users users = new Users();
            users.setId(addRequest.getId());
            users.setUsername(addRequest.getUsername());
            users.setEmail(addRequest.getEmail());
            users.setPassword(addRequest.getPassword());
            usersService.addUser(users);
            return ResponseEntity.status(HttpStatus.OK).body("add success (CODE 200)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("add failed (CODE 502), caused by : " + e.getMessage());
        }
    }

    @Operation(summary = "update user from system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "request success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsersResponse.class)))
    })
    @PutMapping("/update_user")
    public ResponseEntity updateUsers(@RequestParam("users") Users users) {
        try {
            usersService.updateUser(users);
            return ResponseEntity.status(HttpStatus.OK).body("update success (CODE 200)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("update failed (CODE 502), caused by : " + e.getMessage());
        }
    }

    @Operation(summary = "delete user from system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "request success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UsersResponse.class)))
    })
    @DeleteMapping("/delete_user")
    public ResponseEntity deleteUsers(@RequestParam("username") Integer id) {
        try {
            usersService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("update success (CODE 200)");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("update failed (CODE 502), caused by : " + e.getMessage());
        }
    }

}
