public class ChessGame {
    private ChessBoard board;
    private boolean whiteTurn = true;
  
    public ChessGame() {
        this.board = new ChessBoard();
    }

    public boolean makeMove(Position start, Position end) {
        Piece movingPiece = board.getPiece(start.getRow(), start.getColumn());
        if (movingPiece == null || movingPiece.getColor() != (whiteTurn ? PieceColor.WHITE : PieceColor.BLACK)) {
            return false; // No piece at the start position or not the player's turn
        }
      
        if (movingPiece.isValidMove(end, board.getBoard())) {
            board.movePiece(start, end);
            whiteTurn = !whiteTurn; // Switch turns
            return true;
        }
        return false;
      }

    public boolean isInCheck(PieceColor kingColor) {
        Position kingPosition = findKingPosition(kingColor);
        for (int row = 0; row < board.getBoard().length; row++) {
            for (int col = 0; col < board.getBoard()[row].length; col++) {
                Piece piece = board.getPiece(row, col);
                if (piece != null && piece.getColor() != kingColor) {
                    if (piece.isValidMove(kingPosition, board.getBoard())) {
                        return true; // An opposing piece can capture the king
                    }
                }
            }
        }
        return false;
    }
        
  }