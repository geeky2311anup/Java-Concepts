        // Rotate
        Collections.rotate(listObj, 2);
        System.out.println("\n\nAfter Rotating by 2:");
        listObj.forEach(val -> System.out.print(val + " "));

        // Replace All
        Collections.replaceAll(listObj, 2, 20);
        System.out.println("\n\nAfter Replacing 2 with 20:");
        listObj.forEach(val -> System.out.print(val + " "));

        // Reverse Order Sort
        Collections.sort(listObj, Collections.reverseOrder());
        System.out.println("\n\nSorted in Descending Order:");
        listObj.forEach(val -> System.out.print(val + " "));

        // Disjoint
        List<Integer> anotherList = Arrays.asList(100, 200, 300);
        System.out.println("\n\nAre Lists Disjoint? "
                + Collections.disjoint(listObj, anotherList));

        // Singleton List
        List<String> singleton = Collections.singletonList("Java");
        System.out.println("\nSingleton List: " + singleton);

        // nCopies
        List<String> copies = Collections.nCopies(5, "Hello");
        System.out.println("\n5 Copies: " + copies);

        // Empty List
        List<Integer> empty = Collections.emptyList();
        System.out.println("\nEmpty List: " + empty);

        // Enumeration
        Enumeration<Integer> enumeration = Collections.enumeration(listObj);
        System.out.print("\nEnumeration: ");
        while (enumeration.hasMoreElements()) {
            System.out.print(enumeration.nextElement() + " ");
        }

        // Index Of SubList
        List<Integer> sub = Arrays.asList(20, 3);
        System.out.println("\n\nIndex of SubList: "
                + Collections.indexOfSubList(listObj, sub));

        // Last Index Of SubList
        System.out.println("Last Index of SubList: "
                + Collections.lastIndexOfSubList(listObj, sub));

        // Checked List
        List<Integer> checked =
                Collections.checkedList(new ArrayList<>(), Integer.class);
        checked.add(10);
        checked.add(20);
        System.out.println("\nChecked List: " + checked);
