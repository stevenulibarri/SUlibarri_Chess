package chess.gui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import chess.model.board.ChessBoard;

public class ChessPanel extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ChessSpace> spaces = new ArrayList<ChessSpace>();

	public ChessPanel(MouseController mc) {
		this.addMouseListener(mc);
		this.addMouseMotionListener(mc);
		
		createSpaces();
		for(ChessSpace c: spaces) {
			mc.addObserver(c);
		}
	}
	
	protected void paintComponent(Graphics g) {
		g.clearRect(0, 0, 800, 800);
		for (ChessSpace c : spaces) {
			c.drawMe(g);
		}
		for(ChessSpace c : spaces) {
			c.drawLight(g);
		}
	}
	
	private void createSpaces() {
		for (int i = 0; i <= ChessBoard.MAX_INDEX; i++) {
			for (int j = 0; j <= ChessBoard.MAX_INDEX; j++) {
				spaces.add(new ChessSpace(i, j, ((i+1+j+1)%2 != 0)? true:false));
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {

		
	}

}
