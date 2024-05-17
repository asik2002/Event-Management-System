package com.fullstack.restApi.service;
import com.fullstack.restApi.persistence.user_details;
import com.fullstack.restApi.persistence.user_detailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class user_detailsService {
    @Autowired
    user_detailsRepository repository;
    public List<user_details> getAll(){                                         //     To get all users( for Admin use)
        return this.repository.findAll();
    }
    public user_details getById(String email){                                  //      To get details of specified user(admin use)
        return this.repository.findById(email).get();
    }
    public String register(user_details user_details){                          //      To register new user
        if(repository.findByEmail(user_details.getEmail())==null){
        this.repository.save(user_details);
        return "Registration Successfull";
        }
         return "Email already Exist";
    }

    public String authenticateUser(String email,String password){               //      Login Authentication
        user_details user_details =repository.findByEmail(email);
        if (user_details!=null && user_details.getPassword().equals(password)){
            return "Login Successfull";
        }
        return "Check Password or Email";
    }
    public String delete(String email) {                                        //     Deleting user
        Optional<user_details> entity = repository.findById(email);
        if (entity.isPresent()) {
            repository.deleteById(email);
            return "User "+email+" deleted";
        }
        return "User does not Exist";
    }
    public String update(String email,user_details user_details){               //     Updating User info
        Optional<user_details> entity_data=this.repository.findById(email);
        if (entity_data.isPresent()){
           entity_data.get().setUser_name(user_details.getUser_name());
           entity_data.get().setMobile_no(user_details.getMobile_no());
            this.repository.save(entity_data.get());
            return "Updated Successfully";
        }
       return "Unable to Update";
    }


}
