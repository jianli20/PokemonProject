package pokemon.model;

public class Sylveon extends Pokemon implements Fairy
{
	public Sylveon()
	{
		super(700, "Sylveon");
		setup();
	}
	
	public Sylveon(String name)
	{
		super(700, name);
		setup();
	}
	
	public Sylveon(int number, String name)
	{
		super(number,name);
	}
	
	protected void setup()
	{
		this.setAttackPoints(65);
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
