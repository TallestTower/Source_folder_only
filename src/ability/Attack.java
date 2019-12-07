package ability;
import characters.*;


public class Attack extends Ability
{
    public Attack()
    {
        super("/images/ability_icons/AttackIcon.png",0);
    }

    public void applyAbility(Role Caster, Role Target)
    {
        Target.takeDamage(Caster.getCurrentAttack());
    }

    public String toString()
    {
        return("\tAttack allows the current character to deal damage to an enemy," +
                " \n\tlessened by their armor.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" dealt "+Math.max(0,Caster.getCurrentAttack() - Target.getCurrentArmor())+" damage to "+Target.getName());
    }

}
