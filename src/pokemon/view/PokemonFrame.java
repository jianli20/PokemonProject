package pokemon.view;

import pokemon.controller.PokemonController;
import javax.swing.JFrame;

public class PokemonFrame extends JFrame
{
	private PokemonController appController;
	private PokemonPanel appPanel;

	public PokemonFrame(PokemonController appController)
	{
	super();
	this.appController = appController;
	appPanel = new PokemonPanel(appController);
	setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("CS1400 Pokemon");
		this.setResizable(false);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public PokemonController getPokemonController()
	{
		return appController;
	}
}
