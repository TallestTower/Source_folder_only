package ability;

import characters.Role;

public class Brittle extends Ability
{
    public Brittle()
    {
        super("/images/ability_icons/DeBuffAttackIcon.png",3);
    }

    public void applyAbility(Role Caster, Role Target)
    {
        Target.takeDamage(Caster.getCurrentAttack()/2);
        Target.debuffCurrentAttack(Caster.getLevel()/4);
    }

    public String toString()
    {
        return("\tBrittle allows the current character to weaken the" +
                " \n\tweapons a single target, lowering their attack.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" dealt "+Math.max(0,Caster.getCurrentAttack() - Target.getCurrentArmor())+" damage to "+Target.getName()+". Their attack is reduced by "+Caster.getLevel()/4);
    }
}
