package ability;

import characters.Role;

public class Cleanse extends ability
{
    public Cleanse()
    {
        super("Dunno",3);
    }

    public void applyAbility(Role Target)
    {
        Target.setCurrentInitiative(Target.getBaseInitiative());
        Target.setCurrentArmor(Target.getCurrentArmor());
        Target.setCurrentAttack(Target.getCurrentAttack());

    }

    public String toString()
    {
        return("If magic's made you sad (or happy), be ready to become normal again.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" set "+Target.getName()+"back to base settings!");
    }
}
