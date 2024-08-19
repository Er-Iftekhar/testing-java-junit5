package guru.springframework.sfgpetclinic.controllers;

import javax.validation.ValidationException;

public class IndexController {

    public String index(){

        return "index";
    }

    public String oopsHandler(){
        throw new ValidationException("Not a valid handler added.");
    }
}
