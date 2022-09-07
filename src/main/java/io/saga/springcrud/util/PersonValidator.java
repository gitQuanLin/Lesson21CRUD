package io.saga.springcrud.util;

import io.saga.springcrud.dao.PersonDAO;
import io.saga.springcrud.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Controller
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;
    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
         Person person= (Person) o;
         if (personDAO.show(person.getEmail()).isPresent()){
             errors.rejectValue("email","","This email already taken");
         }
    }
}
