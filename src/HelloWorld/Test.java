package HelloWorld;

public class Test {
    // static修饰的属性和方法不属于任何一个对象，属于类【所有对象共享的】，直接可以进行调用 like：System.out.println(Test.id)
    //
    private Integer id;
    private String name;

    public void setId(Integer id) {
        this.id = id; // this指的是当前对象，若Static方法中则不可以使用【因为Static指的是类而不是对象】【静态访问静态】
    }

    public void setName(String name) {
        this.name = name;
    }

    public Test(Integer id, String name){
        super(); // this()和super()不能共存
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
