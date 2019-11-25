package characters;

public class Role {
    private int currentHealth, maxHealth, currentLevel, baseAttack, currentAttack, baseArmor, currentArmor, baseInit, currentInit, currentEXP, maxEXP;
    private String name, classPlaceHolder;
    public Role(String name_, String classPlaceHolder_, int currentLevel_, int maxHealth_, int baseAttack_, int baseArmor_, int baseInit_, int maxEXP_)
    {
        this.name = name_;
        this.classPlaceHolder = classPlaceHolder_;
        this.currentLevel = currentLevel_;
        this.maxHealth = maxHealth_;
        this.currentHealth = this.maxHealth;
        this.baseAttack = baseAttack_;
        this.currentAttack = this.baseAttack;
        this.baseArmor = baseArmor_;
        this.currentArmor = this.baseArmor;
        this.baseInit = baseInit_;
        this.currentInit = this.baseInit;
        this.currentEXP = 0;
        this.maxEXP = maxEXP_;
    }

    public Role(String name_, int currentLevel_)
    {
        this(name_, "Cardboard Cutout", currentLevel_, 100 + (10*currentLevel_),
                5 + currentLevel_, 1+(currentLevel_/10), 10+(currentLevel_),100 * currentLevel_);
    }

    public Role()
    {
        this("Generic Git", "Cardboard Cutout", 1, 110,
                6, 1, 11, 100 );
    }

    //TODO sort methods by getters, setters, and modifiers
    //Getters
    public String getName()
    {
        return this.name;
    }

    public String getClassType()
    {
        return this.classPlaceHolder;
    }

    public int getLevel()
    {
        return this.currentLevel;
    }

    public int getCurrentHealth()
    {
        return this.currentHealth;
    }

    public int getMaxHealth()
    {
        return this.maxHealth;
    }

    public int getBaseAttack(){return this.baseAttack;}

    public int getCurrentAttack()
    {
        return this.currentAttack;
    }

    public int getbaseArmor() {return this.baseArmor;}

    public int getCurrentArmor() {return this.currentArmor;}

    public int getBaseInit() {return this.baseInit;}

    public int getCurrentInit() {return this.currentInit;}

    public int getCurrentEXP()
    {
        return this.currentEXP;
    }

    public String[] getStatsList() {
        String[] tempList = new String[6];
        tempList[0] = "Name: " + getName();
        tempList[1] = "Class: " + getClassType();
        tempList[2] = "Level: " + getLevel();
        tempList[3] = "Current Attack: " + getCurrentAttack();
        tempList[4] = "Current Health: " + getCurrentHealth();
        tempList[5] = "Max Health: " + getMaxHealth();
        return tempList;
    }

    //Setters
    public void setName(String nameChange)
    {
        this.name = nameChange;
    }

    public void setCurrentHealth(int currentHealthChanger)
    {
        this.currentHealth+=currentHealthChanger;
        if(this.currentHealth>this.maxHealth)
        {
            this.currentHealth=this.maxHealth;
        }
    }

    public void setMaxHealth(int maxHealthChanger)
    {
        this.maxHealth += maxHealthChanger;
    }

    public void setBaseAttack(int baseAttackChanger){this.baseAttack += baseAttackChanger;}

    public void setCurrentAttack(int currentAttackChanger)
    {
        this.currentAttack = currentAttackChanger;
    }

    public void setBaseArmor(int baseArmorChanger)
    {
        this.baseArmor+=baseArmorChanger;
    }

    public void setInit(int initChanger)
    {
        this.baseInit+=initChanger;
    }

    //Ecters
    public void levelUp()
    {
        if(this.currentEXP >= 100*this.currentLevel)
        {
            this.currentEXP-=(100*this.currentLevel);
            this.currentLevel++;
            hpUp();
            attackUp();
            armorUp();
            initUp();
        }
    }

    public void hpUp()
    {
        setMaxHealth(10);
    }

    public void attackUp()
    {
        setBaseAttack(1);
    }

    public void armorUp()
    {
        setBaseArmor(1/currentLevel);
    }

    public void initUp()
    {
        setInit(1);
    }

    public String toString()
    {
        return "Name: " + getName() + "\nClass: " + getClassType() + "\nLevel: " + getLevel()
                + "\nCurrent Attack: " + getCurrentAttack() + "\nCurrent Health: " + getCurrentHealth()
                + "\nMax Health: "+getMaxHealth();
    }
}