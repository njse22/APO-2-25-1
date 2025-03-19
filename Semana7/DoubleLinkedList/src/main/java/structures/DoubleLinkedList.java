package structures;

public class DoubleLinkedList<T extends Comparable<T>> {

    private Node<T> first;
    private Node<T> last;

    private int size;

    public DoubleLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean delete(T data){
        boolean isDeleted = false;
        Node<T> current = first;

        // Caso base : Lista NO vacia
        if (first != null){
            // Caso Base -> El nodo a eliminar es el firts
            if(first.getData().compareTo(data) == 0){
                first = first.getNext();
                current.setNext(null);
                first.setPrevious(null);
                isDeleted = true;
            }
            // Caso base -> El nodo a eliminar es diferente del first
            else {

                // Caso iterativo
                while (current.getNext() != null && current.getNext().getData().compareTo(data) != 0){
                    current = current.getNext();
                }
                if (current.getNext() != null){
                    // Tomamos la referencia del nodo a eliminar
                    Node toDelete = current.getNext();

                    // Actualizae las conexiones
                    current.setNext(toDelete.getNext());
                    toDelete.getNext().setPrevious(toDelete.getPrevious());

                    // desconectamos el nodo
                    toDelete.setNext(null);
                    toDelete.setPrevious(null);

                    isDeleted = true;
                }
            }
        }
        return isDeleted;
    }

    public boolean add(T data){
        // Crear el Node a agregar
        Node<T> node = new Node<T>(data);

        boolean isAdded = false;

        // 1. Caso Base -> Empty List
        if(first == null && last == null){
            first = node;
            last = node;
            first.setIndex(0);
            isAdded = true;
        }
        // 2. Caso Base -> La lista tiene UN elemento
        else {
            if(first.getNext() == null){
                first.setNext(node);
                first.getNext().setIndex(1);
                node.setPrevious(first);
                last = node;
                isAdded = true;
            }
            else {
                last.setNext(node);
                node.setPrevious(last);
                node.setIndex(last.getIndex()+1);
                last = node;
                isAdded = true;
            }
        }
        return isAdded;
    }


    /*
    * NO ACTUALIZA CORRECTAMENTE LOS INDICES DE LOS NODOS
    * */
    public boolean addToFirst(T data){
        // Crear el Node a agregar
        Node node = new Node(data);

        boolean isAdded = false;

        // 1. Caso Base -> Empty List
        if(first == null && last == null){
            first = node;
            last = node;
            first.setIndex(0);
            size = 1;
            isAdded = true;
        }
        // 2. Caso iterativo -> La lista tiene UN elemento
        else {
            if(first.getPrevious() == null){
                first.setPrevious(node);
                first.getPrevious().setIndex(0);
                size++;
                first.setIndex(size-1);
                node.setNext(first);
                first = node;
                isAdded = true;
            }
        }
        return isAdded;
    }

    public String inverserOrder(){
        String msj = "";

        Node current = last;
        while (current.getPrevious() != null){
            msj += current.getData() + " ";
            current = current.getPrevious();
        }
        msj += current.getData();

        return msj;
    }


    public String getByIndex(int index){
        Node current = first.getNext();
        String response = "NO DATA FOUND";
        if (index == 0){
            response = first.getData().toString();
        }
        else {
            while (current != null && current.getIndex() != index){
                current = current.getNext();
            }
            if(current != null){
                response = current.getData().toString();
            }
        }
        return response;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }
}
