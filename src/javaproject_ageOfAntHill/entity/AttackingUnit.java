package javaproject_ageOfAntHill.entity;

import javaproject_ageOfAntHill.map.InterfaceMap;
import javaproject_ageOfAntHill.map.Position;

public class AttackingUnit extends Unit implements InterfaceAttack {

	public void attack(Unit enemy) {
		if (!(enemy instanceof Unit)){
			System.out.println("AttackingUnit.java -> attack -> The parametter isn't an Unit instance");
			return;

		}
		Unit unit = this;

		int damages = unit.getDamages() - enemy.getArmor();
		if (damages > 0)
			enemy.setHealthPoints(enemy.getHealthPoints() - damages);
	}

	@Override
	public void attack(Position unitPos, Position enemyPos) {
		
	}

}
