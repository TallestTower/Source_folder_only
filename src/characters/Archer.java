package characters;

import ability.*;

import java.util.ArrayList;

public class Archer extends Role
{
    public Archer(String name_, String classPlaceHolder_, int currentLevel_, int maxHealth_, int baseAttack_, int baseArmor_, int baseInit_)
    {
        super(name_,"Archer",currentLevel_,maxHealth_,baseAttack_,baseArmor_,baseInit_,100*currentLevel_);
    }

    public Archer(String name_, int currentLevel_)
    {
        this(name_, "Archer", currentLevel_, 70 + (7*currentLevel_),
                7 + currentLevel_*2, 1+(currentLevel_/10), 10+(currentLevel_));
    }

    public Archer()
    {
        this("Robin Hood","Archer",10,140,27,2,20);
    }

    public String getIcon(){ return "/images/role_icons/archer.png";}

    public ArrayList<Ability> getAbilities(){
        return this.abilities;
    }

    public void setAbilities(){
        this.abilities.add(new Attack());
        this.abilities.add(new AttackAll());
        this.abilities.add(new BattlefieldMedicine());
        this.abilities.add(new ArrowPin());
    }
    //Ecters
    @Override
    public void hpUp()
    {
        healHealth(7);
    }

    @Override
    public void attackUp()
    {
        buffAttack(2);
    }

    @Override
    public void armorUp()
    {
        if(getLevel() %3 == 0)
        {
            buffArmor(1);
        }
    }

    @Override
    public void initUp()
    {
        buffInitiative(3);
    }
}
