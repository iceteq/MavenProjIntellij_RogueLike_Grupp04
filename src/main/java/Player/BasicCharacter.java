package Player;

import equipment.Weapon;
import quest.Quest;
import quest.QuestLog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BasicCharacter implements Character {

    public static final double INITIAL_BASICCHARACTER_DAMAGE = 5;
    public static final double INITIAL_BASICCHARACTER_DEFENSE = 0;
    public static final int BASICCHARACTER_MAXHEALTH_INCREASE_PER_LEVEL = 5;
    public static final int BASICCHARACTER_BASE_HEALTH = 300;

    public static final int INITIAL_LEVEL = 1;

    public static final String THREE_CONSONANTS_IN_A_ROW = "[b-df-hj-np-tv-z]{3}";
    public static final String THREE_VOWELS_IN_A_ROW = "[AEIOUaeiou]{3}";
    public static final String AT_LEAST_ONE_CONSONANT = "[b-df-hj-np-tv-z]{1}";
    public static final String AT_LEAST_ONE_VOWEL = "[AEIOUaeiou]{1}";
    public static final String FIRST_LETTER_LOWER_CASE = "^[a-z].*";

    QuestLog questLog;
    Weapon weapon;
    String className;
    boolean NPC;
    double damage;
    int maxHealth;
    double defense;
    int level;
    String name;

    // kan jag komma åt inventory TEST här


    public BasicCharacter() {

        this.maxHealth = BASICCHARACTER_BASE_HEALTH + BASICCHARACTER_MAXHEALTH_INCREASE_PER_LEVEL;
        this.questLog = new QuestLog();
        this.damage = 100.0;

        if (this instanceof NPC)
            this.NPC = true;

        this.className = this.getClass().toString();

        this.damage = INITIAL_BASICCHARACTER_DAMAGE;
        this.defense = INITIAL_BASICCHARACTER_DEFENSE;
        this.level = INITIAL_LEVEL;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        // checks what rules name breaks
        if (name == null){
            throw new NullPointerException("name can't be null");
        }
        if (name == ""){
            System.out.println("Error: please choose a name");
            return;
        }
        if  (matchesPattern(THREE_CONSONANTS_IN_A_ROW, name)){
            System.err.println("Error: 3 consonants in a row");
            return;
        }
        if (matchesPattern(THREE_VOWELS_IN_A_ROW, name)) {
            System.err.println("Error: 3 vowels in a row");
            return;
        }
        if (!matchesPattern(AT_LEAST_ONE_CONSONANT, name)) {
            System.err.println("Error: no consonant");
            return;
        }
        if (!matchesPattern(AT_LEAST_ONE_VOWEL, name)){
            System.err.println("Error: no vowel");
            return;
        }
        if (matchesPattern(FIRST_LETTER_LOWER_CASE, name)){
            System.err.println("Error: must have capital letter");
            return;
        }

        if (name.length() > 1 && name.length() < 11)
            this.name = name;
    }


    boolean matchesPattern(String pattern, String target){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(target);
        return m.find();
    }
    @Override
    public int getMaxHealth() {
        return this.maxHealth;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.damage = INITIAL_BASICCHARACTER_DAMAGE + weapon.getWeaponDamage();
    }


    @Override
    public Weapon getWeapon() {
        return this.weapon;
    }

    @Override
    public void setMaxHealth(int i) {
        this.maxHealth = i;
    }

    @Override
    public void setDamage(double newDamage) {
        this.damage = newDamage;
    }

    @Override
    public QuestLog getQuestLog() {
        return questLog;
    }

    @Override
    public void addQuestToNPC(Quest quest) {
        this.questLog.addQuestToNPC(quest);
    }

    @Override
    public void completeQuest(Quest completedQuest) {
        this.questLog.addCompletedQuest(completedQuest, this);
    }

    @Override
    public void removeCompletedQuest(Quest quest) {
        this.questLog.removeCompletedQuestFromPlayer(quest, this);
    }

    @Override
    public void acceptQuest(Quest questToAccept) {
        this.questLog.addToAcceptedQuests(questToAccept, this);
    }

    @Override
    public Quest getNPCQuest(Quest quest) {
        return this.questLog.getNPCQuest(quest, this);
    }

    @Override
    public String getTypeOfCharacter() {
        return this.className;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void setLevelAndOtherStats(int level) {
        this.setLevel(level);
        setMaxHealthWithRegardToLevel();
    }

    @Override
    public void setMaxHealthWithRegardToLevel() {
        this.setMaxHealth(BASICCHARACTER_BASE_HEALTH + (this.getLevel() * BASICCHARACTER_MAXHEALTH_INCREASE_PER_LEVEL));
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public boolean isNPC() {
        return NPC;
    }

}
