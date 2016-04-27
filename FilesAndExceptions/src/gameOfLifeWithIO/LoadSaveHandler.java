package gameOfLifeWithIO;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Handles loading or saving the game state.
 * 
 * @author Curt Clifton.
 */
class LoadSaveHandler {

	private final GameOfLife game;
	private final JFileChooser chooser;

	/**
	 * Constructs a handler for the Save button of the given game.
	 * 
	 * @param game
	 */
	public LoadSaveHandler(GameOfLife game) {
		this.game = game;
		this.chooser = new JFileChooser();
	}

	/**
	 * Prompts the user for a file and loads the current game state from the
	 * file.
	 * 
	 * @throws IOException
	 *             if trouble loading file
	 */
	public void loadGameState() {
		// Makes sure the game isn't running.
		this.game.pause();

		// Prompts the user for the file to open. Skips loading if they
		// canceled.
		if (this.chooser.showOpenDialog(this.game) != JFileChooser.APPROVE_OPTION) {
			return;
		}

		// Stores the file the user picked.
		File inputFile = this.chooser.getSelectedFile();

		// Users a scanner to read in coordinate pairs from the file.
		Scanner inScanner = null;
		try {
			inScanner = new Scanner(inputFile);
		} catch (FileNotFoundException exception1) {
			// TODO Auto-generated catch-block stub.
			exception1.printStackTrace();
			System.err.print("File Not Find!");
		}
		
		

		try {
			ArrayList<Coordinates> coords = new ArrayList<Coordinates>();
			while (inScanner.hasNextInt()) {
				/*
				 * What happens if we don't have an even number of integers in
				 * the file?
				 */
				int row = inScanner.nextInt();
				// TODO: check this condition and throw an exception if needed. 
					if(!inScanner.hasNextInt()){
						throw new Exception("Missing second number! Bad File!");
					}
				
				int column = inScanner.nextInt();
				coords.add(new Coordinates(row, column));
			}

			// Updates the state.
			this.game.setFilledSquares(coords);
		} catch (Exception exception) {
			
			// TODO Auto-generated catch-block stub.
			exception.printStackTrace();
		} finally {
			inScanner.close();
		}
	}

	/**
	 * Prompts the user for a file and saves the current game state to the file.
	 */
	void saveGameState() {
		this.game.pause();
		ArrayList<Coordinates> filledSquares = this.game.getFilledSquares();
		if (this.chooser.showSaveDialog(this.game) != JFileChooser.APPROVE_OPTION) {
			return;
		}
		File outputFile = this.chooser.getSelectedFile();
		try {
			PrintWriter writer = new PrintWriter(outputFile);
			try {
				for (Coordinates c : filledSquares) {
					writer.printf("%d %d%n", c.getRow(), c.getColumn());
				}
			} finally {
				writer.close();
			}
		} catch (FileNotFoundException fnfException) {
			String msg = "Unable to save game: " + fnfException.getMessage();
			JOptionPane.showMessageDialog(this.game, msg, "Save Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
