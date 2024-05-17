package com.fullstack.restApi.resource;
import com.fullstack.restApi.service.user_detailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fullstack.restApi.persistence.user_details;
import java.util.List;

@RestController
public class user_detailsResource {
    @Autowired
    user_detailsService Service;
    String response;
    @GetMapping(value = "/get-all-users")
    public List<user_details> getAll(){
        return this.Service.getAll();
    }
    @GetMapping(value = "/get-by-email/{email}")
    public user_details getByEmail(@PathVariable String email){
        return this.Service.getById(email);
    }
    @PostMapping(value="/register")
    public String register(@RequestBody user_details user_details){
        response=  this.Service.register(user_details);
        return response;
    }
    @PostMapping(value ="/login")
    public String login(@RequestBody user_details user_details){
        response= this.Service.authenticateUser(user_details.getEmail(),user_details.getPassword());
        return response;

    }
    @DeleteMapping(value = "/delete")
    public String delete(@RequestBody user_details user_details){
        response=this.Service.delete(user_details.getEmail());
        return response;
    }
    @PutMapping(value = "/update")
    public String update(@RequestBody user_details user_details){
         response=this.Service.update(user_details.getEmail(),user_details);
        return response;
    }
}
