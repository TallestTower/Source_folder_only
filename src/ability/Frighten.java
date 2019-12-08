package ability;

import characters.Role;

import java.util.ArrayList;

public class Frighten extends Ability
{
    public Frighten()
    {
        super("/images/ability_icons/DeBuffInitiativeIcon.png",3);
    }

    public void applyAbility(){}
    public void applyAbility(Role caster, ArrayList<Role> targets){}
    public void applyAbility(Role Caster, Role Target)
    {
        Target.debuffCurrentInitiative(Caster.getBaseAttack()/2);
    }

    public String toString()
    {
        return("\tFrightening the enemy makes them more hesitant to attack," +
                " \n\tlessening their initiative");
    }
    public String whatHappened(Role Caster, Role Target)
    {
        return(Caster.getName()+" decreased "+Target.getName()+"'s initiative by "+Caster.getCurrentAttack()/2+". "+Target.getName()+"'s initiative is now "+Target.getCurrentInitiative());
    }
}