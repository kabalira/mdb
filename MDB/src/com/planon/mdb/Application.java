package com.planon.mdb;

import java.sql.SQLException;

import com.planon.mdb.operations.read.Read;

import io.joshworks.restclient.http.HttpResponse;
import io.joshworks.restclient.http.JsonNode;
import io.joshworks.restclient.http.Unirest;

public class Application {

	public static void main(String[] args) throws SQLException {

//		Read read = new Read();
//		read.readmdb();

		HttpResponse<JsonNode> response = Unirest.get("https://planon.atlassian.net/wiki/rest/api/audit")
				.header("Accept", "application/json").asJson();

		System.out.println(response.getBody());
	}
}
