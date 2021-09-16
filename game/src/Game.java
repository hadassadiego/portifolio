public class Game {

    public static void main(String[] args) {

        int systemNumber = 10;

        Player player = new Player("Pedro");
        Player player1 = new Player("Paulo");

        int playerNumber = systemNumber + 1;

        while (playerNumber != systemNumber) {
            playerNumber = player.numberGenerator();

            if (playerNumber == systemNumber) {
                System.out.println("Yay");
                break;
            }
            else {
                System.out.println("Try again");
            }
        }

      /* System.out.println(player.somaDeNums(1,2));
        System.out.println(player.divideNums(10,2));*/

    }

}
