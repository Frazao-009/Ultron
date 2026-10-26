package Ultron;
import robocode.*;

import java.awt.Color;

public class Ultron extends Robot
{
	public void run() {
		setColors(Color.gray,Color.orange,Color.red);  

		setTurnRadarLeft(Double.POSITIVE_INFINITY);

		// Movimentação placeholder
		Boolean mov = true;
		while(mov = true) {
			ahead(100);
			turnRight(50);
			ahead(75);
			turnLeft(25);
			mov = false;
		}
		while(mov = false) {
			back(75);
			turnRight(25);
			ahead(25);
			turnLeft(75);
			back(25);
			mov = true;
		}
	}


	public void onScannedRobot(ScannedRobotEvent e) {
	//Calcula a posição atual do inimigo
    double anguloabsoluto= getHeadingRadians() + event.getBearingRadians();
    double XEn = getX() + Math.sin(anguloabsoluto) * event.getDistance();
    double YEn = getY() + Math.cos(anguloabsoluto) * event.getDistance();
	}

	

	public void onHitByBullet(HitByBulletEvent e) {
		back(10);
	}
	

	public void onHitWall(HitWallEvent e) {
		back(150);
		turnRight(90);
		ahead(100);
	}	
}
