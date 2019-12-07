package characters;

import ability.*;

import java.util.ArrayList;

public class Mage extends Role
{
    public Mage(String name_, String classPlaceHolder_, int currentLevel_, int maxHealth_, int baseAttack_, int baseArmor_, int baseInit_)
    {
        super(name_,"Mage",currentLevel_,maxHealth_,baseAttack_,baseArmor_,baseInit_, 100 * currentLevel_);
    }

    public Mage(String name_, int currentLevel_)
    {
        this(name_, "Mage", currentLevel_, 60 +  6 * currentLevel_,
                12 + currentLevel_*5, currentLevel_ / 5, 10 + currentLevel_*2 );
    }

    public Mage()
    {
        this("Tim The Enchanter","Mage",10,120,62,2,30);
    }

    public String getIcon(){ return "/images/role_icons/mage.png";}

    public ArrayList<Ability> getAbilities(){
        return this.abilities;
    }

    public void setAbilities(){
        this.abilities.add(new Attack());
        this.abilities.add(new AttackAll());
        this.abilities.add(new Slag());
        this.abilities.add(new Brittle());
    }
    //Ecters
    @Override
    public void hpUp()
    {
        healHealth(6);
    }

    @Override
    public void attackUp()
    {
        buffAttack(5);
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
        buffInitiative(2);
    }
}
