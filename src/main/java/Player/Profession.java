package Player;

import equipment.Weapon;

/**
 * Profession kan vara Knight eller Archer
 */
public abstract class Profession extends Decorator {


    public static final double INITIAL_KNIGHT_DAMAGE = 10;
    public static final double INITIAL_ARCHER_DAMAGE = 15;

    public static final int KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL = 30;
    public static final int ARCHER_MAXHEALTH_INCREASE_PER_LEVEL = 15;

    public static final int KNIGHT_BASE_MAXHEALTH = 300;
    public static final int ARCHER_BASE_MAXHEALTH = 300;

    public static final int MINIMUM_LEVEL_TO_HAVE_HEALING_ABILITY = 10;

    private Ability healingAbility;

    public Profession(Character ch) {
        super(ch);
    }

    @Override
    public int getMaxHealth() {
        return character.getMaxHealth();
    }

    @Override
    public int getLevel() {
        return character.getLevel();
    }

    @Override
    public Weapon getWeapon() {
        return character.getWeapon();
    }

    @Override
    public double getDamage() {
        return character.getDamage();
    }

    @Override
    public void setDamage(double newDamage) {
        character.setDamage(newDamage);
    }

    @Override
    public void setMaxHealth(int i) {
        character.setMaxHealth(i);
    }

    @Override
    public void setWeapon(Weapon weapon) {
        character.setWeapon(weapon);
    }

    ;

    @Override
    public void setLevel(int level) {
        character.setLevel(level);
    }

    public abstract void setMaxHealthWithRegardToLevel();

    public Ability getHealingAbility() {
        return healingAbility;
    }

    public void updateHealingAbility() {

        int level = character.getLevel();

        if (level >= 30) {
            healingAbility = new GrandHeal();
            return;
        } else if (level >= 20) {
            healingAbility = new Heal();
            return;
        } else if (level >= 10) {
            healingAbility = new MiniHeal();
            return;
        } else if (level >= 1) {
            healingAbility = new NoHealingAbility();
        }

    }

}
