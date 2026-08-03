System.out.println("\n========== Annotations ==========");
Annotation[] annotations = eagleClass.getAnnotations();
if (annotations.length == 0) {
    System.out.println("No Annotations Present");
} else {
    for (Annotation annotation : annotations) {
        System.out.println(annotation.annotationType().getSimpleName());
    }
}

System.out.println("\n========== Nested Classes ==========");
Class<?>[] innerClasses = eagleClass.getDeclaredClasses();
if (innerClasses.length == 0) {
    System.out.println("No Inner Classes");
} else {
    for (Class<?> c : innerClasses) {
        System.out.println(c.getSimpleName());
    }
}

System.out.println("\n========== Public Methods ==========");
Method[] publicMethods = eagleClass.getMethods();
System.out.println("Total Public Methods (Including Inherited): " + publicMethods.length);

System.out.println("\n========== Public Fields ==========");
Field[] publicFields = eagleClass.getFields();
System.out.println("Total Public Fields (Including Inherited): " + publicFields.length);

System.out.println("\n========== Class Modifiers ==========");
System.out.println("Modifiers : " + Modifier.toString(eagleClass.getModifiers()));

System.out.println("\n========== Array Check ==========");
System.out.println("Is Array : " + eagleClass.isArray());

System.out.println("\n========== Primitive Check ==========");
System.out.println("Is Primitive : " + eagleClass.isPrimitive());

System.out.println("\n========== Declaring Class ==========");
System.out.println("Declaring Class : " + eagleClass.getDeclaringClass());

System.out.println("\n========== Canonical Name ==========");
System.out.println("Canonical Name : " + eagleClass.getCanonicalName());
