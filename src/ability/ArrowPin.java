package ability;

import characters.Role;

public class ArrowPin extends ability
{
    public ArrowPin()
    {
        super("dunno",3);
    }

    public void applyAbility(Role Caster, Role Target)
    {
        Target.takeDamage(Caster.getCurrentAttack()/2);
        Target.debuffCurrentInitiative(Caster.getLevel()/2);
    }

    public String toString()
    {
        return("Attack all allows the current character to deal damage to a single target, lowering their initiative.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" dealt "+Math.max(0,Caster.getCurrentAttack() - Target.getCurrentArmor())+" damage to "+Target.getName()+". Their initative is reduced by "+Caster.getLevel()/2);
    }
}
