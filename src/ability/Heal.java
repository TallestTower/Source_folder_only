package ability;

import characters.Role;

import java.util.ArrayList;

public class Heal extends Ability {
    public Heal()
    {
        super("/images/ability_icons/HealIcon.png",2);
    }

    public void applyAbility(){}
    public void applyAbility(Role caster, ArrayList<Role> targets){}
    public void applyAbility(Role Caster, Role Target)
    {
        Target.healHealth(Caster.getBaseAttack()/2);
    }

    public String toString()
    {
        return("\tDo you have booboos and ouchies?" +
                " \n\tThis is better than a mother's kiss." +
                " \n\tRestores some lost HP.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" restored "+Target.getName()+"'s health by "+Caster.getCurrentAttack()/2+". "+Target.getName()+"'s health is now "+Target.getCurrentHealth());
    }
}
