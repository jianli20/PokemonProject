package pokemon.view;

import pokemon.controller.PokemonController;
import javax.swing.*;

public class PokemonPanel extends JPanel
{
	private PokemonController appController;
	private SpringLayout appLayout;
	
	private JLabel healthLabel;
	private JLabel attackLabel;
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel evolvableLabel;
	private JLabel modifierLabel;
	private JLabel iconLabel;
	
	private JCheckBox evolvableBox;
	private JTextField nameField;
	private JTextField numberField;
	private JTextField attackField;
	private JTextField healthField;
	private JTextField modifierField;
	
	private JTextArea descriptionArea;
	private JTextArea typeArea;
	
	private JButton saveButton;
	private JButton clearButton;
	private JComboBox pokedexDropdown;
	
	private JPanel firstType;
	private JPanel secondType;
	private JPanel thirdType;
	private JPanel fourthType;
	
	private void updatePokedexInfo(int index)
	{
		nameField.setText(appController.getPokedex().get(index).getName());
		evolvableBox.setSelected(appController.getPokedex().get(index).isCanEvolve());
		numberField.setText(appController.getPokedex().get(index).getNumber() + "");
		attackField.setText(appController.getPokedex().get(index).getAttackPoints() + "");
		healthField.setText(appController.getPokedex().get(index).getHealthPoints() + "");
		modifierField.setText(appController.getPokedex().get(index).getEnhancementModifier() + "");
	}
	
	public PokemonPanel(PokemonController appController)
	{
		super();
		this.appController = appController;
		
		appLayout = new SpringLayout();
		modifierLabel = new JLabel("Modifier");
		iconLabel = new JLabel ();
		nameField = new JTextField();
		numberField = new JTextField();
		appLayout.putConstraint(SpringLayout.EAST, nameField, -27, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 26, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 361, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, numberField, 389, SpringLayout.WEST, this);
		attackField = new JTextField();
		healthField = new JTextField();
		modifierLabel = new JLabel();
		
		descriptionArea = new JTextArea();
		typeArea = new JTextArea();
		
		saveButton = new JButton();
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -119, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -156, SpringLayout.EAST, this);
		clearButton = new JButton();
		appLayout.putConstraint(SpringLayout.WEST, clearButton, 6, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.SOUTH, clearButton, 0, SpringLayout.SOUTH, saveButton);
		pokedexDropdown = new JComboBox();
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 140, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -47, SpringLayout.WEST, saveButton);
		
		firstType = new JPanel();
		secondType = new JPanel();
		thirdType = new JPanel();
		fourthType = new JPanel();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}	
	public void setupPanel()
	{
		this.setLayout(appLayout);
		
		this.add(modifierField);
		this.add(iconLabel);
		
		evolvableBox = new JCheckBox();
		appLayout.putConstraint(SpringLayout.WEST, nameField, 0, SpringLayout.WEST, evolvableBox);
		appLayout.putConstraint(SpringLayout.WEST, evolvableBox, 341, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableBox, -33, SpringLayout.NORTH, clearButton);
		
		this.add(evolvableBox);
		this.add(nameField);
		this.add(numberField);
		this.add(attackField);
		this.add(healthField);
		this.add(modifierLabel);
		
		this.add(descriptionArea);
		this.add(typeArea);
		
		this.add(saveButton);
		this.add(clearButton);
		this.add(pokedexDropdown);
		
		this.add(firstType);
		this.add(secondType);
		this.add(thirdType);
		this.add(fourthType);
		
		
		healthLabel = new JLabel("Health");
		this.add(healthLabel);
		attackLabel = new JLabel("Attack");
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 31, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, attackLabel, -230, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 14, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, -174, SpringLayout.EAST, this);
		this.add(attackLabel);
		nameLabel = new JLabel("Name");
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, -87, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.SOUTH, numberField, 0, SpringLayout.SOUTH, nameLabel);
		this.add(nameLabel);
		numberLabel = new JLabel("Pokedex Number");
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 10, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, -108, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, numberLabel, 0, SpringLayout.SOUTH, attackField);
		this.add(numberLabel);
		evolvableLabel = new JLabel("Evolvable");
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableLabel, -19, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, evolvableLabel, -44, SpringLayout.WEST, evolvableBox);
		this.add(evolvableLabel);
	}
//	public void setupLayout();
//	{
//		
//	}
	
//	public void setupListeners();
//	{
//		
//	}
}
