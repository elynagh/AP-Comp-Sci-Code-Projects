import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    GameWheel players = new GameWheel();
    ArrayList<PrizeCard> player1 = new ArrayList<PrizeCard>();
    ArrayList<PrizeCard> player2 = new ArrayList<PrizeCard>();
    int flag = 0;
    while (player1.size()<5){
      flag = 0;
      PrizeCard temp = players.spinWheel();
      for (int x = 0; x < player1.size(); x++){
        if (temp == player1.get(x))
          flag = 1;
        }
      if (flag == 0)
        player1.add(temp);
      }
    while (player2.size()<5){
      flag = 0;
      PrizeCard temp = players.spinWheel();
      for (int x = 0; x < player2.size(); x++){
        if (temp == player2.get(x))
          flag = 1;
      }
      if (flag == 0)
        player2.add(temp);
    }
    int sumPlayer1 = 0;
    for (int x = 0; x < player1.size(); x++){
      sumPlayer1 += player1.get(x).getPrizeAmount();
      }
    int sumPlayer2 = 0;
    for (int x = 0; x < player2.size(); x++){
      sumPlayer2 += player2.get(x).getPrizeAmount();
      }
    int diffrence = 0;
    int bigger = 0;
    if (sumPlayer1 > sumPlayer2){
      diffrence = sumPlayer1-sumPlayer2;
      bigger = 1;
    }
    else{
      diffrence = sumPlayer2-sumPlayer1;
      bigger = 2;
    }
    System.out.println("Player 1 Total: $" + sumPlayer1 + "\n" + player1.get(0) + "\n" + player1.get(1) + "\n" +player1.get(2) + "\n" +player1.get(3) + "\n" +player1.get(4) + "\n");
    System.out.println("Player 2 Total: $" + sumPlayer2 + "\n" + player2.get(0) + "\n" + player2.get(1) + "\n" +player2.get(2) + "\n" +player2.get(3) + "\n" +player2.get(4) + "\n");
    if (bigger == 1)
      System.out.print("Player 1 won by $" + diffrence + "!");
    else 
      System.out.print("Player 2 won by $" + diffrence + "!");
  }
}
