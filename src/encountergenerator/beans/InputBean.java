package encountergenerator.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import encountergenerator.interfaces.Encounter;
import encountergenerator.model.StandardEncounter;

@ManagedBean
public class InputBean {
	
	String encounterLevel;
	Encounter encounter;
	
	@ManagedProperty(value="#{resourceBean}")
	private ResourceBean resourceBean;
	
	
	public String doGenerateEncounter() {
		encounter = new StandardEncounter(encounterLevel);
		return "encounter-discription";
	}
	
	public void setResourceBean(ResourceBean resourceBean) {
		this.resourceBean = resourceBean;
	}

	public String getEncounterLevel() {
		return encounterLevel;
	}

	public void setEncounterLevel(String encounterLevel) {
		this.encounterLevel = encounterLevel;
	}

	public Encounter getEncounter() {
		return encounter;
	}
}
