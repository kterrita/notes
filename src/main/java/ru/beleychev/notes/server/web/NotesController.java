package ru.beleychev.notes.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.beleychev.notes.server.domain.User;
import ru.beleychev.notes.server.repository.RoleRepository;
import ru.beleychev.notes.server.repository.UserRepository;
import ru.beleychev.notes.server.service.UserService;

import javax.validation.Valid;

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
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		modelAndView.setViewName(VIEW_NOTES);
		modelAndView.addObject("journal", userRepository.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView modelAndView) {
		modelAndView.setViewName(VIEW_LOGIN);
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(ModelAndView modelAndView) {
		modelAndView.setViewName(VIEW_REGISTRATION);
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(VIEW_REGISTRATION);
		User userExists = userRepository.findUserByName(user.getUsername());
		if (userExists != null) {
			bindingResult
					.rejectValue("username", "error.user",
							"There is already a user registered with the username provided");
			return modelAndView;
		}
		if (!bindingResult.hasErrors()) {
			userService.saveNewUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
		}
		userRepository.save(user);
		return modelAndView;
	}
}
