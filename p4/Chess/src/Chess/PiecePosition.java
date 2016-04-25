package Chess;

public class PiecePosition {

	/**
         * Esta función comprueba si la casilla esta en el tablero
         * @param column Column to check.
         * @param row Row to check.
         * @return True if the position is in the table
         */
	public static boolean isAvailable(int column, int row) {
		return column >= 0 && column < 8 && row >= 0 && row < 8;
	}

	/**
         * Esta función comprueba si hay una pieza en la casilla que buscamos.
         * @param position Piece in this position.
         * @param columnIncrement increment of column.
         * @param rowIncrement increment of row.
         * @return false if there is not a piece in this position.
         */
	static boolean isAvailable(PiecePosition position, int columnIncrement, int rowIncrement) {
		if (position == null)
			return false;
		
		int newColumn = position.getColumn() + columnIncrement;
		int newRow = position.getRow() + rowIncrement;
		return isAvailable(newColumn, newRow);
	}

	/**
         * Esta función comprueba si hay una pieza de forma genérica
         * @param position Piece in this position.
         * @return false if there is not a piece in this position.
         */
	static boolean isAvailable(PiecePosition position) {
		if (position == null)
			return false;
		return isAvailable(position.getColumn(), position.getRow());
	}

	private int column, row;

	/**
         * Esta función devuelve la posición de una pieza
         * @param column The column of the field
         * @param row The row of the field
         */
	public PiecePosition(int column, int row) {
		this.column = column;
		this.row = row;
	}
	
	/**
         * Esta función devuelve la columna que buscamos
         * @return the number of the column
         */
	public int getColumn() {
		return column;
	}

	/**
         * Esta función devuelve la fila que buscamos
         * @return the number of the row
         */
	public int getRow() {
		return row;
	}
	
        /**
         * Esta función da valores a la casilla si está disponible
         * @param column the column of the field
         * @param row the row of the field
         * @return true if we can set a value in this field
         */
	public boolean setValues(int column, int row) {
		if (isAvailable(column, row)) {
			this.column = column;
			this.row = row;			
			return true;
		}
		return false;
	}
	
	/**
         * Esta función devuelve la posición de una pieza que se ha movido
         * @param columnCount
         * @param rowCount
         * @return 
         */
	public PiecePosition getDisplacedPiece(int columnCount, int rowCount) {		
		if (!isAvailable(this, columnCount, rowCount))
			return null;
		int newColumn = getColumn() + columnCount;
		int newRow = getRow() + rowCount;
		return new PiecePosition(newColumn, newRow);
	}
	
	/**
         * Esta función clona la posición de una pieza de una casilla a otra
         * @return the PiecePosition cloned from another field
         */
	public PiecePosition clone() {
		return new PiecePosition(column, row);
	}
	
	/**
         * Esta función compara dos casillas del tablero
         * @param aPosition the position we want to compare
         * @return true if the position is equal
         */
	public boolean equals(PiecePosition aPosition) {
		return aPosition.getColumn() == getColumn() && aPosition.getRow() == getRow();
	}
}
