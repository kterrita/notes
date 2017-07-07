package ru.beleychev.notes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.beleychev.notes.repository.UserRepository;

/**
 * Yeap. My Project)
 * Created by ilya on 05.07.2017.
 */
@RestController
public class NotesController {
    private static final String VIEW_NOTES = "notes";
    private static final String VIEW_LOGIN = "login";
    private static final String VIEW_REGISTRATION = "registration";

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName(VIEW_NOTES);
        modelAndView.addObject("journal", userRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value="/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName(VIEW_LOGIN);
        return modelAndView;
    }

    @RequestMapping(value = "/registration")
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_REGISTRATION);
        return modelAndView;
    }
}
