package ru.beleychev.notes.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author beleychev.ilya 07.07.2017   11:08
 */
public class PasswordEncoderUtil {
	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("root"));
	}
}
