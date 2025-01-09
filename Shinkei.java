import java.awt.Color;
import java.awt.event.MouseEvent;

class Shinkei extends Game {
    public static void main(String[] args) {
    	new Shinkei();
    }

    public Shinkei() {
        super();
		setSize(1100, 480);
		getContentPane( ).setBackground(new Color(0,196,0));    // 背景色を緑に設定
        Player p = new Player(this, "プレーヤー1");               // プレーヤーを作成
        addPlayer(p);        
		// 表示
		setVisible(true);
		// ゲームをスタート
		gameStart();
    }

    @Override
    public void cardReset() {
		// カードをストックに戻す
		while(players.get(0).size()!=0) {
			Card c = players.get(0).remove(0);
            stock.add(c);
        }
        while(place.size()!=0) {
			Card c = place.remove(0);
            stock.add(c);
        }

		// カードをシャッフル
        stock.shuffle();
        // ストックを表示
        stock.show();
    }

    @Override
    public void gameStart() {
    	// 初期化
		cardReset();
    }

    @Override
    public void action(MouseEvent e) {
    }
}
