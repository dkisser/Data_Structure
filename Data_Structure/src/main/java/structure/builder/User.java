package structure.builder;

/**
 * Created by WenChen on 2019/5/24.
 */
public class User {

    private String name;

    private String favorator;

    private int age;

    private String sex;

    private String phone;

    private String email;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavorator() {
        return favorator;
    }

    public void setFavorator(String favorator) {
        this.favorator = favorator;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", favorator='" + favorator + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class UserBuilder {
        private User instance;

        public UserBuilder(User instance) {
            this.instance = instance;
        }

        public UserBuilder() {
            this.instance = new User();
        }

        public UserBuilder setFavorator (String favorator){
            this.instance.setFavorator(favorator);
            return this;
        }

        public UserBuilder setAge (int age){
            this.instance.setAge(age);
            return this;
        }

        public UserBuilder setSex (String sex){
            this.instance.setSex(sex);
            return this;
        }

        public UserBuilder setPhone (String phoe){
            this.instance.setPhone(phoe);
            return this;
        }

        public UserBuilder setEmail (String email){
            this.instance.setEmail(email);
            return this;
        }

        public UserBuilder setAddress (String address){
            this.instance.setAddress(address);
            return this;
        }

        public User build(){
            return this.instance;
        }
    }

    public static void main (String[] args){
        UserBuilder builder = new UserBuilder();
        User user = builder.setAddress("fsfd")
                            .setAge(11)
                            .setEmail("232223232@ww.cn").build();
        System.out.println(user.toString());
    }
}
