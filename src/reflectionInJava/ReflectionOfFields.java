System.out.println("\n=== CLASS INFORMATION ===");
System.out.println("Class Name : " + petClass.getName());
System.out.println("Simple Name : " + petClass.getSimpleName());
System.out.println("Package : " + petClass.getPackage());
System.out.println("Superclass : " + petClass.getSuperclass().getSimpleName());
System.out.println("Modifiers : " + Modifier.toString(petClass.getModifiers()));
System.out.println("Is Public : " + Modifier.isPublic(petClass.getModifiers()));
System.out.println("Is Final : " + Modifier.isFinal(petClass.getModifiers()));

System.out.println("\n=== CREATING OBJECT USING REFLECTION ===");
Constructor<?> constructor = petClass.getConstructor(String.class, int.class);
Pet newPet = (Pet) constructor.newInstance("Jerry", 3);

System.out.println("Object Created");
System.out.println("Name : " + newPet.name);

System.out.println("\n=== ACCESSING PUBLIC FIELD ===");
Field nameField = petClass.getField("name");
System.out.println("Original Name : " + nameField.get(newPet));

nameField.set(newPet, "Rocky");
System.out.println("Updated Name : " + nameField.get(newPet));

System.out.println("\n=== INVOKING PUBLIC METHOD ===");
Method walkMethod = petClass.getMethod("walk");
walkMethod.invoke(newPet);

System.out.println("\n=== ALL PUBLIC METHODS ===");
for (Method m : petClass.getMethods()) {
    System.out.println(
        m.getReturnType().getSimpleName() + " " + m.getName()
    );
}

System.out.println("\n=== METHOD PARAMETERS ===");
for (Method m : petClass.getDeclaredMethods()) {

    System.out.println("Method : " + m.getName());
    System.out.println("Return Type : " + m.getReturnType().getSimpleName());

    Parameter[] parameters = m.getParameters();

    if (parameters.length == 0) {
        System.out.println("No Parameters");
    } else {
        for (Parameter p : parameters) {
            System.out.println(
                p.getType().getSimpleName() + " " + p.getName()
            );
        }
    }

    System.out.println("--------------------");
}

System.out.println("\n=== CONSTRUCTOR PARAMETERS ===");
for (Constructor<?> c : petClass.getDeclaredConstructors()) {

    System.out.println("Constructor : " + c.getName());

    Parameter[] params = c.getParameters();

    if (params.length == 0) {
        System.out.println("No Parameters");
    } else {
        for (Parameter p : params) {
            System.out.println(
                p.getType().getSimpleName() + " " + p.getName()
            );
        }
    }

    System.out.println("--------------------");
}

System.out.println("\n=== FIELD INFORMATION ===");
for (Field field : petClass.getDeclaredFields()) {

    field.setAccessible(true);

    System.out.println("Field : " + field.getName());
    System.out.println("Type : " + field.getType().getSimpleName());
    System.out.println("Value : " + field.get(newPet));
    System.out.println("Modifiers : " +
        Modifier.toString(field.getModifiers()));

    System.out.println("--------------------");
}

System.out.println("\n=== FIELD VALUES OF OBJECT ===");
for (Field field : petClass.getDeclaredFields()) {

    field.setAccessible(true);

    System.out.println(field.getName() + " = " + field.get(newPet));
}

System.out.println("\n=== CHECKING MODIFIERS ===");
for (Field field : petClass.getDeclaredFields()) {

    int mod = field.getModifiers();

    System.out.println("Field : " + field.getName());
    System.out.println("Private : " + Modifier.isPrivate(mod));
    System.out.println("Public : " + Modifier.isPublic(mod));
    System.out.println("Protected : " + Modifier.isProtected(mod));
    System.out.println("Static : " + Modifier.isStatic(mod));
    System.out.println("Final : " + Modifier.isFinal(mod));
    System.out.println("--------------------");
}

System.out.println("\n=== DECLARED CONSTRUCTORS ===");
for (Constructor<?> c : petClass.getDeclaredConstructors()) {

    System.out.println("Constructor : " + c.getName());
    System.out.println("Parameter Count : " + c.getParameterCount());
    System.out.println("Modifiers : " +
        Modifier.toString(c.getModifiers()));

    System.out.println("--------------------");
}

System.out.println("\n=== CLASS CHECKS ===");
System.out.println("Is Interface : " + petClass.isInterface());
System.out.println("Is Array : " + petClass.isArray());
System.out.println("Is Enum : " + petClass.isEnum());
System.out.println("Is Annotation : " + petClass.isAnnotation());
System.out.println("Is Primitive : " + petClass.isPrimitive());
