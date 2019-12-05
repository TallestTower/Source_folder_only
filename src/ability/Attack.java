package ability;
import characters.*;


public class Attack extends ability
{
    public Attack()
    {
        super("NotYetDecided",0);
    }

    public void applyAbility(Role Caster, Role Target)
    {
        Target.takeDamage(Caster.getCurrentAttack());
    }

    public String toString()
    {
        return("Attack allows the current character to deal damage to an enemy, lessened by their armor.");
    }

    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" dealt "+Math.max(0,Caster.getCurrentAttack() - Target.getCurrentArmor())+" damage to "+Target.getName());
    }

}
