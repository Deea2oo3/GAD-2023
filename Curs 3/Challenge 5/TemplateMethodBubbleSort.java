public abstract class TemplateMethodBubbleSort {
    void sort(Integer[] list) {
        // make use of method numbersInCorrectOrder to sort array
        boolean sorted = false;
        int n = list.length;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (numbersInCorrectOrder(list[i + 1], list[i])) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    sorted = false;
                }
            }
            n--;
        }
    }

    abstract boolean numbersInCorrectOrder(Integer i1, Integer i2);
}

class AscBubbleSort extends TemplateMethodBubbleSort {
    @Override
    boolean numbersInCorrectOrder(Integer i1, Integer i2) {
        return i1 < i2;
    }
}

class DescBubbleSort extends TemplateMethodBubbleSort {
    @Override
    boolean numbersInCorrectOrder(Integer i1, Integer i2) {
        return i1 > i2;
    }
}
