package iutsd.scene;
import java.awt.Color;
import java.awt.GridLayout;

import javax.media.j3d.Light;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.vecmath.Color3f;


public class CouleursSlider extends JPanel implements ChangeListener{

	private JSlider[] js;
	private Color3f couleur3f;
	private Light lumiere;
	
	public CouleursSlider(String txt){
		super(new GridLayout(0, 1, 0, 0));
		
		couleur3f = new Color3f(1, 1, 1);
		
		this.add(new JLabel(txt));
		
		int i;
		js = new JSlider[3];
		String[] str = {"rouge", "vert", "bleu"};
		JPanel p;
		for(i=0; i<3; i++){
			js[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 255);
			js[i].setMajorTickSpacing(50);
			js[i].setMinorTickSpacing(25);
			js[i].setPaintLabels(true);
			js[i].setPaintTicks(true);
			js[i].addChangeListener(this);
			
			p = new JPanel();
			p.add(new JLabel(str[i]+" : "));
			p.add(js[i]);
			
			this.add(p);
		}	
	}
	
	public void stateChanged(ChangeEvent e){
		Object o  = e.getSource();
		if(o == js[0])
			couleur3f.setX(js[0].getValue()/255f);
		else if(o == js[1])
			couleur3f.setY(js[1].getValue()/255f);
		else if(o == js[2])
			couleur3f.setZ(js[2].getValue()/255f);
		
	}

}
