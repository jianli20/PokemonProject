package pokemon.model;

public class Garchomp extends Gabite
{	
	public Garchomp()
	{
		super(445, "Garchomp");
		setup();
	}
	
	public Garchomp(String name)
	{
		super(445, name);
		setup();
	}
	
	public Garchomp(int number,String name)
	{
		super(number, name);
		setup();
	}

	protected void setup()
	{
		super.setup();
		this.setAttackPoints(130);
		this.setCanEVolve(false);
		this.setEnhancementModifier(1.23);
		this.setHealthPoints(108);
	}
}
