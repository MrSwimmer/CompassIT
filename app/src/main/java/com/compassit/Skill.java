package com.compassit;

/**
 * Created by Севастьян on 03.10.2017.
 */

class Skill {
    private String skill;
    public int count=0;

    public Skill() {
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        this.count++;
    }
}
