import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper
import com.google.appengine.api.datastore.KeyFactory


if (params["id"]) {
	def id = Long.parseLong(params["id"])
	try {
		def key = KeyFactory.createKey("user", id)
		def user = datastore.get(key)
		ObjectMapper mapper = new ObjectMapper();
		response.contentType = "application/json"
		StringWriter sw = new StringWriter();
		mapper.writeValue(out, user);
	} catch (Throwable t) {
	}
} else {
	forward "index.html"
}

