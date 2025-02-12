package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.User;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	@Autowired
	UserResponse response;
	@Autowired
	User users;

	public UserResponse addUser(UserRequest request) {
		String query = "Insert into User (userId, userName, userPassword, userMail) " + "Values ('"
				+ request.getUserId() + "', '" + request.getUserName() + "', '" + request.getUserPassword() + "', '"
				+ request.getUserMail() + "');";

		try {
			DBUtils.executeQuery(query);

			users.setUserId(request.getUserId());
			users.setUserName(request.getUserName());
			request.getUserPassword(); // to hide the password of user
			users.setUserMail(request.getUserMail());
			response.setResponseCode("0000");
			response.setResponseMessage("user added");
		} catch (SQLException e) {
			e.printStackTrace();
			response.setResponseCode("911");
			response.setResponseMessage("add user fail");

		}
		return response;
	}

	public UserResponse getAllUser() {
		List<User> userList = new ArrayList<>();
		String querey = "select * from user";

		try {
			ResultSet result = DBUtils.executeSelectQuery(querey);

			while (result.next()) {
				User user = new User();
				user.setUserId(result.getString(1));
				user.setUserName(result.getString(2));
				user.setUserMail(result.getString(4));
				userList.add(user);
			}

				response.setResponseCode("0000");
				response.setResponseMessage("Displaying User");
				response.setUsers(userList);
		} catch (SQLException e) {

			response.setResponseCode("911");
			response.setResponseMessage("User fetch failed");
			e.printStackTrace();
		}
		return response;
	}

}
