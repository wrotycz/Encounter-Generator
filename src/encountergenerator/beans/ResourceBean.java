package encountergenerator.beans;

import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import encountergenerator.helpers.DefaultResourceParser;
import encountergenerator.interfaces.ResourceParser;

@ApplicationScoped
@ManagedBean
public class ResourceBean {
	private Map<String, String[]> armorClassHigh;
	private Map<String, String[]> armorClassLow;
	private Map<String, String[]> armorClassMiddle;
	private Map<String, String[]> attackBonusAll;
	private Map<String, String[]> damageAll;
	private Map<String, String[]> HealthPointsAll;
	private Map<String, String[]> SaveBonusAll;
	private ResourceParser resourceParser;
			
	public ResourceBean() {
		resourceParser = new DefaultResourceParser("acHigh");
		armorClassHigh = resourceParser.getResource();
		
		resourceParser = new DefaultResourceParser("acLow");
		armorClassLow = resourceParser.getResource();
		
		resourceParser = new DefaultResourceParser("acMid");
		armorClassMiddle = resourceParser.getResource();
		
		resourceParser = new DefaultResourceParser("atkAll");
		attackBonusAll = resourceParser.getResource();
		
		resourceParser = new DefaultResourceParser("dmgAll");
		damageAll = resourceParser.getResource();
		
		resourceParser = new DefaultResourceParser("hpAll");
		HealthPointsAll = resourceParser.getResource();
		
		resourceParser = new DefaultResourceParser("saveAll");
		SaveBonusAll = resourceParser.getResource();
		
		resourceParser = null;
	}

	public Map<String, String[]> getArmorClassHigh() {
		return armorClassHigh;
	}

	public Map<String, String[]> getArmorClassLow() {
		return armorClassLow;
	}

	public Map<String, String[]> getArmorClassMiddle() {
		return armorClassMiddle;
	}

	public Map<String, String[]> getAttackBonusAll() {
		return attackBonusAll;
	}

	public Map<String, String[]> getDamageAll() {
		return damageAll;
	}

	public Map<String, String[]> getHealthPointsAll() {
		return HealthPointsAll;
	}

	public Map<String, String[]> getSaveBonusAll() {
		return SaveBonusAll;
	}
	
	
	
}
