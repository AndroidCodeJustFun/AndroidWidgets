package com.xiao.demo.lib.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * Created by xiao on 2017/8/12.
 * TODO  动态代理模式 修改方法返回值
 */

public class ReflectUtil {


    public static void main(String[] args) {

        try {
            Class<?> clz = Class.forName(Girls.class.getName());
            Girls girl = (Girls) clz.newInstance();

            System.out.println("  print   init class   ");
            analysis(clz);
            initClass(girl, clz);
            initClass2(girl, clz);
//            Class<?> declaringClass = clz.getDeclaringClass();
//            System.out.println(" clz.getDeclaringClass() = " + declaringClass);
//            Class<?> enclosingClass = clz.getEnclosingClass();
//            System.out.println(" clz.getEnclosingClass() = " + enclosingClass);

            Class<?>[] declaredClasses = clz.getDeclaredClasses();
            if (declaredClasses != null) {
                if (declaredClasses.length > 0) {
                    for (Class<?> declaredClass : declaredClasses) {
                        analysis(declaredClass);
                        initClass(girl, declaredClass);
                        initClass2(girl, declaredClass);
                    }
                } else System.out.println("clz.getDeclaredClasses() is empty");
            } else {
                System.out.println(" clz.getDeclaredClasses() is null");
            }

//            Class<? extends Class> aClass = clz.getClass();
//            if (aClass != null) {
//
//            } else System.out.println(" clz.getClass() is null");
//
//            Class<?>[] classes = clz.getClasses();
//            if (classes != null && classes.length > 0) {
//                for (Class<?> aClass1 : classes) {
//                    System.out.println(" clz.getClasses() = " + aClass1);
//                }
//            } else {
//                if (classes == null) {
//                    System.out.println("clz.getClasses() is null[args]");
//                } else {
//                    System.out.println("clz.getClasses() is empty ");
//                }
//            }


//            System.out.println("  ****************   print declaredClass  ");
////
//            StringBuffer sb1 = new StringBuffer();
//            Class<?>[] declaredClasses = clz.getDeclaredClasses();
//            if (declaredClasses != null && declaredClasses.length > 0) {
//                for (Class<?> declaredClass : declaredClasses) {
//                    System.out.print("main.[args] " + declaredClass);
//                    Constructor<?>[] constructors1 = declaredClass.getConstructors();
//                    System.out.print("  declaredClass.getConstructors()  " + jointContructors(constructors1));
//                    Constructor<?>[] declaredConstructors = declaredClass.getDeclaredConstructors();
//                    System.out.print(" declaredClass.getDeclaredConstructors()  =  " + jointContructors(declaredConstructors));
//                    Method[] methods1 = declaredClass.getMethods();
//                    System.out.print("  declaredClass.getMethods()  =  " + jointMethods(methods1));
//                    Method[] declaredMethods = declaredClass.getDeclaredMethods();
//                    System.out.print("  declaredClass.getDeclaredMethods() = " + jointMethods(declaredMethods));
//                    Field[] fields1 = declaredClass.getFields();
//                    System.out.print(" declaredClass.getFields() = " + jointFileds(fields1));
//                    Field[] declaredFields = declaredClass.getDeclaredFields();
//                    System.out.print(" declaredClass.getDeclaredFields() = " + jointFileds(declaredFields) + " \n");
//                }
//            } else System.out.println("main.[args]  declaredClasses is empty ");
//
//            Constructor<?>[] declaredConstructors = clz.getDeclaredConstructors();
//            sb1.append("  declaredConstructors   " + jointContructors(declaredConstructors));
//            Field[] declaredFields = clz.getDeclaredFields();
//            sb1.append(" declaredFields  " + jointFileds(declaredFields));
//            Method[] declaredMethods = clz.getDeclaredMethods();
//            sb1.append("declaredMethods  " + jointMethods(declaredMethods));
//
//            System.out.println("  sb1 = " + sb1);

//            System.out.println("**********  print enclosing class");
//            StringBuffer sb2 = new StringBuffer();
//            Class<?> enclosingClass = clz.getEnclosingClass();
//            Constructor<?> enclosingConstructor = clz.getEnclosingConstructor();
//            sb2.append("enclosingConstructor   " + jointContructors(new Constructor<?>[]{enclosingConstructor}));
//            Method enclosingMethod = clz.getEnclosingMethod();
//            sb2.append("enclosingMethod   " + jointMethods(new Method[]{enclosingMethod}));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public static String jointContructors(Constructor<?>[] constructors) {
        if (constructors != null) {
            StringBuffer sb = new StringBuffer();
//            System.out.println("jointContructors.[constructors]  " + constructors.length);
            for (int i = 0; i < constructors.length; i++) {
                Constructor<?> constructor = constructors[i];
//                System.out.println("i = " + i + "  constructor = " + (constructor == null ? "  constructor is null" : constructor));
                if (constructor != null) {
                    Parameter[] parameters = constructor.getParameters();
                    sb.append(Modifier.toString(constructor.getModifiers()) + " " + constructor.getName() + "(");
                    if (parameters != null) {
                        for (int i1 = 0; i1 < parameters.length; i1++) {
                            Parameter param = parameters[i1];
//                            AnnotatedType annotatedType1 = param.getAnnotatedType();
//                            sb.append(" getAnnotatedType = " + annotatedType1.getType());
//                            Class<?> type = param.getType();
//                            sb.append(" getType = " + type);
//                            Annotation[] annotations = param.getAnnotations();
//                            sb.append(" getAnnotations = " + joinAnnotaions(annotations));
//                            Annotation[] declaredAnnotations = param.getDeclaredAnnotations();
//                            sb.append(" declaredAnnotations = " + joinAnnotaions(declaredAnnotations));
//                            Class<? extends Parameter> aClass = param.getClass();
//                            sb.append(" getClass = " + aClass + " ");
                            sb.append(param.toString());
                            if (i1 < parameters.length - 1)
                                sb.append(",");
                        }
                    }
                    sb.append(")\n");
                } else System.out.println("jointContructors.[constructors] constructor is null");
            }
            return sb.toString();
        }
        return "";
    }

    public static String jointFileds(Field[] field) {
        if (field != null) {
            StringBuffer sb = new StringBuffer();
            for (Field field1 : field) {
//                System.out.println("field1 = " + field1);
                sb.append(Modifier.toString(field1.getModifiers()) + " " + field1.getType() + " " + field1.getName() + "\n");
            }
            return sb.toString();
        }
        return "";
    }

    public static String jointMethods(Method[] methods) {
        if (methods != null) {
            StringBuffer sb = new StringBuffer();
            for (Method method : methods) {
                if (method != null) {
                    Annotation[] annotations = method.getAnnotations();
//                System.out.println("method = " + method);
                    sb.append(joinAnnotaions(annotations));
                    sb.append(Modifier.toString(method.getModifiers()) + " " + method.getReturnType() + " " + method.getName() + "\n");
                } else System.out.println("jointMethods.[methods]  method is null");
            }
            return sb.toString();
        }
        Modifier.isPublic(1);
        return "no annotation ";
    }

    public static String joinAnnotaions(Annotation[] annotations) {
        if (annotations != null) {
            StringBuffer sb = new StringBuffer();
            for (Annotation annotation : annotations) {
                sb.append(annotation == null ? "annotation is null" : annotation.annotationType() + "\n");
            }
            return sb.toString();
        }
        return "";
    }

    public static void analysis(Class<?> clz) {
        StringBuffer sb = new StringBuffer();
        System.out.println("analysis.clz.getName = " + clz.getName() + "  " + Modifier.toString(clz.getModifiers()) + "  " + ("  clz.isAnonymousClass() = " + clz.isAnonymousClass()) + "  clz.isLocalClass() = " + clz.isLocalClass() + " clz.isMemberClass() = " + clz.isMemberClass());
        Constructor<?>[] constructors = clz.getConstructors();
        sb.append("  constructors  = \n" + jointContructors(constructors));
//        Field[] declaredFields = clz.getDeclaredFields();
//        sb.append(" \ndeclaredFields = \n" + jointFileds(declaredFields));
//        Method[] declaredMethods = clz.getDeclaredMethods();
//        sb.append("  \ndeclaredMethods = \n" + jointMethods(declaredMethods));
        System.out.println("\n" + sb + "\n");
        analysis2(clz);
    }

    public static void analysis2(Class<?> clz) {
        System.out.println("\nanalysis2.[clz] = " + clz);
        Class<?> superclass = clz.getSuperclass();
        System.out.println("analysis2.[clz] clz.getSuperclass() = " + superclass);
        Type genericSuperclass = clz.getGenericSuperclass();
        System.out.println("analysis2.[clz] clz.getGenericSuperclass() = " + genericSuperclass);
        AnnotatedType annotatedSuperclass = clz.getAnnotatedSuperclass();
        System.out.println("analysis2.[clz] clz.getAnnotatedSuperclass() = " + annotatedSuperclass);

        Class<?>[] interfaces = clz.getInterfaces();
        if (interfaces != null && interfaces.length > 0) {
            for (Class<?> anInterface : interfaces) {
                System.out.println("analysis2.[clz] clz.getInterfaces()  anInterface = " + anInterface);
            }
        } else System.out.println("analysis2.[clz]  clz.getInterfaces() is empty");

        AnnotatedType[] annotatedInterfaces = clz.getAnnotatedInterfaces();
        if (annotatedInterfaces != null && annotatedInterfaces.length > 0) {
            for (AnnotatedType annotatedInterface : annotatedInterfaces) {
                System.out.println("analysis2.[clz] clz.getAnnotatedInterfaces() annotatedInterface = " + annotatedInterface);
            }
        } else System.out.println("analysis2.[clz] clz.getAnnotatedInterfaces() is empty");
        Type[] genericInterfaces = clz.getGenericInterfaces();
        if (genericInterfaces != null && genericInterfaces.length > 0) {
            for (Type genericInterface : genericInterfaces) {
                System.out.println("analysis2.[clz] clz.getGenericInterfaces() genericInterface = " + genericInterface);
            }
        } else System.out.println("analysis2.[clz] clz.getGenericInterfaces() is empty");
        System.out.println("");

    }

    private static void initClass(Girls girl, Class<?> clz) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Object o = null;
        if (Modifier.isPublic(clz.getModifiers())) {
            o = clz.newInstance();
        } else if (clz.isMemberClass()) {
            if (Modifier.isStatic(clz.getModifiers())) {
                o = clz.newInstance();
            } else {
                Constructor<?>[] declaredConstructors = clz.getDeclaredConstructors();
                if (declaredConstructors != null) {
                    for (Constructor<?> declaredConstructor : declaredConstructors) {
                        if (declaredConstructor.getParameterCount() == 1) {
                            o = declaredConstructor.newInstance(girl);
                        }
                        System.out.println("initClass.[girl, clz]  " + clz + "  " + declaredConstructor.getParameterCount() + "  o = " + o);
                        if (o != null) break;
                    }
                }
            }
        }
        if (o instanceof Girls) {
            Girls girls = (Girls) o;
            System.out.println("initClass.[girl, clz] " + girls.reflectStringMethods());
            girls.reflectVoidMethods();
        } else {
            if (o instanceof Girls.StaticInnerClass) {
                Girls.StaticInnerClass staticInnerClass = (Girls.StaticInnerClass) o;
                staticInnerClass.reflectVoidMethods();
                staticInnerClass.reflectStringMethods();
            } else if (o instanceof Girls.NoModifierInnerClass) {
                Girls.NoModifierInnerClass noModifierInnerClass = (Girls.NoModifierInnerClass) o;
                noModifierInnerClass.reflectStringMethods();
                noModifierInnerClass.reflectVoidMethods();
            } else if (clz == Girls.AbstractExtendedClass.class) {
                Method paramVoidMethod = clz.getDeclaredMethod("paramVoidMethod", Integer.class);
                paramVoidMethod.invoke(o, 12);
                Method paramStringMethod = clz.getDeclaredMethod("paramStringMethod", Integer.class);
                paramStringMethod.invoke(o, 1);
                Method abstractMethod = clz.getDeclaredMethod("abstractMethod");
                abstractMethod.invoke(o);
                Method reflectVoidMethods = clz.getDeclaredMethod("reflectVoidMethods");
                reflectVoidMethods.invoke(o);
                Method reflectStringMethods = clz.getDeclaredMethod("reflectStringMethods");
                Object invoke = reflectStringMethods.invoke(o);
                System.out.println("initClass.[girl, clz] reflectStringMethods.return value is " + invoke + "  " + invoke.getClass());
                Method getParam = clz.getDeclaredMethod("getParam");
                getParam.setAccessible(true);
                Object invoke1 = getParam.invoke(o);
                System.out.println("initClass.[girl, clz] getParam.return value " + invoke1);
            } else if (clz == Girls.ParamsExtendedClass.class) {

            } else {
                System.out.println("initClass.[girl, clz] o = " + o);
                Ple ple = ((Ple) o);
                ple.reflectStringMethods();
                ple.reflectVoidMethods();
            }
        }
        System.out.println("\n");
    }

    private static void initClass2(Girls girl, Class<?> clz) throws IllegalAccessException, InstantiationException {
        System.out.println("initClass2.[girl, clz] " + Modifier.toString(clz.getModifiers()));
        if (clz.isMemberClass()) {  //是否是内部类

        } else if (Modifier.isPublic(clz.getModifiers())) {  //  非 内部类 且是public  认为是main Class
            Girls g = (Girls) clz.newInstance();
            Object newGirl = Proxy.newProxyInstance(g.getClass().getClassLoader(), g.getClass().getInterfaces(), (proxy, method, args) -> {
//                System.out.println("initClass2.[girl, clz]  proxy = " + proxy + " method = " + method + " args = " + args);
                switch (method.getName()) {
                    case "toString":
                        return "update toString" ;
                    case "reflectStringMethods":
                        return "update reflectStringMethods";
                }
                return method.invoke(g, args);
            });
            System.out.println("initClass2.[girl, clz] result  is " + newGirl);
            System.out.println("initClass2.[girl, clz] " + g.reflectStringMethods() + "   " + g.toString());
//            System.out.println("initClass2.[girl, clz]  " + newGirl.toString());
//            System.out.println("initClass2.[girl, clz]  " + newGirl.reflectStringMethods());
        }
    }

}
