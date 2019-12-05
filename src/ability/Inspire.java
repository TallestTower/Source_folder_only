package ability;

import characters.Role;

import java.util.ArrayList;

public class Inspire extends ability
{
    public Inspire()
    {
        super("Dunno",1);
    }

    public void applyAbility(Role Caster, ArrayList<Role> Target)
    {
        for(Role targets : Target)
        {
            targets.buffInitiative(Caster.getCurrentAttack()/4);
        }
    }

    public String toString() {
        return ("Inspire increases the entire team's speed by a small amount, ensuring that their ability to act comes sooner in a round.");
    }

    public String whatHappened(Role Caster, ArrayList<Role> Target)
    {
        return(Caster.getName()+" increased the entire team's initiative by "+Caster.getCurrentAttack()/4);
    }
}
