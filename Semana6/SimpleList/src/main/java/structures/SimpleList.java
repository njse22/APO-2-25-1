package structures;

public class SimpleList {

    private Node first;

    public SimpleList() {
        first = null;
    }

    public boolean delete(String data){
        boolean isDeleted = false;
        Node current = first;

        // Caso base : Lista NO vacia
        if (first != null){
            // Caso Base -> El nodo a eliminar es el firts
            if(first.getData().compareTo(data) == 0){
                first = first.getNext();
                current.setNext(null);
                isDeleted = true;
            }
            // Caso base -> El nodo a eliminar es diferente del first
            else {

                // Caso iterativo
                while (current.getNext() != null && current.getNext().getData().compareTo(data) != 0){
                    current = current.getNext();
                }
                if (current.getNext() != null){
                    Node toDelete = current.getNext();
                    current.setNext(toDelete.getNext());
                    toDelete.setNext(null);
                    isDeleted = true;
                }
            }
        }
        return isDeleted;
    }

    public boolean add(String data){
        // Crear el Node a agregar
        Node node = new Node(data);

        boolean isAdded = false;

        // 1. Caso Base -> Empty List
        if(first == null){
            first = node;
            first.setIndex(0);
            isAdded = true;
        }
        // 2. Caso Base -> La lista tiene UN elemento
        else {
            if(first.getNext() == null){
                first.setNext(node);
                first.getNext().setIndex(1);
                isAdded = true;
            }
            else {
                // elemento de referencia
                Node current = first.getNext();

                // ir al final de la lista
                while (current.getNext() != null){
                    current = current.getNext();
                }
                // Agregar al final de la lista
                current.setNext(node);
                current.getNext().setIndex(current.getIndex()+1);
                isAdded = true;
            }
        }
        return isAdded;
    }


    public String getByIndex(int index){
        Node current = first.getNext();
        String response = "NO DATA FOUND";
        if (index == 0){
            response = first.getData();
        }
        else {
            while (current != null && current.getIndex() != index){
                current = current.getNext();
            }
            if(current != null){
                response = current.getData();
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
}
