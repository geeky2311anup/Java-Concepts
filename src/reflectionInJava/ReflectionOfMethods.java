System.out.println("\n========== Declared Annotations ==========");
Annotation[] declaredAnnotations = eagleClass.getDeclaredAnnotations();
System.out.println("Declared Annotations Count : " + declaredAnnotations.length);

System.out.println("\n========== Enum Constants ==========");
Object[] enumConstants = eagleClass.getEnumConstants();
if (enumConstants == null) {
    System.out.println("Not An Enum");
} else {
    for (Object constant : enumConstants) {
        System.out.println(constant);
    }
}

System.out.println("\n========== Record Components ==========");
RecordComponent[] recordComponents = eagleClass.getRecordComponents();
if (recordComponents == null) {
    System.out.println("Not A Record");
} else {
    for (RecordComponent component : recordComponents) {
        System.out.println(component.getType().getSimpleName() + " " + component.getName());
    }
}

System.out.println("\n========== Permitted Subclasses ==========");
Class<?>[] permittedSubclasses = eagleClass.getPermittedSubclasses();
if (permittedSubclasses == null) {
    System.out.println("Not A Sealed Class");
} else {
    for (Class<?> permitted : permittedSubclasses) {
        System.out.println(permitted.getName());
    }
}

System.out.println("\n========== Component Type ==========");
Class<?> componentType = eagleClass.getComponentType();
System.out.println("Component Type : " + (componentType == null ? "Not An Array" : componentType.getName()));

System.out.println("\n========== Enclosing Method And Constructor ==========");
System.out.println("Enclosing Method : " + eagleClass.getEnclosingMethod());
System.out.println("Enclosing Constructor : " + eagleClass.getEnclosingConstructor());

System.out.println("\n========== Nest Host ==========");
System.out.println("Nest Host : " + eagleClass.getNestHost().getName());

System.out.println("\n========== Method Details ==========");
for (Method method : eagleClass.getDeclaredMethods()) {
    System.out.println("Method : " + method.getName());
    System.out.println("  Return Type : " + method.getReturnType().getSimpleName());
    System.out.println("  Modifiers : " + Modifier.toString(method.getModifiers()));
    System.out.println("  Parameter Count : " + method.getParameterCount());
    for (Parameter parameter : method.getParameters()) {
        System.out.println("  Parameter : " + parameter.getType().getSimpleName() + " " + parameter.getName());
    }
    for (Class<?> exception : method.getExceptionTypes()) {
        System.out.println("  Throws : " + exception.getSimpleName());
    }
    System.out.println("  Is Varargs : " + method.isVarArgs());
    System.out.println("  Is Default : " + method.isDefault());
}

System.out.println("\n========== Constructor Details ==========");
for (Constructor<?> constructor : eagleClass.getDeclaredConstructors()) {
    System.out.println("Constructor : " + constructor.getName());
    System.out.println("  Modifiers : " + Modifier.toString(constructor.getModifiers()));
    System.out.println("  Parameter Types : " + Arrays.toString(constructor.getParameterTypes()));
}

System.out.println("\n========== Static Fields ==========");
for (Field field : eagleClass.getDeclaredFields()) {
    if (Modifier.isStatic(field.getModifiers())) {
        System.out.println(field.getName() + " : " + field.getType().getSimpleName());
    }
}

System.out.println("\n========== Final And Transient Fields ==========");
for (Field field : eagleClass.getDeclaredFields()) {
    int fieldModifiers = field.getModifiers();
    System.out.println(field.getName() + " -> final=" + Modifier.isFinal(fieldModifiers)
            + ", transient=" + Modifier.isTransient(fieldModifiers)
            + ", volatile=" + Modifier.isVolatile(fieldModifiers));
}

System.out.println("\n========== Inheritance Chain ==========");
Class<?> current = eagleClass;
while (current != null) {
    System.out.println(current.getName());
    current = current.getSuperclass();
}

System.out.println("\n========== All Interfaces In Hierarchy ==========");
Set<Class<?>> allInterfaces = new LinkedHashSet<>();
Class<?> walker = eagleClass;
while (walker != null) {
    allInterfaces.addAll(Arrays.asList(walker.getInterfaces()));
    walker = walker.getSuperclass();
}
if (allInterfaces.isEmpty()) {
    System.out.println("None");
} else {
    for (Class<?> item : allInterfaces) {
        System.out.println(item.getName());
    }
}

System.out.println("\n========== Instance Creation ==========");
try {
    Object created = eagleClass.getDeclaredConstructor().newInstance();
    System.out.println("Created : " + created.getClass().getSimpleName());
} catch (Exception e) {
    System.out.println("Cannot Create Instance : " + e.getClass().getSimpleName());
}

System.out.println("\n========== Misc ==========");
System.out.println("Is Hidden : " + eagleClass.isHidden());
System.out.println("Descriptor : " + eagleClass.descriptorString());
System.out.println("Package Name : " + eagleClass.getPackageName());
System.out.println("Assertions Enabled : " + eagleClass.desiredAssertionStatus());
System.out.println("Is Assignable From Self : " + eagleClass.isAssignableFrom(eagleClass));
