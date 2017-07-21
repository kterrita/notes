package ru.beleychev.notes.shared;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Class for getting spring context in GWT module
 * @author beleychev.ilya 21.07.2017   16:52
 */
@Component
public class AppContextManager implements ApplicationContextAware {
	private static ApplicationContext _applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		_applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return _applicationContext;
	}
}
