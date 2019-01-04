package com.yyx.springboot.invoke;

import com.yyx.springboot.entity.po.UserPo;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.*;

/**
 * @Description: 反射学习
 * @Auther: yinyuxin
 * @Date: 2018/11/13 16:21
 */
@Slf4j
public class InvokeStudy {


    public static void baseMethods() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //获取class对象的三种方法
        log.info("根据类名:"+UserPo.class);
        /*log.info("根据类的实例:"+ new UserPo().getClass());*/
        log.info("根据全限定类名:"+Class.forName("com.yyx.springboot.entity.po.UserPo"));

        log.info("======================================");
        //常用的方法
        Class<UserPo> userPoClass = UserPo.class;
        log.info("获取全限定类名:"+userPoClass.getName());
        log.info("获取类的名字:"+userPoClass.getSimpleName());
        log.info("实例化该类:"+userPoClass.newInstance());
    }

    public static void constructorsMethods(){
        Class<UserPo> userPoClass = UserPo.class;
        //获取所有的构造函数
        Constructor<?>[] constructors = userPoClass.getDeclaredConstructors();
        //取消安全性检查，这样才能对private修饰符的构造器进行查看和调用
        Constructor.setAccessible(constructors,true);
        for (int i=0;i<constructors.length;i++){
            Class<?>[] parameterTypes = constructors[i].getParameterTypes();
            System.out.print("第"+i+"个构造函数，参数:(");
            for (int j=0;j<parameterTypes.length;j++){
                System.out.print(parameterTypes[j].getName()+" ");
            }
            System.out.print(")");
            System.out.println();
        }
        try {
            log.info("调用有参构造方法实例化:"+constructors[0].newInstance(1,"invoke",25));
            log.info("调用无参构造方法实例化:"+constructors[1].newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void fieldInvoke() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<UserPo> userPoClass = UserPo.class;
        Constructor<UserPo> declaredConstructor = userPoClass.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        UserPo userPo=declaredConstructor.newInstance(null);
        //获取所有的字段
        Field[] declaredFields = userPoClass.getDeclaredFields();
        Field.setAccessible(declaredFields,true);
        for (int i=0;i<declaredFields.length;i++){
            System.out.println("第一个参数:"+declaredFields[i].getName()+declaredFields[i].getType()+declaredFields[i].get(userPo));
        }
        //修改对象属性
    }

    public static void methodInvoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<UserPo> userPoClass = UserPo.class;
        Method[] declaredMethods = userPoClass.getDeclaredMethods();
        Method.setAccessible(declaredMethods,true);
        for (Method method:declaredMethods){
            System.out.print(method.getName()+":"+method.getReturnType());
            Parameter[] parameters = method.getParameters();
            System.out.print("-->参数：");
            for (Parameter parameter:parameters){
                System.out.print(parameter.getName()+parameter.getType()+"&");
            }
            System.out.println();
        }
        Method privateMethod = userPoClass.getDeclaredMethod("privateMethod", String.class);
        privateMethod.setAccessible(true);
        Object haha = privateMethod.invoke(userPoClass.newInstance(),"这是method测试");
        System.out.println(haha.toString());
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        methodInvoke();
    }

}
