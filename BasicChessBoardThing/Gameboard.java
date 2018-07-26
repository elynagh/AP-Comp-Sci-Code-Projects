class Gameboard
{
  public char [][] board = new char [8][8];
  
  public Gameboard(boolean setup)
  {
    if(setup == false)
    {
      for(int r = 0; r < board.length; r++)
      {
        for(int c = 0; c < board[0].length; c++)
        {
          board[r][c] = '-';
        }
      }
    }
    else
    {
      for(int r = 0; r < board.length; r++)
      {
        if(r <= 2)
        {
          if((r % 2) != 0)
          {
            for(int c = 0; c < board[0].length; c++)
            {
              if((c % 2) != 0)
              {
                board[r][c] = '-';
              }
              else if((c % 2) == 0)
              {
                board[r][c] = 'r';
              }
            }
          }
          else if((r % 2) == 0)
          {
            for(int c = 0; c < board[0].length; c++)
            {
              if((c % 2) != 0)
              {
                board[r][c] = 'r';
              }
              else if((c % 2) == 0)
              {
                board[r][c] = '-';
              }
            }
          }
        }
        else if(r > 2 && r <= 4)
        {
          for(int c = 0; c < board[0].length; c++)
          {
            board[r][c] = '-';
          }
        }
        else if(r > 4 && r <= 8)
        {
          if((r % 2) != 0)
          {
            for(int c = 0; c < board[0].length; c++)
            {
              if((c % 2) != 0)
              {
                board[r][c] = '-';
              }
              else if((c % 2) == 0)
              {
                board[r][c] = 'w';
              }
            }
          }
          else if((r % 2) == 0)
          {
            for(int c = 0; c < board[0].length; c++)
            {
              if((c % 2) != 0)
              {
                board[r][c] = 'w';
              }
              else if((c % 2) == 0)
              {
                board[r][c] = '-';
              }
            }
          }
        }
      }
    }
  }
  
  public boolean move(int x, int y, boolean left)
  {
      boolean can_move = false;
    if(x >= 0 && y >=0 && x<=7 && y <=7)
    {
      if(jump(x, y)){
        jump(x, y);
        can_move = true;
      }
      if(board[x][y] == 'w'){
        if(left){
          if((board[x-1][y-1] == '-') && (x+1) >= 0 && (y-1) >=0 && (x+1)<=7 && (y-1) <=7){
            board[x][y] = '-';
            board[x-1][y-1] = 'w';
            can_move = true;
          }
        }
        else{
          if((board[x-1][y+1] == '-') && (x-1) >= 0 && (y+1) >=0 && (x-1)<=7 && (y+1) <=7){
            board[x][y] = '-';
            board[x-1][y+1] = 'w';
            can_move = true;
          }
          
        }
      }
      else if(board[x][y] == 'r'){
        if(left){
          if((board[x+1][y+1] == '-') && (x+1) >= 0 && (y+1) >=0 && (x+1)<=7 && (y+1) <=7){
            board[x][y] = '-';
            board[x+1][y+1] = 'r';
            can_move = true;
          }
        }
        else{
          if((board[x+1][y-1] == '-') && (x+1) >= 0 && (y-1) >=0 && (x+1)<=7 && (y-1) <=7){
            board[x][y] = '-';
            board[x+1][y-1] = 'r';
            can_move = true;
          }
          
        }
      }
      
      
     
    }
    
    return can_move;
  }
  
  public boolean checkSpace(int x, int y){
    if(x >= 0 && y >=0 && x<=7 && y <=7){
      return true;
    }
    else{
      return false;
    }
  }
  
  public boolean isOccupiedOpp(int x, int y, int a, int b){
    if(x >= 0 && y >=0 && a >=0 && b >= 0 && x<=7 && y <=7 && a <=7 && b<=7){
    if(board[x][y] == 'w'){
      if(board[a][b] == 'r'){
        return true;
      }
      else{
        return false;
      }
    }
    else if(board[x][y] == 'r'){
      if(board[a][b] == 'w'){
        return true;
      }
      else{
        return false;
      }
    }
    else{
     return false; 
    }}
    else{
      return false;
    }
  }
  
  public boolean isEmpty(int x, int y){
    if(board[x][y] == '-'){
      return true;
    }
    else{
      return false;
    }
  }
  
  public boolean jump(int x, int y)
  {
    boolean canJump = false;
    if(x >= 0 && y >=0 && x<=7 && y <=7){
    if(board[x][y] == 'w'){
      if(isOccupiedOpp(x, y, (x-1), (y-1))){
        if(isEmpty(x-2, y-2) && ((x-2) >= 0) && ((y-2) >=0) && ((x-2)<=7) && ((y-2) <=7)){
          canJump = true;
          board[x-1][y-1] = '-';
          board[x][y] = '-';
          board[x-2][y-2] = 'w';
          jump(x-2, y-2);
        }
      }
      else if(isOccupiedOpp(x, y, (x-1), (y+1))){
        if(isEmpty(x-2, y+2) && ((x-2) >= 0) && ((y+2) >=0) && ((x-2)<=7) && ((y+2) <=7)){
          canJump = true;
          board[x-1][y+1] = '-';
          board[x][y] = '-';
          board[x-2][y+2] = 'w';
          jump(x-2, y+2);
        }
      }
    }
    
    else if(board[x][y] == 'r'){
      if(isOccupiedOpp(x, y, x+1, y-1)){
        if(isEmpty(x+2, y-2) && ((x+2) >= 0) && ((y-2) >=0) && ((x+2)<=7) && ((y-2) <=7)){
          canJump = true;
          board[x+1][y-1] = '-';
          board[x][y] = '-';
          board[x+2][y-2] = 'r';
          jump(x+2, y-2);
        }
      }
      else if(isOccupiedOpp(x, y, x+1, y+1)){
        if(isEmpty(x+2, y+2) && ((x+2) >= 0) && ((y+2) >=0) && ((x+2)<=7) && ((y+2) <=7)){
          canJump = true;
          board[x+1][y+1] = '-';
          board[x][y] = '-';
          board[x+2][y+2] = 'r';
          jump(x+2, y+2);
        }
      }
    }
    else{
      canJump = false;
    }}
    
  return canJump;
  }
  
  boolean kingMe(int x, int y)
  {
    boolean possking = false;
    if((x == 0 || x == 7) && x >= 0 && y >=0 && x<=7 && y <=7){
      if(x==0 && board[x][y] == 'w'){
        board[x][y] = Character.toUpperCase(board[x][y]);
      possking = true;
    }
    else if(x==7 && board[x][y] == 'r'){
      board[x][y] = Character.toUpperCase(board[x][y]);
      possking = true;
    }
    }
    return possking;
  }
  
  public String toString()
  {
    String prt = "";
  
    for(int r = 0; r < board.length; r++)
    {
      for(int c = 0; c < board[0].length; c++)
      {
        prt = prt + board[r][c] + " ";
      }
      prt = prt + "\n";
    }
    
    return prt;
  }
  
}
