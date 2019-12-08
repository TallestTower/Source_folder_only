package ability;

import characters.Role;

import java.util.ArrayList;

public class Slag extends Ability
{
    public Slag()
    {
        super("/images/ability_icons/DeBuffArmorIcon.png",2);
    }

    public void applyAbility(){}
    public void applyAbility(Role caster, ArrayList<Role> targets){}
    public void applyAbility(Role Caster, Role Target)
    {
        Target.takeDamage(Caster.getCurrentAttack()/2);
        Target.debuffCurrentArmor(Caster.getLevel()/2);
    }

    public String toString()
    {
        return("\tSlag allows the current character to deal damage to a single target, " +
                "\n\tlowering their armor.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" dealt "+Math.max(0,Caster.getCurrentAttack() -
                Target.getCurrentArmor())+" damage to "+Target.getName() +
                ". \nTheir armor is reduced by "+Caster.getLevel()/2);
    }
}
