package ability;

import characters.Role;

public class Brittle extends ability
{
    public Brittle()
    {
        super("dunno",3);
    }

    public void applyAbility(Role Caster, Role Target)
    {
        Target.takeDamage(Caster.getCurrentAttack()/2);
        Target.debuffCurrentAttack(Caster.getLevel()/4);
    }

    public String toString()
    {
        return("Attack all allows the current character to deal damage to a single target, lowering their attack.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" dealt "+Math.max(0,Caster.getCurrentAttack() - Target.getCurrentArmor())+" damage to "+Target.getName()+". Their attack is reduced by "+Caster.getLevel()/4);
    }
}
