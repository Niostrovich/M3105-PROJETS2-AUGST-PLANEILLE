package javaproject_ageOfAntHill;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.LinkedList;

import javaproject_ageOfAntHill.map.Cell;

public class SaveManager {
	private static final String DEFAULT_FILENAME = "files/save.aoa";
	private String filename;
	private LinkedList<Save> saves;

	public SaveManager() {
		this.filename = DEFAULT_FILENAME;
		this.readSaves();
	}

	public SaveManager(String filename) {
		this.filename = filename;
		this.readSaves();
	}

	private void readSaves() {
		// Reading the file
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(this.filename));
			String str;

			while ((str = in.readLine()) != null) {
				this.saves.add(new Save(str));
			}
			in.close();
		} catch (IOException e) {
			System.out.println("Error reading file : " + e);
			return;
		}

		return;
	}

	public void writeSave() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(this.filename), "utf-8"))) {
			for(Save save : this.saves)
				writer.write(save+"\n");
		} catch (UnsupportedEncodingException e){
			System.out.println("Unsupported encoding");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO error");
			e.printStackTrace();
		}
	}

	public String listSaves() {
		String ret = "";
		for (Save elem : this.saves) {
			ret += elem.getName() + "\n";
		}
		return ret;
	}

	public Cell[][] getSave(String name) {
		for (Save elem : this.saves) {
			if (elem.getName() == name)
				return elem.getSave();
		}
		return null;
	}

	public void addSave(Cell[][] grid) {
		this.saves.add(new Save(""+ this.saves.size(), grid));
	}

	@Override
	protected void finalize() throws Throwable {
		this.writeSave();
		super.finalize();
	}

}
