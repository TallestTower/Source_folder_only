package ability;

import characters.Role;

public class Fervor extends Ability
{
    public Fervor()
    {
        super("/images/ability_icons/BuffInitiativeIcon.png",1);
    }

    public void applyAbility(Role Caster, Role Target)
    {
        Target.buffCurrentAttack(5+Caster.getLevel());
    }

    public String toString()
    {
        return("\tFervor inspires the target to attack with more zeal," +
                " \n\tinfluenced by the cleric's level.");
    }
    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" increased "+Target.getName()+"'s attack by "+(5+Caster.getLevel())+". "+Target.getName()+"'s current attack is now "+Target.getCurrentAttack());
    }
}
