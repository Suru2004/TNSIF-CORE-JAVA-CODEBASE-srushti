package EncapsulationDemo;

// Class to hold the data
class OopsConcept {
    private int serailNum;
    private String name;
    private int age;

    // Getters and setters
    public int getSerailNum() {
        return serailNum;
    }

    public void setSerailNum(int serailNum) {
        this.serailNum = serailNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString method
    @Override
    public String toString() {
        return "OopsConcept [serailNum=" + serailNum + ", name=" + name + ", age=" + age + "]";
    }
}
