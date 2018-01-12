package pokemon.controller;

import pokemon.model.*;
import java.util.List;
import java.util.ArrayList;

public class PokemonController
{
	private List<Pokemon> pokedex;
	
	public PokemonController()
	{
		pokedex = new ArrayList<Pokemon>();
		buildPokedex();
	}
	
	public void buildPokedex()
	{
		pokedex.add(new Clefable());
		pokedex.add(new Gabite());
		pokedex.add(new Garchomp());
		pokedex.add(new Lapras());
		pokedex.add(new Ninetales());
		pokedex.add(new Sylveon());
	}
	
	public List<Pokemon> getPokedex()
	{
		
		return pokedex;
	}
	
	public boolean isValidInteger(String input)
	{
		return false;
	}
	
	public boolean isValidDouble(String input)
	{
		return false;
	}
	
	public String [] convertPokedex()
	{
		String [] names = new String [pokedex.size()];
		
		for (int index = 0; index < pokedex.size(); index ++)
		{
			names[index] = pokedex.get(index).getName();
		}
		
		return names;
	}
	
	 public void updateSelected(int selection, int health, int attack, boolean evolve, double modify, String name)
	 {
		 Pokemon selected = pokedex.get(selection);
		 
		 selected.setAttackPoints(attack);
		 selected.setCanEVolve(evolve);;
		 selected.setEnhancementModifier(modify);
		 selected.setName(name);
		 selected.setHealthPoints(health);
	 }
}
