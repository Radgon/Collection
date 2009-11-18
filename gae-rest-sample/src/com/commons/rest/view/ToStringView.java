package com.commons.rest.view;


import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.servlet.view.AbstractView;

import com.commons.rest.UserDetails;


public class ToStringView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Collection<UserDetails> udetails = (Collection<UserDetails>) model.get("users");
		JSONArray array = new JSONArray();
		for (UserDetails us : udetails) {
			array.put(new JSONObject(us));
		}
		JSONObject wrapper = new JSONObject();
		wrapper.put("payload", array);
		PrintWriter writer = response.getWriter();
		writer.write(wrapper.toString());
		response.setContentType("text/javascript");
	}

}
