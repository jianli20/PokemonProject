package pokemon.view;

import pokemon.controller.PokemonController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	private void updatePokedexInfo(int index)
	{
		nameField.setText(appController.getPokedex().get(index).getName());
		evolvableBox.setSelected(appController.getPokedex().get(index).isCanEvolve());
		numberField.setText(appController.getPokedex().get(index).getNumber() + "");
		attackField.setText(appController.getPokedex().get(index).getAttackPoints() + "");
		healthField.setText(appController.getPokedex().get(index).getHealthPoints() + "");
		modifierField.setText(appController.getPokedex().get(index).getEnhancementModifier() + "");
	}
	
	private void setupComboBox()
	{
		DefaultComboBoxModel pokemonModel = new DefaultComboBoxModel(appController.convertPokedex());
		pokedexDropdown.setModel(pokemonModel);
	}
	
	private void setupTypePanel()
	{
		firstType.setSize(50, 50);
		secondType.setSize(50, 50);
	}
	
	public PokemonPanel(PokemonController appController)
	{
		super();
		this.appController = appController;
		
		appLayout = new SpringLayout();
		modifierLabel = new JLabel("Modifier");
		attackLabel = new JLabel("Attack");
		healthLabel = new JLabel("Health");
		nameLabel = new JLabel("Name");
		numberLabel = new JLabel("Pokedex Number");
		evolvableLabel = new JLabel("Evolvable");
		
		evolvableBox = new JCheckBox();
		
		nameField = new JTextField();
		numberField = new JTextField();
		attackField = new JTextField();
		healthField = new JTextField();
		
		iconLabel = new JLabel("", new ImageIcon(getClass().getResource("/pokemon/view/images/pokeball.png")), JLabel.CENTER);
		
		descriptionArea = new JTextArea();
		typeArea = new JTextArea();
		saveButton = new JButton();
		clearButton = new JButton();
		
		pokedexDropdown = new JComboBox();
		
		
		firstType = new JPanel();
		secondType = new JPanel();
	

		
		setupComboBox();
		setupTypePanel();
		setupPanel();
		setupLayout();
		setupListeners();
	}	
	public void setupPanel()

	{
		this.setLayout(appLayout);
		
		this.add(modifierField);
		
	
		
		this.add(evolvableBox);
		this.add(nameField);
		this.add(numberField);
		this.add(attackField);
		this.add(healthField);
		this.add(modifierLabel);
		
		this.add(descriptionArea);
		this.add(typeArea);
		
		this.add(iconLabel);
		
		this.add(saveButton);
		this.add(clearButton);
		this.add(pokedexDropdown);
		
		this.add(firstType);
		this.add(secondType);
		this.add(evolvableLabel);
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(attackLabel);
		this.add(healthLabel);
		
		
	}
	
	private void updateTypePanels()
	{
		String[] types = appController.getPokedex().get(pokedexDropdown.getSelectedIndex()).getPokemonTypes();
		
		if(types[0].equals("Ice"))
		{	
			firstType.setBackground(Color.cyan);
		}
		else if (types[0].equals("Fairy"))
		{
			firstType.setBackground(Color.pink);
		}
		else
		{
			firstType.setBackground(Color.blue);
		}
		
		if (types.length > 1)
		{
			if (types[1].equals("Fairy"))
			{
				secondType.setBackground(Color.pink);
			}
		}
	}	
	
	public void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, modifierLabel, 6, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 6, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 29, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 6, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, numberLabel, -6, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, -167, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, evolvableLabel, 6, SpringLayout.SOUTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.NORTH, evolvableBox, 0, SpringLayout.NORTH, evolvableLabel);
		appLayout.putConstraint(SpringLayout.EAST, evolvableBox, -52, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 0, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, nameField, 0, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 0, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, numberField, 0, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 34, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, numberField, 130, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 0, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.SOUTH, attackField, 0, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 0, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.SOUTH, healthField, 0, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, modifierLabel, 0, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolvableLabel, 0, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, iconLabel, 0, SpringLayout.SOUTH, evolvableBox);
		appLayout.putConstraint(SpringLayout.EAST, iconLabel, 176, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.NORTH, iconLabel, 0, SpringLayout.NORTH, descriptionArea);
		appLayout.putConstraint(SpringLayout.WEST, iconLabel, 0, SpringLayout.WEST, descriptionArea);
		appLayout.putConstraint(SpringLayout.NORTH, clearButton, 65, SpringLayout.SOUTH, evolvableBox);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, 0, SpringLayout.SOUTH, clearButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -6, SpringLayout.WEST, clearButton);
		appLayout.putConstraint(SpringLayout.EAST, clearButton, 0, SpringLayout.EAST, nameField);
		appLayout.putConstraint(SpringLayout.NORTH, pokedexDropdown, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, 0, SpringLayout.EAST, modifierLabel);
		appLayout.putConstraint(SpringLayout.NORTH, firstType, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, firstType, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, firstType, -13, SpringLayout.SOUTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, firstType, -41, SpringLayout.WEST, pokedexDropdown);
		appLayout.putConstraint(SpringLayout.NORTH, secondType, 18, SpringLayout.SOUTH, firstType);
		appLayout.putConstraint(SpringLayout.WEST, secondType, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, secondType, -58, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, secondType, 0, SpringLayout.EAST, firstType);
		
	}
	
	public void setupListeners()
	{
		pokedexDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int selectedPokemonIndex = pokedexDropdown.getSelectedIndex();
				updatePokedexInfo(selectedPokemonIndex);
//				updateImage();
				updateTypePanels();
				repaint();
			}
		});
	}
}
