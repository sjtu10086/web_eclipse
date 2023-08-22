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

public class cus_good {
	private String cus_id;
	private String good_id;
	private int num;
	private int price;
    public cus_good(String cus_i, String good_i, int nu, int pric) {
        this.cus_id = cus_i;
        this.good_id = good_i;
        this.num = nu;
        this.price = pric;
    }
    public String getC_id()
    {
    	return this.cus_id;
    }
    public String getG_id()
    {
    	return this.good_id;
    }
    public int getNum()
    {
    	return this.num;
    }
    
    public int getPrice()
    {
    	return this.price;
    }
}
