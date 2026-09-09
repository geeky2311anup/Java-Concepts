```java
// More StringBuilder methods
System.out.println("StringBuilder Content: " + sb.toString());

sb.append(" Programming");
System.out.println("After Adding Text: " + sb);

System.out.println("Contains 'Java': "
        + (sb.indexOf("Java") != -1));

sb.setLength(5);
System.out.println("After Set Length: " + sb);

sb.append(" Language");
System.out.println("After Adding Again: " + sb);
```
