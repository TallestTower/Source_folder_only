package ability;

import characters.Role;

public class ArrowPin extends Ability
{
    public ArrowPin()
    {
        super("/images/ability_icons/DeBuffAttackIcon.png",3);
    }

    public void applyAbility(Role Caster, Role Target)
    {
        Target.takeDamage(Caster.getCurrentAttack()/2);
        Target.debuffCurrentInitiative(Caster.getLevel()/2);
    }

    public String toString()
    {
        return("ArrowPin allows the current character to deal precise" +
                " \ndamage to a single target, lowering their initiative.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" dealt "+Math.max(0,Caster.getCurrentAttack() - Target.getCurrentArmor())+" damage to "+Target.getName()+". Their initative is reduced by "+Caster.getLevel()/2);
    }
}
