package ability;
import characters.*;

import java.util.ArrayList;

/*
Abilities for each class
    Warrior:
        0 - Attack -> one
        1-Inspire -> all
        2-Guard -> one
        3-Frighten -> one
    Cleric:
        0 - Attack -> one
        1 - Fervor -> one
        2 - Heal -> one
        3 - Cleanse -> one
    Mage:
        0-Attack -> one
        1-AttackAll -> all
        2-Slag -> one
        3-Brittle -> one
    Archer:
        0-Attack -> one
        1-AttackAll -> all
        2-BattleFieldMedicine -> one
        3-ArrowPin -> one
*/
public abstract class Ability
{
    protected String iconLocation;
    protected int iconPosition;
    public Ability(String iconLocation_, int iconPosition_){
        this.iconLocation = iconLocation_;
        this.iconPosition = iconPosition_;
    }

    public Ability()
    {
        this.iconLocation = "Null";
        this.iconPosition = 0;
    }

    public abstract void applyAbility();
    public abstract void applyAbility(Role caster, Role target);
    public abstract void applyAbility(Role caster, ArrayList<Role> targets);

    public String whatHappened(Role User) {return "";}

    public String whatHappened(Role User, Role Target)
    {
        return "";
    }

    public String whatHappened(Role User, ArrayList<Role> Targets)
    {
        return "";
    }

    public String getIconLocation()
    {
        return iconLocation;
    }

    public int getIconPosition()
    {
        return iconPosition;
    }

    protected void setIconLocation(String iconLocation_)
    {
        this.iconLocation = iconLocation_;
    }

    protected void setIconPosition(int iconPosition_)
    {
        this.iconPosition = iconPosition_;
    }

}
