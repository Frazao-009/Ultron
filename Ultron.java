package Ultron;
import robocode.*;
import robocode.util.Utils;
import java.awt.Color;

public class Ultron extends AdvancedRobot
{
	private static final int TURNOS_SEM_VISAO = 3;
    private static final double AFRENTE = Math.toRadians(5);
    private int turnos_depois_visao = TURNOS_SEM_VISAO + 1;


	public void run() {
		setColors(Color.gray,Color.orange,Color.red);  

	//Ativa a busca por alvos se não encontrar um alvo por muito tempo
	 if (turnos_depois_visao > TURNOS_SEM_VISAO) {
                setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
            }
		turnos_depois_visao++;


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
    double anguloabsoluto= getHeadingRadians() + e.getBearingRadians();
    double XInimigo = getX() + Math.sin(anguloabsoluto) * e.getDistance();
    double YInimigo = getY() + Math.cos(anguloabsoluto) * e.getDistance();

	//Tenta Perseguir o alvo
	turnos_depois_visao = 0;
        double virarScan = Utils.normalRelativeAngle(anguloabsoluto - getRadarHeadingRadians());
        double afrente = Math.copySign(AFRENTE, virarScan);
        setTurnRadarRightRadians(virarScan + afrente);
	}

	

	public void onHitByBullet(HitByBulletEvent e) {
		back(75);
	}
	

	public void onHitWall(HitWallEvent e) {
		back(150);
		turnRight(90);
		ahead(100);
	}	
}
