public abstract class Piece {
    protected Position position;
    protected PieceColor color;
  
    public Piece(PieceColor color, Position position) {
        this.color = color;
        this.position = position;
    }
  
    public PieceColor getColor() {
        return color;
    }
  
    public Position getPosition() {
        return position;
    }
  
    public void setPosition(Position position) {
        this.position = position;
    }
  
    public abstract boolean isValidMove(Position newPosition, Piece[][] board);

    private void setupPieces() {
        // Rooks
        board[0][0] = new Rook(PieceColor.BLACK, new Position(0, 0));
        board[0][7] = new Rook(PieceColor.BLACK, new Position(0, 7));
        board[7][0] = new Rook(PieceColor.WHITE, new Position(7, 0));
        board[7][7] = new Rook(PieceColor.WHITE, new Position(7, 7));
        // Knights
        board[0][1] = new Knight(PieceColor.BLACK, new Position(0, 1));
        board[0][6] = new Knight(PieceColor.BLACK, new Position(0, 6));
        board[7][1] = new Knight(PieceColor.WHITE, new Position(7, 1));
        board[7][6] = new Knight(PieceColor.WHITE, new Position(7, 6));
        // Bishops
        board[0][2] = new Bishop(PieceColor.BLACK, new Position(0, 2));
        board[0][5] = new Bishop(PieceColor.BLACK, new Position(0, 5));
        board[7][2] = new Bishop(PieceColor.WHITE, new Position(7, 2));
        board[7][5] = new Bishop(PieceColor.WHITE, new Position(7, 5));
        // Queens
        board[0][3] = new Queen(PieceColor.BLACK, new Position(0, 3));
        board[7][3] = new Queen(PieceColor.WHITE, new Position(7, 3));
        // Kings
        board[0][4] = new King(PieceColor.BLACK, new Position(0, 4));
        board[7][4] = new King(PieceColor.WHITE, new Position(7, 4));
        // Pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(PieceColor.BLACK, new Position(1, i));
            board[6][i] = new Pawn(PieceColor.WHITE, new Position(6, i));
        }
      } 

      public void movePiece(Position start, Position end) {
        // Check if there is a piece at the start position and if the move is valid
        if (board[start.getRow()][start.getColumn()] != null &&
                board[start.getRow()][start.getColumn()].isValidMove(end, board)) {
      
            // Perform the move
            board[end.getRow()][end.getColumn()] = board[start.getRow()][start.getColumn()];
      
            // Update piece position
            board[end.getRow()][end.getColumn()].setPosition(end);
      
            // Clear the start position
            board[start.getRow()][start.getColumn()] = null;
        }
      }
  }