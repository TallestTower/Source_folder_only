package ability;

import characters.Role;

public class Cleanse extends Ability
{
    public Cleanse()
    {
        super("/images/ability_icons/CleanseIcon.png",3);
    }

    public void applyAbility(Role Target)
    {
        Target.setCurrentInitiative(Target.getBaseInitiative());
        Target.setCurrentArmor(Target.getBaseArmor());
        Target.setCurrentAttack(Target.getBaseAttack());

    }

    public String toString()
    {
        return("\tIf magic's made you sad (or happy)," +
                " \n\tbe ready to become normal again.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" set "+Target.getName()+"back to base settings!");
    }
}
