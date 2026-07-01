System.out.println("\n=== CLASS INFORMATION ===");
System.out.println("Class Name : " + petClass.getName());
System.out.println("Simple Name : " + petClass.getSimpleName());
System.out.println("Package : " + petClass.getPackage());
System.out.println("Superclass : " + petClass.getSuperclass().getSimpleName());
System.out.println("Modifiers : " + Modifier.toString(petClass.getModifiers()));

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

System.out.println("\n=== METHOD PARAMETERS ===");
for (Method m : petClass.getDeclaredMethods()) {
    System.out.println("Method : " + m.getName());

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

    System.out.println(c.getName());

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

System.out.println("\n=== FIELD VALUES OF OBJECT ===");
for (Field field : petClass.getDeclaredFields()) {

    field.setAccessible(true);

    System.out.println(field.getName() + " = " + field.get(newPet));
}

System.out.println("\n=== CHECKING MODIFIERS ===");
for (Field field : petClass.getDeclaredFields()) {

    int mod = field.getModifiers();

    System.out.println(field.getName());

    System.out.println("Private : " + Modifier.isPrivate(mod));
    System.out.println("Public : " + Modifier.isPublic(mod));
    System.out.println("Static : " + Modifier.isStatic(mod));
    System.out.println("--------------------");
}
