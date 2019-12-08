package characters;

import ability.*;

import java.util.ArrayList;

public class Warrior extends Role {

    public Warrior(String name_, String classPlaceHolder_, int currentLevel_, int maxHealth_, int baseAttack_, int baseArmor_, int baseInit_)
    {
        super(name_,"Warrior",currentLevel_,maxHealth_,baseAttack_,baseArmor_,baseInit_, 100 * currentLevel_);
        this.roleImage = "/images/role_icons/warrior.png";
    }

    public Warrior(String name_, int currentLevel_)
    {
        this(name_, "Warrior", currentLevel_, 70 + 7 * currentLevel_,
                7 + currentLevel_ * 2, 1 + currentLevel_ / 10 , 10 + currentLevel_);
    }

    public Warrior()
    {
        this("Maximus Meridius","Warrior",10,200,20,3,10);
    }

    public String getIcon(){ return roleImage;}

    public ArrayList<Ability> getAbilities(){
        return this.abilities;
    }

    public void setAbilities(){
        this.abilities.add(new Attack());
        this.abilities.add(new Inspire());
        this.abilities.add(new Guard());
        this.abilities.add(new Frighten());
    }

    //Ecters
    @Override
    public void hpUp()
    {
        healHealth(10);
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
        buffInitiative(0);
    }
}
