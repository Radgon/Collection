import com.google.appengine.api.datastore.Entity 
import java.text.SimpleDateFormat 
import org.codehaus.jackson.map.ObjectMapper

def requestComplete = new StringBuilder();
while ((line = request.getReader().readLine()) != null) {
	requestComplete.append(line);
}
ObjectMapper mapper = new ObjectMapper(); 
Map map = mapper.readValue(requestComplete.toString(), Map.class);

def user = new Entity("user")
user.name = map.key
user.save()