package bean;

public class RjNewsSubsBean {
public boolean technology;
public boolean pharmaceuticals;
public boolean infrastructure;
public boolean power;
public boolean automobile;

public RjNewsSubsBean(){
this.technology=true;
this.pharmaceuticals=true;
this.infrastructure=true;
this.power=true;
this.automobile=true;
}

public boolean isTechnology() {
	return technology;
}

public void setTechnology(boolean technology) {
	this.technology = technology;
}

public boolean isPharmaceuticals() {
	return pharmaceuticals;
}

public void setPharmaceuticals(boolean pharmaceuticals) {
	this.pharmaceuticals = pharmaceuticals;
}

public boolean isInfrastructure() {
	return infrastructure;
}

public void setInfrastructure(boolean infrastructure) {
	this.infrastructure = infrastructure;
}

public boolean isPower() {
	return power;
}

public void setPower(boolean power) {
	this.power = power;
}

public boolean isAutomobile() {
	return automobile;
}

public void setAutomobile(boolean automobile) {
	this.automobile = automobile;
}



}
