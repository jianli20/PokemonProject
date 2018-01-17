package pokemon.model;

public class Gabite extends Pokemon implements Dragon
{
	public Gabite()
	{
		super(444, "Gabite");
		setup();
	}
	public Gabite(String name)
	{
		super(444, name);
		setup();
	}
	public Gabite(int number, String name)
	{
		super(number, name);
		setup();
	}
	
	protected void setup()
	{
		this.setAttackPoints(90);
		this.setCanEVolve(true);
		this.setEnhancementModifier(.89);
		this.setHealthPoints(68);
	}
	
	public int dragonClaw(int amount)
	{
		int sample = 0;
		return sample;
	}
	
	public int dracoMeteor(int amount)
	{
		int sample = 0;
		return sample;
	}
	
	public boolean dragonDance()
	{
		return true;
	}
}

