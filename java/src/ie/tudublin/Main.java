package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
import C19332586.CatrionasVisual;
import C19332586.SnakeGame;

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
        processing.core.PApplet.runSketch( a, new CatrionasVisual());
	}

	public void SnakeGame()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new SnakeGame());
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.CatrionasVisual();			
	}
}