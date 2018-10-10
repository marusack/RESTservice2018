package com.sockethttp.ws.rest.vo;

public class VOUser {
    private String user;
    private String password;
    private boolean status;

    public VOUser() {
    }

    public VOUser(String name, String pass, boolean stat) {
        user = name;
        password = pass;
        status = stat;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "[{\r\n" + "    \"user\": " + user + ",\r\n" + "    \"password\": " + password + ",\r\n"
				+ "    \"status\": " + status + "}\r\n" + "]";
	}

}
