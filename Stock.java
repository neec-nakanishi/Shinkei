class Stock extends CardHolder {
    public Stock(Game game, String name) {
        super(game, name);
    }

    public void show() {
        for (int i=0; i<size() ; i++) {
            Card c = get(i);
            c.setLocation(70-i, 70-i);  // 重ねる
            c.setFace(false);           // 裏向き
        }
    }

    /* カードに対するアクション時（クリックなど）の処理 */
    @Override
    public void action(Card cd) {
        if (size()==52) {
            for (int y=0 ; y<4 ; y++) {
                for (int x=0 ; x<13 ; x++) {
                    Card c = get(0);
                    c.setFace(false);
                    remove(c);
                    game.getPlace().add(c);
                    game.getContentPane().setComponentZOrder(c, game.getComponentCount()-1);
                    game.getPlace().moveTo(c, 140+x*70, 30+y*100, 1);
                }
            }
        }
    }
}
