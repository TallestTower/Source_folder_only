package characters;

import ability.*;

import java.util.ArrayList;

public class Cleric extends Role {
    public Cleric(String name_, String classPlaceHolder_, int currentLevel_, int maxHealth_, int baseAttack_, int baseArmor_, int baseInit_)
    {
        super(name_,"Cleric",currentLevel_,maxHealth_,baseAttack_,baseArmor_,baseInit_, 100*currentLevel_);
    }

    public Cleric(String name_, int currentLevel_)
    {
        this(name_, "Cleric", currentLevel_, 70 +  7 * currentLevel_,
                7 + currentLevel_*2, 1 + currentLevel_/10, 11 + currentLevel_);
    }

    public Cleric()
    {
        this("Jesus Christ","Cleric",10,200,20,3,20);
    }

    public String getIcon(){ return "/images/role_icons/cleric.png"; }

    public ArrayList<Ability> getAbilities(){
        return this.abilities;
    }

    public void setAbilities(){
        this.abilities.add(new Attack());
        this.abilities.add(new Fervor());
        this.abilities.add(new Heal());
        this.abilities.add(new Cleanse());
    }

    //Ecters
    @Override
    public void hpUp()
    {
        healHealth(8);
    }

    @Override
    public void attackUp()
    {
        buffAttack(1);
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
        buffInitiative(1);
    }

}

