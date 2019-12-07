package ability;

import characters.Role;

public class BattlefieldMedicine extends Ability
{
    public BattlefieldMedicine()
    {
        super("/images/ability_icons/HealIcon.png",2);
    }

    public void applyAbility(Role Caster, Role Target)
    {
        Target.healHealth((Caster.getCurrentAttack()/4)+(2*Caster.getLevel()));
    }

    public String toString()
    {
        return("\tDo you have booboos and ouchies? No magic here," +
                " \n\tjust bandages and medicine.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" restored "+Target.getName()+"'s health by "+(Caster.getCurrentAttack()/4)+(2*Caster.getLevel())+". "+Target.getName()+"'s health is now "+Target.getCurrentHealth());
    }
}
