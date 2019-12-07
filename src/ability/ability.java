package ability;
import characters.*;

import java.util.ArrayList;

//TODO
/*
Warrior:
0 - Attack
1-Inspire
2-Guard
3-Frighten
Cleric:
0 - Attack
1 - Fervor
2 - Heal
3 - Cleanse
Mage:
0-Attack
1-AttackAll
2-Slag
3-Brittle
Archer:
0-Attack
1-AttackAll
2-BattleFieldMedicine
3-ArrowPin
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

    public void applyAbility(){}

    protected String whatHappened(Role User, Role Target)
    {
        return "";
    }

    protected String whatHappened(Role User, ArrayList<Role> Targets)
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
