package neuhoff.physics;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class GraphGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public GraphGUI(){
		setTitle("GraphGUI");
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// closes the window exits your program
		
		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		container.add(new GraphComponent(), BorderLayout.CENTER);
	}	


	public static void main (String[] args){
		GraphGUI graph = new GraphGUI();
		graph.setVisible(true);
	}

}
