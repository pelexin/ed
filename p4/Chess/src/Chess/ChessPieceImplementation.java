package Chess;

public class ChessPieceImplementation implements ChessPiece {

    private Color color;
    private Type type;
    private boolean wasMoved;
    
    public ChessPieceImplementation(Color color, Type type) {
        this.color = color;
        this.type = type;
        wasMoved = false;
    }
    
    public ChessPieceImplementation(Color color, Type type, boolean wasMoved) {
        this.color = color;
        this.type = type;
        this.wasMoved = wasMoved;
    }
    
    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void notifyMoved() {
        wasMoved = true;
    }

    @Override
    public boolean wasMoved() {
        return wasMoved;
    }

    @Override
    public PiecePosition[] getAvailablePositions(ChessBoard aBoard) {
     
        if (null != getType()) switch (getType()) {
            case BISHOP:
                return ChessMovementManager.getAvailablePositionsOfBishop(this,aBoard);
            case KING:
                return ChessMovementManager.getAvailablePositionsOfKing(this,aBoard);
            case KNIGHT:
                return ChessMovementManager.getAvailablePositionsOfKnight(this,aBoard);
            case QUEEN:
                return ChessMovementManager.getAvailablePositionsOfQueen(this,aBoard);
            case ROOK:
                return ChessMovementManager.getAvailablePositionsOfRook(this,aBoard);
            default:
                break;
        }
        
        return ChessMovementManager.getAvailablePositionsOfPawn(this,aBoard);
    }

}
