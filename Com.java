import java.util.ArrayList;

class Com extends Player {
    private ArrayList<Card> select;

    public Com(Game game, String name) {
        super(game, name);
        select = new ArrayList<>();
    }

    /* カードに対するアクション時（クリックなど）の処理 */
    @Override
    public void action(Card c) {
    }
}
