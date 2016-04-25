package Chess;

public class PiecePosition {

	/**
         * Esta función 
         * @param column Columna a comprobar.
         * @param row Fila a comprobar
         * @return Devuelve si 
         */
	public static boolean isAvailable(int column, int row) {
		return column >= 0 && column < 8 && row >= 0 && row < 8;
	}

	/**
         * 
         * @param position
         * @param columnIncrement
         * @param rowIncrement
         * @return 
         */
	static boolean isAvailable(PiecePosition position, int columnIncrement, int rowIncrement) {
		if (position == null)
			return false;
		
		int newColumn = position.getColumn() + columnIncrement;
		int newRow = position.getRow() + rowIncrement;
		return isAvailable(newColumn, newRow);
	}

	/**
         * 
         * @param position
         * @return 
         */
	static boolean isAvailable(PiecePosition position) {
		if (position == null)
			return false;
		return isAvailable(position.getColumn(), position.getRow());
	}

	private int column, row;

	/**
         * 
         * @param column
         * @param row 
         */
	public PiecePosition(int column, int row) {
		this.column = column;
		this.row = row;
	}
	
	/**
         * 
         * @return 
         */
	public int getColumn() {
		return column;
	}

	/**
         * 
         * @return 
         */
	public int getRow() {
		return row;
	}
	
        /**
         * 
         * @param column
         * @param row
         * @return 
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
         * 
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
         * 
         * @return 
         */
	public PiecePosition clone() {
		return new PiecePosition(column, row);
	}
	
	/**
         * 
         * @param aPosition
         * @return 
         */
	public boolean equals(PiecePosition aPosition) {
		return aPosition.getColumn() == getColumn() && aPosition.getRow() == getRow();
	}
}
