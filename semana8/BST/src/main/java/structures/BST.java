package structures;

public class BST<T extends Comparable<T> > {

    private Node<T> root;

    public BST() {
        root = null;
    }

    // Método Fachada
    // Recursividad en dos partes -> Trigger
    public void add(T value){
        Node<T> node = new Node<>(value);

        // CASO BASE: La lista esta vacia
        if(root == null){
            root = node;
        }
        // CASO RECURSIVO: (LLamado a un método recursivo)
        else {
           add(node, root);
        }
    }

    // Método recursivo
    private void add(Node<T> node, Node<T> current){

        // CASO BASE 1: el nodo ha a gregar es menor que el current
        if (current.getValue().compareTo(node.getValue()) > 0){
            // CASO BASE 1.1: La izquierda del nodo current esta vacia
            if(current.getLeft() == null)
                current.setLeft(node);
            // CASO BASE 1.2: La izquierda no esta vacia
            else
                add(node, current.getLeft());
        }
        // CASO BASE 2: el nodo ha a gregar es mayor que el current
        else if (current.getValue().compareTo(node.getValue()) < 0){
            // CASO BASE 2.1: La derecha del nodo current esta vacia
            if(current.getRight() == null)
                current.setRight(node);
            // CASO BASE 2.2: La derecha no esta vacia
            else {
                add(node, current.getRight());
            }
        }
    }


}
