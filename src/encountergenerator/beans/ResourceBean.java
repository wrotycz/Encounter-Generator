package encountergenerator.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.InvalidNameException;

import encountergenerator.helpers.DefaultResourceParser;
import encountergenerator.interfaces.ResourceFactory;
import encountergenerator.interfaces.ResourceParser;

@ApplicationScoped
@ManagedBean
public class ResourceBean implements ResourceFactory{
	private Map<String, String[]> armorClassHigh;
	private Map<String, String[]> armorClassLow;
	private Map<String, String[]> armorClassMiddle;
	private Map<String, String[]> attackBonusAll;
	private Map<String, String[]> damageAll;
	private Map<String, String[]> HealthPointsAll;
	private Map<String, String[]> SaveBonusAll;
	private ResourceParser resourceParser;
	
	private List<String> resourceNames = new ArrayList<>();
	
	public ResourceBean() {
		resourceParser = new DefaultResourceParser("acHigh");
		armorClassHigh = resourceParser.getResource();
		resourceNames.add("armorClassHigh");
		
		resourceParser = new DefaultResourceParser("acLow");
		armorClassLow = resourceParser.getResource();
		resourceNames.add("armorClassLow");
		
		resourceParser = new DefaultResourceParser("acMid");
		armorClassMiddle = resourceParser.getResource();
		resourceNames.add("armorClassMiddle");
		
		resourceParser = new DefaultResourceParser("atkAll");
		attackBonusAll = resourceParser.getResource();
		resourceNames.add("attackBonusAll");
		
		resourceParser = new DefaultResourceParser("dmgAll");
		damageAll = resourceParser.getResource();
		resourceNames.add("damageAll");
		
		resourceParser = new DefaultResourceParser("hpAll");
		HealthPointsAll = resourceParser.getResource();
		resourceNames.add("HealthPointsAll");
		
		resourceParser = new DefaultResourceParser("saveAll");
		SaveBonusAll = resourceParser.getResource();
		resourceNames.add("SaveBonusAll");
		
		resourceParser = null;
	}
	
	public Map<String, String[]> getResource(String resourceName) throws InvalidNameException {
		if (!resourceNames.contains(resourceName)) throw new InvalidNameException();
		switch (resourceName) {
			case "armorClassHigh": return armorClassHigh;
			case "armorClassLow": return armorClassLow;
			case "armorClassMiddle": return armorClassMiddle;
			case "attackBonusAll": return attackBonusAll;
			case "damageAll": return damageAll;
			case "HealthPointsAll": return HealthPointsAll;
			case "SaveBonusAll": return SaveBonusAll;
			default: return new HashMap<String, String[]>();
		}
	}
	
	public List<String> getResourceNames() {
		return resourceNames;
	}	
	
}
