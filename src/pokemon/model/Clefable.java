package pokemon.model;

public class Clefable extends Pokemon implements Fairy
{
	public Clefable()
	{
		super(36, "Clefable");
		setup();
	}
	public Clefable(String name)
	{
		super(36, name);
		setup();
	}
	public Clefable(int number, String name)
	{
		super(number, name);
		setup();
	}
	
	protected void setup()
	{
		this.setAttackPoints(70);
		this.setCanEVolve(false);
		this.setEnhancementModifier(1.23);
		this.setHealthPoints(95);
	}
	public int dazzlingGleam(int amount)
	{
		int sample = 0;
		return sample;
	}
	public int playRough(int amount)
	{
		int sample = 0;
		return sample;
	}
	public boolean healingWish()
	{
		return true;
	}
}
