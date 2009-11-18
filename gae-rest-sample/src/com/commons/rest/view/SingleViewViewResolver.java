package com.commons.rest.view;


import java.util.Locale;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class SingleViewViewResolver implements ViewResolver, Ordered{

	private  final View view;

	private int order;

	public SingleViewViewResolver(View view) {
		this.view = view;
	}

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		return view;
	}

	@Override
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}
