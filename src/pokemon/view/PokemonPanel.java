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
		//Update basic fields
		nameField.setText(appController.getPokedex().get(index).getName());
		evolvableBox.setSelected(appController.getPokedex().get(index).isCanEvolve());
		numberField.setText(appController.getPokedex().get(index).getNumber() + "");
		attackField.setText(appController.getPokedex().get(index).getAttackPoints() + "");
		healthField.setText(appController.getPokedex().get(index).getHealthPoints() + "");
		modifierField.setText(appController.getPokedex().get(index).getEnhancementModifier() + "");
		
		//Update Text areas
		{
			descriptionArea.setText(appController.getPokedex().get(index).toString());
			typeArea.setText("");;
			
			for (String current : appController.getPokedex().get(index).getPokemonTypes())
			{
				typeArea.append(current + "\n");
			}
		}
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
		modifierField = new JTextField();

		
		iconLabel = new JLabel("", new ImageIcon(getClass().getResource("/pokemon/view/images/pokeball.png")), JLabel.CENTER);
		
		
		descriptionArea = new JTextArea();
		typeArea = new JTextArea();
		appLayout.putConstraint(SpringLayout.NORTH, descriptionArea, 0, SpringLayout.SOUTH, typeArea);
		saveButton = new JButton();
		appLayout.putConstraint(SpringLayout.NORTH, typeArea, 0, SpringLayout.SOUTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, typeArea, 0, SpringLayout.WEST, saveButton);

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
	
	private void updateImage()
	{
		String path = "/pokemon/view/images/";
		String defaultName = "pokeball";
		String name = pokedexDropdown.getSelectedItem().toString();
		String extension = ".png";
		ImageIcon pokemonIcon;
		
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingImageFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		
		iconLabel.setIcon(pokemonIcon);
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
		else
		{
			secondType.setBackground(Color.white);
		}
	}	
	
	public void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, modifierLabel, 0, SpringLayout.WEST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.EAST, modifierLabel, 0, SpringLayout.EAST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 0, SpringLayout.WEST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackLabel, 0, SpringLayout.EAST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 7, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 320, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, numberField, -6, SpringLayout.NORTH, nameField);
		appLayout.putConstraint(SpringLayout.EAST, numberField, -37, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, evolvableLabel, 0, SpringLayout.NORTH, evolvableBox);
		appLayout.putConstraint(SpringLayout.EAST, evolvableLabel, -142, SpringLayout.WEST, evolvableBox);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.EAST, healthLabel, 0, SpringLayout.EAST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.EAST, nameLabel, 0, SpringLayout.EAST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.NORTH, modifierLabel, 6, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.NORTH, attackLabel, 6, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 29, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 6, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, numberLabel, -6, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.EAST, evolvableBox, -52, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 0, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, nameField, 0, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, attackField, 0, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.SOUTH, attackField, 0, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, healthField, 0, SpringLayout.NORTH, healthLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.SOUTH, healthField, 0, SpringLayout.SOUTH, healthLabel);
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, modifierField, 0, SpringLayout.NORTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.WEST, modifierField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.SOUTH, modifierField, 0, SpringLayout.SOUTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.EAST, modifierField, 0, SpringLayout.EAST, numberField);
		appLayout.putConstraint(SpringLayout.NORTH, evolvableBox, 6, SpringLayout.SOUTH, modifierField);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, 28, SpringLayout.EAST, typeArea);
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
		appLayout.putConstraint(SpringLayout.EAST, secondType, 0, SpringLayout.EAST, firstType);
		appLayout.putConstraint(SpringLayout.NORTH, iconLabel, 0, SpringLayout.NORTH, numberField);
		appLayout.putConstraint(SpringLayout.WEST, iconLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, iconLabel, 0, SpringLayout.SOUTH, evolvableBox);
		appLayout.putConstraint(SpringLayout.EAST, iconLabel, 0, SpringLayout.EAST, firstType);
		appLayout.putConstraint(SpringLayout.WEST, descriptionArea, 0, SpringLayout.WEST, saveButton);
		appLayout.putConstraint(SpringLayout.SOUTH, secondType, 34, SpringLayout.SOUTH, firstType);

		
	}
	
	public void setupListeners()
	{
		pokedexDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int selectedPokemonIndex = pokedexDropdown.getSelectedIndex();
				updatePokedexInfo(selectedPokemonIndex);
				updateImage();
				updateTypePanels();
				repaint();
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(appController.isValidInteger(attackField.getText()) && appController.isValidInteger(healthField.getText())
						&& appController.isValidDouble(modifierField.getText()))
				{
					int selected = pokedexDropdown.getSelectedIndex();
					int health = Integer.parseInt(healthField.getText());
					int attack = Integer.parseInt(attackField.getText());
					double modifier = Double.parseDouble(modifierField.getText());
					String name = nameField.getText();
					boolean evolvable = evolvableBox.isSelected();
					
					//Send to the Controller to modify the Pokemon
					appController.updateSelected(selected,  health , attack , evolvable, modifier, name);
				}
			}
		});
	}
}
