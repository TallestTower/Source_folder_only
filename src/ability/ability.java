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
public abstract class ability
{
    protected String iconLocation;
    protected int iconPosition;
    public ability(String iconLocation_, int iconPosition_){
        this.iconLocation = iconLocation_;
        this.iconPosition = iconPosition_;
    }

    public ability()
    {
        this.iconLocation = "Null";
        this.iconPosition = 0;
    }

    protected void applyAbility()
    {

    }

    protected String whatHappened(Role User, Role Target)
    {
        return "";
    }

    protected String whatHappened(Role User, ArrayList<Role> Targets)
    {
        return "";
    }

    protected String getIconLocation()
    {
        return iconLocation;
    }

    protected int getIconPosition()
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
