package cbskarmory.units.air;

import java.util.ArrayList;

import cbskarmory.Player;
import cbskarmory.units.Air;
import cbskarmory.units.Carry;
import cbskarmory.units.Unit;
import cbskarmory.weapons.WeaponType;

/**
 * The DropShip is a flying transport unit
 * Gets NONE (unarmed)
 * Costs 3000
 * Can carry 3 Land Units
 * Costs 5 fuel/turn to stay airborne
 */
public class DropShip extends Air implements Carry {

	/**
	 * Constructs a DropShip
	 * sets primary weapon to NONE (unarmed)
	 * @param owner owner of the unit
	 */
	public DropShip(Player owner) {
		super(owner);
		setWeapon(0, WeaponType.NONE); // unarmed
		carried = new ArrayList<Unit>();
	}

	private ArrayList<Unit> carried;
	@Override
	public ArrayList<Unit> getUnits() {
		return carried;
	}

	@Override
	public void resupply() {
		//cannot resupply

	}

	@Override
	public boolean canResupply() {
		return false;
	}

	@Override
	public boolean canCarry(Unit u) {
		switch(u.getMovementType()){
		case FOOT:
			return true;
		case TREADS:
			return true;
		case TIRES:
			return true;
		default:
			return false;
		}
	}

	@Override
	public int getBuildCost() {
		return 3000;
	}

	@Override
	public double getBaseArmorResistance() {
		return 1;
	}
	@Override
	public int getDailyCost() {
		return 5;
	}
	@Override
	public int getMaxCapacity() {
		return 3;
	}

}
