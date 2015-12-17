package neuhoff.extendedWeather;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EWJPanel extends JPanel {

	protected JLabel date, icon, desc, hi, low, n1, n2, n3;

	public EWJPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		Font font = new Font("Dialog", Font.PLAIN, 18);
		Font f = new Font("Dialog", Font.HANGING_BASELINE, 20);

		date = new JLabel();
		date.setFont(f);
		date.setOpaque(true);

		n1 = new JLabel("<html> <br> </html>");
		icon = new JLabel();
		desc = new JLabel();
		desc.setFont(font);
		n2 = new JLabel("<html> <br> </html>");
		n3 = new JLabel("<html> <br> </html>");
		hi = new JLabel();
		hi.setFont(font);
		low = new JLabel();
		low.setFont(new Font("Dialog", Font.PLAIN, 16));

		date.setAlignmentX(LEFT_ALIGNMENT);
		icon.setAlignmentX(CENTER_ALIGNMENT);
		desc.setAlignmentX(CENTER_ALIGNMENT);
		hi.setAlignmentX(RIGHT_ALIGNMENT);
		low.setAlignmentX(LEFT_ALIGNMENT);

		add(date);
		add(n1);
		add(icon);
		add(desc);
		add(n2);
		add(n3);
		add(hi);
		add(low);
	}

}
