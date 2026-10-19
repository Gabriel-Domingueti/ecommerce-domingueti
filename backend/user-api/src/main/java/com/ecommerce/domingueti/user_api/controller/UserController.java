package com.ecommerce.domingueti.user_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.domingueti.user_api.dto.UserDTO;
import com.ecommerce.domingueti.user_api.service.UserService;


@RestController 
public class UserController {
   @Autowired
   private UserService userService;

   @GetMapping("/user/")
   public List<UserDTO> getUsers() {
       List<UserDTO> users = userService.getAll();
       return users;
   }
    
   @GetMapping("/user/{id}")
   UserDTO findById(@PathVariable long id) {
       return userService.findById(id); 
   }
   
   @PostMapping("/user")
   UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
   }
   
   @GetMapping("/user/cpf/{cpf}")
   UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
   } 

   @DeleteMapping("/user/{id}")
   UserDTO delete(@PathVariable long id) {
        return userService.delete(id);
   } 

   @GetMapping("/user/search")
   public List<UserDTO> queryByName(@RequestParam(name = "nome", required=true) String name) {
        return userService.queryByName(name);
   }
}
