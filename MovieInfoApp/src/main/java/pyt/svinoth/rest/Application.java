package pyt.svinoth.rest;

import java.util.Arrays;
import java.util.List;

import pyt.svinoth.restservice.ServImpl;

public class Application {
	public static void main(String[] args) {
		ServImpl serv = new ServImpl();
		String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title={substr}&page=";
		String substr = "spiderman";
		List<String> list = serv.getTitle(url, substr);
		System.out.println(Arrays.toString(list.toArray()));
	}

}
