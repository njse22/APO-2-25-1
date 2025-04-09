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

    // eliminar
    public boolean delete(T goal){
        boolean isDeleted = false;

        if(root != null){
            if(root.getValue().compareTo(goal) == 0){
                if(root.getRight() == null && root.getLeft() == null){
                    root = null;
                }
                // la riaz tiene un único hijo
                if(root.getRight() != null && root.getLeft() == null){
                    root = root.getRight();
                }
                else if(root.getRight() == null && root.getLeft() != null){
                    root = root.getLeft();
                }
                // la raiź tiene ambos hijos
                else if( root.getLeft() != null && root.getRight() != null){
                    Node<T> predecessor = getMax(root.getLeft());
                    root.setValue(predecessor.getValue());
                    delete(root, root.getLeft(), predecessor.getValue());
                }
            }
            delete(null, root, goal);

        }
        return isDeleted;
    }

    private boolean delete(Node<T> parent, Node<T> current, T goal){
        boolean isDeleted = false;

        // CASO BASE 1. Encontramos el nodo
        if(current.getValue().compareTo(goal) == 0){
            // CASO BASE 1.1. es un nodo hoja
            if (current.getLeft() == null && current.getRight() == null){
                // CASO BASE 1.1.1. es hijo derecho
                if(parent.getRight() == current){
                    parent.setRight(null);
                }
                // CASO BASE 1.1.2. es hijo izquierdo
                else {
                    parent.setLeft(null);
                }
            }
            // CASO BASE 1.2.
            // CASO BASE 1.2.1. tiene único hijo derecho
            if (current.getRight() != null && current.getLeft() == null){
                // CASO BASE 1.1.1. es hijo derecho
                if(parent.getRight() == current){
                    parent.setRight(current.getRight());
                    current.setRight(null);
                }
                // CASO BASE 1.1.2. es hijo izquierdo
                else {
                    parent.setLeft(current.getRight());
                    current.setRight(null);
                }
            }
            // CASO BASE 1.2.2. tiene un único hijo izquierdo
            else if (current.getRight() == null && current.getLeft() != null) {

                // CASO BASE 1.1.1. es hijo derecho
                if(parent.getRight() == current){
                   parent.setRight(current.getLeft());
                   current.setLeft(null);
                }
                // CASO BASE 1.1.2. es hijo izquierdo
                else {
                   parent.setLeft(current.getLeft());
                   current.setLeft(null);
                }
            }
            else if (current.getLeft() != null && current.getRight() != null){
                Node<T> predecessor = getMax(current.getLeft());
                // CASO BASE 1.1.1. es hijo derecho
                if(parent.getRight() == current){
                    parent.getRight().setValue(predecessor.getValue());
                }
                // CASO BASE 1.1.2. es hijo izquierdo
                else {
                    parent.getLeft().setValue(predecessor.getValue());
                }
                delete(current, current.getLeft(), predecessor.getValue());
            }

        }
        // CASO RECURSIVO
        else if(current.getValue().compareTo(goal) > 0){
            delete(current, current.getLeft(), goal);
        }
        else if (current.getValue().compareTo(goal) < 0){
            delete(current, current.getRight(), goal);
        }


        return isDeleted;
    }


    // get max
    public Node<T> getMax(){
        Node<T> current = null;
        if(root != null){
            current = root;
            while (current.getRight() != null){
                current = current.getRight();
            }
        }
        return current;
    }

    private Node<T> getMax(Node<T> current){
        if(current.getRight() != null){
            getMax(current.getRight());
        }
        return current;
    }

    // get min

}
