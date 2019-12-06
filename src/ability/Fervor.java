package ability;

import characters.Role;

public class Fervor extends ability
{
    public Fervor()
    {
        super("Dunno",1);
    }

    public void applyAbility(Role Caster, Role Target)
    {
        Target.buffCurrentAttack(5+Caster.getLevel());
    }

    public String toString()
    {
        return("Fervor inspires the target to attack with more zeal, influenced by the cleric's level.");
    }
    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" increased "+Target.getName()+"'s attack by "+(5+Caster.getLevel())+". "+Target.getName()+"'s current attack is now "+Target.getCurrentAttack());
    }
}
