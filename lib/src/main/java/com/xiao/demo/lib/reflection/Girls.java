package com.xiao.demo.lib.reflection;


/**
 * Created by xiao on 2017/8/12.
 */

public class Girls extends Ple implements ReflectInterface {

    private String name;

    public Integer age;

    protected int height;

    private int weight;

    private String birthday;

    public Girls() {
    }

    public Girls( String name,  int age, int height, int weight,  String birthday) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
    }

    public Girls(String country, String name, Integer age, int height, int weight, String birthday) {
        super(country);
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public static void test() {

    }

    public final void ttt() {

    }

    @Override
    public String getCountry() {
        return super.getCountry();
    }

    @Override
    public void setCountry(String country) {
        super.setCountry(country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Girls)) return false;

        Girls girls = (Girls) o;

        if (age != girls.age) return false;
        if (height != girls.height) return false;
        if (weight != girls.weight) return false;
        if (name != null ? !name.equals(girls.name) : girls.name != null) return false;
        return birthday != null ? birthday.equals(girls.birthday) : girls.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + height;
        result = 31 * result + weight;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Girls{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    @Override
    public void reflectVoidMethods() {
        System.out.println("Girls.reflectVoidMethods is called");
    }

    @Override
    public String reflectStringMethods() {
        return "Girls.reflectStringMethods is called";
    }

    class NoModifierInnerClass extends Ple implements ReflectInterface {

        public NoModifierInnerClass() {
        }

        public NoModifierInnerClass(String country) {
            super(country);
        }

        @Override
        public String getCountry() {
            return super.getCountry();
        }

        @Override
        public void setCountry(String country) {
            super.setCountry(country);
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public void reflectVoidMethods() {
            System.out.println("NoModifierInnerClass.reflectVoidMethods is Called");
        }

        @Override
        public String reflectStringMethods() {
            return "NoModifierInnerClass.reflectStringMethods is Called";
        }
    }

    private class NormalInnerClass extends Ple implements ReflectInterface {


        private String bName;

        private int bAge;

        public NormalInnerClass() {
        }

        public NormalInnerClass(String bName, int bAge) {
            this.bName = bName;
            this.bAge = bAge;
        }

        public String getbName() {
            return bName;
        }

        public void setbName(String bName) {
            this.bName = bName;
        }

        public int getbAge() {
            return bAge;
        }

        public void setbAge(int bAge) {
            this.bAge = bAge;
        }

        @Override
        public String toString() {
            return "NormalInnerClass{" +
                    "bName='" + bName + '\'' +
                    ", bAge=" + bAge +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof NormalInnerClass)) return false;

            NormalInnerClass boy = (NormalInnerClass) o;

            if (bAge != boy.bAge) return false;
            return bName != null ? bName.equals(boy.bName) : boy.bName == null;
        }

        @Override
        public int hashCode() {
            int result = bName != null ? bName.hashCode() : 0;
            result = 31 * result + bAge;
            return result;
        }

        @Override
        public void reflectVoidMethods() {
            System.out.println("Girls.NormalInnerClass.reflectVoidMethods is Called");
        }

        @Override
        public String reflectStringMethods() {
            return "Girls.NormalInnerClass.reflectStringMethods is Called";
        }
    }

    public static class StaticInnerClass extends Ple implements ReflectInterface {

        private String innerName = StaticInnerClass.class.getName();

        public StaticInnerClass() {
        }

        public StaticInnerClass(String innerName) {
            this.innerName = innerName;
        }

        public String getInnerName() {
            return innerName;
        }

        public void setInnerName(String innerName) {
            this.innerName = innerName;
        }

        @Override
        public void reflectVoidMethods() {
            System.out.println("Girls.StaticInnerClass.reflectVoidMethods is Called");
        }

        @Override
        public String reflectStringMethods() {
            return "Girls.StaticInnerClass.reflectStringMethods is Called";
        }
    }

    protected class AbstractExtendedClass extends AbstractClass implements ParameterInterface<Integer>, ReflectInterface {

        Integer params;

        @Override
        void abstractMethod() {
            System.out.println("Girls.AbstractExtendedClass.abstractMethod is Called params = " + params);
        }

        @Override
        public void paramVoidMethod(Integer integer) {
            params = integer;
        }

        @Override
        public void paramStringMethod(Integer integer) {
            System.out.println("Girls.AbstractExtendedClass.paramStringMethod.[integer = " + integer);
            params += integer;
        }

        @Override
        public void reflectVoidMethods() {
            System.out.println("Girls.AbstractExtendedClass.reflectVoidMethods params = " + params);
        }

        @Override
        public String reflectStringMethods() {
            return "Girls.AbstractExtendedClass.reflectStringMethods" + params;
        }

        private Integer getParam() {
            return params;
        }
    }

    protected class ParamsExtendedClass extends  ParentClass<String> implements  ParameterInterface<Integer>{

        @Override
        public String getT() {
            return super.getT();
        }

        @Override
        public void setT(String s) {
            super.setT(s);
        }

        @Override
        public void paramVoidMethod(Integer integer) {

        }

        @Override
        public void paramStringMethod(Integer integer) {

        }
    }

}

class Dog {

    private String dogName;

    public Dog() {
    }

    public Dog(String dogName) {
        this.dogName = dogName;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;

        Dog dog = (Dog) o;

        return dogName != null ? dogName.equals(dog.dogName) : dog.dogName == null;
    }

    @Override
    public int hashCode() {
        return dogName != null ? dogName.hashCode() : 0;
    }
}