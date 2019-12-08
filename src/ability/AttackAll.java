package ability;

import characters.Role;

import java.util.ArrayList;

public class AttackAll extends Ability
{
    public AttackAll()
    {
        super("/images/ability_icons/MultiAttackIcon.png",1);
    }

    public void applyAbility(){}
    public void applyAbility(Role caster, Role target){}
    public void applyAbility(Role Caster, ArrayList<Role> Target)
    {
        for(Role targets : Target)
        {
            targets.takeDamage(Caster.getCurrentAttack()/2);
        }
    }

    public String toString()
    {
        return("\tAttack all allows the current character to deal damage" +
                " \n\tto the entire enemy team, lessened by their armor.");
    }

    public String whatHappened(Role Caster)
    {
        return(Caster.getName()+" dealt up to "+Caster.getCurrentAttack()/2+ " damage to the enemy team.");
    }
}
