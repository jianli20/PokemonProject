package pokemon.model;

public class Ninetales extends Pokemon implements Ice, Fairy
{
	public Ninetales()
	{
		super(38, "Ninetales");
		setup();
	}
	public Ninetales(String name)
	{
		super(38, name);
		setup();
	}
	public Ninetales(int number, String name)
	{
		super(number, name);
		setup();
	}
	
	protected void setup()
	{
		this.setAttackPoints(67);
		this.setCanEVolve(false);
		this.setEnhancementModifier(1.23);
		this.setHealthPoints(73);
	}
	
	public int iceBeam(int amount)
	{
		int sample = 0;
		return sample;
	}
	
	public int blizzard(int amount)
	{
		int sample =0;
		return sample;
	}
	
	public boolean hail()
	{
		return true;
	}
	
	public int dazzlingGleam(int amount)
	{
		int sample =0;
		return sample;
	}
	public int playRough(int amount)
	{
		int sample =0;
		return sample;
	}
	public boolean healingWish()
	{
		return true;
	}
}

