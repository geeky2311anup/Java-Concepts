System.out.println("\n========== Annotations ==========");
Annotation[] annotations = eagleClass.getAnnotations();
if (annotations.length == 0) {
    System.out.println("No Annotations Present");
} else {
    for (Annotation annotation : annotations) {
        System.out.println(annotation.annotationType().getSimpleName());
    }
}

System.out.println("\n========== Class Names ==========");
System.out.println("Simple Name : " + eagleClass.getSimpleName());
System.out.println("Full Name : " + eagleClass.getName());
System.out.println("Type Name : " + eagleClass.getTypeName());

System.out.println("\n========== Package ==========");
Package classPackage = eagleClass.getPackage();
System.out.println("Package : " + (classPackage == null ? "No Package" : classPackage.getName()));

System.out.println("\n========== Superclass ==========");
System.out.println("Superclass : " + eagleClass.getSuperclass());
System.out.println("Generic Superclass : " + eagleClass.getGenericSuperclass());

System.out.println("\n========== Interfaces ==========");
Class<?>[] interfaces = eagleClass.getInterfaces();
if (interfaces.length == 0) {
    System.out.println("No Interfaces Implemented");
} else {
    for (Class<?> anInterface : interfaces) {
        System.out.println(anInterface.getName());
    }
}

System.out.println("\n========== Generic Interfaces ==========");
Type[] genericInterfaces = eagleClass.getGenericInterfaces();
if (genericInterfaces.length == 0) {
    System.out.println("No Generic Interfaces");
} else {
    for (Type type : genericInterfaces) {
        System.out.println(type.getTypeName());
    }
}

System.out.println("\n========== Type Parameters ==========");
TypeVariable<?>[] typeParameters = eagleClass.getTypeParameters();
if (typeParameters.length == 0) {
    System.out.println("No Type Parameters");
} else {
    for (TypeVariable<?> typeVariable : typeParameters) {
        System.out.println(typeVariable.getName());
    }
}

System.out.println("\n========== Constructors ==========");
Constructor<?>[] constructors = eagleClass.getDeclaredConstructors();
if (constructors.length == 0) {
    System.out.println("No Constructors");
} else {
    for (Constructor<?> constructor : constructors) {
        System.out.println(constructor);
    }
}

System.out.println("\n========== Declared Methods ==========");
Method[] declaredMethods = eagleClass.getDeclaredMethods();
if (declaredMethods.length == 0) {
    System.out.println("No Declared Methods");
} else {
    for (Method method : declaredMethods) {
        System.out.println(method);
    }
}

System.out.println("\n========== Declared Fields ==========");
Field[] declaredFields = eagleClass.getDeclaredFields();
if (declaredFields.length == 0) {
    System.out.println("No Declared Fields");
} else {
    for (Field field : declaredFields) {
        System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName());
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
System.out.println("Is Abstract : " + Modifier.isAbstract(eagleClass.getModifiers()));
System.out.println("Is Final : " + Modifier.isFinal(eagleClass.getModifiers()));
System.out.println("Is Static : " + Modifier.isStatic(eagleClass.getModifiers()));
System.out.println("Is Public : " + Modifier.isPublic(eagleClass.getModifiers()));

System.out.println("\n========== Kind Checks ==========");
System.out.println("Is Array : " + eagleClass.isArray());
System.out.println("Is Primitive : " + eagleClass.isPrimitive());
System.out.println("Is Interface : " + eagleClass.isInterface());
System.out.println("Is Enum : " + eagleClass.isEnum());
System.out.println("Is Annotation : " + eagleClass.isAnnotation());
System.out.println("Is Record : " + eagleClass.isRecord());
System.out.println("Is Sealed : " + eagleClass.isSealed());
System.out.println("Is Synthetic : " + eagleClass.isSynthetic());
System.out.println("Is Anonymous Class : " + eagleClass.isAnonymousClass());
System.out.println("Is Local Class : " + eagleClass.isLocalClass());
System.out.println("Is Member Class : " + eagleClass.isMemberClass());

System.out.println("\n========== Declaring Class ==========");
System.out.println("Declaring Class : " + eagleClass.getDeclaringClass());
System.out.println("Enclosing Class : " + eagleClass.getEnclosingClass());

System.out.println("\n========== Canonical Name ==========");
System.out.println("Canonical Name : " + eagleClass.getCanonicalName());

System.out.println("\n========== Class Loader ==========");
System.out.println("Class Loader : " + eagleClass.getClassLoader());

System.out.println("\n========== Module ==========");
System.out.println("Module : " + eagleClass.getModule().getName());

System.out.println("\n========== Instance Check ==========");
System.out.println("Is Instance Of Object : " + Object.class.isAssignableFrom(eagleClass));
System.out.println("Hash Code : " + eagleClass.hashCode());
