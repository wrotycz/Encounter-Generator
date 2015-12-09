package encountergenerator.beans;

import javax.faces.bean.ManagedBean;

import encountergenerator.interfaces.Encounter;
import encountergenerator.model.StandardEncounter;

@ManagedBean
public class InputBean {
	
	String input1, input2, input3, input4;	
	Encounter encounter;
	
	public String doGenerateEncounter() {
		encounter = new StandardEncounter(input1, input2, input3, input4);
		return "encounter-discription";
	}

	public String getInput1() {
		return input1;
	}

	public void setInput1(String input1) {
		this.input1 = input1;
	}

	public String getInput2() {
		return input2;
	}

	public void setInput2(String input2) {
		this.input2 = input2;
	}

	public String getInput3() {
		return input3;
	}

	public void setInput3(String input3) {
		this.input3 = input3;
	}

	public String getInput4() {
		return input4;
	}

	public void setInput4(String input4) {
		this.input4 = input4;
	}

	public Encounter getEncounter() {
		return encounter;
	}
}
