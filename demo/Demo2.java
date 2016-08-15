import org.frice.game.Game;
import org.frice.game.anim.SimpleMove;
import org.frice.game.event.OnClickEvent;
import org.frice.game.event.OnMouseEvent;
import org.frice.game.event.OnWindowEvent;
import org.frice.game.obj.ImageObject;
import org.frice.game.resource.FileImageResource;
import org.frice.game.utils.time.FTimer;

import java.util.Random;

/**
 * Created by ice1000 on 2016/8/15.
 *
 * @author ice1000
 * @since v0.2.1
 */
public class Demo2 extends Game {

	private FTimer timer;
	private Random random = new Random();
	private ImageObject object;

	public static void main(String[] args) {
		new Demo2();
	}

	@Override
	public void onInit() {
		timer = new FTimer(100);
		object = new ImageObject(new FileImageResource("test.png"), 120, 120);
		object.getAnims().add(new SimpleMove(10, 10));
		addObject(object);
//		setBack(new FileImageResource("test.png"));
		setRefreshPerSecond(40);
	}

	@Override
	public void onExit() {
		System.exit(0);
	}

	@Override
	public void onRefresh() {
		try {
			if (timer.ended()) {
				object.getAnims().clear();
				object.getAnims().add(new SimpleMove(random.nextInt(180) - 90, random.nextInt(180) - 90));
			}
		} catch (Exception ignored){
		}
	}

	@Override
	public void onClick(OnClickEvent e) {

	}

	@Override
	public void onMouse(OnMouseEvent e) {
	}

	@Override
	public void onLoseFocus(OnWindowEvent e) {
		setPaused(true);
	}

	@Override
	public void onFocus(OnWindowEvent e) {
		setPaused(false);
	}
}