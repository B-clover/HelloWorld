package HelloWorld;

public class Test {
    private Integer id;
    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Test(){
        this(1, "123"); //默认的构造方法
    }
    public void test(){
        System.out.println(123);
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                '}';
    }
}
