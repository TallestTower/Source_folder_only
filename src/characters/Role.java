package characters;

public abstract class Role {
    private int currentHealth, maxHealth, currentLevel, baseAttack, currentAttack, baseArmor, currentArmor, baseInitiative, currentInitiative, currentEXP, maxEXP;
    private String name, classPlaceHolder;
    public Role(String name_, String classPlaceHolder_, int currentLevel_, int maxHealth_, int baseAttack_, int baseArmor_, int baseInit_, int maxEXP_)
    {
        this.name = name_;
        this.classPlaceHolder = classPlaceHolder_;
        this.currentLevel = currentLevel_;
        this.maxHealth = maxHealth_;
        this.currentHealth = maxHealth_;
        this.baseAttack = baseAttack_;
        this.currentAttack = baseAttack_;
        this.baseArmor = baseArmor_;
        this.currentArmor = baseArmor_;
        this.baseInitiative = baseInit_;
        this.currentInitiative= baseInit_;
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

    public int getBaseArmor() {return this.baseArmor;}

    public int getCurrentArmor() {return this.currentArmor;}

    public int getBaseInitiative() {return this.baseInitiative;}

    public int getCurrentInitiative() {return this.currentInitiative;}

    public int getMaxEXP()
    {
        return this.maxEXP;
    }
    
    public int getCurrentEXP()
    {
        return this.currentEXP;
    }

    public abstract String getIcon();

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
    public void setName(String newName)
    {
        this.name = newName;
    }

    public void setCurrentHealth(int newHealth)
    {
        this.currentHealth = newHealth;
    }

    public void setMaxHealth(int newMaxHealth)
    {
        this.maxHealth = newMaxHealth;
    }

    public void setBaseAttack(int newBaseAttack)
    {
        this.baseAttack = newBaseAttack;
    }
    
    public void setCurrentAttack(int newAttack)
    {
        this.currentAttack = newAttack;
    }

    public void setBaseArmor(int newBaseArmor)
    {
        this.baseArmor = newBaseArmor;
    }
    
    public void setCurrentArmor(int newArmor)
    {
        this.currentArmor = newArmor;
    }

    public void setBaseInitiative(int newInitiative)
    {
        this.baseInitiative = newInitiative;
    }

    public void setCurrentInitiative(int newInitiative)
    {
        this.currentInitiative = newInitiative;
    }

    public void buffCurrentInitiatve(int buffInit)
    {
        this.currentInitiative+=buffInit;
    }

    public void debuffCurrentInitiative(int debuffInit)
    {
        this.currentInitiative-=debuffInit;
    }

    public void buffCurrentAttack(int buffAttack)
    {
        this.currentAttack+=buffAttack;
    }

    public void debuffCurrentAttack(int debuffAttack)
    {
        this.currentAttack-=debuffAttack;
    }

    public void buffCurrentArmor(int buffArmor)
    {
        this.currentArmor+=buffArmor;
    }

    public void debuffCurrentArmor(int debuffArmor)
    {
        this.currentArmor-=debuffArmor;
    }

    public void takeDamage(int damageTaken)
    {
        if(damageTaken > currentArmor)
            this.currentHealth -= damageTaken-currentArmor;
        if(currentHealth<0)
        {
            currentHealth = 0;
        }
    }

    //Ecters
    public void levelUp()
    {
        this.currentLevel++;
        hpUp();
        attackUp();
        armorUp();
        initUp();
    }
    public void healHealth(int healthChange)
    {
        if(healthChange + getCurrentHealth() > getMaxHealth())
        {
            setCurrentHealth(getMaxHealth());
        }
        else if(healthChange + getCurrentHealth() < 0)
        {
            setCurrentHealth(1);
        }
        else{
            setCurrentHealth(healthChange + getCurrentHealth());
        }
    }
    public void buffArmor(int armorChange)
    {
        if(armorChange + getCurrentArmor() < getBaseArmor())
        {
            setCurrentArmor(getBaseArmor());
        }
        else{
            setCurrentArmor(armorChange + getCurrentArmor());
        }
    }
    public void buffAttack(int attackChange)
    {
        if(attackChange + getCurrentAttack() < getBaseAttack()){
            setCurrentAttack(getBaseAttack());
        }
        else{
            setCurrentAttack(attackChange + getCurrentAttack());
        }
    }
    public void buffInitiative(int initiativeChange)
    {
        if(initiativeChange + getCurrentInitiative() < getBaseInitiative())
        {
            setCurrentInitiative(getBaseInitiative());
        }
        else{ setCurrentInitiative(initiativeChange + getCurrentInitiative()); }
    }
    public void buffExp(int expChange)
    {
        if(expChange + getCurrentEXP() > 100 * getLevel())
        {
            levelUp();
            this.currentEXP = getCurrentEXP() - 100 * getLevel();
        }
        else
        {
            this.currentEXP += expChange;
        }
    }
    public void hpUp()
    {
        healHealth(10);
    }

    public void attackUp()
    {
        buffAttack(1);
    }

    public void armorUp()
    {
        buffArmor(currentLevel/10);
    }

    public void initUp()
    {
        buffInitiative(1);
    }

    public String toString()
    {
        return "Name: " + getName() + "\nClass: " + getClassType() + "\nLevel: " + getLevel()
                + "\nCurrent Attack: " + getCurrentAttack() + "\nCurrent Health: " + getCurrentHealth()
                + "\nMax Health: "+getMaxHealth();
    }
}