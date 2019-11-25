package characters;

public class Persona {
    private int currentHealth, maxHealth, currentLevel, baseAttack, currentAttack, currentEXP, maxEXP;
    private String name, classPlaceHolder;
    public Persona(String name_, String classPlaceHolder_, int currentLevel_, int maxHealth_, int baseAttack_, int maxEXP_)
    {
        this.name = name_;
        this.classPlaceHolder = classPlaceHolder_;
        this.currentLevel = currentLevel_;
        this.maxHealth = maxHealth_;
        this.currentHealth = this.maxHealth;
        this.baseAttack = baseAttack_;
        this.currentAttack = this.baseAttack;
        this.currentEXP = 0;
        this.maxEXP = maxEXP_;
    }

    public Persona(String name_, int currentLevel_)
    {
        this(name_, "Cardboard Cutout", currentLevel_, 100 + (10*currentLevel_),
                5 + currentLevel_, 100 * currentLevel_);
    }

    public Persona()
    {
        this("Generic Git", "Cardboard Cutout", 1, 110,
                6, 100 );
    }

    //TODO sort methods by getters, setters, and modifiers
    public String getName()
    {
        return this.name;
    }

    public void setName(String nameChange)
    {
        this.name = nameChange;
    }
    public String getClassType()
    {
        return this.classPlaceHolder;
    }

    public int getLevel()
    {
        return this.currentLevel;
    }

    public void levelUp()
    {
        setCurrentEXP(this.currentEXP - (this.currentLevel*100));
        this.currentLevel++;
    }

    public int getCurrentHealth()
    {
        return this.currentHealth;
    }

    public int getMaxHealth()
    {
        return this.maxHealth;
    }

    public void setMaxHealth(int maxHealthChanger)
    {
        this.maxHealth = maxHealthChanger;
    }

    public int getBaseAttack(){return this.baseAttack;}

    public void setBaseAttack(int baseAttackChanger){this.baseAttack = baseAttackChanger;}

    public int getCurrentAttack()
    {
        return this.currentAttack;
    }

    public void setCurrentAttack(int currentAttackChanger)
    {
        this.currentAttack = currentAttackChanger;
    }

    public int getCurrentEXP()
    {
        return this.currentEXP;
    }

    public void setCurrentEXP(int EXPchanger){ this.currentEXP = EXPchanger; }

    public String[] getStatsList(){
        String[] tempList = new String[6];
        tempList[0] = "Name: " + getName();
        tempList[1] = "Class: " + getClassType();
        tempList[2] = "Level: " + getLevel();
        tempList[3] = "Current Attack: " + getCurrentAttack();
        tempList[4] = "Current Health: " + getCurrentHealth();
        tempList[5] = "Max Health: "+getMaxHealth();
        return tempList;
    }
    public String toString()
    {
        return "Name: " + getName() + "\nClass: " + getClassType() + "\nLevel: " + getLevel()
                + "\nCurrent Attack: " + getCurrentAttack() + "\nCurrent Health: " + getCurrentHealth()
                + "\nMax Health: "+getMaxHealth();
    }
}