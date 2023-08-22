package web0515_01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class Users {
	private String password;
	private String id;
	private String power;
    public Users(String i, String pass, String po) {
        this.password = pass;
        this.id = i;
        this.power = po;
    }
    public String getPassword()
    {
    	return this.password;
    }
    public String getId()
    {
    	return this.id;
    }
    public String getPower()
    {
    	return this.power;
    }

}
