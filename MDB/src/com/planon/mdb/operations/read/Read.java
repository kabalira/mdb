package com.planon.mdb.operations.read;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.planon.mdb.util.ConnectionUtil;

public class Read {
	public void readmdb() throws SQLException {

		try (Connection aConnection = ConnectionUtil.openConnection()) {

			String aSql = "SELECT * FROM RequirementInfo WHERE Type = 'BO Specification (BO)' and hierarchy in('1','2','2.1','1.1','1.2','1.3')";

			PreparedStatement aPreparedStatement = aConnection.prepareStatement(aSql);
			ResultSet aResult = aPreparedStatement.executeQuery();

			while (aResult.next()) {

				int aId_number = aResult.getInt("id_number");
				String aName = aResult.getString("Name");
				String aType = aResult.getString("Type");
//				String aOwner = aResult.getString("Owner");
//				String aStatus = aResult.getString("Status");
//				String aPriority = aResult.getString("Priority");
//				String aVersion = aResult.getString("version");
				String aDescription = aResult.getString("Description");
//				String aValidation = aResult.getString("Validation");
//				String aTag = aResult.getString("tag");
				String aHierarchy = aResult.getString("hierarchy");
				if (!aHierarchy.startsWith("1.") && !aHierarchy.equals("1"))
					continue;
				// starts with 1
				//
//				int aIndex = aResult.getInt("index");
//				String aName_tag = aResult.getString("name_tag");

				System.out.println(aId_number + ", " + aName + ", " + aType + ", " + aDescription + ", " + aHierarchy);
			}
		}
	}
}
