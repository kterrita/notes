package ru.beleychev.notes.server.config;

import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import ru.beleychev.notes.client.NotesGwtService;
import ru.beleychev.notes.server.service.NotesGwtServiceImpl;
import ru.beleychev.notes.server.web.NotesGwtController;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration for controller mapping
 * @author beleychev.ilya 17.07.2017   14:57
 */

@Configuration
public class SpringForGwtConfig {
	@Bean
	public HandlerMapping simpleUrlHandlerMapping() {
		SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
		Map<String, Controller> map = new HashMap<>();
		map.put("/notes/notes.rpc", notesGwtController());
		simpleUrlHandlerMapping.setUrlMap(map);
		return simpleUrlHandlerMapping;
	}

	@Bean
	public ServletRegistrationBean gwtServlet() {
		return new ServletRegistrationBean(notesGwtController(), "/notes/notes.rpc");
	}

	@Bean
	public NotesGwtController notesGwtController() {
		NotesGwtController notesGwtController = new NotesGwtController();
		notesGwtController.setRemoteService(notesService());
		return notesGwtController;
	}

	@Bean
	public NotesGwtService notesService() {
		return new NotesGwtServiceImpl();
	}
}
