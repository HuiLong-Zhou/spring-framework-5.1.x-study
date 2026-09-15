package org.springframework;

/**
 * ClassName: ServiceBean
 * Package: com.zhl
 * Description <p/>
 *
 * @author zhl
 * @Create 2024-05-06 21:03
 * version 1.0
 */
public class ServiceTestBean {
	private int id;
	private String username;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "ServiceBean{" +
				"id=" + id +
				", username='" + username + '\'' +
				'}';
	}
}
