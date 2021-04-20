package ie.tudublin;

import C19332586.CatrionasVisual;
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}

	public void CatrionasVisual()
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch(a, new CatrionasVisual());
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.CatrionasVisual();			
	}
}