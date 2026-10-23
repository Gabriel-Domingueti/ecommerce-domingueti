package com.ecommerce.domingueti.user_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.domingueti.user_api.dto.UserDTO;
import com.ecommerce.domingueti.user_api.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController 
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
   private final UserService userService;

   @GetMapping("/")
   public List<UserDTO> getUsers() {
       List<UserDTO> users = userService.getAll();
       return users;
   }
    
   @GetMapping("/{id}")
   public UserDTO findById(@PathVariable long id) {
       return userService.findById(id); 
   }
   
   @PostMapping
   public UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
   }
   
   @GetMapping("/cpf/{cpf}")
   public UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
   } 

   @DeleteMapping("/{id}")
   public UserDTO delete(@PathVariable long id) {
        return userService.delete(id);
   } 

   @GetMapping("/search")
   public List<UserDTO> queryByName(@RequestParam(name = "nome", required=true) String name) {
        return userService.queryByName(name);
   }
}
