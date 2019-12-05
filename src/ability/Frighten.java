package ability;

import characters.Role;

public class Frighten extends ability
{
    public Frighten()
    {
        super("Dunno",3);
    }

    public void applyAbility(Role Caster, Role Target)
    {
        Target.debuffCurrentInitiative(Caster.getBaseAttack()/2);
    }

    public String toString()
    {
        return("Frightening the enemy makes them more hesitant to attack, lessening their initiative");
    }
    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" decreased "+Target.getName()+"'s initiative by "+Caster.getCurrentAttack()/2+". "+Target.getName()+"'s initiative is now "+Target.getCurrentInitiative());
    }
}