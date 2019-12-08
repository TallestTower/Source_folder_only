package ability;

import characters.Role;

import java.util.ArrayList;

public class Guard extends Ability
{
    public Guard()
    {
        super("/images/ability_icons/BuffArmorIcon.png",2);
    }

    public void applyAbility(){}
    public void applyAbility(Role caster, ArrayList<Role> targets){}
    public void applyAbility(Role Caster, Role Target)
    {
        Target.buffArmor(Caster.getCurrentAttack()/4);
    }

    public String toString()
    {
        return("\tBuff armor increases the target's armor," +
                " \n\treducing the damage they take from attacks.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" increased "+Target.getName()+"'s armor by "+Caster.getCurrentAttack()/4+". "+Target.getName()+"'s armor is now "+Target.getCurrentArmor());
    }
}
