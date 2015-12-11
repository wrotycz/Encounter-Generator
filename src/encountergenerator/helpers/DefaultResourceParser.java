package encountergenerator.helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import encountergenerator.interfaces.ResourceParser;

public class DefaultResourceParser implements ResourceParser {
	String resourceName;
	Map<String, String[]> resource = new HashMap<>();
	Path resourcePath;

	public DefaultResourceParser(String resourceName) {
		this.resourceName = resourceName;
		
		try {
			ServletContext servletContext = (ServletContext) FacesContext
				        .getCurrentInstance().getExternalContext().getContext();
			resourcePath = Paths.get(servletContext.getRealPath("/"), "WEB-INF", "Classes", resourceName);
		} catch (InvalidPathException e) {
			System.out.println("Invalid Path error: " + e);
		}
		
		setResource();
	}
	
	public DefaultResourceParser(Path resourcePath) {
		this.resourcePath = resourcePath;
		setResource();
	}

	@Override
	public Map<String, String[]> getResource() {
		return resource;
	}
	
	private void setResource() {
		if (resourcePath == null) {
			return;
		}
			
		
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream(resourcePath.toFile())))) {
			String line;
			String[] splittedLine;
			String key;
			String[] values;
			
			while ((line = in.readLine()) != null) {
				splittedLine = line.split("\\t");
				key = splittedLine[0];
				values = new String[splittedLine.length - 1];
				for (int i = 1; i < splittedLine.length; i++) {
					values[i - 1] = splittedLine[i];
				}

				resource.put(key, values);

			}
		} catch (IOException e) {
			System.out.println("Input/Output error: " + e);
		}

	}

	public String getResourceName() {
		return resourceName;
	}
	
	public Path getResourcePath() {
		return resourcePath;
	}

}
