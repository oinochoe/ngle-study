package springbook.user.domain;

import lombok.Data;

@Data
public class User {
	String id;
	String name;
	String password;

	public User(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public User() {

	}
}


