package encountergenerator.interfaces;

import java.nio.file.Path;
import java.util.Map;

public interface ResourceParser {
	Map<String, String[]> getResource();
	void setResource();
	Path getResourcePath();
	void setResourcePath(Path resourcePath);
}
