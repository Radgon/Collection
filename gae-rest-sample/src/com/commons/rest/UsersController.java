package com.commons.rest;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {

	private Map<String, UserDetails> users = new HashMap<String, UserDetails>();

	{
		UserDetails user = new UserDetails("eyal", new Date(), true);
		users.put(user.getName(), user);

		user = new UserDetails("john", new Date(), false);
		users.put(user.getName(), user);

		user = new UserDetails("emily", new Date(), true);
		users.put(user.getName(), user);

		user = new UserDetails("mark", new Date(), false);
		users.put(user.getName(), user);

	}
	@RequestMapping("/users/{namePrefix}")
	public String getUsers(@PathVariable("namePrefix") String prefix, Model model) {


		Collection<UserDetails> result = new LinkedList<UserDetails>();

		for (Entry<String, UserDetails> entry : users.entrySet()) {
			if (entry.getKey().startsWith(prefix)) {
				result.add(entry.getValue());
			}
		}
		model.addAttribute("users", result);
		return "usersListView";
	}
}
