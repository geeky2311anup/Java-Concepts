System.out.println("\n========== Constructors ==========");
Constructor<?>[] constructors = eagleClass.getDeclaredConstructors();

for (Constructor<?> constructor : constructors) {
    System.out.println("Constructor : " + constructor.getName());
    System.out.println("Modifiers   : " + Modifier.toString(constructor.getModifiers()));
    System.out.println("Parameters  : " + constructor.getParameterCount());

    Class<?>[] params = constructor.getParameterTypes();
    if (params.length > 0) {
        System.out.print("Parameter Types : ");
        for (Class<?> p : params) {
            System.out.print(p.getSimpleName() + " ");
        }
        System.out.println();
    }

    System.out.println("------------------------------");
}

System.out.println("\n========== Method Parameters ==========");
for (Method method : eagleClass.getDeclaredMethods()) {
    System.out.print(method.getName() + " -> ");
    Class<?>[] parameterTypes = method.getParameterTypes();

    if (parameterTypes.length == 0) {
        System.out.println("No Parameters");
    } else {
        for (Class<?> type : parameterTypes) {
            System.out.print(type.getSimpleName() + " ");
        }
        System.out.println();
    }

    System.out.println("Return Type : " + method.getReturnType().getSimpleName());
    System.out.println("Modifiers   : " + Modifier.toString(method.getModifiers()));
    System.out.println("------------------------------");
}

System.out.println("\n========== Invoke Public Method ==========");
Method flyMethod = eagleClass.getMethod("fly");
flyMethod.invoke(eagle);

System.out.println("\n========== Class Information ==========");
System.out.println("Class Name   : " + eagleClass.getName());
System.out.println("Simple Name  : " + eagleClass.getSimpleName());
System.out.println("Package Name : " + eagleClass.getPackageName());
System.out.println("Superclass   : " + eagleClass.getSuperclass().getSimpleName());

System.out.println("\n========== Check Members ==========");
System.out.println("Has field 'breed' : " + (eagleClass.getField("breed") != null));
System.out.println("Has method 'eat'  : " + (eagleClass.getMethod("eat") != null));

System.out.println("\n========== Interfaces ==========");
Class<?>[] interfaces = eagleClass.getInterfaces();
if (interfaces.length == 0) {
    System.out.println("No Interfaces Implemented");
} else {
    for (Class<?> i : interfaces) {
        System.out.println(i.getSimpleName());
    }
}

System.out.println("\n========== Total Members ==========");
System.out.println("Fields       : " + eagleClass.getDeclaredFields().length);
System.out.println("Methods      : " + eagleClass.getDeclaredMethods().length);
System.out.println("Constructors : " + eagleClass.getDeclaredConstructors().length);
