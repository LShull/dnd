import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CharacterAddListener implements ActionListener {

	JComboBox<String> characterList;
	SpellSheet newSheet;

	public CharacterAddListener(JComboBox<String> characterList,
			SpellSheet newSheet) {
		this.characterList = characterList;
		this.newSheet = newSheet;
	}

	public void actionPerformed(ActionEvent arg0) {

		String item = (String) (JOptionPane.showInputDialog("Character Name:"));
		characterList.addItem(item);
		FileWriter fw = null;
		try {
			fw = new FileWriter("character/" + item + ".txt");
			fw.write("0 0 0 0 0 0 0 0 0\n");
			fw.write("0 0 0 0 0 0 0 0 0");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// newSheet.updateLists();
		characterList.setSelectedItem(item);
		try {
			newSheet.loadFromText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
