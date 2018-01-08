package pokemon.model;

public class Lapras extends Pokemon implements Ice
{
	public Lapras()
	{
		super(131, "Lapras");
		setup();
	}
	public Lapras(String name)
	{
		super(131, name);
		setup();
	}
	public Lapras(int number, String name)
	{
		super(number, name);
		setup();
	}
	
	protected void setup()
	{
		this.setAttackPoints(85);
		this.setCanEVolve(false);
		this.setEnhancementModifier(1.23);
		this.setHealthPoints(130);
	}
	public int iceBeam(int amount)
	{
		int sample = 0;
		return sample;
	}
	public int blizzard(int amount)
	{
		int sample = 0;
		return sample;
	}
	public boolean hail()
	{
		return true;
	}
}
