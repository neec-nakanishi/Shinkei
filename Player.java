class Player extends CardHolder {
    private Card card1;
    private Card card2;

    public Player(Game game, String name) {
        super(game, name);
    }

    /* カードに対するアクション時（クリックなど）の処理 */
    @Override
    public void action(Card c) {
        // スタート時は何もしない
        if (game.getStock().size()==52) {
            return;
        }

        // もし2枚開いている状態であれば何もしない
        int count = 0;
        for (Card cd : game.getPlace()) {
            if (cd.getFace()) {
                count++;
                if (count>=2) {
                    return;
                }
            }
        }

        // すべてカードを取ったら再スタート
        if (size()==52) {
            game.cardReset();
            return;
        }

        if (c.getFace()==false) {
            if (card1==null) {
                c.reverse();    // 表にする
                card1 = c;
            } else if (card2==null) {
                c.reverse();    // 表にする
                card2 = c;
                if (card1.getNum()==card2.getNum()) {
                    // ストックから揃ったカードを取る
                    game.getPlace().remove(card1);
                    game.getPlace().remove(card2);
                    add(card1);
                    add(card2);
                    game.getContentPane().setComponentZOrder(card1, game.getComponentCount()-1);
                    game.getContentPane().setComponentZOrder(card2, game.getComponentCount()-1);                    
                    // プレーヤーの手札に移動させる
                    moveTo(card1, 60-size(), 310-size(), 1);
                    moveTo(card2, 60-size(), 312-size(), 1);
                } else {
                    // 揃わなかった場合は3秒後に裏返す
                    reverse(card1, 3000);
                    reverse(card2, 3000);
                }
                card1 = null;
                card2 = null;
            }
        }
    }
}
