package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * Author: Inga Mbobo, 230711723
 * Date: March 2026
 */
@Entity
//@Table(name = "skill")
public class Skill {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    protected String skillId;
    private String name;
    private String category;
    private int yearsOfExperience;

    protected Skill() {
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

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Float.compare(getYearsOfExperience(), skill.getYearsOfExperience()) == 0 &&
                Objects.equals(getSkillId(), skill.getSkillId()) &&
                Objects.equals(getName(), skill.getName()) &&
                Objects.equals(getCategory(), skill.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkillId(),
                getName(),
                getCategory(),
                getYearsOfExperience());
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
        protected String skillId;
        private String name;
        private String category;
        private int yearsOfExperience;

        public Builder setSkillId(String skillId) {
            this.skillId = skillId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCategory(String category) {
            this.category = category;
            return  this;
        }

        public Builder setYearsOfExperience(int yearsOfExperience) {
            this.yearsOfExperience = yearsOfExperience;
            return this;
        }

        public Builder copy(Skill skill) {
            this.skillId = skill.skillId;
            this.name = skill.name;
            this.category = skill.category;
            this.yearsOfExperience = skill.yearsOfExperience;
            return this;
        }

        public Skill build() {
            return new Skill(this);
        }
    }
}