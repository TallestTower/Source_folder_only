package ability;

import characters.Role;

import java.util.ArrayList;

public class AttackAll extends Ability
{
    public AttackAll()
    {
        super("/images/ability_icons/MultiAttackIcon.png",1);
    }

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

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" dealt up to "+Caster.getCurrentAttack()+ " damage to the enemy team.");
    }
}
