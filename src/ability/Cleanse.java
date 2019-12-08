package ability;

import characters.Role;

import java.util.ArrayList;

public class Cleanse extends Ability
{
    public Cleanse()
    {
        super("/images/ability_icons/CleanseIcon.png",3);
    }

    public void applyAbility(){}
    public void applyAbility(Role caster, ArrayList<Role> targets){}
    public void applyAbility(Role caster, Role target)
    {
        target.setCurrentInitiative(target.getBaseInitiative());
        target.setCurrentArmor(target.getBaseArmor());
        target.setCurrentAttack(target.getBaseAttack());

    }

    public String toString()
    {
        return("\tIf magic's made you sad (or happy)," +
                " \n\tbe ready to become normal again.");
    }

    public String whatHappened(Role caster, Role target)
    {
        return(caster.getName()+" set "+target.getName()+" back to base settings!");
    }
}
