package encountergenerator.tests;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import encountergenerator.helpers.DefaultResourceParser;
import encountergenerator.interfaces.ResourceParser;

public class ResourceParserTests {

	String level, value;
	ResourceParser parser;
	Map<String, String[]> resource;
	
	@After
	public void tearDown() {
		level = value = null;
		parser = null;
		resource = null;
	}
	
	@Test
	public void shouldBeAbleToParseProperly1() {
		Path resourcePath = Paths.get("resources", "acHigh");
		parser = new DefaultResourceParser();
		parser.setResourcePath(resourcePath);
		parser.setResource();
		Assert.assertNotNull("Parser should be created", parser);
		
		resource = new HashMap<>();
		
		resource = parser.getResource();
		Assert.assertNotNull("Resource shoud be created", resource);
		
		level = "1";
		value = resource.get(level)[0];
		Assert.assertEquals("Armor Class for level 1 and high threat level should equals 16", "16", value);		
	}
	
	@Test
	public void shouldBeAbleToParseProperly2() {
		Path resourcePath = Paths.get("resources", "saveAll");
		parser = new DefaultResourceParser();
		parser.setResourcePath(resourcePath);
		parser.setResource();
		Assert.assertNotNull("Parser should be created", parser);
		
		resource = new HashMap<>();
		
		resource = parser.getResource();
		Assert.assertNotNull("Resource shoud be created", resource);
		
		level = "20";
		value = resource.get(level)[1];
		Assert.assertEquals("Save bonus for level 20 and weak value should equals 7", "7", value);	
		
		value = resource.get(level)[2];
		Assert.assertEquals("Third column in saving bounuses should equal '-'", "-", value);
	}
}
