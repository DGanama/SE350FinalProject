package FReader;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class PaneManager {
	private Pane root;
	private static PaneManager instance = null;
	private PaneManager() {
		
	}
	public void setPane(Pane rt) {
		root = rt;
	}
	public void deleteChild(Node x) {
		root.getChildren().remove(x);
	}
	public void addChild(Node x) {
		root.getChildren().add(x);
	}
	public void deleteAll() {
		root.getChildren().clear();
	}
	public Pane getPane() {
		return root;
	}
	public static PaneManager getIns() {
		if(instance == null) {
			instance = new PaneManager();
		}
		return instance;
	}
}
