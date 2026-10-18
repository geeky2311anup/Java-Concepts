System.out.println("\n=== IMPLEMENTED INTERFACES ===");
for (Class<?> interfaceClass : petClass.getInterfaces()) {
    System.out.println("Interface : " + interfaceClass.getSimpleName());
}

System.out.println("\n=== SUPERCLASS HIERARCHY ===");
Class<?> currentClass = petClass;

while (currentClass != null) {
    System.out.println(currentClass.getSimpleName());
    currentClass = currentClass.getSuperclass();
}

System.out.println("\n=== CHECKING ANNOTATIONS ===");
for (java.lang.annotation.Annotation annotation : petClass.getAnnotations()) {
    System.out.println("Annotation : " + annotation.annotationType().getSimpleName());
}

System.out.println("\n=== METHOD MODIFIERS ===");
for (Method method : petClass.getDeclaredMethods()) {
    int mod = method.getModifiers();

    System.out.println("Method : " + method.getName());
    System.out.println("Public : " + Modifier.isPublic(mod));
    System.out.println("Private : " + Modifier.isPrivate(mod));
    System.out.println("Static : " + Modifier.isStatic(mod));
    System.out.println("Final : " + Modifier.isFinal(mod));
    System.out.println("--------------------");
}

System.out.println("\n=== CHECKING OBJECT TYPE ===");
System.out.println("Is Pet Instance : " + petClass.isInstance(newPet));
System.out.println("Class Name : " + newPet.getClass().getName());

System.out.println("\n=== INVOKING METHOD WITH PARAMETERS ===");
try {
    Method method = petClass.getMethod("setAge", int.class);
    method.invoke(newPet, 5);
    System.out.println("setAge() invoked successfully");
} catch (NoSuchMethodException e) {
    System.out.println("setAge(int) method does not exist in Pet.");
}
