package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Seller seller = new Seller();
		seller.create("Abigail Navarro","abigail@gmail.com","12/07/1999",10000,4);
	
	}

}
