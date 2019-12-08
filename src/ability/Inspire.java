package ability;

import characters.Role;

import java.util.ArrayList;

public class Inspire extends Ability
{
    public Inspire()
    {
        super("/images/ability_icons/BuffInitiativeIcon.png",1);
    }

    public void applyAbility(){}
    public void applyAbility(Role caster, Role target){}
    public void applyAbility(Role Caster, ArrayList<Role> Target)
    {
        for(Role targets : Target)
        {
            targets.buffInitiative(Caster.getCurrentAttack()/4);
        }
    }

    public String toString() {
        return ("\tInspire increases the entire team's speed by a small amount," +
                " \n\tensuring that their ability to act comes sooner in a round.");
    }

    public String whatHappened(Role Caster)
    {
        return(Caster.getName()+" increased the entire team's initiative by "+Caster.getCurrentAttack()/4);
    }
}
