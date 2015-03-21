package eveofescape;

public class Item extends Object {

	private int uses, max_uses, dura, max_dura, value, weight, hitroll, damroll, armor;
	private String wearloc, status_effect;
	
	
	public int getUses() {
		return uses;
	}
	public void setUses(int uses) {
		this.uses = uses;
	}
	public int getMax_uses() {
		return max_uses;
	}
	public void setMax_uses(int max_uses) {
		this.max_uses = max_uses;
	}
	public int getDura() {
		return dura;
	}
	public void setDura(int dura) {
		this.dura = dura;
	}
	public int getMax_dura() {
		return max_dura;
	}
	public void setMax_dura(int max_dura) {
		this.max_dura = max_dura;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHitroll() {
		return hitroll;
	}
	public void setHitroll(int hitroll) {
		this.hitroll = hitroll;
	}
	public int getDamroll() {
		return damroll;
	}
	public void setDamroll(int damroll) {
		this.damroll = damroll;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public String getWearloc() {
		return wearloc;
	}
	public void setWearloc(String wearloc) {
		this.wearloc = wearloc;
	}
	public String getStatus_effect() {
		return status_effect;
	}
	public void setStatus_effect(String status_effect) {
		this.status_effect = status_effect;
	}
	
}
