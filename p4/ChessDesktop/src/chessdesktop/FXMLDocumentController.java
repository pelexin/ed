package chessdesktop;

import Chess.ChessAI;
import Chess.ChessBoard;
import Chess.ChessBoardImplementation;
import Chess.ChessPiece;
import Chess.ChessRandomAI;
import Chess.PiecePosition;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FXMLDocumentController implements Initializable {
	

        
	ChessBoardRenderer board = new ChessBoardRenderer();
        
        
            ChessRandomAI myAI = new ChessRandomAI();
            ChessBoard tablero = board.getBoard();

        boolean finish=false;
        boolean whiteMove = true;
        
	@FXML
	private Label label;
	@FXML
	private Canvas canvas;
        
	
	@FXML
	private void handleButtonAction(ActionEvent event) {
		board = new ChessBoardRenderer();
		board.draw(canvas);
                whiteMove = true;
                finish=false;
                label.setText("");
                tablero=board.getBoard();
                
	}
	
	@FXML
	private void handleSaveButtonAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Game");
		File file = fileChooser.showSaveDialog(null);
		if (file != null) {
			Charset charset = Charset.forName("US-ASCII");
			try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), charset)) {
                            board.getBoard().saveToFile(file);
                            writer.close();
			} 
			catch (IOException x) {
				System.err.format("IOException: %s%n", x);
			}
		}
	}

	@FXML
	private void handleLoadButtonAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Chess Files", "*.chess"));
		File selectedFile = fileChooser.showOpenDialog(null);
		if (selectedFile != null) {
			try {
				Scanner in = new Scanner(selectedFile);
                                board.getBoard().loadFromFile(selectedFile);
                                
			} catch (IOException ex) {
				Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
			}
                        board.draw(canvas);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		board.draw(canvas);
		
                        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e)->{
			Chess.ChessPiece piece = board.getPieceAt(canvas, e.getX(), e.getY());

                        if(!finish){
                        
			if (board.getMovingPiece() == piece) {
                                board.setMovingPiece(null);
				board.draw(canvas);
				return;
                        }
                        
			if (board.getMovingPiece() == null) {
                            if(piece.getColor() == ChessPiece.Color.WHITE && whiteMove )
                            {
                                
				board.setMovingPiece(piece);
				board.draw(canvas);
                                board.ChangeColorAvailablePositions(canvas,piece.getAvailablePositions(board.getBoard()));
				return;
                            }
                            
                            if(piece.getColor() == ChessPiece.Color.BLACK && !whiteMove )
                            {
				board.setMovingPiece(piece);
				board.draw(canvas);
                                board.ChangeColorAvailablePositions(canvas,piece.getAvailablePositions(board.getBoard()));
				return;
                            }
			}
                        
			if (board.movePieceTo(canvas, e.getX(), e.getY())) {
				board.setMovingPiece(null);
                                whiteMove = !whiteMove;
				board.draw(canvas);
				if (!board.containsKing(ChessPiece.Color.BLACK) || !board.containsKing(ChessPiece.Color.WHITE)) {
					if (!board.containsKing(ChessPiece.Color.BLACK))
						label.setText("Ganan las blancas");
					else
						label.setText("Ganan las negras");
                                        
                                        finish=true;
				}
			}
                        
                        if (!whiteMove){
                            if (myAI.performNextMovement( tablero, ChessPiece.Color.BLACK))
                            {
                                whiteMove = !whiteMove;
                                board.draw(canvas);
                                
                                 if (!board.containsKing(ChessPiece.Color.BLACK) || !board.containsKing(ChessPiece.Color.WHITE)) {
					if (!board.containsKing(ChessPiece.Color.BLACK))
						label.setText("Ganan las blancas");
					else
						label.setText("Ganan las negras");
				}
                                board.draw(canvas);
                            }
                        }
                        }
		});
            }
}