package com.commons.rest;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.FileCopyUtils;

public class JsonHttpMessageConverter extends AbstractHttpMessageConverter<JSONObject>{


	public JsonHttpMessageConverter() {
		super(new MediaType("text", "javascript"));
	}

	@Override
	protected JSONObject readInternal(Class<JSONObject> clazz, HttpInputMessage inputMessage) throws IOException,
	HttpMessageNotReadableException {
		MediaType contentType = inputMessage.getHeaders().getContentType();
		Charset charset = contentType.getCharSet() != null ? contentType.getCharSet() : Charset.forName("utf-8");
		String stringResult =  FileCopyUtils.copyToString(new InputStreamReader(inputMessage.getBody(), charset));

		JSONObject jObject;
		try {
			jObject = new JSONObject(stringResult);
		} catch (JSONException e) {
			throw new IOException (e);
		}
		return jObject;
	}

	@Override
	protected void writeInternal(JSONObject t, HttpOutputMessage outputMessage)
	throws IOException, HttpMessageNotWritableException {
		throw new IOException("Not implemented yet.");

	}

	public boolean supports(Class<? extends JSONObject> clazz) {
		return JSONObject.class.isAssignableFrom(clazz);
	}

}
