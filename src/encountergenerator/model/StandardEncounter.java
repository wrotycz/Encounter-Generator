package encountergenerator.model;

import encountergenerator.interfaces.Encounter;

public class StandardEncounter implements Encounter {
	
	String level;
	
	public StandardEncounter(String level) {
		this.level = level;
	}

	@Override
	public String getLoot() {
		return "MOCK loot";
	}

	public String getLevel() {
		return level;
	}
	
}
