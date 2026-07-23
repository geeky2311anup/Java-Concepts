System.out.println("\n========== Constructors ==========");
Constructor<?>[] constructors = eagleClass.getDeclaredConstructors();

for (Constructor<?> constructor : constructors) {
    System.out.println("Constructor : " + constructor.getName());
    System.out.println("Modifiers   : " + Modifier.toString(constructor.getModifiers()));
    System.out.println("Parameters  : " + constructor.getParameterCount());
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
}

System.out.println("\n========== Invoke Public Method ==========");
Method flyMethod = eagleClass.getMethod("fly");
flyMethod.invoke(eagle);

System.out.println("\n========== Class Information ==========");
System.out.println("Class Name : " + eagleClass.getName());
System.out.println("Simple Name: " + eagleClass.getSimpleName());
System.out.println("Package    : " + eagleClass.getPackageName());

System.out.println("\n========== Check Members ==========");
System.out.println("Has field 'breed' : "
        + (eagleClass.getField("breed") != null));
System.out.println("Has method 'eat' : "
        + (eagleClass.getMethod("eat") != null));
