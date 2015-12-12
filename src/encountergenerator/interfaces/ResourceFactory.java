package encountergenerator.interfaces;

import java.util.List;
import java.util.Map;

import javax.naming.InvalidNameException;

public interface ResourceFactory {
	Map<String, String[]> getResource(String resourceName) throws InvalidNameException;
	List<String> getResourceNames();
}
