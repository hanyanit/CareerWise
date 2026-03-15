package Domain;

import java.util.Objects;

public class Skill {
    private String skillId;
    private String name;
    private String category;
    private float yearsOfExperience;

    public Skill() {
    }

    private Skill(Builder builder){
        this.skillId = builder.skillId;
        this.name = builder.name;
        this.category = builder.category;
        this.yearsOfExperience = builder.yearsOfExperience;
    }

    public String getSkillId() {
        return skillId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Float.compare(getYearsOfExperience(), skill.getYearsOfExperience()) == 0 && Objects.equals(getSkillId(), skill.getSkillId()) && Objects.equals(getName(), skill.getName()) && Objects.equals(getCategory(), skill.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkillId(), getName(), getCategory(), getYearsOfExperience());
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillId='" + skillId + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }

    public static class Builder {
        private String skillId;
        private String name;
        private String category;
        private float yearsOfExperience;

        public Builder skillId(String skillId) {
            this.skillId = skillId;
            return this;
        }
        public Builder skillName(String skillName) {
            this.name = skillName;
            return this;
        }

        public Builder skillCategory(String skillCategory) {
            this.category = skillCategory;
            return this;
        }

        public Builder yearsOfExperience(float yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
            return this;
        }

        public Builder copy(Skill skill) {
            this.skillId = skill.getSkillId();
            this.name = skill.getName();
            this.category = skill.getCategory();
            this.yearsOfExperience = skill.getYearsOfExperience();
            return this;
        }

        public Skill build() {
            return new Skill(this);
        }
    }

}
