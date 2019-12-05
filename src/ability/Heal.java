package ability;

import characters.Role;

public class Heal extends ability{
    public Heal()
    {
        super("Dunno",2);
    }

    public void applyAbility(Role Caster, Role Target)
    {
        Target.healHealth(Caster.getBaseAttack()/2);
    }

    public String toString()
    {
        return("Do you have booboos and ouchies? This is better than a mother's kiss. Restores some lost HP.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" restored "+Target.getName()+"'s health by "+Caster.getCurrentAttack()/2+". "+Target.getName()+"'s health is now "+Target.getCurrentHealth());
    }
}
