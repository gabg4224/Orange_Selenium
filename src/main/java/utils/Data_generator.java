package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.Number;

public class Data_generator {

	private Faker faker = new Faker();

	public   String random_milis() {

		return String.valueOf(System.currentTimeMillis());
	}

}
